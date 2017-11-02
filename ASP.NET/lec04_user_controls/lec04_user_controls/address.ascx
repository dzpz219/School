<%@ Control Language="C#" AutoEventWireup="true" CodeFile="address.ascx.cs" Inherits="address" %>
<fieldset>
    <legend>
        <asp:Literal ID="ltlTitle" Text="Address Form" runat="server" />
    </legend>

    <div class="addressLabel">
        <asp:Label ID="lblStreet" Text="Street:" AssociatedControlID="txtStreet" runat="server" />
    </div>
    <div class="addressField">
        <asp:TextBox ID="txtStreet" runat="server" MaxLength="50" Width="360px"></asp:TextBox>
    </div>
    <br class="clear" />

    <div class="addressLabel">
        <asp:Label ID="lblCity" Text="City:" AssociatedControlID="txtCity" runat="server" />
    </div>
    <div class="addressField">
        <asp:TextBox ID="txtCity" runat="server" MaxLength="50" Width="360px"></asp:TextBox>
    </div>
    <br class="clear" />

    <div class="addressLabel">
        <asp:Label ID="lblProvince" Text="Province:" AssociatedControlID="ddlProv" runat="server" />
    </div>
    <div class="addressField">
        <asp:DropDownList ID="ddlProv" runat="server">
        </asp:DropDownList>
    </div>
    <br class="clear" />

    <div class="addressLabel">
        <asp:Label ID="lblPostalCode" Text="Postal Code:" AssociatedControlID="txtPostalCode" runat="server" />
    </div>
    <div class="addressField">
        <asp:TextBox ID="txtPostalCode" runat="server" MaxLength="7" Width="80px"></asp:TextBox>
    </div>
</fieldset>