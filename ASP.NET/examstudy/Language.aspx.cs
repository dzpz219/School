using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Language : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void FR_Click(object sender, EventArgs e)
    {
        Session["Language"] = "fr-FR";
    }
    protected void EN_Click(object sender, EventArgs e)
    {
        Session["Language"] = "en-CA";
    }
}