<%@ Page Title="Acme Corporation - Order Page" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="page3.aspx.cs" Inherits="page3" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
    page 3 head
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    Title is specified on page3.aspx page directive, so &lt;title&gt; does not come from Master Page.<br /><br />
    <table>
        <tr>
            <td>
                <asp:Label ID="Label1" runat="server" Text="Product ID:"></asp:Label></td>
            <td>
                <asp:TextBox ID="txtID" runat="server"></asp:TextBox></td>
        </tr>
        <tr>
            <td>
                <asp:Label ID="Label2" runat="server" Text="Quantity:"></asp:Label></td>
            <td>
                <asp:TextBox ID="txtQty" runat="server"></asp:TextBox></td>
        </tr>
        <tr>
            <td colspan="2">
                <asp:Button ID="btnSubmit" runat="server" Text="Submit" OnClick="btnSubmit_Click" /></td>
        </tr>
    </table>
    <br />
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="ContentPlaceHolder2" Runat="Server">
    <asp:Label ID="lblResult" runat="server"></asp:Label>
</asp:Content>

