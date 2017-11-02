using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.Configuration; // Added for WebConfigurationManager
using System.Data.SqlClient; // Added for SQL classes
using System.Web.UI.DataVisualization.Charting; // Added for Chart classes

public partial class drill_down_preview : System.Web.UI.Page
{
    /// <summary>
    /// Set up bar chart preview with detailed sales from category in query string
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            // Parse query parameter
            string category = Request.QueryString.ToString();
            if (category.IndexOf("=") != -1)
            {
                category = category.Substring(category.IndexOf("=") + 1);

                // Convert %2f to /
                if (category.IndexOf("%2f") != -1)
                    category = category.Replace("%2f", "/");

                // Convert + to " "
                if (category.IndexOf("+") != -1)
                    category = category.Replace("+", " ");

                // Convert Dairy to Dairy Products
                if (category == "Dairy")
                    category = "Dairy Products";
            }

            string con_string = WebConfigurationManager.ConnectionStrings["NorthwindConnectionString"].ConnectionString;
            SqlConnection con = new SqlConnection(con_string);
            SqlCommand cmd = new SqlCommand("SELECT Product, Sales FROM CategoryProductSales WHERE Category = '" + category + "' ORDER BY Product", con);

            try
            {
                using (con)
                {
                    con.Open();
                    SqlDataReader reader = cmd.ExecuteReader();

                    // Rename series1
                    chtProducts.Series["Series1"].Name = "Sales";

                    // Bind chart to data source
                    // reader = data source
                    // Product = The name of the column that will supply the X-values for the data points
                    // Sales = Name of the field for Y values
                    chtProducts.Series["Sales"].Points.DataBindXY(reader, "Product", reader, "Sales");

                    // Loop through all data series and set each to bar
                    foreach (Series ser in chtProducts.Series)
                    {
                        ser.ChartType = SeriesChartType.Bar;
                    }

                    // Set chart size
                    chtProducts.Height = 160;
                    chtProducts.Width = 160;

                    // Set border rounded corners
                    chtProducts.BorderSkin.SkinStyle = BorderSkinStyle.Emboss;

                    // Format y axis labels
                    chtProducts.ChartAreas[0].AxisY.LabelStyle.Format = "c0";

                    // Ensure all x axis labels display
                    chtProducts.ChartAreas[0].AxisX.Interval = 1.0;

                    // Disable x axis margin
                    chtProducts.ChartAreas[0].AxisX.IsMarginVisible = false;

                    // Chart render type needs to be BinaryStreaming to show up as a preview
                    chtProducts.RenderType = RenderType.BinaryStreaming;
                }
            }
            catch
            {
            }
        }
    }
}