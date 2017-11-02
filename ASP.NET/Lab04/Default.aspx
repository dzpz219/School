<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <asp:DropDownList ID="divisionDropdown" runat="server" DataSourceID="divisionSrc" DataTextField="DivisionName" DataValueField="DivisionID" OnSelectedIndexChanged="divisionChange" Width="163px" AutoPostBack="True">
        </asp:DropDownList>
    
    </div>
        <asp:SqlDataSource ID="divisionSrc" runat="server" ConnectionString="<%$ ConnectionStrings:HASCConnectionString %>" SelectCommand="SELECT * FROM [Divisions]"></asp:SqlDataSource>
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataKeyNames="TeamID" DataSourceID="teamSrc">
            <Columns>
                <asp:BoundField DataField="TeamID" HeaderText="TeamID" ReadOnly="True" SortExpression="TeamID" />
                <asp:BoundField DataField="TeamName" HeaderText="TeamName" SortExpression="TeamName" />
                <asp:BoundField DataField="JerseyColour" HeaderText="JerseyColour" SortExpression="JerseyColour" />
            </Columns>
        </asp:GridView>
        <asp:SqlDataSource ID="teamSrc" runat="server" ConnectionString="<%$ ConnectionStrings:HASCConnectionString %>" SelectCommand="SELECT * FROM [Teams]"></asp:SqlDataSource>
        <asp:Button ID="Button1" runat="server" Text="Create Team" PostBackUrl="~/teams.aspx" />
    </form>
</body>
</html>
