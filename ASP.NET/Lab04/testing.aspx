<%@ Page Language="C#" AutoEventWireup="true" CodeFile="testing.aspx.cs" Inherits="testing" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:Button ID="Button1" runat="server" Text="Button" OnClick="Button1_Click" />
    </div>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:HASCConnectionString %>" SelectCommand="SELECT * FROM [Teams]"></asp:SqlDataSource>
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataKeyNames="TeamID" DataSourceID="SqlDataSource1">
            <Columns>
                <asp:BoundField DataField="TeamID" HeaderText="TeamID" ReadOnly="True" SortExpression="TeamID" />
                <asp:BoundField DataField="TeamName" HeaderText="TeamName" SortExpression="TeamName" />
                <asp:BoundField DataField="JerseyColour" HeaderText="JerseyColour" SortExpression="JerseyColour" />
                <asp:BoundField DataField="DivisionID" HeaderText="DivisionID" SortExpression="DivisionID" />
            </Columns>
        </asp:GridView>
        <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
    </form>
</body>
</html>
