﻿<%@ Page Language="C#" AutoEventWireup="true" CodeFile="categories_bar.aspx.cs" Inherits="categories_bar" %>

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
        <asp:Chart ID="chtCategories" runat="server" DataSourceID="sqlCategories" Height="600px" Width="600px">
            <Series>
                <asp:Series Name="Series1" ChartType="Bar" XValueMember="Category" YValueMembers="Products">
                </asp:Series>
            </Series>
            <ChartAreas>
                <asp:ChartArea Name="ChartArea1">
                </asp:ChartArea>
            </ChartAreas>
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
