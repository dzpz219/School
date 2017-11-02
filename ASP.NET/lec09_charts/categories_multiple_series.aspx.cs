using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.Configuration; // Added for WebConfigurationManager
using System.Data.SqlClient; // Added for SQL classes
using System.Web.UI.DataVisualization.Charting; // Added for Chart classes

public partial class categories_multiple_series : System.Web.UI.Page
{
    /// <summary>
    /// Set up line chart to show sales trends by product category
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            string con_string = WebConfigurationManager.ConnectionStrings["NorthwindConnectionString"].ConnectionString;
            SqlConnection con = new SqlConnection(con_string);
            SqlCommand cmd = new SqlCommand("SELECT Category, Month, Sales FROM CategorySales1998 ORDER BY Category, MonthNum", con);

            try
            {
                using (con)
                {
                    con.Open();
                    SqlDataReader reader = cmd.ExecuteReader();

                    // Remove default series
                    chtSalesByCategory.Series.RemoveAt(0);

                    // Bind chart to data source
                    // reader = data source
                    // Category = The name of the field used to group data into the series
                    // Month = Name of the field for X values
                    // Sales = Name of the field for Y values
                    // "" = Other data point properties that can be bound
                    chtSalesByCategory.DataBindCrossTable(reader, "Category", "Month", "Sales", "");

                    // Loop through all data series and set each to line and width to 5 pixels
                    foreach (Series ser in chtSalesByCategory.Series)
                    {
                        ser.ChartType = SeriesChartType.Spline;
                        ser.BorderWidth = 5;
                    }

                    // Set chart size
                    chtSalesByCategory.Height = 600;
                    chtSalesByCategory.Width = 600;

                    // Add a legend and dock it to bottom of chart
                    chtSalesByCategory.Legends.Add("default");
                    chtSalesByCategory.Legends[0].Docking = Docking.Bottom;

                    // Set border rounded corners
                    chtSalesByCategory.BorderSkin.SkinStyle = BorderSkinStyle.Emboss;

                    // Disable x axis margin
                    chtSalesByCategory.ChartAreas[0].AxisX.IsMarginVisible = false;
                }
            }
            catch (Exception ex)
            {
                lblError.Text = ex.Message;
            }
        }
    }
}