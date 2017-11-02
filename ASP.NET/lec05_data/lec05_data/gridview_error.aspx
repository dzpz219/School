<%@ Page Language="C#" AutoEventWireup="true" CodeFile="gridview_error.aspx.cs" Inherits="gridview_error" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>GridView Error Handling</title>
    <link href="StyleSheet.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h1>GridView Error Handling</h1>
            <asp:GridView
                ID="grdDepartments"
                runat="server"
                AutoGenerateColumns="False"
                DataKeyNames="DepartmentID"
                DataSourceID="sqlDepartments"
                OnRowUpdated="grdDepartments_RowUpdated">
                <Columns>
                    <asp:CommandField ShowEditButton="True" />
                    <asp:BoundField DataField="DepartmentID" HeaderText="DepartmentID" ReadOnly="True" SortExpression="DepartmentID" />
                    <asp:BoundField DataField="DepartmentName" HeaderText="DepartmentName" SortExpression="DepartmentName" />
                    <asp:BoundField DataField="ManagerFirstName" HeaderText="ManagerFirstName" SortExpression="ManagerFirstName" />
                    <asp:BoundField DataField="ManagerLastName" HeaderText="ManagerLastName" SortExpression="ManagerLastName" />
                </Columns>
            </asp:GridView>
            <p>To simulate a run-time error, there is an error in the SQL UpdateCommand in the DataSource.<br />
               The error is handled in GridView RowUpdated event.</p>
            <p><a href="Default.aspx">Default.aspx</a></p>
            <p><asp:Label ID="lblError" runat="server" ForeColor="Red"></asp:Label></p>
            <asp:SqlDataSource
                ID="sqlDepartments"
                runat="server"
                ConnectionString='<%$ ConnectionStrings:CHDBConnectionString %>'
                SelectCommand="SELECT * FROM [Departments]"
                UpdateCommand="UPDATE [TableThatDoesNotExist] SET [DepartmentName] = @DepartmentName, [ManagerLastName] = @ManagerLastName , [ManagerFirstName] = @ManagerFirstName WHERE [DepartmentID] = @DepartmentID">
            </asp:SqlDataSource>
        </div>
    </form>
</body>
</html>