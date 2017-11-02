using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class programmatic_insert_results : System.Web.UI.Page
{
    /// <summary>
    /// Populate a label with a query string.
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            lblResults.Text = "Nursing Unit " + Request["nursing_unit_id"] + " created.";
        }
    }
}