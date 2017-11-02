using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class search : System.Web.UI.Page
{
    /// <summary>
    /// Access previous page to retrieve search string 3 different ways
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        if (PreviousPage != null)
        {
            // Using FindControl
            TextBox txtSearch = (TextBox)(PreviousPage.FindControl("txtSearch"));
            lblSearch.Text = String.Format("Search for: {0}. Found with PreviousPage.FindControl", txtSearch.Text);

            // Using typed property
            lblSearchTyped.Text = "Search for: " + PreviousPage.SearchString + ". Found with PreviousPage.SearchString";

            // Using request object
            lblSearchRequestObject.Text = "Search for: " + Request["txtSearch"] + ". Found with Request[\"txtSearch\"]";
        }
        else
            lblNoSearchText.Text = "This page was called directly and therefore there is no previous page to access.";
    }
}