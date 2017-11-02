using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.Configuration; // Added for WebConfigurationManager
using System.Data.SqlClient; // Added for SQL classes
using System.Web.UI.DataVisualization.Charting; // Added for Chart classes

public partial class drill_down : System.Web.UI.Page
{
    /// <summary>
    /// Set up column chart with category sales data with drill down and preview tooltip
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            string con_string = WebConfigurationManager.ConnectionStrings["NorthwindConnectionString"].ConnectionString;
            SqlConnection con = new SqlConnection(con_string);
            SqlCommand cmd = new SqlCommand("SELECT Category, Sales FROM CategorySales ORDER BY Category", con);

            try
            {
                using (con)
                {
                    con.Open();
                    SqlDataReader reader = cmd.ExecuteReader();

                    // Rename series1
                    chtCategories.Series["Series1"].Name = "Sales";

                    // Bind chart to data source
                    // reader = data source
                    // Category = The name of the column that will supply the X-values for the data points
                    // Sales = Name of the field for Y values
                    chtCategories.Series["Sales"].Points.DataBindXY(reader, "Category", reader, "Sales");

                    // Set chart size
                    chtCategories.Height = 600;
                    chtCategories.Width = 600;

                    // Set border rounded corners
                    chtCategories.BorderSkin.SkinStyle = BorderSkinStyle.Emboss;

                    // Format y axis labels
                    chtCategories.ChartAreas[0].AxisY.LabelStyle.Format = "c0";

                    // Make chart area 3D
                    chtCategories.ChartAreas[0].Area3DStyle.Enable3D = true;

                    // Disable x axis margin
                    chtCategories.ChartAreas[0].AxisX.IsMarginVisible = false;

                    // Set series preview and drill down
                    foreach (Series series in chtCategories.Series)
                    {
                        for (int pointIndex = 0; pointIndex < series.Points.Count; pointIndex++)
                        {
                            string toolTip = "<img src=drill_down_preview.aspx?category=" + series.Points[pointIndex].AxisLabel + " />";
                            series.Points[pointIndex].MapAreaAttributes = "onmouseover=\"DisplayTooltip('" + toolTip + "');\" onmouseout=\"DisplayTooltip('');\"";
                            series.Points[pointIndex].Url = "drill_down_detail.aspx?category=" + series.Points[pointIndex].AxisLabel;
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                lblError.Text = ex.Message;
            }
        }
    }
}