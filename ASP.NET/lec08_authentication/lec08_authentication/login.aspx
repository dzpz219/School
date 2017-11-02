<%@ Page Title="Login Page" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="login.aspx.cs" Inherits="login" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <asp:Login ID="Login1" runat="server" DisplayRememberMe="False" OnAuthenticate="Login1_Authenticate" OnLoggedIn="Login1_LoggedIn">
    </asp:Login><br />
    <asp:Label
        ID="lblError"
        runat="server"
        EnableViewState="False"
        ForeColor="Red">
    </asp:Label><br />
    <a href="register.aspx">Register</a>
</asp:Content>