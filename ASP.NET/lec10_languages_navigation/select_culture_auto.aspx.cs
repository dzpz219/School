using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class select_culture_auto : System.Web.UI.Page
{
    /// <summary>
    /// Populate the the current date/time and a price, for something to work with.
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        lblDate.Text = DateTime.Now.ToString("D");
        lblPrice.Text = (1234.56).ToString("c");
    }
}