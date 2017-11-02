using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class medication_detail : System.Web.UI.Page
{
    /// <summary>
    /// Ensure that query string is an int
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        string medicationid = Request["medicationid"];
        int medicationid_int;
        if (!Int32.TryParse(medicationid, out medicationid_int))
            Response.Redirect("medication_detail.aspx?medicationid=0");
    }
}