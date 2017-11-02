using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class page3 : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    /// <summary>
    /// Thank customer for order.
    /// </summary>
    /// <param name="sender">btnSubmit</param>
    /// <param name="e">Event data</param>
    protected void btnSubmit_Click(object sender, EventArgs e)
    {
        lblResult.Text = "Thank you for your order";
    }
}