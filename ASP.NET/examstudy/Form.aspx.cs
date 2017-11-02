using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Form : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected override void InitializeCulture()
    {
        base.InitializeCulture();
        if (Session["Language"] != null)
        {
            String language = (String)Session["Language"];
            UICulture = language;
            Culture = language;
        }

        else {
            UICulture = "auto";
            Culture = "auto";
        }
    }
}