<%@ Page Language="C#" AutoEventWireup="true" CodeFile="grid_view_summary.aspx.cs" Inherits="grid_view_summary" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>GridView with Summary</title>
    <link href="StyleSheet.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <h1>GridView with Summary Row</h1>
        <asp:GridView ID="grdInventory" runat="server" AutoGenerateColumns="False" DataSourceID="sqlInventory" OnRowDataBound="grdInventory_RowDataBound" CellPadding="4" ForeColor="#333333" GridLines="None" ShowFooter="True">
            <AlternatingRowStyle BackColor="White" />
            <Columns>
                <asp:BoundField DataField="Category" HeaderText="Category" SortExpression="Category" />
                <asp:TemplateField HeaderText="Inventory Value" SortExpression="InventoryValue">
                    <ItemTemplate>
                        <%# Eval("InventoryValue", "{0:c}") %>
                    </ItemTemplate>
                    <ItemStyle HorizontalAlign="Right" />
                    <FooterTemplate>
                        <b><asp:Label id="lblSummary" Runat="server" /></b>
                    </FooterTemplate>
                    <FooterStyle HorizontalAlign="Right" />
                </asp:TemplateField>
            </Columns>
            <EditRowStyle BackColor="#7C6F57" />
            <FooterStyle BackColor="#1C5E55" Font-Bold="True" ForeColor="White" />
            <HeaderStyle BackColor="#1C5E55" Font-Bold="True" ForeColor="White" />
            <PagerStyle BackColor="#666666" ForeColor="White" HorizontalAlign="Center" />
            <RowStyle BackColor="#E3EAEB" />
            <SelectedRowStyle BackColor="#C5BBAF" Font-Bold="True" ForeColor="#333333" />
            <SortedAscendingCellStyle BackColor="#F8FAFA" />
            <SortedAscendingHeaderStyle BackColor="#246B61" />
            <SortedDescendingCellStyle BackColor="#D4DFE1" />
            <SortedDescendingHeaderStyle BackColor="#15524A" />
        </asp:GridView>
        <asp:SqlDataSource ID="sqlInventory"
            runat="server"
            ConnectionString='<%$ ConnectionStrings:NorthwindConnectionString %>'
            SelectCommand="SELECT CategoryName AS Category, SUM(UnitPrice * UnitsInStock) AS InventoryValue FROM Categories c JOIN Products p ON c.CategoryID = p.CategoryID GROUP BY CategoryName">
        </asp:SqlDataSource>
        <p><a href="Default.aspx">Default.aspx</a></p>
    </div>
    </form>
</body>
</html>
