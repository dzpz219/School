// I, Firstname Lastname, student number 123456789, certify that this material is my
// original work. No other person's work has been used without due
// acknowledgement and I have not made my work available to anyone else.

using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        Name.Focus();
    }

    protected void PWValidator_ServerValidate(Object source, ServerValidateEventArgs args) 
    {
        if (args.Value.Length >= 6)
            args.IsValid = true;
        else
            args.IsValid = false;
    }
    protected void Coach_CheckedChanged(object sender, EventArgs e)
    {
        txtBoxCoach.Visible = true;
    }
    protected void Referee_CheckedChanged(object sender, EventArgs e)
    {
        txtBoxReferee.Visible = Referee.Checked;
    }
    protected void Password_TextChanged(object sender, EventArgs e)
    {
        if (Password.Text.Length < 6)
        {
            lblPassword.Text = "Password must be at least 6 characters";
        }
    }
}