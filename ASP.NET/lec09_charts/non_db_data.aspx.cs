using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.DataVisualization.Charting; // Added for Chart classes
using System.Drawing; // Added for Color class

public partial class non_db_data : System.Web.UI.Page
{
    /// <summary>
    /// Set up column chart to show wins by the Leafs and Canadiens from recent seasons
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            // Set chart size
            chtLeafsVsCanadiens.Height = 600;
            chtLeafsVsCanadiens.Width = 600;

            // Rename existing Series1 to Leafs and add wins from 2008-09 to 2013-14
            chtLeafsVsCanadiens.Series["Series1"].Name = "Leafs";
            chtLeafsVsCanadiens.Series["Leafs"].Points.AddY(34);
            chtLeafsVsCanadiens.Series["Leafs"].Points.AddY(30);
            chtLeafsVsCanadiens.Series["Leafs"].Points.AddY(37);
            chtLeafsVsCanadiens.Series["Leafs"].Points.AddY(35);
            chtLeafsVsCanadiens.Series["Leafs"].Points.AddY(26);
            chtLeafsVsCanadiens.Series["Leafs"].Points.AddY(38);

            // Add series for Canadiens and wins from 2008-09 to 2013-14
            chtLeafsVsCanadiens.Series.Add("Canadiens");
            chtLeafsVsCanadiens.Series["Canadiens"].Points.AddY(41);
            chtLeafsVsCanadiens.Series["Canadiens"].Points.AddY(39);
            chtLeafsVsCanadiens.Series["Canadiens"].Points.AddY(44);
            chtLeafsVsCanadiens.Series["Canadiens"].Points.AddY(31);
            chtLeafsVsCanadiens.Series["Canadiens"].Points.AddY(29);
            chtLeafsVsCanadiens.Series["Canadiens"].Points.AddY(46);

            // Set series column colours
            chtLeafsVsCanadiens.Series["Leafs"].Color = Color.Blue;
            chtLeafsVsCanadiens.Series["Canadiens"].Color = Color.Red;

            // Add a legend, dock it to bottom of chart, centre it and format it
            chtLeafsVsCanadiens.Legends.Add("default");
            chtLeafsVsCanadiens.Legends[0].Docking = Docking.Bottom;
            chtLeafsVsCanadiens.Legends[0].Alignment = StringAlignment.Center;
            chtLeafsVsCanadiens.Legends[0].Font = new Font("SansSerif", 12, FontStyle.Bold);

            // Disable y axis and grids and ticks from x axis
            chtLeafsVsCanadiens.ChartAreas[0].AxisY.Enabled = AxisEnabled.False;
            chtLeafsVsCanadiens.ChartAreas[0].AxisX.MajorGrid.Enabled = false;
            chtLeafsVsCanadiens.ChartAreas[0].AxisX.MajorTickMark.Enabled = false;

            // Add custom x axis labels
            chtLeafsVsCanadiens.ChartAreas[0].AxisX.CustomLabels.Add(0.5, 1.5, "2008-09");
            chtLeafsVsCanadiens.ChartAreas[0].AxisX.CustomLabels.Add(1.5, 2.5, "2009-10");
            chtLeafsVsCanadiens.ChartAreas[0].AxisX.CustomLabels.Add(2.5, 3.5, "2010-11");
            chtLeafsVsCanadiens.ChartAreas[0].AxisX.CustomLabels.Add(3.5, 4.5, "2011-12");
            chtLeafsVsCanadiens.ChartAreas[0].AxisX.CustomLabels.Add(4.5, 5.5, "2012-13");
            chtLeafsVsCanadiens.ChartAreas[0].AxisX.CustomLabels.Add(5.5, 6.5, "2013-14");
            chtLeafsVsCanadiens.ChartAreas[0].AxisX.LabelStyle.Font = new Font("SansSerif", 12, FontStyle.Bold);
            
            // Disable x axis margin
            chtLeafsVsCanadiens.ChartAreas[0].AxisX.IsMarginVisible = false;

            // Set border rounded corners
            chtLeafsVsCanadiens.BorderSkin.SkinStyle = BorderSkinStyle.Emboss;

            // Set background colours
            chtLeafsVsCanadiens.BackColor = Color.Silver;

            // Add title
            chtLeafsVsCanadiens.Titles.Add("Wins - Leafs vs. Canadiens");
            chtLeafsVsCanadiens.Titles[0].Font = new Font("SansSerif", 20, FontStyle.Bold);

            // Show data point labels and format them
            chtLeafsVsCanadiens.Series["Leafs"].IsValueShownAsLabel = true;
            foreach (DataPoint dp in chtLeafsVsCanadiens.Series["Leafs"].Points)
            {
                dp.Font = new Font("SansSerif", 12, FontStyle.Bold);
            }
            chtLeafsVsCanadiens.Series["Canadiens"].IsValueShownAsLabel = true;
            foreach (DataPoint dp in chtLeafsVsCanadiens.Series["Canadiens"].Points)
            {
                dp.Font = new Font("SansSerif", 12, FontStyle.Bold);
            }
        }
    }
}