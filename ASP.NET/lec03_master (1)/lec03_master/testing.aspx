<%@ Page Language="C#" AutoEventWireup="true" CodeFile="testing.aspx.cs" Inherits="testing" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:wizard runat="server">
                <WizardSteps>
                    <asp:WizardStep title="Step 1" runat="server"></asp:WizardStep>
                    <asp:WizardStep title="Step 2" runat="server"></asp:WizardStep>
                </WizardSteps>
            </asp:wizard>
        </div>
    </form>
</body>
</html>

