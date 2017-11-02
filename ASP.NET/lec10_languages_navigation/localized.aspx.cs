using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class localized : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    /// <summary>
    /// Retrieve welcome message from correct language, populate placeholder with user name.
    /// </summary>
    /// <param name="sender">btnSubmit</param>
    /// <param name="e">Event data</param>
    protected void btnSubmit_Click(object sender, EventArgs e)
    {
        string welcomeMessage = GetLocalResourceObject("WelcomeMessage").ToString();
        lblResult.Text = string.Format(welcomeMessage, txtFirstName.Text);
    }
}