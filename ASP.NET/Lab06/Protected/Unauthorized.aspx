<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Unauthorized.aspx.cs" Inherits="Protected_Unauthorized" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <h1>Sorry, but you are not authorized to use that page.</h1>
    <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
</asp:Content>

