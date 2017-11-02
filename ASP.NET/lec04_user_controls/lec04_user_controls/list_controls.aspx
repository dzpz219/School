<%@ Page Language="C#" AutoEventWireup="true" CodeFile="list_controls.aspx.cs" Inherits="list_controls" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
        <title>List Controls</title>
        <link href="StyleSheet.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:SqlDataSource
            ID="sqlNursingUnits"
            runat="server"
            ConnectionString="<%$ ConnectionStrings:CHDBConnectionString %>"
            SelectCommand="SELECT [NursingUnitID] FROM [NursingUnits]">
        </asp:SqlDataSource>
    
                <div class="floater">
                    <h3>BulletedList</h3>
                    <asp:BulletedList
                        ID="bltNursingUnits"
                        runat="server"
                        DataSourceID="sqlNursingUnits"
                        DataTextField="NursingUnitID"
                        DataValueField="NursingUnitID">
                    </asp:BulletedList>
                </div>

                <div class="floater">
                    <h3>CheckBoxList</h3>
                    <asp:CheckBoxList
                        ID="chkNursingUnits"
                        runat="server" 
                        DataSourceID="sqlNursingUnits"
                        DataTextField="NursingUnitID"
                        DataValueField="NursingUnitID">
                    </asp:CheckBoxList>
                </div>

                <div class="floater">
                    <h3>DropDownList</h3>
                    <asp:DropDownList ID="ddlNursingUnits"
                        runat="server"
                        DataSourceID="sqlNursingUnits"
                        DataTextField="NursingUnitID"
                        DataValueField="NursingUnitID">
                    </asp:DropDownList>
                </div>

                <div class="floater">
                    <h3>ListBox</h3>
                    <asp:ListBox ID="lstNursingUnits"
                        runat="server"
                        DataSourceID="sqlNursingUnits"
                        DataTextField="NursingUnitID"
                        DataValueField="NursingUnitID"
                        ondatabound="lstNursingUnits_DataBound"
                        SelectionMode="Multiple">
                    </asp:ListBox>
                </div>

                <div class="floater">
                    <h3>RadioButtonList</h3>
                    <asp:RadioButtonList
                        ID="radNursingUnits"
                        runat="server"
                        DataSourceID="sqlNursingUnits"
                        DataTextField="NursingUnitID"
                        DataValueField="NursingUnitID">
                    </asp:RadioButtonList>
                </div>
        
                <br />

                <asp:Button ID="btnSubmit" runat="server" Text="Submit" OnClick="btnSubmit_Click" /><br />
                <asp:Label ID="lblResult" runat="server"></asp:Label>
                <br />
                <br />
                <a href="Default.aspx">Default.aspx</a>
    </div>
    </form>
</body>
</html>