<%@ Page Language="C#" AutoEventWireup="true" CodeFile="medication.aspx.cs" Inherits="medication" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    <title>Repeater with DataBinding</title>
    <link href="StyleSheet.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
    <h1>Repeater with DataBinding</h1>
    <a href="Default.aspx">Default.aspx</a><br /><br />

    <asp:SqlDataSource
        ID="srcMedications"
        runat="server"
        ConnectionString="<%$ ConnectionStrings:CHDBConnectionString %>"
        SelectCommand="SELECT [MedicationID], [MedicationDescription] FROM [Medications] ORDER BY [MedicationDescription]">
    </asp:SqlDataSource>

        <table>
          <asp:Repeater
            ID="rptMedication"
            runat="server"
            DataSourceID="srcMedications">
            <ItemTemplate>
              <tr>
                <td>
                  <asp:HyperLink ID="HyperLink1" 
                                 Text='<%# Eval("MedicationDescription") %>'
                                 NavigateUrl='<%# Eval("MedicationID", "medication_detail.aspx?medicationid={0}") %>' 
                                 runat="server" />
                </td>
              </tr>
            </ItemTemplate>
          </asp:Repeater>
        </table>
    
    </div>
    </form>
</body>
</html>