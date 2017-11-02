<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Tree.aspx.cs" Inherits="Tree" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Tree View</title>
    <link href="StyleSheet.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <h1>Tree View</h1>

        <asp:SiteMapDataSource ID="srcSiteMap" runat="server" />
        <p><b>A TreeView can be used for navigation</b></p>
        <asp:TreeView
            ID="treNavigation"
            runat="server"
            DataSourceID="srcSiteMap"
            ShowLines="True"
            ImageSet="XPFileExplorer">
        </asp:TreeView>

        <asp:XmlDataSource ID="srcXML" runat="server" DataFile="~/restaurant.xml"></asp:XmlDataSource>
        <p><b>Or for any hierarchical data</b></p>
        <asp:TreeView ID="treMeals" runat="server" DataSourceID="srcXML" ShowCheckBoxes="All" ShowLines="True">
        </asp:TreeView>

        <asp:Button ID="btnOrder" runat="server" Text="Order" OnClick="btnOrder_Click" />
            
        <asp:BulletedList ID="bltMeals" runat="server">
        </asp:BulletedList>

        <p><a href="navigation.aspx">navigation.aspx</a></p>
            
    </div>
    </form>
</body>
</html>