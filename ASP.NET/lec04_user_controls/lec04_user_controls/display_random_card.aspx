<%@ Page Language="C#" AutoEventWireup="true" CodeFile="display_random_card.aspx.cs" Inherits="display_random_card" %>

<%@ Register src="random_card.ascx" tagname="random_card" tagprefix="uc1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
    <head id="Head1" runat="server">
        <title>User Controls</title>
        <link href="StyleSheet.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <form id="form1" runat="server">
        <div>
            Card changes on every refresh.<br />
            <br />
            <uc1:random_card ID="random_card1" runat="server" />
            <br />
            <br />
            <a href="Default.aspx">Default.aspx</a></div>
        </form>
    </body>

</html>