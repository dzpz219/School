using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Drawing; // Added for Color
using System.Web.Configuration; // Added for WebConfigurationManager
using System.Data.SqlClient; // Added for SQL objects
using System.Data; // Added for CommandType enumeration

public partial class register : System.Web.UI.Page
{
    /// <summary>
    /// Set focus to the user name of the login control.
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        txtUserName.Focus();
    }

    /// <summary>
    /// Register new user.
    /// </summary>
    /// <param name="sender">btnRegister</param>
    /// <param name="e">Event data</param>
    protected void btnRegister_Click(object sender, EventArgs e)
    {
        if (Page.IsValid)
        {
            lblResult.Text = "";
            lblResult.ForeColor = Color.Black;

            string con_string = WebConfigurationManager.ConnectionStrings["CHDBConnectionString"].ConnectionString;
            SqlConnection con = new SqlConnection(con_string);

            // Create SQL command object
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.CommandText = "InsertUsers";

            // Create SQL command parameters
            cmd.Parameters.Add("@UserName", SqlDbType.VarChar, 50);
            cmd.Parameters["@UserName"].Value = txtUserName.Text.Trim();
            cmd.Parameters.Add("@Email", SqlDbType.VarChar, 50);
            cmd.Parameters["@Email"].Value = txtEmail.Text.Trim();
            cmd.Parameters.Add("@Password", SqlDbType.VarChar, 50);
            cmd.Parameters["@Password"].Value = txtPassword.Text.Trim();

            using (con)
            {
                try
                {
                    con.Open();
                    int results = cmd.ExecuteNonQuery();
                    if (results == 1)
                        lblResult.Text = "User registered successfully.";
                }
                catch (Exception ex)
                {
                    lblResult.Text = ex.Message;
                    lblResult.ForeColor = Color.Red;
                }
            }
        }
    }
}