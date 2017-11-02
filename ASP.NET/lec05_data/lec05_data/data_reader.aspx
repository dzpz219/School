<%@ Page Language="C#" AutoEventWireup="true" CodeFile="data_reader.aspx.cs" Inherits="data_reader" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>SQL Data Reader</title>
    <link href="StyleSheet.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <h1>DataSource in DataReader Mode</h1>
        <asp:GridView ID="grdPurchases" runat="server" AutoGenerateColumns="False" DataSourceID="sqlPurchases">
            <Columns>
                <asp:BoundField DataField="OrderDate" DataFormatString="{0:d}" HeaderText="OrderDate" SortExpression="OrderDate" />
                <asp:BoundField DataField="DepartmentName" HeaderText="DepartmentName" SortExpression="DepartmentName" />
                <asp:BoundField DataField="VendorName" HeaderText="VendorName" SortExpression="VendorName" />
                <asp:BoundField DataField="TotalAmount" HeaderText="TotalAmount" SortExpression="TotalAmount" />
                <asp:BoundField DataField="OrderStatus" HeaderText="OrderStatus" SortExpression="OrderStatus" />
            </Columns>
        </asp:GridView>
        <p><a href="Default.aspx">Default.aspx</a></p>
        <asp:SqlDataSource ID="sqlPurchases" runat="server" ConnectionString="<%$ ConnectionStrings:CHDBConnectionString %>" DataSourceMode="DataReader" SelectCommand="SELECT PurchaseOrders.OrderDate, Departments.DepartmentName, Vendors.VendorName, PurchaseOrders.TotalAmount, PurchaseOrders.OrderStatus FROM PurchaseOrders INNER JOIN Departments ON PurchaseOrders.DepartmentID = Departments.DepartmentID INNER JOIN Vendors ON PurchaseOrders.VendorID = Vendors.VendorID"></asp:SqlDataSource>
    </div>
    </form>
</body>
</html>
