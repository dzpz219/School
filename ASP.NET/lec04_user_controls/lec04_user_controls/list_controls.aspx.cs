using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class list_controls : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    /// <summary>
    /// Populate a label with all items that have been selected.
    /// </summary>
    /// <param name="sender">btnSubmit</param>
    /// <param name="e">Event data</param>
    protected void btnSubmit_Click(object sender, EventArgs e)
    {
        lblResult.Text = "<b>The following items have been selected</b><br /><br />";

        // Loop through all check box items to see if any are selected
        lblResult.Text += "<b>CheckBox</b><br />";
        foreach (ListItem item in chkNursingUnits.Items)
        {
            if (item.Selected)
                lblResult.Text += item.Value + "<br />";
        }

        lblResult.Text += "<br /><b>DropDownList</b><br />";
        lblResult.Text += ddlNursingUnits.SelectedValue + "<br />";

        // Loop through all list box items to see if any are selected
        lblResult.Text += "<br /><b>ListBox</b><br />";
        foreach (ListItem item in lstNursingUnits.Items)
        {
            if (item.Selected)
                lblResult.Text += item.Value + "<br />";
        }

        lblResult.Text += "<br /><b>RadioButton</b><br />";
        lblResult.Text += radNursingUnits.SelectedValue + "<br />";
    }

    /// <summary>
    /// List box displays 4 rows by default, display all rows (prevents scroll bars).
    /// </summary>
    /// <param name="sender">lstNursingUnits</param>
    /// <param name="e">Event data</param>
    protected void lstNursingUnits_DataBound(object sender, EventArgs e)
    {
        lstNursingUnits.Rows = lstNursingUnits.Items.Count;
    }
}