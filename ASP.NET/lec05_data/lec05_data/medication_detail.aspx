<%@ Page Language="C#" AutoEventWireup="true" CodeFile="medication_detail.aspx.cs" Inherits="medication_detail" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Medication Detail</title>
    <link href="StyleSheet.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:Repeater ID="Repeater1" runat="server" DataSourceID="sqlMedication">
            <ItemTemplate>
                <h1><%# Eval("MedicationDescription") %></h1>
            </ItemTemplate>
        </asp:Repeater>
        <asp:DetailsView ID="DetailsView1" runat="server" AutoGenerateRows="False" DataKeyNames="MedicationID" DataSourceID="sqlMedication" Height="50px" EmptyDataText="No medication found">
            <Fields>
                <asp:BoundField DataField="MedicationID" HeaderText="MedicationID" ReadOnly="True" SortExpression="MedicationID" />
                <asp:BoundField DataField="MedicationDescription" HeaderText="MedicationDescription" SortExpression="MedicationDescription" />
                <asp:BoundField DataField="MedicationCost" HeaderText="MedicationCost" SortExpression="MedicationCost" />
                <asp:BoundField DataField="PackageSize" HeaderText="PackageSize" SortExpression="PackageSize" />
                <asp:BoundField DataField="Strength" HeaderText="Strength" SortExpression="Strength" />
                <asp:BoundField DataField="Sig" HeaderText="Sig" SortExpression="Sig" />
                <asp:BoundField DataField="UnitsUsedYTD" HeaderText="UnitsUsedYTD" SortExpression="UnitsUsedYTD" />
            </Fields>
        </asp:DetailsView>
        <p><a href="medication.aspx">Return to Medication</a></p>
        <asp:SqlDataSource ID="sqlMedication" runat="server" ConnectionString="<%$ ConnectionStrings:CHDBConnectionString %>" SelectCommand="SELECT [MedicationID], [MedicationDescription], [MedicationCost], [PackageSize], [Strength], [Sig], [UnitsUsedYTD] FROM [Medications] WHERE ([MedicationID] = @MedicationID)">
            <SelectParameters>
                <asp:QueryStringParameter Name="MedicationID" QueryStringField="medicationid" Type="Int32" />
            </SelectParameters>
        </asp:SqlDataSource>
    </div>
    </form>
</body>
</html>
