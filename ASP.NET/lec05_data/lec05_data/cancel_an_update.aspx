<%@ Page Language="C#" AutoEventWireup="true" CodeFile="cancel_an_update.aspx.cs" Inherits="cancel_an_update" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Cancelling an Update</title>
    <link href="StyleSheet.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <h1>Cancelling an Update</h1>
        <asp:DetailsView
            ID="dtlDepartments"
            runat="server"
            AutoGenerateRows="False"
            DataKeyNames="DepartmentID"
            DataSourceID="sqlDepartments"
            AllowPaging="True">
            <Fields>
                <asp:BoundField DataField="DepartmentID" HeaderText="DepartmentID" ReadOnly="True" SortExpression="DepartmentID"></asp:BoundField>
                <asp:BoundField DataField="DepartmentName" HeaderText="DepartmentName" SortExpression="DepartmentName"></asp:BoundField>
                <asp:BoundField DataField="ManagerFirstName" HeaderText="ManagerFirstName" SortExpression="ManagerFirstName"></asp:BoundField>
                <asp:BoundField DataField="ManagerLastName" HeaderText="ManagerLastName" SortExpression="ManagerLastName"></asp:BoundField>
                <asp:CommandField ShowEditButton="True" />
            </Fields>
        </asp:DetailsView>
        <p><asp:Label ID="lblError" runat="server" EnableViewState="false" ForeColor="Red"></asp:Label></p>
        <p><a href="Default.aspx">Default.aspx</a></p>
        <asp:SqlDataSource
            ID="sqlDepartments"
            runat="server"
            ConnectionString='<%$ ConnectionStrings:CHDBConnectionString %>'
            SelectCommand="SELECT Departments.* FROM Departments"
            UpdateCommand="UPDATE Departments SET DepartmentName = @DepartmentName, ManagerFirstName = @ManagerFirstName, ManagerLastName = @ManagerLastName WHERE (DepartmentID = @DepartmentID)"
            OnUpdating="sqlDepartments_Updating">
            <UpdateParameters>
                <asp:Parameter Name="DepartmentName"></asp:Parameter>
                <asp:Parameter Name="ManagerFirstName"></asp:Parameter>
                <asp:Parameter Name="ManagerLastName"></asp:Parameter>
                <asp:Parameter Name="DepartmentID"></asp:Parameter>
            </UpdateParameters>
        </asp:SqlDataSource>
    </div>
    </form>
</body>
</html>