<%@ Page Title="Authorized Page 2" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="authorized2.aspx.cs" Inherits="protected_authorized2" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
  <h1>Authorized Page 2</h1>
  You must be authorized to access this page. You are currently logged in as
    <asp:LoginName
        ID="LoginName1"
        runat="server" />.
</asp:Content>