using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Configuration;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Coach : System.Web.UI.Page
{
    /// <summary>
    /// Only allow coaches and admin to access this page
    /// Display access level and full name of user
    /// </summary>
    /// <param name="sender">Page load</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        string PID = (string)Session["PID"];
        string accessLevel = (string)Session["accessLevel"];

        if (accessLevel != "coach" && accessLevel != "admin")
        {
            Response.Redirect("Unauthorized.aspx", true);
        }

        string con_string = WebConfigurationManager.ConnectionStrings["HASCConnectionString"].ConnectionString;
        SqlConnection con = new SqlConnection(con_string);
        string qString = "SELECT FirstName, LastName FROM dbo.Persons WHERE PersonID = " + PID;
        SqlCommand cmd = new SqlCommand(qString, con);
        try
        {
            using (con)
            {
                con.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                if (reader.Read())
                {
                    Label1.Text = "Greetings " + accessLevel + " " + reader.GetString(0) + " " + reader.GetString(1);
                }
            }
        }
        catch
        {
            Label1.Text = "noaccess";
        }
    }
}