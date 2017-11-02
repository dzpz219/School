<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Wizard.aspx.cs" Inherits="Wizard" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:Wizard ID="Wizard1" HeaderText="Product Survey" OnFinishButtonClick="Wizard1_FinishButtonClick"
            runat="server" ActiveStepIndex="0">
            <WizardSteps>
                <asp:WizardStep ID="WizardStep1" Title="Introduction" runat="server">
                    Please complete our survey so that we can improve our products.
                </asp:WizardStep>
                <asp:WizardStep ID="WizardStep2" Title="Step 1" runat="server">
                    <asp:Label ID="lblName" Text="Your Name:" AssociatedControlID="txtName" runat="server" />
                    <br />
                    <asp:TextBox ID="txtName" runat="server" />
                </asp:WizardStep>
                <asp:WizardStep ID="WizardStep3" Title="Step 2" StepType="Finish" runat="server">
                    <asp:Label ID="lblPhone" Text="Phone Number:" AssociatedControlID="txtPhone" runat="server" />
                    <br />
                    <asp:TextBox ID="txtPhone" runat="server" />
                </asp:WizardStep>
                <asp:WizardStep ID="WizardStep4" Title="Summary" StepType="Complete" runat="server">
                    <h1>
                        Summary</h1>
                        <h3>Thank you for completing our survey</h3>
                    Name:
                    <asp:Label ID="lblNameResult" runat="server" />
                    <br />
                    <br />
                    Phone Number:
                    <asp:Label ID="lblPhoneResult" runat="server" />
                </asp:WizardStep>
            </WizardSteps>
        </asp:Wizard>
        <a href="Default.aspx">Default.aspx</a>
    </div>
    </form>
</body>
</html>