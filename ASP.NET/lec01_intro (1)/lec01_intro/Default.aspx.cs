using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Collections; // Added for ArrayList

public partial class _Default : System.Web.UI.Page
{
    /// <summary>
    /// The Page_Load routine is called every time
    /// </summary>
    /// <param name="sender">The object that raised the event, in this case the Page object that represents .aspx web page</param>
    /// <param name="e">Object that contains event data, most event handlers don't use this data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        string host_name = Request.Url.Host;
        lblNow.Text = DateTime.Now.ToString();
        spnDate.InnerText = DateTime.Now.ToShortDateString();
        spnTime.InnerText = DateTime.Now.ToShortTimeString();

        lblPageEvents.Text = "Page_Load";

        // This only needs to be done once
        if (!Page.IsPostBack)
        {
            // Create collection of items
            ArrayList items = new ArrayList();
            items.Add("Apples");
            items.Add("Bananas");
            items.Add("Lemons");
            items.Add("Strawberries");

            // Bind to drop down list
            ddlPostBack.DataSource = items;
            ddlPostBack.DataBind();

            // This information will be available to other pages
            Session["items"] = "fruits";
            Session["item_count"] = items.Count;
        }

        // Divide by 0
        int i = 0;
        //i = 5 / i;
    }
    
    /// <summary>
    /// Event handler for Click button
    /// </summary>
    /// <param name="sender">btnClick</param>
    /// <param name="e">Event data</param>
    protected void btnClick_Click(object sender, EventArgs e)
    {
        lblButtonClick.Text = "Thank you for clicking the button";
        btnClick.Visible = false;
        lblPageEvents.Text += "<br />btnClick_Click";
    }

    /// <summary>
    /// Event handler for Counter1 and Counter2 buttons
    /// </summary>
    /// <param name="sender">btnCounter1 or btnCounter2</param>
    /// <param name="e">Event data</param>
    protected void btnCounter_Click(object sender, EventArgs e)
    {
        // Since this handler is called by two different buttons and the text
        // of the button needs to be accessed, the sender object must be cast
        // to a button type
        Button btn = (Button)sender;
        btn.Text = (Int32.Parse(btn.Text) + 1).ToString();
        lblPageEvents.Text += "<br />btnCounter_Click";
    }
    
    /// <summary>
    /// Event handler for Totoro image button
    /// </summary>
    /// <param name="sender">btnTotoro</param>
    /// <param name="e">Image button provides more event data, specifically
    /// the X and Y co-ordinates of the user click</param>
    protected void btnTotoro_Click(object sender, ImageClickEventArgs e)
    {
        lblX.Text = e.X.ToString();
        lblY.Text = e.Y.ToString();
        lblPageEvents.Text += "<br />btnTotoro_Click";
    }

    /// <summary>
    /// Event handler for Page Events button
    /// </summary>
    /// <param name="sender">btnPageEvents</param>
    /// <param name="e">Event data</param>
    protected void btnPageEvents_Click(object sender, EventArgs e)
    {
        lblPageEvents.Text += "<br />btnPageEvents_Click";
    }
    
    /// <summary>
    /// Event handler for Select button
    /// </summary>
    /// <param name="sender">btnPostBack</param>
    /// <param name="e">Event data</param>
    protected void btnPostBack_Click(object sender, EventArgs e)
    {
        lblPostBack.Text = "You selected " + ddlPostBack.SelectedItem.Text + " which is index " + ddlPostBack.SelectedIndex.ToString();
        lblPageEvents.Text += "<br />btnPostBack_Click";
    }

    /// <summary>
    /// Event handler for Post Back drop down list
    /// </summary>
    /// <param name="sender">ddlPostBack</param>
    /// <param name="e">Event data</param>
    protected void ddlPostBack_SelectedIndexChanged(object sender, EventArgs e)
    {
        lblPageEvents.Text += "<br />ddlPostBack_SelectedIndexChanged";
    }
    
    /// <summary>
    /// The Page_Prerender event occurs on every page cycle after any control events
    /// </summary>
    protected void Page_Prerender()
    {
        lblPageEvents.Text += "<br />Page_PreRender";
    }
}