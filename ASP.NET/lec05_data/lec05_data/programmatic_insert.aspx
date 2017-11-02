<%@ Page Language="C#" AutoEventWireup="true" CodeFile="programmatic_insert.aspx.cs" Inherits="programmatic_insert" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Programmatic Insert</title>
    <link href="StyleSheet.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form id="form1" runat="server" defaultfocus="txtNursingUnitID">
        <div>
            <h1>Programmatic Insert</h1>

            <table>
                <tr>
                    <td>Nursing Unit ID:</td>
                    <td><asp:TextBox ID="txtNursingUnitID" runat="server" /></td>
                </tr>
                <tr>
                    <td>Specialty:</td>
                    <td><asp:TextBox ID="txtSpecialty" runat="server" /></td>
                </tr>
                <tr>
                    <td>Manager First Name:</td>
                    <td><asp:TextBox ID="txtManagerFirstName" runat="server" /></td>
                </tr>
                <tr>
                    <td>Manager Last Name:</td>
                    <td><asp:TextBox ID="txtManagerLastName" runat="server" /></td>
                </tr>
                <tr>
                    <td>Beds:</td>
                    <td><asp:TextBox ID="txtBeds" runat="server" /></td>
                </tr>
                <tr>
                    <td>Extension:</td>
                    <td><asp:TextBox ID="txtExtension" runat="server" /></td>
                </tr>
            </table>
            
            <asp:Button
                ID="btnCreateNew"
                runat="server"
                Text="Create New Nursing Unit"
                OnClick="btnCreateNew_Click" />

            <p><asp:Label ID="lblError" runat="server" EnableViewState="False" ForeColor="Red"></asp:Label></p>
            <p><a href="Default.aspx">Default.aspx</a></p>
            <asp:SqlDataSource
                ID="sqlNursingUnits"
                runat="server"
                ConnectionString='<%$ ConnectionStrings:CHDBConnectionString %>'
                InsertCommand="INSERT INTO NursingUnits(NursingUnitID, Specialty, ManagerFirstName, ManagerLastName, Beds, Extension) VALUES (@NursingUnitID, @Specialty, @ManagerFirstName, @ManagerLastName, @Beds, @Extension)"
                SelectCommand="SELECT * FROM NursingUnits">
                <InsertParameters>
                    <asp:Parameter Name="NursingUnitID"></asp:Parameter>
                    <asp:Parameter Name="Specialty"></asp:Parameter>
                    <asp:Parameter Name="ManagerFirstName"></asp:Parameter>
                    <asp:Parameter Name="ManagerLastName"></asp:Parameter>
                    <asp:Parameter Name="Beds"></asp:Parameter>
                    <asp:Parameter Name="Extension"></asp:Parameter>
                </InsertParameters>
            </asp:SqlDataSource>
        </div>
    </form>
</body>
</html>
