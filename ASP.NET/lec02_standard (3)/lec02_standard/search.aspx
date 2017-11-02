<%@ Page Language="C#" AutoEventWireup="true" CodeFile="search.aspx.cs" Inherits="search" %>
<%@ PreviousPageType VirtualPath="~/Default.aspx" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    <title>Search Page</title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:Label ID="lblSearch" runat="server"></asp:Label><br />
        <asp:Label ID="lblSearchTyped" runat="server"></asp:Label><br />
        <asp:Label ID="lblSearchRequestObject" runat="server"></asp:Label><br />
        <asp:Label ID="lblNoSearchText" runat="server"></asp:Label>
    </div>
    </form>
</body>
</html>