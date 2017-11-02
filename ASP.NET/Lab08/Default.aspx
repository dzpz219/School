<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" UICulture="auto"%>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
    </div>
        <asp:ObjectDataSource ID="ObjectDataSource1" runat="server" TypeName="System.Globalization.CultureInfo" OldValuesParameterFormatString="original_{0}" SelectMethod="GetCultures">
            <SelectParameters>
                <asp:Parameter DefaultValue="SpecificCultures" Name="types" Type="Object" />
            </SelectParameters>
        </asp:ObjectDataSource>
        <asp:DropDownList ID="DropDownList1" runat="server" DataSourceID="ObjectDataSource1" DataTextField="DisplayName" DataValueField="Name">
        </asp:DropDownList>
        <p>
            <asp:Literal ID="Literal1" runat="server" Text="<%$ Resources:Header %>" ></asp:Literal>
        </p>
        <asp:Button ID="Button1" runat="server" Text="Button" OnClick="Button1_Click" />
        <asp:HyperLink ID="HyperLink1" runat="server" NavigateUrl="~/Default2.aspx">HyperLink</asp:HyperLink>
    </form>
</body>
</html>
