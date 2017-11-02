<%@ Page Language="C#" AutoEventWireup="true" CodeFile="grid_view.aspx.cs" Inherits="grid_view" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Advanced GridView</title>
    <link href="StyleSheet.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <h1>GridView Row Highlighting and TemplateFields</h1>
        <asp:GridView ID="grdAdmissions" runat="server" AllowPaging="True" AutoGenerateColumns="False" CellPadding="4" DataKeyNames="PatientID,AdmissionDate" DataSourceID="sqlAdmissions" EmptyDataText="No patients currently admitted" ForeColor="#333333" GridLines="None" OnRowDataBound="grdAdmissions_RowDataBound" PageSize="20">
            <AlternatingRowStyle BackColor="White" />
            <Columns>
                <asp:CommandField ShowEditButton="True" />
                <asp:BoundField DataField="PatientID" HeaderText="PatientID" ReadOnly="True" SortExpression="PatientID" />
                <asp:BoundField DataField="AdmissionDate" HeaderText="AdmissionDate" ReadOnly="True" SortExpression="AdmissionDate" />
                <asp:BoundField DataField="PatientName" HeaderText="PatientName" ReadOnly="True" SortExpression="PatientName" />
                <asp:TemplateField HeaderText="NursingUnitID" SortExpression="NursingUnitID">
                    <EditItemTemplate>
                        <asp:DropDownList ID="DropDownList1" runat="server" DataSourceID="sqlNursingUnits" DataTextField="NursingUnitID" DataValueField="NursingUnitID" SelectedValue='<%# Bind("NursingUnitID") %>'>
                        </asp:DropDownList>
                    </EditItemTemplate>
                    <ItemTemplate>
                        <asp:Label ID="Label1" runat="server" Text='<%# Bind("NursingUnitID") %>'></asp:Label>
                    </ItemTemplate>
                </asp:TemplateField>
                <asp:TemplateField HeaderText="Room" SortExpression="Room">
                    <EditItemTemplate>
                        <asp:TextBox ID="TextBox1" runat="server" Text='<%# Bind("Room") %>'></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="TextBox1" ErrorMessage="RequiredFieldValidator"><b>(Required)</b></asp:RequiredFieldValidator>
                    </EditItemTemplate>
                    <ItemTemplate>
                        <asp:Label ID="Label2" runat="server" Text='<%# Bind("Room") %>'></asp:Label>
                    </ItemTemplate>
                </asp:TemplateField>
                <asp:BoundField DataField="Bed" HeaderText="Bed" SortExpression="Bed" />
            </Columns>
            <FooterStyle BackColor="#1C5E55" Font-Bold="True" ForeColor="White" />
            <HeaderStyle BackColor="#1C5E55" Font-Bold="True" ForeColor="White" />
            <PagerSettings FirstPageText="First" LastPageText="Last" Mode="NextPreviousFirstLast" NextPageText="Next" Position="TopAndBottom" PreviousPageText="Prev" />
            <PagerStyle BackColor="#666666" ForeColor="White" HorizontalAlign="Center" />
            <RowStyle BackColor="#E3EAEB" />
            <SelectedRowStyle BackColor="#C5BBAF" Font-Bold="True" ForeColor="#333333" />
            <SortedAscendingCellStyle BackColor="#F8FAFA" />
            <SortedAscendingHeaderStyle BackColor="#246B61" />
            <SortedDescendingCellStyle BackColor="#D4DFE1" />
            <SortedDescendingHeaderStyle BackColor="#15524A" />
        </asp:GridView>
        <asp:SqlDataSource
            ID="sqlAdmissions"
            runat="server"
            ConnectionString="<%$ ConnectionStrings:CHDBConnectionString %>"
            SelectCommand="SELECT a.PatientID, AdmissionDate, FirstName + ' ' + LastName AS PatientName, NursingUnitID, Room, Bed FROM Admissions a INNER JOIN Patients p ON a.PatientID = p.PatientID WHERE DischargeDate IS NULL"
            UpdateCommand="UPDATE Admissions SET NursingUnitID = @NursingUnitID, Room = @Room, Bed = @Bed WHERE PatientID = @PatientID AND AdmissionDate = @AdmissionDate">
            <UpdateParameters>
                <asp:Parameter Name="NursingUnitID" />
                <asp:Parameter Name="Room" />
                <asp:Parameter Name="Bed" />
                <asp:Parameter Name="PatientID" />
                <asp:Parameter Name="AdmissionDate" />
            </UpdateParameters>
        </asp:SqlDataSource>
        <asp:SqlDataSource
            ID="sqlNursingUnits"
            runat="server"
            ConnectionString="<%$ ConnectionStrings:CHDBConnectionString %>"
            SelectCommand="SELECT NursingUnitID FROM NursingUnits">
        </asp:SqlDataSource>
        <p><a href="Default.aspx">Default.aspx</a></p>
    </div>
    </form>
</body>
</html>
