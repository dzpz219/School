using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Protected_Unauthorized : System.Web.UI.Page
{
    /// <summary>
    /// Display access level of user
    /// </summary>
    /// <param name="sender">Page load</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        Label1.Text = "Access level = " + Session["accessLevel"];
    }
}