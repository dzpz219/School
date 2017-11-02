<%@ Page Language="C#" AutoEventWireup="true" CodeFile="repeater.aspx.cs" Inherits="repeater" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Repeater Control</title>
    <link href="StyleSheet.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <a href="Default.aspx">Default.aspx</a>
            <br />
            <br />

            <asp:SqlDataSource
                ID="sqlPatients"
                runat="server"
                ConnectionString="<%$ ConnectionStrings:CHDBConnectionString %>"
                SelectCommand="SELECT [FirstName], [LastName], [Gender], [BirthDate], [PatientHeight], [PatientWeight], [Allergies] FROM [Patients] WHERE [BirthDate] BETWEEN '1990-01-01' AND '1995-12-31'"></asp:SqlDataSource>

            <asp:Repeater
                ID="rptPatients"
                runat="server"
                DataSourceID="sqlPatients">
                <ItemTemplate>
                    <div class="floater">
                        <h3><%#Eval("FirstName") %> <%#Eval("LastName") %></h3>
                        <b>Gender:</b> <%#Eval("Gender") %><br />
                        <b>Date of birth:</b> <%#Eval("BirthDate","{0:d}") %><br />
                        <b>Height:</b> <%#Eval("PatientHeight") %> <b>Weight:</b> <%#Eval("PatientWeight") %><br />
                        <b>Allergies:</b> <%#Eval("Allergies") %>
                    </div>
                </ItemTemplate>
            </asp:Repeater>

        </div>
    </form>
</body>
</html>
