using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient; // Added for SqlParameter

public partial class cancel_an_update : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    /// <summary>
    /// If any of the parameters in the update are empty, inform the user that all
    /// fields are required and cancel the update.
    /// </summary>
    /// <param name="sender">srcDepartment</param>
    /// <param name="e">Data source updating event data</param>
    protected void sqlDepartments_Updating(object sender, SqlDataSourceCommandEventArgs e)
    {
        foreach (SqlParameter parm in e.Command.Parameters)
        {
            if (parm.Value == null)
            {
                lblError.Text = "All fields are required!";
                e.Cancel = true;
            }
        }
    }
}