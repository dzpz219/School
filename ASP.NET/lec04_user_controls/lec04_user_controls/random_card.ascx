<%@ Control Language="C#" AutoEventWireup="true" CodeFile="random_card.ascx.cs" Inherits="random_card" %>

Pick a card, any card:<br />

<asp:Image
    ID="imgRandom"
    runat="server"
    ImageUrl="~/images/clubs-4.png" />

<br />

<asp:Label
    ID="lblRandom"
    runat="server">
</asp:Label>