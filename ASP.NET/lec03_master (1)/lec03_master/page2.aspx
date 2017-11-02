<%@ Page Title="Acme Corporation - Dehydrated Boulders" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="page2.aspx.cs" Inherits="page2" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
    page 2 head
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    Title is specified on page2.aspx page directive, so &lt;title&gt; does not come from Master Page<br /><br />
    <img alt="Dehydrated Boulder"
        class="style1"
        src="images/boulders.jpg"
        width="106"
        height="100" />
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="ContentPlaceHolder2" Runat="Server">
    One of our most popular products.
</asp:Content>

