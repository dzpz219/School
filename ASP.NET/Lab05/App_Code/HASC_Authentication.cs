// I, Chao Zhang, student number 000306946, certify that this material is my
// original work. No other person's work has been used without due
// acknowledgement and I have not made my work available to anyone else.

using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Configuration;
using System.Web.Services;

/// <summary>
/// Summary description for HASC_Authentication
/// </summary>
[WebService(Namespace = "http://mohawkcollege.ca/hasc")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
// [System.Web.Script.Services.ScriptService]
public class HASC_Authentication : System.Web.Services.WebService {

    public HASC_Authentication () {

        //Uncomment the following line if using designed components 
        //InitializeComponent(); 
    }

    /// <summary>
    /// Returns a string to identify the accesslevel of the user entered
    /// </summary>
    /// <param name="Email">Email address of the user</param>
    /// <param name="Password">Password for the user</param>
    /// <returns>accesslevel of user</returns>
    [WebMethod(Description = "Returns a user's accesslevel based on credentials entered.")]
    public string Authenticate(string Email, string Password) {
        string output = "noaccess";
        bool admin = false;
        bool coach = false;
        bool player = false;
        bool referee = false;
        int PID = -1;
        string con_string = WebConfigurationManager.ConnectionStrings["HASCConnectionString"].ConnectionString;
        SqlConnection con = new SqlConnection(con_string);
        string qString = "SELECT PersonID, Administrator, Coach, Player, Referee FROM dbo.Persons WHERE Email = " + "'" + Email + "'" +  " AND UserPassword = " + "'" + Password + "'";
        SqlCommand cmd = new SqlCommand(qString, con);
        try
        {
            using (con)
            {
                con.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                if (reader.Read())
                {
                    PID = (int)reader.GetValue(0);
                    admin = (bool)reader.GetValue(1);
                    coach = (bool)reader.GetValue(2);
                    player = (bool)reader.GetValue(3);
                    referee = (bool)reader.GetValue(4);

                    if (admin == true)
                    {
                        output = "administrator," + PID;
                    }
                    if (coach == true)
                    {
                        output = "coach," + PID;
                    }
                    if (player == true)
                    {
                        output = "player," + PID;
                    }
                    if (referee == true)
                    {
                        output = "referee," + PID;
                    }                    
                }
            }
        }
        catch
        {
            output = "noaccess";
        }
        return output;
    }
    
}
