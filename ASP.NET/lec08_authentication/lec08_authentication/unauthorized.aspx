<%@ Page Title="Open Content" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="unauthorized.aspx.cs" Inherits="unauthorized" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
  <h1>Open Content</h1>
  You do not need to be authenticated to access this page.<br />
  <asp:LoginName ID="LoginName1" runat="server" />
    <br /><br />
  <asp:LoginView ID="LoginView1" runat="server">
    <AnonymousTemplate>If you are <b>NOT</b> logged in you will see this.</AnonymousTemplate>
    <LoggedInTemplate>If you <b>are</b> logged in you will see this.</LoggedInTemplate>
  </asp:LoginView>
</asp:Content>