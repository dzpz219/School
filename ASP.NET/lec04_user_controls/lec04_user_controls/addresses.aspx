<%@ Page Language="C#" AutoEventWireup="true" CodeFile="addresses.aspx.cs" Inherits="addresses" %>

<%@ Register Src="address.ascx" TagName="address" TagPrefix="uc1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>User Controls</title>
    <link href="StyleSheet.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <uc1:address
                ID="addBilling"
                runat="server"
                Title="Billing Address" />
            <br />
            <br />
            <uc1:address
                ID="addShipping"
                runat="server"
                Title="Shipping Address" />
            <br />
            <asp:Button
                ID="btnSubmit"
                runat="server"
                OnClick="btnSubmit_Click"
                Text="Submit" /><br />
            <br />
            <asp:Label
                ID="lblResult"
                runat="server"></asp:Label>
            <br />
            <br />
            <a href="Default.aspx">Default.aspx</a>
        </div>
    </form>
</body>
</html>
