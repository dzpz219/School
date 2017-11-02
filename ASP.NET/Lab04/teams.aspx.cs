using System;
using System.Collections.Generic;
using System.Web.Configuration;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;

public partial class teams : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {


        DropDownList divisionDropdown = (DropDownList)Page.PreviousPage.FindControl("divisionDropdown");
        Label1.Text = divisionDropdown.SelectedItem.ToString();
        newTeamSrc.SelectCommand = "SELECT * FROM [Players] WHERE ([DivisionID] = " + divisionDropdown.SelectedValue.ToString() + ") ORDER BY [SkillLevel] ASC";
    }
}