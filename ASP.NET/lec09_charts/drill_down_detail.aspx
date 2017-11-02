<%@ Page Language="C#" AutoEventWireup="true" CodeFile="drill_down_detail.aspx.cs" Inherits="drill_down_detail" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Sales by Product</title>
    <link href="StyleSheet.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <h1><asp:Literal ID="ltlCategory" runat="server"></asp:Literal> Sales</h1>
            <asp:Chart ID="chtProducts" runat="server">
                <Series>
                    <asp:Series Name="Series1">
                    </asp:Series>
                </Series>
                <ChartAreas>
                    <asp:ChartArea Name="ChartArea1">
                    </asp:ChartArea>
                </ChartAreas>
            </asp:Chart>
        <p><asp:Label id="lblError" runat="server"></asp:Label></p>
        <p><a href="drill_down.aspx">Back</a></p>
        <p><a href="Default.aspx">Default.aspx</a></p>
    </div>
    </form>
</body>
</html>
