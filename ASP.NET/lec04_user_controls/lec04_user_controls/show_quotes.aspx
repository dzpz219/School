<%@ Page Language="C#" AutoEventWireup="true" CodeFile="show_quotes.aspx.cs" Inherits="show_quotes" %>

<%@ Register Src="random_quotes.ascx" TagName="random_quotes" TagPrefix="uc1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <link href="StyleSheet.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <%= DateTime.Now %><br />
            <br />
            <b>New Yoda quotes every 5 seconds</b>
            <br />
            <br />
            <uc1:random_quotes ID="random_quotes1" runat="server" />
            <br />
            <a href="Default.aspx">Default.aspx</a>
        </div>
    </form>
</body>
</html>
