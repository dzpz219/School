<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Web Service Consumer</title>
    <link href="StyleSheet.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <a href="http://api.wikia.com/wiki/LyricWiki_API/SOAP">
          <img src="images/Wiki-wordmark.png" alt="Lyric Wiki API" title="Lyric Wiki API" />
        </a>
        <table>
            <tr>
                <td>1. Search for an artist (wildcard % allowed):</td>
                <td><asp:TextBox ID="txtArtist" runat="server" ToolTip="% available as a wildcard"></asp:TextBox></td>
                <td><asp:Button ID="btnArtistSearch" runat="server" Text="Search" OnClick="btnArtistSearch_Click" /></td>
            </tr>
            <tr>
                <td>2. Select artist:</td>
                <td><asp:ListBox ID="lstArtists" runat="server" AutoPostBack="True" OnSelectedIndexChanged="lstArtists_SelectedIndexChanged"></asp:ListBox></td>
                <td>
                    <asp:Label ID="lblArtistInfo" runat="server"></asp:Label>
                </td>
            </tr>
            <tr>
                <td>3. Search for a song (must be precise):</td>
                <td><asp:TextBox ID="txtSong" runat="server"></asp:TextBox></td>
                <td><asp:Button ID="btnGetLyrics" runat="server" Text="Get Lyrics" OnClick="btnGetLyrics_Click" /></td>
            </tr>
        </table>
        
        <p><asp:Literal ID="ltlOutput" runat="server"></asp:Literal></p>
    </div>
    </form>
</body>
</html>
