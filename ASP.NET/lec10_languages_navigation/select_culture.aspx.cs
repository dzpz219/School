using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Globalization; // Added for CultureInfo class

public partial class select_culture : System.Web.UI.Page
{
    /// <summary>
    /// On first post, set Culture to Hungarian.
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            Culture = "hu-HU";
            // Add a breakpoint here and inspect the cultures array
            CultureInfo[] cultures = CultureInfo.GetCultures(CultureTypes.SpecificCultures);

            // Create a table of all Specific Cultures
            ltlCulture.Text = "<table border='1' cellspacing='0'>\n";
            ltlCulture.Text += "<tr>\n";
            ltlCulture.Text += "<th>LCID</th>\n";
            ltlCulture.Text += "<th>Name</th>\n";
            ltlCulture.Text += "<th>Display Name</th>\n";
            ltlCulture.Text += "<th>Native Name</th>\n";
            ltlCulture.Text += "</tr>\n";
            foreach (CultureInfo culture in cultures)
            {
                ltlCulture.Text += "<tr>\n";
                ltlCulture.Text += "<td>" + culture.LCID + "</td>";
                ltlCulture.Text += "<td>" + culture.Name + "</td>";
                ltlCulture.Text += "<td>" + culture.DisplayName + "</td>";
                ltlCulture.Text += "<td>" + culture.NativeName + "</td>";
                ltlCulture.Text += "</tr>\n";
            }
            ltlCulture.Text += "</table>\n";
        }
    }

    /// <summary>
    /// Change Culture to value selected by user in drop down list.
    /// </summary>
    /// <param name="sender">ddlCulture</param>
    /// <param name="e">Event data</param>
    protected void ddlCulture_SelectedIndexChanged(object sender, EventArgs e)
    {
        Culture = ddlCulture.SelectedValue;
    }

    /// <summary>
    /// Page_PreRender happens after DropDownList SelectedIndexChanged event.
    /// </summary>
    void Page_PreRender()
    {
        lblDate.Text = DateTime.Now.ToString("D");
        lblPrice.Text = (1234.56).ToString("c");
    }
}