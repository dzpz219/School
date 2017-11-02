using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : System.Web.UI.Page
{
    /// <summary>
    /// Set page title
    /// Give focus to first name text box
    /// Populate bulleted list items 0 to 99
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        ltlTitle.Text = "Standard Controls - " + DateTime.Now.ToString("D");

        txtFirstName.Focus();

        for (int i = 0; i < 100; i++)
            bltList.Items.Add("Item " + i.ToString());
    }

    /// <summary>
    /// Toggle visibility of SQL newsletter check box
    /// </summary>
    /// <param name="sender">chkNewsletter</param>
    /// <param name="e">Event data</param>
    protected void chkNewsletter_CheckedChanged(object sender, EventArgs e)
    {
        chkSQL.Visible = chkNewsletter.Checked;
    }

    /// <summary>
    /// Process submit link button
    /// </summary>
    /// <param name="sender">lnkSubmit</param>
    /// <param name="e">Event data</param>
    protected void lnkSubmit_Click(object sender, EventArgs e)
    {
        lblResult.Text = "Favourite Colour=" + txtFavColour.Text + "<br />";

        lblResult.Text += "SQL=" + chkSQL.Checked.ToString() + "<br />";

        if (radMagazine.Checked)
            lblResult.Text += radMagazine.Text;
        else if (radTelevision.Checked)
            lblResult.Text += radTelevision.Text;
        else if (radOther.Checked)
            lblResult.Text += radOther.Text;
    }

    /// <summary>
    /// Toggle visibility of work phone numbers panel
    /// </summary>
    /// <param name="sender">chkBusiness</param>
    /// <param name="e">Event data</param>
    protected void chkBusiness_CheckedChanged(object sender, EventArgs e)
    {
        pnlBusiness.Visible = chkBusiness.Checked;
    }

    /// <summary>
    /// Public read only property to return the contents of the txtSearch text box
    /// </summary>
    public string SearchString
    {
        get { return txtSearch.Text; }
    }
}