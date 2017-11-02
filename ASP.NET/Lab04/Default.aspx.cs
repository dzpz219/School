using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : System.Web.UI.Page
{

    protected void Page_Load(object sender, EventArgs e)
    {

        if (!IsPostBack)
        {
            divisionDropdown.SelectedIndex = 4;
            teamSrc.SelectCommand = "SELECT * FROM [Teams] WHERE ([DivisionID] = 4)";
        }
    }
    protected void divisionChange(object sender, EventArgs e)
    {
        teamSrc.SelectCommand = "SELECT * FROM [Teams] WHERE ([DivisionID] = " + divisionDropdown.SelectedValue.ToString() + ")";
        
    }
}
