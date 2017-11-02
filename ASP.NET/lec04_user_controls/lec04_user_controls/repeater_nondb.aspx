<%@ Page Language="C#" AutoEventWireup="true" CodeFile="repeater_nondb.aspx.cs" Inherits="repeater_nondb" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Repeater Control</title>
    <link href="StyleSheet.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h1>Images</h1>
            <asp:Repeater ID="rptPhotos" runat="server">
                <ItemTemplate>
                    <asp:Image
                        ID="img1"
                        ImageUrl='<%#Container.DataItem %>'
                        runat="server" />
                </ItemTemplate>
            </asp:Repeater>

            <br />
            <br />
            <a href="Default.aspx">Default.aspx</a>
        </div>
    </form>
</body>
</html>
