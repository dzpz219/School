<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    <style type="text/css">
        .labelStyle
      {
            color: #000080;
            background-color: #00FFFF;
            border: 2px solid #000080;
        }
        .resultStyle
        {
            font-size: x-large;
        }
    </style>
    <title><asp:Literal id="ltlTitle" runat="server" /></title>
</head>
<body>
    <form id="form1" runat="server" defaultbutton="btnSearch">
    <div>
        <h1>Standard Controls</h1>
        <table>
            <tr>
                <td>
        <asp:Label ID="lblFormatted" runat="server" Text="Formatted Label" BackColor="Yellow" BorderColor="Red" BorderStyle="Solid" BorderWidth="2px" ForeColor="Red"></asp:Label><br /><br />
        <asp:Label ID="lblStyleFormatted" runat="server" Text="Style Formatted Label" CssClass="labelStyle"></asp:Label></td>
                <td>
                  <table>
                    <tr>
                      <td><asp:Label ID="lblFirstName" runat="server" AssociatedControlID="txtFirstName" Text="First Name:"></asp:Label></td>
                      <td><asp:TextBox ID="txtFirstName" runat="server"></asp:TextBox></td>
                    </tr>
                    <tr>
                      <td><asp:Label ID="lblLastName" runat="server" AssociatedControlID="txtLastName" Text="Last Name:"></asp:Label></td>
                      <td><asp:TextBox ID="txtLastName" runat="server"></asp:TextBox></td>
                    </tr>
                    <tr>
                      <td><asp:Label ID="lblFavColour" runat="server" AssociatedControlID="txtFavColour" Text="Favourite Colour:"></asp:Label></td>
                      <td><asp:TextBox ID="txtFavColour" runat="server" TextMode="Color"></asp:TextBox></td>
                    </tr>
                    <tr>
                      <td><asp:Label ID="lblPassword" runat="server" AssociatedControlID="txtPassword" Text="Password:"></asp:Label></td>
                      <td><asp:TextBox ID="txtPassword" runat="server" TextMode="Password"></asp:TextBox></td>
                    </tr>
                    <tr>
                      <td><asp:Label ID="lblDate" runat="server" AssociatedControlID="txtDate" Text="Date:"></asp:Label></td>
                      <td><asp:TextBox ID="txtDate" runat="server" TextMode="Date"></asp:TextBox></td>
                    </tr>
                    <tr>
                      <td><asp:Label ID="lblNumber" runat="server" AssociatedControlID="txtNumber" Text="Number:"></asp:Label></td>
                      <td><asp:TextBox ID="txtNumber" runat="server" TextMode="Number"></asp:TextBox></td>
                    </tr>
                    <tr>
                      <td><asp:Label ID="lblMaxLength" runat="server" AssociatedControlID="txtMaxLength" Text="Max Length (3):"></asp:Label></td>
                      <td><asp:TextBox ID="txtMaxLength" runat="server" MaxLength="3"></asp:TextBox></td>
                    </tr>
                    <tr>
                      <td><asp:Label ID="lblMultiLine" runat="server" AssociatedControlID="txtMultiLine" Text="Multi Line:"></asp:Label></td>
                      <td><asp:TextBox ID="txtMultiLine" runat="server" Columns="25" Rows="5" TextMode="MultiLine"></asp:TextBox></td>
                    </tr>
                  </table>
                </td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr>
                <td>
        <asp:CheckBox ID="chkNewsletter" runat="server" Text="Receive newsletter?" AutoPostBack="True" OnCheckedChanged="chkNewsletter_CheckedChanged" /><br />
        <asp:CheckBox ID="chkSQL" runat="server" Text="Do you want to receive the bonus SQL newsletter?" Visible="False" /></td>
                <td>
        How did you hear about our website?<br />
        <asp:RadioButton ID="radMagazine" runat="server" Text="Magazine article" GroupName="Source" /><br />
        <asp:RadioButton ID="radTelevision" runat="server" Text="Television program" GroupName="Source" /><br />
        <asp:RadioButton ID="radOther" runat="server" Text="Other source" GroupName="Source" /></td>
            </tr>
            <tr>
                <td>
        <asp:LinkButton ID="lnkSubmit" 
                        runat="server" 
                        OnClick="lnkSubmit_Click" 
                        OnClientClick="return confirm('Are you sure?');"
                        onmouseover="this.innerText='Click Here!'"
                        onmouseout="this.innerText='Submit'">
                        Submit
        </asp:LinkButton></td>
                <td>
        <asp:Label ID="lblResult" runat="server" CssClass="resultStyle"></asp:Label></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>
                  <asp:Label ID="lblSearch" runat="server" Text="Search:"></asp:Label>
                  <asp:TextBox ID="txtSearch" runat="server"></asp:TextBox>
                  <asp:Button ID="btnSearch" runat="server" PostBackUrl="~/search.aspx" Text="Search" /></td>
              <td>
                  <asp:ImageMap ID="mapButtons" runat="server" ImageUrl="~/images/buttons.PNG">
                      <asp:RectangleHotSpot AlternateText="Mohawk College Web Site" Bottom="105" NavigateUrl="http://www.mohawkcollege.ca"
                          Right="192" />
                      <asp:RectangleHotSpot AlternateText="eLearn Web Site" Bottom="105" Left="201"
                          NavigateUrl="https://elearn.mohawkcollege.ca" Right="399" />
                  </asp:ImageMap>
              </td>
            </tr>
            <tr>
              <td>
              </td>
              <td>
                  <asp:HyperLink ID="lnkMohawk" runat="server" NavigateUrl="~/validations.aspx">Validations Page</asp:HyperLink></td>
            </tr>
        </table>
        <br />
                  <h3>Phone Numbers</h3>
                  <asp:Label ID="lblHomePhone" runat="server" AssociatedControlID="txtHomePhone" Text="Home:"></asp:Label>
                  <asp:TextBox ID="txtHomePhone" runat="server"></asp:TextBox><br />
                  <asp:CheckBox ID="chkBusiness" runat="server" Text="Business numbers" AutoPostBack="True" OnCheckedChanged="chkBusiness_CheckedChanged" /><br />
                  <asp:Panel ID="pnlBusiness" runat="server" Width="237px" 
            GroupingText="Work Numbers" Visible="False">
                  <table>
                  <tr>
                      <td><asp:Label ID="lblWorkPhone" runat="server" Text="Work:" AssociatedControlID="txtWorkPhone"></asp:Label></td>
                      <td><asp:TextBox ID="txtWorkPhone" runat="server"></asp:TextBox></td>
                  </tr>
                  <tr>
                      <td><asp:Label ID="lblWorkFax" runat="server" Text="Fax:" AssociatedControlID="txtWorkFax"></asp:Label></td>
                      <td><asp:TextBox ID="txtWorkFax" runat="server"></asp:TextBox></td>
                  </tr>
                  </table>
                  </asp:Panel>
                  <br />
                  <br />
                  <br />
        <asp:Panel ID="pnlList" runat="server" Height="200px" Width="125px" 
            ScrollBars="Auto">
            <asp:BulletedList ID="bltList" runat="server">
            </asp:BulletedList>
        </asp:Panel>
        <br />
        <br />
        <br />


    </div>
    </form>
</body>
</html>