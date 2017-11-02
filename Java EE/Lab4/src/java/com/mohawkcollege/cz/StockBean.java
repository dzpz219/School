/*
 * StAuth10066: I Chao Zhang, 000306946 certify that this material is my original work. 
 * Except formatXML code
 * No other person's work has been used without due acknowledgement. 
 * I have not made my work available to anyone else.
 */
package com.mohawkcollege.cz;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.xml.ws.WebServiceRef;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

/**
 *
 * @author Danny
 */
@ManagedBean
@Named(value = "stockBean")
@SessionScoped
public class StockBean implements Serializable{
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/www.webservicex.net/stockquote.asmx.wsdl")
    private StockQuote service;
    
    private String symbol;
    private String quote;
    private String currentDate;
    private String formattedXML;
    private boolean debug = false;
    private ArrayList<String> quoteList = new ArrayList<>();
    private ArrayList<Stock> stockList = new ArrayList<>();
    
    /**
     * Creates a new instance of StockBean
     */
    
    public StockBean() {
    }
    
    public ArrayList<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(ArrayList<Stock> stockList) {
        this.stockList = stockList;
    }

    public ArrayList<String> getQuoteList() {
        return quoteList;
    }

    public void setQuoteList(ArrayList<String> quoteList) {
        this.quoteList = quoteList;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getFormattedXML() {
        return formattedXML;
    }

    public void setFormattedXML(String formattedXML) {
        this.formattedXML = formattedXML;
    }
    
    /**
     * Get the value of quote
     *
     * @return the value of quote
     */
    public String getQuote() {
        return quote;
    }

    /**
     * Set the value of quote
     *
     * @param quote new value of quote
     */
    public void setQuote(String quote) {
        this.quote = quote;
    }

    /**
     * Get the value of symbol
     *
     * @return the value of symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Set the value of symbol
     *
     * @param symbol new value of symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    public void currentQuote() throws TransformerException {
        quote = getQuote(symbol);
        quoteList.add(formatXML(quote));
        parseXML(quote);
    }
    
    public void deleteQuote(Stock stock) {
        stockList.remove(stock);
        quoteList.removeIf(p -> p.equalsIgnoreCase(stock.getQuote()));
    }
    
    public void deleteAllQuote() {
        stockList.removeAll(stockList);
        quoteList.removeAll(quoteList);
    }
    
    public void toggleDebug() {
        debug = !debug;
    }
    
    //This is not my original work, I searched google for a XML formatter
    
    public String formatXML(String xml) throws TransformerException {
        Source xmlInput = new StreamSource(new StringReader(xml));
        StreamResult xmlOutput = new StreamResult(new StringWriter());

        // Configure transformer
        Transformer transformer = TransformerFactory.newInstance()
                        .newTransformer(); // An identity transformer
        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "XML Debug");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(xmlInput, xmlOutput);
        return xmlOutput.getWriter().toString();
    }
    
    private String getQuote(java.lang.String symbol) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.mohawkcollege.cz.StockQuoteSoap port = service.getStockQuoteSoap();
        return port.getQuote(symbol);
    }

    private void parseXML(String xmlDoc) {

    // read data from XML file
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    Stock currentStock = new Stock();
    Document document;
    try
    {
      DocumentBuilder builder = factory.newDocumentBuilder();

      InputStream is = new ByteArrayInputStream(xmlDoc.getBytes());

      document = builder.parse(is);
      Element root = document.getDocumentElement();
      NodeList nList = document.getElementsByTagName("Stock");

      for (int temp = 0; temp < nList.getLength(); temp++)
      {

        Node nNode = nList.item(temp);
        if (nNode.getNodeType() == Node.ELEMENT_NODE)
        {
          Element eElement = (Element) nNode;
          // Based on element place the data into appropriate variables
          currentStock.setName(getTagValue("Name", eElement));
          currentStock.setSymbol(getTagValue("Symbol", eElement));
          currentStock.setLast(getTagValue("Last", eElement));
          currentStock.setChange(getTagValue("Change", eElement));
          currentStock.setPercentChange(getTagValue("PercentageChange", eElement));
          currentStock.setQuote(formatXML(quote));
          currentDate = getTagValue("Date", eElement) + " " + getTagValue("Time", eElement);
          
          if (getTagValue("Change", eElement).startsWith("+")){
              currentStock.setColour("green");
          }
          
          else if (getTagValue("Change", eElement).startsWith("-")){
              currentStock.setColour("red");
          }
          
          else {
              currentStock.setColour("black");
          }
          stockList.add(currentStock);
        }
      }
    } catch (Exception e)
    {
      e.printStackTrace();
    }
  }


  private static String getTagValue(String sTag, Element eElement) {
    NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();

    Node nValue = (Node) nlList.item(0);

    return nValue.getNodeValue();
  }
    
}
