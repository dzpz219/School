using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class grid_view : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    /// <summary>
    /// Highlight admission records in yellow if the nursing unit doesn't start
    /// with a 1, 2 or 3.
    /// </summary>
    /// <param name="sender">grdAdmissions</param>
    /// <param name="e">Grid view row event data</param>
    protected void grdAdmissions_RowDataBound(object sender, GridViewRowEventArgs e)
    {
        if (e.Row.RowType == DataControlRowType.DataRow)
        {
            String floor = DataBinder.Eval(e.Row.DataItem, "NursingUnitID").ToString().Substring(0, 1);
            if (floor != "1" && floor != "2" && floor != "3")
                e.Row.BackColor = System.Drawing.Color.Yellow;
        }
    }
}