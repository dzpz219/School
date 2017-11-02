using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class addresses : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    /// <summary>
    /// Access the properties of the user control and return the values.
    /// </summary>
    /// <param name="sender">btnSubmit</param>
    /// <param name="e">Event data</param>
    protected void btnSubmit_Click(object sender, EventArgs e)
    {
        lblResult.Text = "<hr><b>Billing Address</b><br>" +
                         addBilling.Street + "<br>" +
                         addBilling.City + "<br>" +
                         addBilling.Province + "<br>" +
                         addBilling.PostalCode + "<br><br>" +
                         "<b>Shipping Address</b><br>" +
                         addShipping.Street + "<br>" +
                         addShipping.City + "<br>" +
                         addShipping.Province + "<br>" +
                         addShipping.PostalCode;
    }
}