using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Login : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        SetFocus(Login1.FindControl("UserName")); 
    }
    /// <summary>
    /// Handles the login credentials  
    /// </summary>
    /// <param name="sender">Login1</param>
    /// <param name="e">Event data</param>
    protected void Login1_Authenticate(object sender, AuthenticateEventArgs e)
    {
        HASC_Authentication auth = new HASC_Authentication();
        string user = auth.Authenticate(Login1.UserName, Login1.Password);
        if (user != "noaccess"){
            e.Authenticated = true;
            Session["accessLevel"] = user.Substring(0, user.IndexOf(","));
            Session["PID"] = user.Substring(user.IndexOf(",") + 1);
        }
    }

    /// <summary>
    /// Redirect pages on login
    /// </summary>
    /// <param name="sender">Login1</param>
    /// <param name="e">Event data</param>
    protected void Login1_LoggedIn(object sender, EventArgs e)
    {
        string qs = Request.QueryString.ToString();
        string accessLevel = (string)Session["accessLevel"];

        if (accessLevel == "admin" || accessLevel == "player")
        {
            Response.Redirect("~/protected/Player.aspx");
        }

        if ((accessLevel == "coach" || accessLevel == "referee") && qs.IndexOf("Player.aspx") == 25)
        {
            Response.Redirect("~/protected/Unauthorized.aspx");
        }

        if (accessLevel == "coach" && qs.IndexOf("Player.aspx") == -1)
        {
            Response.Redirect("~/protected/Coach.aspx");
        }

        if (accessLevel == "referee" && qs.IndexOf("Player.aspx") == -1)
        {
            Response.Redirect("~/protected/Referee.aspx");
        }
    }
}