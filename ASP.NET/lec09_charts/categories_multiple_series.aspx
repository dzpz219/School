<%@ Page Language="C#" AutoEventWireup="true" CodeFile="categories_multiple_series.aspx.cs" Inherits="categories_multiple_series" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Monthly Sales by Category</title>
    <link href="StyleSheet.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <h1>Monthly Sales by Category</h1>
        <asp:Chart ID="chtSalesByCategory" runat="server">
            <Series>
                <asp:Series Name="Series1"></asp:Series>
            </Series>
            <ChartAreas>
                <asp:ChartArea Name="ChartArea1"></asp:ChartArea>
            </ChartAreas>
        </asp:Chart>
        <p><asp:Label ID="lblError" runat="server"></asp:Label></p>
        <p><a href="Default.aspx">Default.aspx</a></p>
    </div>
    </form>
</body>
</html>
