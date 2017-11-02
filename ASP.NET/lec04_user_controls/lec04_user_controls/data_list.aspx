<%@ Page Language="C#" AutoEventWireup="true" CodeFile="data_list.aspx.cs" Inherits="data_list" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>DataList Controls</title>
    <link href="StyleSheet.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:SqlDataSource
                ID="sqlPhysicians"
                runat="server"
                ConnectionString="<%$ ConnectionStrings:CHDBConnectionString %>"
                SelectCommand="SELECT [FirstName], [LastName], [Specialty], [Phone] FROM [Physicians]"></asp:SqlDataSource>
            <div class="floater">
                <asp:DataList ID="dlsPhysicians" runat="server" DataSourceID="sqlPhysicians" CellPadding="4" ForeColor="#333333">
                    <ItemTemplate>
                        <b>Dr. <%# Eval("FirstName") %> <%# Eval("LastName") %></b> is a <%# Eval("Specialty") %> and can be reached at <%# Eval("Phone") %>
                    </ItemTemplate>
                    <AlternatingItemStyle BackColor="White" />
                    <ItemStyle BackColor="#FFFBD6" />
                </asp:DataList>
            </div>
            <a href="Default.aspx">Default.aspx</a>
        </div>
    </form>
</body>
</html>
