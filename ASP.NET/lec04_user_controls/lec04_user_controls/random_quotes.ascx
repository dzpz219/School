<%@ Control Language="C#" AutoEventWireup="true" CodeFile="random_quotes.ascx.cs" Inherits="random_quotes" %>

<asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>
<asp:Timer ID="Timer1" runat="server" Interval="5000"></asp:Timer>

<asp:UpdatePanel ID="UpdatePanel1" runat="server">
    <ContentTemplate>
        <div class="quote">
            <asp:Label ID="lblQuote" runat="server"></asp:Label>
        </div>
    </ContentTemplate>
    <Triggers>
        <asp:AsyncPostBackTrigger ControlID="Timer1" EventName="Tick" />
    </Triggers>
</asp:UpdatePanel>