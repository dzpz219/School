<%@ Page Language="C#" AutoEventWireup="true" CodeFile="categories.aspx.cs" Inherits="categories" %>

<%@ Register assembly="System.Web.DataVisualization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35" namespace="System.Web.UI.DataVisualization.Charting" tagprefix="asp" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Categories</title>
    <link href="StyleSheet.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <h1>Number of Products in each Category</h1>
        <asp:Chart ID="chtCategories" runat="server" DataSourceID="sqlCategories">
            <series>
                <asp:Series Name="Series1" XValueMember="Category" YValueMembers="Products">
                </asp:Series>
            </series>
            <chartareas>
                <asp:ChartArea Name="ChartArea1">
                </asp:ChartArea>
            </chartareas>
        </asp:Chart>
        <asp:SqlDataSource
            ID="sqlCategories"
            runat="server"
            ConnectionString="<%$ ConnectionStrings:NorthwindConnectionString %>"
            SelectCommand="SELECT * FROM [ProductCounts] ORDER BY [Category]">
        </asp:SqlDataSource>
        <p><a href="Default.aspx">Default.aspx</a></p>
    </div>
    </form>
</body>
</html>