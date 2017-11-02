<%@ Page Language="C#" AutoEventWireup="true" CodeFile="non_db_data.aspx.cs" Inherits="non_db_data" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Leafs vs. Canadiens</title>
    <link href="StyleSheet.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:Chart ID="chtLeafsVsCanadiens" runat="server">
            <Series>
                <asp:Series Name="Series1"></asp:Series>
            </Series>
            <ChartAreas>
                <asp:ChartArea Name="ChartArea1"></asp:ChartArea>
            </ChartAreas>
        </asp:Chart>
        <p><a href="Default.aspx">Default.aspx</a></p>
    </div>
    </form>
</body>
</html>
