<%@ Page Language="C#" AutoEventWireup="true" CodeFile="gridview.aspx.cs" Inherits="gridview" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <link href="StyleSheet.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <asp:SqlDataSource ID="sqlCategories" runat="server" ConnectionString="<%$ ConnectionStrings:NorthwindConnectionString1 %>" SelectCommand="SELECT [CategoryID], [CategoryName] FROM [Categories]"></asp:SqlDataSource>
        Category:
        <asp:DropDownList ID="ddlCategory" runat="server" AutoPostBack="True" DataSourceID="sqlCategories" DataTextField="CategoryName" DataValueField="CategoryID">
        </asp:DropDownList>
        <br />
        <br />
        <asp:GridView ID="grdProducts" runat="server" AllowPaging="True" AllowSorting="True" AutoGenerateColumns="False" BackColor="White" BorderColor="#CC9966" BorderStyle="None" BorderWidth="1px" CellPadding="4" DataKeyNames="ProductID" DataSourceID="sqlProducts" EmptyDataText="There are no data records to display.">
            <Columns>
                <asp:CommandField ShowSelectButton="True" />
                <asp:BoundField DataField="ProductName" HeaderText="ProductName" SortExpression="ProductName" />
                <asp:BoundField DataField="QuantityPerUnit" HeaderText="QuantityPerUnit" SortExpression="QuantityPerUnit"></asp:BoundField>
                <asp:BoundField DataField="UnitPrice" HeaderText="UnitPrice" SortExpression="UnitPrice"></asp:BoundField>
                <asp:BoundField DataField="UnitsInStock" HeaderText="UnitsInStock" SortExpression="UnitsInStock"></asp:BoundField>
            </Columns>
            <FooterStyle BackColor="#FFFFCC" ForeColor="#330099" />
            <HeaderStyle BackColor="#990000" Font-Bold="True" ForeColor="#FFFFCC" />
            <PagerStyle BackColor="#FFFFCC" ForeColor="#330099" HorizontalAlign="Center" />
            <RowStyle BackColor="White" ForeColor="#330099" />
            <SelectedRowStyle BackColor="#FFCC66" Font-Bold="True" ForeColor="#663399" />
            <SortedAscendingCellStyle BackColor="#FEFCEB" />
            <SortedAscendingHeaderStyle BackColor="#AF0101" />
            <SortedDescendingCellStyle BackColor="#F6F0C0" />
            <SortedDescendingHeaderStyle BackColor="#7E0000" />
        </asp:GridView>
        <asp:SqlDataSource ID="sqlProducts" runat="server" ConflictDetection="CompareAllValues" ConnectionString="<%$ ConnectionStrings:NorthwindConnectionString1 %>" DeleteCommand="DELETE FROM [Products] WHERE [ProductID] = @original_ProductID AND [ProductName] = @original_ProductName AND (([QuantityPerUnit] = @original_QuantityPerUnit) OR ([QuantityPerUnit] IS NULL AND @original_QuantityPerUnit IS NULL)) AND (([UnitPrice] = @original_UnitPrice) OR ([UnitPrice] IS NULL AND @original_UnitPrice IS NULL)) AND (([UnitsInStock] = @original_UnitsInStock) OR ([UnitsInStock] IS NULL AND @original_UnitsInStock IS NULL))" InsertCommand="INSERT INTO [Products] ([ProductName], [QuantityPerUnit], [UnitPrice], [UnitsInStock]) VALUES (@ProductName, @QuantityPerUnit, @UnitPrice, @UnitsInStock)" OldValuesParameterFormatString="original_{0}" SelectCommand="SELECT [ProductName], [QuantityPerUnit], [UnitPrice], [UnitsInStock], [ProductID] FROM [Products] WHERE ([CategoryID] = @CategoryID)" UpdateCommand="UPDATE [Products] SET [ProductName] = @ProductName, [QuantityPerUnit] = @QuantityPerUnit, [UnitPrice] = @UnitPrice, [UnitsInStock] = @UnitsInStock WHERE [ProductID] = @original_ProductID AND [ProductName] = @original_ProductName AND (([QuantityPerUnit] = @original_QuantityPerUnit) OR ([QuantityPerUnit] IS NULL AND @original_QuantityPerUnit IS NULL)) AND (([UnitPrice] = @original_UnitPrice) OR ([UnitPrice] IS NULL AND @original_UnitPrice IS NULL)) AND (([UnitsInStock] = @original_UnitsInStock) OR ([UnitsInStock] IS NULL AND @original_UnitsInStock IS NULL))">
            <DeleteParameters>
                <asp:Parameter Name="original_ProductID" Type="Int32" />
                <asp:Parameter Name="original_ProductName" Type="String" />
                <asp:Parameter Name="original_QuantityPerUnit" Type="String" />
                <asp:Parameter Name="original_UnitPrice" Type="Decimal" />
                <asp:Parameter Name="original_UnitsInStock" Type="Int16" />
            </DeleteParameters>
            <InsertParameters>
                <asp:Parameter Name="ProductName" Type="String" />
                <asp:Parameter Name="QuantityPerUnit" Type="String" />
                <asp:Parameter Name="UnitPrice" Type="Decimal" />
                <asp:Parameter Name="UnitsInStock" Type="Int16" />
            </InsertParameters>
            <SelectParameters>
                <asp:ControlParameter ControlID="ddlCategory" Name="CategoryID" PropertyName="SelectedValue" Type="Int32" />
            </SelectParameters>
            <UpdateParameters>
                <asp:Parameter Name="ProductName" Type="String" />
                <asp:Parameter Name="QuantityPerUnit" Type="String" />
                <asp:Parameter Name="UnitPrice" Type="Decimal" />
                <asp:Parameter Name="UnitsInStock" Type="Int16" />
                <asp:Parameter Name="original_ProductID" Type="Int32" />
                <asp:Parameter Name="original_ProductName" Type="String" />
                <asp:Parameter Name="original_QuantityPerUnit" Type="String" />
                <asp:Parameter Name="original_UnitPrice" Type="Decimal" />
                <asp:Parameter Name="original_UnitsInStock" Type="Int16" />
            </UpdateParameters>
        </asp:SqlDataSource>
        <br />
        <asp:SqlDataSource ID="sqlProduct" runat="server" ConflictDetection="CompareAllValues" ConnectionString="<%$ ConnectionStrings:NorthwindConnectionString1 %>" DeleteCommand="DELETE FROM [Products] WHERE [ProductID] = @original_ProductID AND [ProductName] = @original_ProductName AND (([SupplierID] = @original_SupplierID) OR ([SupplierID] IS NULL AND @original_SupplierID IS NULL)) AND (([CategoryID] = @original_CategoryID) OR ([CategoryID] IS NULL AND @original_CategoryID IS NULL)) AND (([QuantityPerUnit] = @original_QuantityPerUnit) OR ([QuantityPerUnit] IS NULL AND @original_QuantityPerUnit IS NULL)) AND (([UnitPrice] = @original_UnitPrice) OR ([UnitPrice] IS NULL AND @original_UnitPrice IS NULL)) AND (([UnitsInStock] = @original_UnitsInStock) OR ([UnitsInStock] IS NULL AND @original_UnitsInStock IS NULL)) AND (([UnitsOnOrder] = @original_UnitsOnOrder) OR ([UnitsOnOrder] IS NULL AND @original_UnitsOnOrder IS NULL)) AND (([ReorderLevel] = @original_ReorderLevel) OR ([ReorderLevel] IS NULL AND @original_ReorderLevel IS NULL)) AND [Discontinued] = @original_Discontinued" InsertCommand="INSERT INTO [Products] ([ProductName], [SupplierID], [CategoryID], [QuantityPerUnit], [UnitPrice], [UnitsInStock], [UnitsOnOrder], [ReorderLevel], [Discontinued]) VALUES (@ProductName, @SupplierID, @CategoryID, @QuantityPerUnit, @UnitPrice, @UnitsInStock, @UnitsOnOrder, @ReorderLevel, @Discontinued)" OldValuesParameterFormatString="original_{0}" SelectCommand="SELECT * FROM [Products] WHERE ([ProductID] = @ProductID)" UpdateCommand="UPDATE [Products] SET [ProductName] = @ProductName, [SupplierID] = @SupplierID, [CategoryID] = @CategoryID, [QuantityPerUnit] = @QuantityPerUnit, [UnitPrice] = @UnitPrice, [UnitsInStock] = @UnitsInStock, [UnitsOnOrder] = @UnitsOnOrder, [ReorderLevel] = @ReorderLevel, [Discontinued] = @Discontinued WHERE [ProductID] = @original_ProductID AND [ProductName] = @original_ProductName AND (([SupplierID] = @original_SupplierID) OR ([SupplierID] IS NULL AND @original_SupplierID IS NULL)) AND (([CategoryID] = @original_CategoryID) OR ([CategoryID] IS NULL AND @original_CategoryID IS NULL)) AND (([QuantityPerUnit] = @original_QuantityPerUnit) OR ([QuantityPerUnit] IS NULL AND @original_QuantityPerUnit IS NULL)) AND (([UnitPrice] = @original_UnitPrice) OR ([UnitPrice] IS NULL AND @original_UnitPrice IS NULL)) AND (([UnitsInStock] = @original_UnitsInStock) OR ([UnitsInStock] IS NULL AND @original_UnitsInStock IS NULL)) AND (([UnitsOnOrder] = @original_UnitsOnOrder) OR ([UnitsOnOrder] IS NULL AND @original_UnitsOnOrder IS NULL)) AND (([ReorderLevel] = @original_ReorderLevel) OR ([ReorderLevel] IS NULL AND @original_ReorderLevel IS NULL)) AND [Discontinued] = @original_Discontinued">
            <DeleteParameters>
                <asp:Parameter Name="original_ProductID" Type="Int32" />
                <asp:Parameter Name="original_ProductName" Type="String" />
                <asp:Parameter Name="original_SupplierID" Type="Int32" />
                <asp:Parameter Name="original_CategoryID" Type="Int32" />
                <asp:Parameter Name="original_QuantityPerUnit" Type="String" />
                <asp:Parameter Name="original_UnitPrice" Type="Decimal" />
                <asp:Parameter Name="original_UnitsInStock" Type="Int16" />
                <asp:Parameter Name="original_UnitsOnOrder" Type="Int16" />
                <asp:Parameter Name="original_ReorderLevel" Type="Int16" />
                <asp:Parameter Name="original_Discontinued" Type="Boolean" />
            </DeleteParameters>
            <InsertParameters>
                <asp:Parameter Name="ProductName" Type="String" />
                <asp:Parameter Name="SupplierID" Type="Int32" />
                <asp:Parameter Name="CategoryID" Type="Int32" />
                <asp:Parameter Name="QuantityPerUnit" Type="String" />
                <asp:Parameter Name="UnitPrice" Type="Decimal" />
                <asp:Parameter Name="UnitsInStock" Type="Int16" />
                <asp:Parameter Name="UnitsOnOrder" Type="Int16" />
                <asp:Parameter Name="ReorderLevel" Type="Int16" />
                <asp:Parameter Name="Discontinued" Type="Boolean" />
            </InsertParameters>
            <SelectParameters>
                <asp:ControlParameter ControlID="grdProducts" Name="ProductID" PropertyName="SelectedValue" Type="Int32" />
            </SelectParameters>
            <UpdateParameters>
                <asp:Parameter Name="ProductName" Type="String" />
                <asp:Parameter Name="SupplierID" Type="Int32" />
                <asp:Parameter Name="CategoryID" Type="Int32" />
                <asp:Parameter Name="QuantityPerUnit" Type="String" />
                <asp:Parameter Name="UnitPrice" Type="Decimal" />
                <asp:Parameter Name="UnitsInStock" Type="Int16" />
                <asp:Parameter Name="UnitsOnOrder" Type="Int16" />
                <asp:Parameter Name="ReorderLevel" Type="Int16" />
                <asp:Parameter Name="Discontinued" Type="Boolean" />
                <asp:Parameter Name="original_ProductID" Type="Int32" />
                <asp:Parameter Name="original_ProductName" Type="String" />
                <asp:Parameter Name="original_SupplierID" Type="Int32" />
                <asp:Parameter Name="original_CategoryID" Type="Int32" />
                <asp:Parameter Name="original_QuantityPerUnit" Type="String" />
                <asp:Parameter Name="original_UnitPrice" Type="Decimal" />
                <asp:Parameter Name="original_UnitsInStock" Type="Int16" />
                <asp:Parameter Name="original_UnitsOnOrder" Type="Int16" />
                <asp:Parameter Name="original_ReorderLevel" Type="Int16" />
                <asp:Parameter Name="original_Discontinued" Type="Boolean" />
            </UpdateParameters>
        </asp:SqlDataSource>
        <asp:DetailsView ID="DetailsView1" runat="server" AutoGenerateRows="False" BackColor="White" BorderColor="#CC9966" BorderStyle="None" BorderWidth="1px" CellPadding="4" DataKeyNames="ProductID" DataSourceID="sqlProduct" Height="50px">
            <EditRowStyle BackColor="#FFCC66" Font-Bold="True" ForeColor="#663399" />
            <Fields>
                <asp:BoundField DataField="ProductID" HeaderText="ProductID" InsertVisible="False" ReadOnly="True" SortExpression="ProductID" />
                <asp:BoundField DataField="ProductName" HeaderText="ProductName" SortExpression="ProductName" />
                <asp:BoundField DataField="SupplierID" HeaderText="SupplierID" SortExpression="SupplierID" />
                <asp:BoundField DataField="CategoryID" HeaderText="CategoryID" SortExpression="CategoryID" />
                <asp:BoundField DataField="QuantityPerUnit" HeaderText="QuantityPerUnit" SortExpression="QuantityPerUnit" />
                <asp:BoundField DataField="UnitPrice" HeaderText="UnitPrice" SortExpression="UnitPrice" />
                <asp:BoundField DataField="UnitsInStock" HeaderText="UnitsInStock" SortExpression="UnitsInStock" />
                <asp:BoundField DataField="UnitsOnOrder" HeaderText="UnitsOnOrder" SortExpression="UnitsOnOrder" />
                <asp:BoundField DataField="ReorderLevel" HeaderText="ReorderLevel" SortExpression="ReorderLevel" />
                <asp:CheckBoxField DataField="Discontinued" HeaderText="Discontinued" SortExpression="Discontinued" />
                <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" ShowInsertButton="True" />
            </Fields>
            <FooterStyle BackColor="#FFFFCC" ForeColor="#330099" />
            <HeaderStyle BackColor="#990000" Font-Bold="True" ForeColor="#FFFFCC" />
            <PagerStyle BackColor="#FFFFCC" ForeColor="#330099" HorizontalAlign="Center" />
            <RowStyle BackColor="White" ForeColor="#330099" />
        </asp:DetailsView>
        <a href="Default.aspx">Default.aspx</a>
    
    </div>
    </form>
</body>
</html>
