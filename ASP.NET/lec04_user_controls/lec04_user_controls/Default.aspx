<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Lecture 4</title>
    <link href="StyleSheet.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <h2>Lecture 4 - User Controls, List Controls, DataLists &amp; Repeaters</h2>
        <a href="display_random_card.aspx">display_random_card.aspx</a> User control<br />
        <br />
        <a href="addresses.aspx">addresses.aspx</a> User control that uses properties and is used twice on the same page<br />
        <br />
        <a href="show_quotes.aspx">show_quotes.aspx</a> User control with AJAX<br />
        <br />
        <a href="list_controls.aspx">list_controls.aspx</a> List controls bound to SQL data source<br />
        <br />
        <a href="data_list.aspx">data_list.aspx</a> Data list control renders a table<br />
        <br />
        <a href="repeater.aspx">repeater.aspx</a> Repeater control allows more control over rendering<br />
        <br />
        <a href="repeater_nondb.aspx">repeater_nondb.aspx</a> Repeater with a non-database source
    </div>
    </form>
</body>
</html>
