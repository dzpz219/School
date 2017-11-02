using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class validations : System.Web.UI.Page
{
    /// <summary>
    /// Populate Date of Birth compare validator with current date to compare against
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        cmpDOB.ValueToCompare = DateTime.Now.ToString("d");
    }

    /// <summary>
    /// If all validations are successful, acknowledge user input
    /// </summary>
    /// <param name="sender">btnSubmit</param>
    /// <param name="e">Event data</param>
    protected void btnSubmit_Click(object sender, EventArgs e)
    {
        if (Page.IsValid)
        {
            lblResult.Text = "Thank you for your input.";
        }
    }

    /// <summary>
    /// Perform custom validation server side, in case client has disabled JavaScript
    /// </summary>
    /// <param name="source">cusProgram</param>
    /// <param name="args">Event data</param>
    protected void cusProgram_ServerValidate(Object source, ServerValidateEventArgs args)
    {
        if (args.Value == "548" || args.Value == "558" || args.Value == "559")
            args.IsValid = true;
        else
            args.IsValid = false;
    }
}