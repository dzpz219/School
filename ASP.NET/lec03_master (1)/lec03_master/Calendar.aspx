<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Calendar.aspx.cs" Inherits="Calendar" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    <title>Calendar Control</title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        Calendar selection mode:

        <asp:DropDownList ID="ddlSelectionMode" runat="server" AutoPostBack="True" 
            onselectedindexchanged="ddlSelectionMode_SelectedIndexChanged">
            <asp:ListItem Value="d">Day</asp:ListItem>
            <asp:ListItem Value="dw">DayWeek</asp:ListItem>
            <asp:ListItem Value="dwm">DayWeekMonth</asp:ListItem>
            <asp:ListItem Value="n">None</asp:ListItem>
        </asp:DropDownList>

        <br /><br />

        <asp:Calendar ID="Calendar1" runat="server" 
            onselectionchanged="Calendar1_SelectionChanged">
        </asp:Calendar>

        <hr />

        <asp:BulletedList ID="bltResults" DataTextFormatString="{0:d}" runat="server">
        </asp:BulletedList>
        <a href="Default.aspx">Default.aspx</a>
    </div>
    </form>
</body>
</html>