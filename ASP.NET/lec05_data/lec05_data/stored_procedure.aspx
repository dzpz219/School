<%@ Page Language="C#" AutoEventWireup="true" CodeFile="stored_procedure.aspx.cs" Inherits="stored_procedure" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Stored Procedure</title>
    <link href="StyleSheet.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h1>GridView populated by stored procedure</h1>
            <asp:GridView ID="grdPatientCount" runat="server" AutoGenerateColumns="False" DataSourceID="sqlPatientCount">
                <Columns>
                    <asp:BoundField DataField="NursingUnitID" HeaderText="Nursing Unit" SortExpression="NursingUnitID" />
                    <asp:BoundField DataField="Specialty" HeaderText="Specialty" SortExpression="Specialty" />
                    <asp:BoundField DataField="PatientCount" HeaderText="Patients" ReadOnly="True" SortExpression="PatientCount">
                        <ItemStyle HorizontalAlign="Right" />
                    </asp:BoundField>
                </Columns>
            </asp:GridView>
            <p><a href="Default.aspx">Default.aspx</a></p>
            <asp:SqlDataSource ID="sqlPatientCount" runat="server" ConnectionString="<%$ ConnectionStrings:CHDBConnectionString %>" SelectCommand="CountPatientsByNursingUnit" SelectCommandType="StoredProcedure"></asp:SqlDataSource>
        </div>
    </form>
</body>
</html>