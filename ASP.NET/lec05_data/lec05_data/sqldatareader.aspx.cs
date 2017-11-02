using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.Configuration; // Added for WebConfigurationManager
using System.Data.SqlClient; // Added for SqlConnection, SqlCommand and SqlDataReader

public partial class sqldatareader : System.Web.UI.Page
{
    /// <summary>
    /// Loop through all current admissions and count the number of patients on each floor.
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            int floor1 = 0, floor2 = 0, floor3 = 0, other = 0, total;
            String con_string = WebConfigurationManager.ConnectionStrings["CHDBConnectionString"].ConnectionString;
            SqlConnection con = new SqlConnection(con_string);
            SqlCommand cmd = new SqlCommand("SELECT * FROM Admissions WHERE DischargeDate IS NULL", con);

            ltlOutput.Text = "<h1>Using a SQL Data Reader</h1>\n";

            try
            {
                using (con)
                {
                    con.Open();
                    SqlDataReader reader = cmd.ExecuteReader();

                    while (reader.Read())
                    {
                        String floor = reader["NursingUnitID"].ToString().Substring(0, 1);
                        if (floor == "1")
                            floor1++;
                        else if (floor == "2")
                            floor2++;
                        else if (floor == "3")
                            floor3++;
                        else
                            other++;
                    }
                    reader.Close();
                }

                total = floor1 + floor2 + floor3 + other;

                // \n is a newline character to enhance the readability of the HTML
                ltlOutput.Text += "<h2>Current Patient Admissions</h2>\n";
                ltlOutput.Text += "<table>\n";
                ltlOutput.Text += "<tr><td>Patients on 1st floor</td><td style='text-align:right;'>" + floor1.ToString() + "</td></tr>\n";
                ltlOutput.Text += "<tr><td>Patients on 2nd floor</td><td style='text-align:right;'>" + floor2.ToString() + "</td></tr>\n";
                ltlOutput.Text += "<tr><td>Patients on 3rd floor</td><td style='text-align:right;'>" + floor3.ToString() + "</td></tr>\n";
                ltlOutput.Text += "<tr><td>Patients in special units</td><td style='text-align:right;'>" + other.ToString() + "</td></tr>\n";
                ltlOutput.Text += "<tr><td><b>Total patients</b></td><td style='text-align:right;'><b>" + total.ToString() + "</b></td></tr>\n";
                ltlOutput.Text += "</table>\n";
            }
            catch (Exception ex)
            {
                ltlOutput.Text += "<br /><br /><span id=\"lblError\" style=\"color:Red;\">" + ex.Message + "</span>";
            }
        }
    }
}