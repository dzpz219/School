using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.Configuration; // Added for WebConfigurationManager
using System.Data.SqlClient; // Added for Sql objects
using System.Data; // Added for CommandType enumeration

public partial class login : System.Web.UI.Page
{
    /// <summary>
    /// Set focus to the user name of the login control.
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        SetFocus(Login1.FindControl("UserName"));
    }

    /// <summary>
    /// Override ASP.NET membership authentication with custom routine.
    /// </summary>
    /// <param name="sender">Login1</param>
    /// <param name="e">Login event data</param>
    protected void Login1_Authenticate(object sender, AuthenticateEventArgs e)
    {
        String con_string = WebConfigurationManager.ConnectionStrings["CHDBConnectionString"].ConnectionString;
        SqlConnection con = new SqlConnection(con_string);

        // Create SQL command object
        SqlCommand cmd = new SqlCommand();
        cmd.Connection = con;
        cmd.CommandType = CommandType.StoredProcedure;
        cmd.CommandText = "VerifyUsers";

        // Create SQL command parameters
        cmd.Parameters.Add("@UserName", SqlDbType.VarChar, 50);
        cmd.Parameters["@UserName"].Value = Login1.UserName.Trim();
        cmd.Parameters.Add("@Password", SqlDbType.VarChar, 50);
        cmd.Parameters["@Password"].Value = Login1.Password.Trim();

        try
        {
            using (con)
            {
                con.Open();
                // Since stored procedure returns single row, single column result set, ExecuteScalar can be used
                int result = (int)cmd.ExecuteScalar();
                if (result == 1)
                {
                    e.Authenticated = true;
                }
            }
        }
        catch (Exception ex)
        {
            lblError.Text = ex.Message;
        }
    }

    /// <summary>
    /// Redirect to page authorized2 if not already targetting authorized1.
    /// </summary>
    /// <param name="sender">Login1</param>
    /// <param name="e">Event data</param>
    protected void Login1_LoggedIn(object sender, EventArgs e)
    {
        string qs = Request.QueryString.ToString();
        if (qs.IndexOf("authorized1.aspx") == -1)
            Response.Redirect("~/protected/authorized2.aspx");
    }
}