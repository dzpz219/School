using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Configuration;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class testing : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
 
    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        SqlConnection con = new SqlConnection(WebConfigurationManager.ConnectionStrings["HASCConnectionString"].ConnectionString);
        string queryString = "SELECT * FROM [Teams]";
        SqlCommand cmd = new SqlCommand(queryString, con);
        using (con) {
            con.Open();
            SqlDataReader rdr = cmd.ExecuteReader();
            while (rdr.Read()) {
                ReadSingleRow((IDataRecord)rdr);
            }
            rdr.Close();
        }
    }
    private static void ReadSingleRow(IDataRecord record)
    {
        Console.WriteLine(String.Format("{0}, {1}", record[0], record[1]));
    }
}