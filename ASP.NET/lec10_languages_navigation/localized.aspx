<%@ Page Language="C#" AutoEventWireup="true" CodeFile="localized.aspx.cs" Inherits="localized" UICulture="auto" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Localized Page</title>
    <link href="StyleSheet.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server" defaultfocus="txtFirstName">
    <div>
        <h1><asp:Literal Text="<%$ Resources:Header %>" ID="h1Header" runat="server" /></h1>

        <table>
        <tr>
            <td><asp:Label ID="lblFirstName" Text="<%$ Resources:FirstName %>" runat="server" /></td>
            <td><asp:TextBox ID="txtFirstName" runat="server" /></td>
        </tr>
        <tr>
            <td><asp:Label ID="lblLastName" Text="<%$ Resources:LastName %>" runat="server" /></td>
            <td><asp:TextBox ID="txtLastName" runat="server" /></td>
        </tr>
        </table><br />

        <asp:Button ID="btnSubmit" Text="<%$ Resources:Submit %>" runat="server" OnClick="btnSubmit_Click" />

        <p><asp:Label ID="lblResult" runat="server" /></p>

        <p><asp:Label ID="Label1" Text="<%$ Resources:Site,Greeting %>" runat="server" /></p>

        <p>UICulture=&quot;auto&quot; added to Page directive</p>

        <p><a href="Default.aspx">Default.aspx</a></p>
    </div>
    </form>
</body>
</html>
