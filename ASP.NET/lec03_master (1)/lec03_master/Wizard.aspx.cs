using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Wizard : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    /// <summary>
    /// Display name and telephone number of surveyed user
    /// </summary>
    /// <param name="sender">Wizard1</param>
    /// <param name="e">Wizard event data</param>
    protected void Wizard1_FinishButtonClick(object sender, WizardNavigationEventArgs e)
    {
        lblNameResult.Text = txtName.Text;
        lblPhoneResult.Text = txtPhone.Text;
    }
}