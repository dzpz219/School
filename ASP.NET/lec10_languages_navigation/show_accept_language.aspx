<%@ Page Language="C#" AutoEventWireup="true" CodeFile="show_accept_language.aspx.cs" Inherits="show_accept_language" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Show Accept Language Header</title>
    <link href="StyleSheet.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <h1>Accept Language Header</h1>
        <asp:BulletedList
            id="bltAcceptLanguages"
            runat="server" />
        <p><a href="Default.aspx">Default.aspx</a></p>
    </div>
    </form>
</body>
</html>
