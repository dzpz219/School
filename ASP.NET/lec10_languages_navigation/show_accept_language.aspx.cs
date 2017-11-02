using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class show_accept_language : System.Web.UI.Page
{
    /// <summary>
    /// Bind the Accept-Language header list to the bulleted list.
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        bltAcceptLanguages.DataSource = Request.UserLanguages;
        bltAcceptLanguages.DataBind();
    }
}