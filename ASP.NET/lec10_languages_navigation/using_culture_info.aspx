<%@ Page Language="C#" AutoEventWireup="true" CodeFile="using_culture_info.aspx.cs" Inherits="using_culture_info" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Using the CultureInfo Class</title>
    <link href="StyleSheet.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <h1>Using the CultureInfo Class</h1>

        <h2>German</h2>
        <p>Today's date is: <asp:Label id="lblGermanDate" Runat="server" /><br />    
           The price of the product is: <asp:Label id="lblGermanPrice" Runat="server" /></p>

        <h2>Hungarian</h2>
        <p>Today's date is: <asp:Label id="lblHungarianDate" Runat="server" /><br />    
           The price of the product is: <asp:Label id="lblHungarianPrice" Runat="server" /></p>

        <p><a href="Default.aspx">Default.aspx</a></p>
    </div>
    </form>
</body>
</html>
