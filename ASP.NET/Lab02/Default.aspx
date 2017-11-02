<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <link href="Content/bootstrap.min.css" rel="stylesheet" />
    <script src="Scripts/jquery-2.1.1.js"></script>
</head>

<body>
    <div class="container">
    <h1>Hamilton Adult Soccer Club Registration</h1>
    <form id="form1" runat="server">
    <div class="form-horizontal">
        <div class="form-group">
            <label for="Name" class="control-label col-xs-2">Name:</label>
            <div class="col-xs-4">
                <asp:TextBox class="form-control" placeholder="Name" ID="Name" runat="server"></asp:TextBox>
            </div>
            <asp:RequiredFieldValidator ControlToValidate="Name" runat="server" ErrorMessage="Name is required"></asp:RequiredFieldValidator>
        </div>
        <div class="form-group">
            <label for="Email" class="control-label col-xs-2">Email:</label>
            <div class="col-xs-4">
                <asp:TextBox class="form-control" placeholder="Email" ID="Email" runat="server"></asp:TextBox>
            </div>
            <asp:RequiredFieldValidator ControlToValidate="Email" runat="server" ErrorMessage="Email is required" SetFocusOnError="True" Display="Dynamic"></asp:RequiredFieldValidator>
            <asp:RegularExpressionValidator ControlToValidate="Email" ID="RegularExpressionValidator1" runat="server" ErrorMessage="Invalid Email Address" SetFocusOnError="True" ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*" Display="Dynamic"></asp:RegularExpressionValidator>
        </div>
        <div class="form-group">
            <label for="Gender" class="control-label col-xs-2">Gender:</label>
            <div class="col-xs-4">
                <asp:DropDownList ID="Gender" class="form-control" runat="server">
                    <asp:ListItem>Male</asp:ListItem>
                    <asp:ListItem>Female</asp:ListItem>
                </asp:DropDownList>
            </div>
            <asp:RequiredFieldValidator ControlToValidate="Gender" runat="server" ErrorMessage="Gender is required" SetFocusOnError="True"></asp:RequiredFieldValidator>
        </div>
        <div class="form-group">
            <label for="DOB" class="control-label col-xs-2">Date Of Birth:</label>
            <div class="col-xs-4">
                <asp:TextBox class="form-control" ID="DOB" runat="server" type="date"></asp:TextBox>
            </div>
            <asp:RequiredFieldValidator ControlToValidate="DOB" runat="server" ErrorMessage="Date is required" SetFocusOnError="True"></asp:RequiredFieldValidator>
        </div>
        <div class="form-group">
            <label for="Address1" class="control-label col-xs-2">Address Line 1:</label>
            <div class="col-xs-4">
                <asp:TextBox class="form-control" placeholder="Address 1" ID="Address1" runat="server"></asp:TextBox>
            </div>
            <asp:RequiredFieldValidator ControlToValidate="Address1" runat="server" ErrorMessage="Address 1 is required" SetFocusOnError="True"></asp:RequiredFieldValidator>
        </div>
        <div class="form-group">
            <label for="Address2" class="control-label col-xs-2">Address Line 2:</label>
            <div class="col-xs-4">
                <input type="text" class="form-control" id="Address2" placeholder="Address 2" />
            </div>
        </div>
        <div class="form-group">
            <label for="City" class="control-label col-xs-2">City:</label>
            <div class="col-xs-4">
                <asp:TextBox class="form-control" placeholder="City" ID="City" runat="server"></asp:TextBox>
            </div>
            <asp:RequiredFieldValidator ControlToValidate="City" runat="server" ErrorMessage="City is required" SetFocusOnError="True"></asp:RequiredFieldValidator>
        </div>
        <div class="form-group">
            <label for="Province" class="control-label col-xs-2">Province:</label>
            <div class="col-xs-4">
                <select class="form-control">
                    <option>AB</option>
                    <option>BC</option>
                    <option>MB</option>
                    <option>NB</option>
                    <option>NL</option>
                    <option>NT</option>
                    <option>NS</option>
                    <option>NU</option>
                    <option selected="selected">ON</option>
                    <option>PE</option>
                    <option>QC</option>
                    <option>SK</option>
                    <option>YT</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="Postal" class="control-label col-xs-2">Postal Code:</label>
            <div class="col-xs-4">
                <asp:TextBox class="form-control" placeholder="Postal Code" ID="Postal" runat="server"></asp:TextBox>
            </div>
            <asp:RequiredFieldValidator ControlToValidate="Postal" runat="server" ErrorMessage="Postal is required" SetFocusOnError="True" Display="Dynamic"></asp:RequiredFieldValidator>
            <asp:RegularExpressionValidator ControlToValidate="Postal" ID="RegularExpressionValidator2" runat="server" ErrorMessage="Invalid Postal Code Address" SetFocusOnError="True" ValidationExpression="^([ABCEGHJKLMNPRSTVXY]\d[ABCEGHJKLMNPRSTVWXYZ])\ {0,1}(\d[ABCEGHJKLMNPRSTVWXYZ]\d)$" Display="Dynamic"></asp:RegularExpressionValidator>
        </div>
        <div class="form-group">
            <label for="Postal" class="control-label col-xs-2">Phone:</label>
            <div class="col-xs-4">
                <asp:TextBox class="form-control" placeholder="" ID="Phone" runat="server"></asp:TextBox>
            </div>
            <asp:RequiredFieldValidator ControlToValidate="Phone" runat="server" ErrorMessage="Phone is required" SetFocusOnError="True" Display="Dynamic"></asp:RequiredFieldValidator>
            <asp:RegularExpressionValidator ControlToValidate="Phone" ID="RegularExpressionValidator3" runat="server" ErrorMessage="Invalid Phone Number" SetFocusOnError="True" ValidationExpression="\(?\d{3}\)?-? *\d{3}-? *-?\d{4}" Display="Dynamic"></asp:RegularExpressionValidator>
        </div>
        <div class="form-group">
            <div class="col-xs-offset-2">
                <label>
                    <asp:CheckBox ID="Player" runat="server" /> Player
                </label>
                <label>
                    <asp:CheckBox ID="Coach" runat="server" OnCheckedChanged="Coach_CheckedChanged" /> Coach
                </label>
                <label>
                    <asp:CheckBox ID="Referee" runat="server" OnCheckedChanged="Referee_CheckedChanged" /> Referee
                </label>
            </div>
        </div>
        <div class="form-group">
            <asp:TextBox class="form-control" ID="txtBoxCoach" TextMode="MultiLine" runat="server" Text="Please summarize your coaching experience" Visible="False"></asp:TextBox>
            <asp:TextBox class="form-control" ID="txtBoxReferee" TextMode="MultiLine" runat="server" Text="Please summarize your coaching experience" Visible="False"></asp:TextBox>
        </div>
        <div class="form-group">
            <label for="Postal" class="control-label col-xs-2">Password:</label>
            <div class="col-xs-4">
                <asp:TextBox class="form-control" TextMode="Password" ID="Password" runat="server" OnTextChanged="Password_TextChanged"></asp:TextBox>
            </div>
            <asp:Label ID="lblPassword" runat="server" Text="asdas"></asp:Label>
            <asp:RequiredFieldValidator runat="server" ControlToValidate="Password" Display="Dynamic" ErrorMessage="Password is required" SetFocusOnError="True"></asp:RequiredFieldValidator>
            <asp:CustomValidator ID="PWValidator" runat="server" ControlToValidate="Password" OnServerValidate="PWValidator_ServerValidate" ErrorMessage="Password must be at least 6 characters" SetFocusOnError="True" Display="Dynamic"></asp:CustomValidator>
        </div>
        
        <div class="form-group">
            <label for="Postal" class="control-label col-xs-2">Confirm Password:</label>
            <div class="col-xs-4">
                <asp:TextBox class="form-control" TextMode="Password" ID="CPassword" runat="server"></asp:TextBox>
            </div>
        </div>
        <div class="col-xs-6 text-right">
                <asp:Button runat="server" Text="Submit" ID="btnSubmit" CssClass="btn btn-default" />
                <asp:Button runat="server" Text="Cancel" CssClass="btn btn-default" CausesValidation="False" />
        </div>
    </div>
    </form>
    </div>
</body>
</html>
