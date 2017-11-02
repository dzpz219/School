using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class gridview_error : System.Web.UI.Page
{
    /// <summary>
    /// Reset error label.
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        lblError.Text = "";
    }

    /// <summary>
    /// If an exception occurs during the update, pass the error message to the user
    /// and mark the exception as handled.
    /// </summary>
    /// <param name="sender">grdDepartments</param>
    /// <param name="e">GridView updated event data</param>
    protected void grdDepartments_RowUpdated(object sender, GridViewUpdatedEventArgs e)
    {
        if (e.Exception != null)
        {
            lblError.Text = e.Exception.Message;
            e.ExceptionHandled = true;
        }
    }
}