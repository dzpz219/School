<%@ Page Title="Home" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <h1>Home</h1>
    <a href="unauthorized.aspx">Link to unprotected page</a><br /><br />
    <a href="protected/authorized1.aspx">Link to protected page 1</a>
</asp:Content>

