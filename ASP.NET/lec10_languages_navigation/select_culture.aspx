<%@ Page Language="C#" AutoEventWireup="true" CodeFile="select_culture.aspx.cs" Inherits="select_culture" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Select Culture</title>
    <link href="StyleSheet.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <p><asp:Label
            ID="lblHungarian"
            runat="server"
            Text="Culture set to hu-HU Hungarian (Hungary) in Page_Load, first post only.">
        </asp:Label></p>
        
        <p><asp:Label
            id="lblCulture"
            Text="Select culture:"
            AssociatedControlID="ddlCulture"
            Runat="server" />
            &nbsp;
        
        <asp:DropDownList
            id="ddlCulture"
            DataTextField="DisplayName"
            DataValueField="Name"
            DataSourceID="srcCultures"
            Runat="server"
            AutoPostBack="True"
            OnSelectedIndexChanged="ddlCulture_SelectedIndexChanged" />
            &nbsp;
        
        Cultures appear in Locale ID (LCID) sequence.</p>

        <asp:ObjectDataSource
            id="srcCultures"
            TypeName="System.Globalization.CultureInfo"
            SelectMethod="GetCultures"
            Runat="server">
            <SelectParameters>
                <asp:Parameter Name="types" DefaultValue="SpecificCultures" />
            </SelectParameters>
        </asp:ObjectDataSource>
    
        <hr />
        <p>Today's date is: <asp:Label id="lblDate" Runat="server" /></p>
        <p>The price of the product is: <asp:Label id="lblPrice" Runat="server" /></p>
        <asp:Calendar ID="Calendar1" runat="server"></asp:Calendar>

        <p><a href="Default.aspx">Default.aspx</a></p>

        <asp:Literal ID="ltlCulture" runat="server"></asp:Literal>
    </div>
    </form>
</body>
</html>
