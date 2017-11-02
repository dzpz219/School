<%@ Page Title="Language" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Language.aspx.cs" Inherits="Language" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <h1>Language</h1>
    <asp:Button ID="FR" runat="server" Text="FR" class="btn btn-default" OnClick="FR_Click"/>
    <asp:Button ID="EN" runat="server" Text="EN" class="btn btn-default" OnClick="EN_Click"/>
</asp:Content>

