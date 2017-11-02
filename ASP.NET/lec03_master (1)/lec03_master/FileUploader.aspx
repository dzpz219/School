<%@ Page Language="C#" AutoEventWireup="true" CodeFile="FileUploader.aspx.cs" Inherits="FileUploader" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    <title>File Uploader</title>
</head>
<body>
    <form id="form1" runat="server">
    <div>

    <asp:Label
        id="lblImageFile"
        Text="Image File: "
        AssociatedControlID="upImage"
        Runat="server" />

    <asp:FileUpload
        id="upImage"
        Runat="server" />

    <br /><br />
    
    <asp:Button
        id="btnAdd"
        Text="Add Image"
        OnClick="btnAdd_Click" 
        Runat="server" />

    &nbsp;
    <asp:Label ID="lblError" runat="server"></asp:Label>

    <hr />
    
    <asp:DataList
        id="dlstImages"
        RepeatColumns="3"
        runat="server">
        <ItemTemplate>
        <asp:Image ID="Image1" 
            ImageUrl='<%# Eval("Name", "~/UploadImages/{0}") %>'
            style="width:200px"
            Runat="server" />
        <br />
        <%# Eval("Name") %>    
        </ItemTemplate>
    </asp:DataList>
        <a href="Default.aspx">Default.aspx</a>
    </div>
    </form>
</body>
</html>