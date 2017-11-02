<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<%@ Register assembly="System.Web.DataVisualization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35" namespace="System.Web.UI.DataVisualization.Charting" tagprefix="asp" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
    </div>
        <asp:Chart ID="Chart1" runat="server" DataSourceID="SqlDataSource1" Height="600px" Width="600px">
            <series>
                <asp:Series Legend="Legend1" Name="Series1" XValueMember="Floor" YValueMembers="Patients">
                </asp:Series>
            </series>
            <chartareas>
                <asp:ChartArea Name="ChartArea1">
                </asp:ChartArea>
            </chartareas>
            <Titles>
                <asp:Title Font="Microsoft Sans Serif, 20pt" Name="Title1" Text="Number of Current Patients on Each Floor">
                </asp:Title>
            </Titles>
            <BorderSkin SkinStyle="Emboss" />
        </asp:Chart>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:CHDBConnectionString %>" SelectCommand="SELECT SUBSTRING(NursingUnitID, 1, 1) AS Floor, COUNT(*) AS Patients FROM Admissions WHERE (SUBSTRING(NursingUnitID, 1, 1) IN ('1', '2', '3')) AND (DischargeDate IS NULL) GROUP BY SUBSTRING(NursingUnitID, 1, 1)"></asp:SqlDataSource>
    </form>
</body>
</html>
