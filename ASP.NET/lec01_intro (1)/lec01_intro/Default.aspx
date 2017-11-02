<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" Trace="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Introduction to ASP.NET</title>
    <style type="text/css">
        .labelStyle
      {
            color: #006600;
            background-color: #99CCFF;
            border: medium Solid #006600;
            font-family: Arial, Helvetica, sans-serif;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <table>
            <tr>
                <td>
                    Date and time: <asp:Label ID="lblNow" runat="server"></asp:Label><br />
                    Date: <span id="spnDate" runat="server" /><br />
                    Time: <span id="spnTime" runat="server" />
                </td>
                <td>
                    <asp:Button ID="btnClick" runat="server" Text="Click Here" OnClick="btnClick_Click" /><br />
                    <asp:Label ID="lblButtonClick" runat="server"></asp:Label>
                </td>
                <td>
                    First counter: <asp:Button ID="btnCounter1" runat="server" Text="0" OnClick="btnCounter_Click" /><br />
                    Second counter: <asp:Button ID="btnCounter2" runat="server" Text="0" OnClick="btnCounter_Click" />
                </td>
            </tr>
            <tr>
                <td>
                    <asp:ImageButton ID="btnTotoro" runat="server" ImageUrl="~/images/totoro.png" OnClick="btnTotoro_Click" /><br />
                    X Coordinate: <asp:Label ID="lblX" runat="server"></asp:Label><br />
                    Y Coordinate: <asp:Label ID="lblY" runat="server" EnableViewState="false"></asp:Label>
                </td>
                <td>
                    <asp:Button ID="btnPageEvents" runat="server" OnClick="btnPageEvents_Click" Text="Page Events" /><br />
                    <asp:Label ID="lblPageEvents" runat="server"></asp:Label>
                </td>
                <td>
                    <asp:DropDownList ID="ddlPostBack" runat="server" 
                        onselectedindexchanged="ddlPostBack_SelectedIndexChanged">
                    </asp:DropDownList><br />
                    <asp:Button ID="btnPostBack" runat="server" Text="Select" OnClick="btnPostBack_Click" /><br />
                    <asp:Label ID="lblPostBack" runat="server"></asp:Label>
                </td>
            </tr>
            <tr>
                <td>
                    <asp:Label ID="Label1" runat="server" BackColor="Yellow" BorderColor="Red" BorderStyle="Solid"
                        BorderWidth="2px" ForeColor="Red" Text="Formatted Label"></asp:Label><br /><br />
                    <asp:Label ID="Label2" runat="server" Text="Style Formatted Label" CssClass="labelStyle"></asp:Label>
                </td>
                <td>
                </td>
                <td>
                    
                    <asp:HyperLink ID="HyperLink1" runat="server" NavigateUrl="~/page1.aspx">Visit Page 1</asp:HyperLink>
                    
                </td>
            </tr>
        </table>   
    </div>
    </form>
</body>
</html>