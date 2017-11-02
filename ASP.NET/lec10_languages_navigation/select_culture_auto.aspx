<%@ Page Language="C#" AutoEventWireup="true" CodeFile="select_culture_auto.aspx.cs" Inherits="select_culture_auto" Culture="auto:en-CA" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Automatically Select Culture</title>
    <link href="StyleSheet.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <h1>Culture Selected Automatically</h1>
        <p>Today's date is: <asp:Label id="lblDate" Runat="server" /></p>
        <p>The price of the product is: <asp:Label id="lblPrice" Runat="server" /></p>
        <asp:Calendar ID="Calendar1" runat="server"></asp:Calendar>
        <p>Culture=&quot;auto:en-CA&quot; added to Page directive.<br />
           Adding en-CA after auto acts as a default culture, if language preference can&#39;t be determined by 
           the browser.</p>
        <p><a href="Default.aspx">Default.aspx</a></p>
    </div>
    </form>
</body>
</html>
