<%@ Page Language="C#" AutoEventWireup="true" CodeFile="teams.aspx.cs" Inherits="teams" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:Label ID="Label1" runat="server" Text="Label" Font-Size="Larger"></asp:Label>
    </div>
        <asp:SqlDataSource ID="newTeamSrc" runat="server" ConnectionString="<%$ ConnectionStrings:HASCConnectionString %>" SelectCommand="SELECT * FROM [Divisions]"></asp:SqlDataSource>
        <asp:Repeater ID="Repeater1" runat="server" DataSourceID="newTeamSrc">
            <HeaderTemplate>
                <table>
                    <tr>
                        <th></th>
                        <th>Player</th>
                        <th>Skill</th>
                        <th>Email</th>
                        <th>Phone</th>
                    </tr>
            </HeaderTemplate>
            <ItemTemplate>
                <tr>
                    <td><%# DataBinder.Eval(Container.DataItem, "TeamID") %></td>
                    <td><%# DataBinder.Eval(Container.DataItem, "LastName") %>, <%# DataBinder.Eval(Container.DataItem, "FirstName") %></td>
                    <td><%# DataBinder.Eval(Container.DataItem, "SkillLevel") %></td>
                    <td><%# DataBinder.Eval(Container.DataItem, "Email") %></td>
                    <td><%# DataBinder.Eval(Container.DataItem, "Phone") %></td>
                </tr>                
            </ItemTemplate>
            <FooterTemplate>
                </table>
            </FooterTemplate>
        </asp:Repeater>
    </form>
</body>
</html>
