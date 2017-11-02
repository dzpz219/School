using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class grid_view_summary : System.Web.UI.Page
{
    private decimal total_value = 0; // Acumulate inventory value

    protected void Page_Load(object sender, EventArgs e)
    {

    }

    /// <summary>
    /// Accumulate inventory total, then place total in summary row.
    /// </summary>
    /// <param name="sender">grdInventory</param>
    /// <param name="e">Grid view row event data</param>
    protected void grdInventory_RowDataBound(object sender, GridViewRowEventArgs e)
    {
        // Accumulate inventory
        if (e.Row.RowType == DataControlRowType.DataRow)
        {
            decimal value = (decimal)DataBinder.Eval(e.Row.DataItem, "InventoryValue");
            total_value += value;
        }

        // Place total
        if (e.Row.RowType == DataControlRowType.Footer)
        {
            Label lblSummary = (Label)e.Row.FindControl("lblSummary");
            lblSummary.Text = String.Format("{0:c}", total_value);
        }
    }
}