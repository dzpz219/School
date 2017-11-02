<%@ Page Title="Home Page" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="navigation.aspx.cs" Inherits="navigation" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <h1>Home Page</h1>
    <asp:Menu ID="Menu1" runat="server">
        <Items>
            <asp:MenuItem Text="Hard Coded Menu" Value="Hard Coded Menu">
                <asp:MenuItem Text="Products" Value="Products">
                    <asp:MenuItem NavigateUrl="~/Products/FirstProduct.aspx" Text="First Product" Value="FirstProduct">
                    </asp:MenuItem>
                    <asp:MenuItem NavigateUrl="~/Products/SecondProduct.aspx" Text="Second Product" Value="Second Product">
                    </asp:MenuItem>
                </asp:MenuItem>
                <asp:MenuItem Text="Services" Value="Services">
                    <asp:MenuItem NavigateUrl="~/Services/FirstService.aspx" Text="First Service" Value="First Service">
                    </asp:MenuItem>
                    <asp:MenuItem NavigateUrl="~/Services/SecondService.aspx" Text="Second Service" Value="Second Service">
                    </asp:MenuItem>
                </asp:MenuItem>
            </asp:MenuItem>
        </Items>
    </asp:Menu>
    <br />
    <br />
    <br />
    <br />
    <p><a href="Tree.aspx">Tree.aspx</a> Explore the capabilities of the TreeView</p>
    <p><a href="Default.aspx">Default.aspx</a></p>
</asp:Content>