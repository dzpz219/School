<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>CO884 Lab 1 - Chao Zhang</title>
    <link href="Content/bootstrap.css" rel="stylesheet" />
</head>
<body>
    <h1>Number Guessing Game</h1>
    <form id="form1" runat="server">
    <div>
        <input maxlength="2" runat="server" id="inputNum" autofocus="autofocus" />
        <asp:Button Text="Guess" runat="server" OnClick="btnGuess_Click" ID="btnGuess" />
        <asp:Button Text="Give Up" runat="server" ID="btnGiveup" OnClick="btnGiveup_Click"/>
        <asp:Button Text="Start New Game" runat="server" ID="btnNew" OnClick="btnNew_Click" Visible="False" />
        <asp:Label ID="lblTest" runat="server"></asp:Label>
        <asp:Label ID="lblCorrect" runat="server"></asp:Label>
        <asp:Label ID="lblCount" runat="server"></asp:Label>
    </div>
    </form>
</body>
</html>
