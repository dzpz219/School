using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Globalization; // Added for CultureInfo class

public partial class using_culture_info : System.Web.UI.Page
{
    /// <summary>
    /// Create two culture objects (German & Hungarian) and use them to format the date and currency.
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        // Create German Culture Info object
        CultureInfo gCulture = new CultureInfo("de-DE");

        // Use culture when formatting strings
        lblGermanDate.Text = DateTime.Now.ToString("D", gCulture);
        lblGermanPrice.Text = (1234.56).ToString("c", gCulture);

        // Create Hungarian Culture Info object
        CultureInfo hCulture = new CultureInfo("hu-HU");

        // Use culture when formatting strings
        lblHungarianDate.Text = DateTime.Now.ToString("D", hCulture);
        lblHungarianPrice.Text = (1234.56).ToString("c", hCulture);

    }
}