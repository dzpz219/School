using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class page1 : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        String items = Session["items"].ToString();
        int cnt = (int)Session["item_count"];
        lblOutput.Text = String.Format("There are {0} {1} in the array list.", cnt, items);
    }
}