<%@ Page Language="C#" AutoEventWireup="true" CodeFile="validations.aspx.cs" Inherits="validations" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    <title>Validation Controls</title>
    <script type="text/javascript">
        function cusProgram_ClientValidate(source, args) {
            if (args.Value == "548" || args.Value == "558" || args.Value == "559")
                args.IsValid = true;
            else
                args.IsValid = false;
        }
    </script>
    <style type="text/css">
        .auto-style1 {
            height: 26px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server" defaultfocus="txtID">
    <div>
        <h1>Validation Controls</h1>
        <asp:Panel ID="pnlStudent" runat="server" Height="366px" 
            GroupingText="Student Information" Width="595px">
                <table>
                    <tr>
                        <td>
                            <asp:Label ID="lblID" runat="server" AssociatedControlID="txtID" Text="Student ID:"></asp:Label></td>
                        <td>
                            <asp:TextBox ID="txtID" runat="server" Columns="9" MaxLength="9"></asp:TextBox>
                            <asp:RequiredFieldValidator ID="reqID" runat="server" ControlToValidate="txtID" ErrorMessage="Student ID is required" Display="Dynamic" SetFocusOnError="True">(Required)</asp:RequiredFieldValidator>&nbsp;
                            <asp:RangeValidator ID="rngID" runat="server" ControlToValidate="txtID"
                                ErrorMessage="StudentID must be in range 1 to 999999999" MaximumValue="999999999" MinimumValue="1"
                                SetFocusOnError="True" Type="Integer">(Must be in range 1 to 999999999)</asp:RangeValidator></td>
                    </tr>
                    <tr>
                        <td><asp:Label ID="lblName" runat="server" Text="Name:" AssociatedControlID="txtName"></asp:Label></td>
                        <td>
                            <asp:TextBox ID="txtName" runat="server"></asp:TextBox>
                            <asp:RequiredFieldValidator ID="reqName" runat="server" ControlToValidate="txtName" Display="Dynamic" ErrorMessage="Name is required" SetFocusOnError="True"><img src='images/error.jpg' alt='Name is required' title='Name is required' /></asp:RequiredFieldValidator>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <asp:Label ID="lblAge" runat="server" AssociatedControlID="txtAge" Text="Age:"></asp:Label></td>
                        <td>
                            <asp:TextBox ID="txtAge" runat="server" Columns="3" MaxLength="3"></asp:TextBox>
                            <asp:RequiredFieldValidator ID="reqAge" runat="server" ControlToValidate="txtAge"
                                ErrorMessage="Age is required" Display="Dynamic" SetFocusOnError="True">(Required)</asp:RequiredFieldValidator>
                            <asp:CompareValidator ID="cmpAge" runat="server" ControlToValidate="txtAge"
                                ErrorMessage="Age must be whole number" Operator="DataTypeCheck" Type="Integer" SetFocusOnError="True">(Must be whole number)</asp:CompareValidator>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <asp:Label ID="lblGender" runat="server" AssociatedControlID="ddlGender" Text="Gender:"></asp:Label></td>
                        <td>
                            <asp:DropDownList ID="ddlGender" runat="server">
                                <asp:ListItem Value="none">Select gender</asp:ListItem>
                                <asp:ListItem Value="F">Female</asp:ListItem>
                                <asp:ListItem Value="M">Male</asp:ListItem>
                            </asp:DropDownList>
                            <asp:RequiredFieldValidator ID="reqGender" runat="server" ControlToValidate="ddlGender"
                                ErrorMessage="Gender is required" InitialValue="none" SetFocusOnError="True">(Required)</asp:RequiredFieldValidator></td>
                    </tr>
                    <tr>
                        <td>
                            <asp:Label ID="lblDOB" runat="server" AssociatedControlID="txtDOB" Text="Date of birth:"></asp:Label></td>
                        <td>
                            <asp:TextBox ID="txtDOB" runat="server" TextMode="Date"></asp:TextBox>
                            <asp:RequiredFieldValidator ID="reqDOB" runat="server" ControlToValidate="txtDOB"
                                Display="Dynamic" ErrorMessage="Date of birth is required" SetFocusOnError="True">(Required)</asp:RequiredFieldValidator>
                            <asp:CompareValidator ID="cmpDOB" runat="server" ControlToValidate="txtDOB" 
                                ErrorMessage="Date of birth must be valid and before today" Type="Date" 
                                Operator="LessThan" SetFocusOnError="True">(Date must be valid and before today)</asp:CompareValidator>
                            </td>
                    </tr>
                    <tr>
                        <td>
                            <asp:Label ID="lblEmail" runat="server" AssociatedControlID="txtEmail" Text="Email:"></asp:Label><td>
                                <asp:TextBox ID="txtEmail" runat="server"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="reqMail" runat="server" ControlToValidate="txtEmail"
                                    Display="Dynamic" ErrorMessage="Email is required" SetFocusOnError="True">(Required)</asp:RequiredFieldValidator>
                                <asp:RegularExpressionValidator ID="regEmail" runat="server" ControlToValidate="txtEmail"
                                    ErrorMessage="Email address is invalid" SetFocusOnError="True" ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*">(Invalid email)</asp:RegularExpressionValidator></td>
                    </tr>
                    <tr>
                        <td class="auto-style1">
                            <asp:Label ID="lblProgram" runat="server" AssociatedControlID="txtProgram" Text="Program:"></asp:Label></td>
                        <td class="auto-style1">
                            <asp:TextBox ID="txtProgram" runat="server"></asp:TextBox>
                            <asp:RequiredFieldValidator
                                ID="reqProgram"
                                runat="server"
                                ControlToValidate="txtProgram"
                                Display="Dynamic"
                                ErrorMessage="Program of study is required"
                                SetFocusOnError="True">(Required)</asp:RequiredFieldValidator>
                            <asp:CustomValidator
                                ID="cusProgram"
                                runat="server" 
                                ControlToValidate="txtProgram"
                                OnServerValidate="cusProgram_ServerValidate"
                                ClientValidationFunction="cusProgram_ClientValidate"
                                ErrorMessage="Program of study invalid, valid programs are: 548, 558, 559" 
                                SetFocusOnError="True">(Valid programs: 548, 558, 559)
                            </asp:CustomValidator>
                        </td>
                    </tr>
                </table>
            <asp:Button ID="btnSubmit" runat="server" Text="Submit" OnClick="btnSubmit_Click" />
            <asp:Button ID="btnCancel" runat="server" CausesValidation="False" Text="Cancel" /><br />
            <asp:Label ID="lblResult" runat="server"></asp:Label><br />
            &nbsp;<asp:ValidationSummary ID="valSummary" runat="server" />
        </asp:Panel>    
    </div>
    </form>
</body>
</html>