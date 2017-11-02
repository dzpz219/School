<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="page1.aspx.cs" Inherits="page1" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
    page 1 head
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    Title is not specified on page1.aspx page directive, so &lt;title&gt; comes from Master Page.
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="ContentPlaceHolder2" Runat="Server">
    Content from page 1.
</asp:Content>

