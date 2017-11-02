<%@ Page Title="Registration Page" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="register.aspx.cs" Inherits="register" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
  <h1>Registration Page</h1>
  <table>
    <tr>
      <td>User Name:</td>
      <td><asp:TextBox ID="txtUserName" runat="server"></asp:TextBox>
          <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
              ControlToValidate="txtUserName" ErrorMessage="RequiredFieldValidator">(Required)</asp:RequiredFieldValidator>
        </td>
    </tr>
    <tr>
      <td>Email:</td>
      <td><asp:TextBox ID="txtEmail" runat="server"></asp:TextBox>
          <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" 
              ControlToValidate="txtEmail" ErrorMessage="RequiredFieldValidator" 
              Display="Dynamic">(Required)</asp:RequiredFieldValidator>
          <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" 
              ControlToValidate="txtEmail" ErrorMessage="RegularExpressionValidator" 
              ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*">(Must be properly formatted email address)</asp:RegularExpressionValidator>
        </td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><asp:TextBox ID="txtPassword" runat="server" TextMode="Password"></asp:TextBox>
          <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" 
              ControlToValidate="txtPassword" ErrorMessage="RequiredFieldValidator">(Required)</asp:RequiredFieldValidator>
        </td>
    </tr>
    <tr>
      <td>Confirm Password:</td>
      <td><asp:TextBox ID="txtConfirmPassword" runat="server" TextMode="Password"></asp:TextBox>
          <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" 
              ControlToValidate="txtConfirmPassword" 
              ErrorMessage="RequiredFieldValidator" Display="Dynamic">(Required)</asp:RequiredFieldValidator>
          <asp:CompareValidator ID="CompareValidator1" runat="server" 
              ControlToCompare="txtConfirmPassword" ControlToValidate="txtPassword" 
              ErrorMessage="CompareValidator">(Must be same)</asp:CompareValidator>
        </td>
    </tr>
  </table>

  <asp:Button
    ID="btnRegister"
    runat="server"
    Text="Register" 
    onclick="btnRegister_Click" /><br /><br />

  <asp:Label ID="lblResult" runat="server"></asp:Label>
</asp:Content>