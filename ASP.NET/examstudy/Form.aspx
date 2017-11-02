<%@ Page Title="Form" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Form.aspx.cs" Inherits="Form" UICulture="auto"%>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
        <h1>Form</h1>
         <div class="form-horizontal">
             <div class="form-group">
                 <label class="control-label col-xs-3">
                     <asp:Literal ID="Name" runat="server" Text="<%$ Resources:Name %>"></asp:Literal>
                 </label>
                 <div class="col-xs-6">
                     <input class="form-control" type="text"/>
                 </div>
             </div>
             <div class="form-group">
                 <label class="control-label col-xs-3">
                     <asp:Literal ID="Password" runat="server" Text="<%$ Resources:Password %>"></asp:Literal>
                 </label>
                 <div class="col-xs-6">
                     <input class="form-control" type="text"/>
                 </div>
             </div>
             <div class="form-group">
                 <label class="control-label col-xs-3">
                     <asp:Literal ID="Phone" runat="server" Text="<%$ Resources:Phone %>"></asp:Literal>
                 </label>
                 <div class="col-xs-6">
                     <input class="form-control" type="text"/>
                 </div>
             </div>
             <div class="form-group">
                 <label class="control-label col-xs-3">
                     <asp:Literal ID="Address" runat="server" Text="<%$ Resources:Address %>"></asp:Literal>
                 </label>
                 <div class="col-xs-6">
                     <input class="form-control" type="text"/>
                 </div>
             </div>
         </div>
</asp:Content>

