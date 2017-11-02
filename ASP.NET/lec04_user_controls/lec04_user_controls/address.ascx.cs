using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class address : System.Web.UI.UserControl
{
    /// <summary>
    /// Setup province drop down list.
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            String[] prov = { "AB", "BC", "MB", "NB", "NL", "NT", "NS", "NU", "ON", "PE", "QC", "SK", "YT" };
            ddlProv.DataSource = prov;
            ddlProv.DataBind();
            ddlProv.SelectedIndex = 8;
        }
    }

    /// <summary>
    /// Gets or sets a value that is the title of the address block.
    /// </summary>
    public String Title
    {
        get { return ltlTitle.Text; }
        set { ltlTitle.Text = value; }
    }

    /// <summary>
    /// Gets or sets a value for the street address of the address block.
    /// </summary>
    public String Street
    {
        get { return txtStreet.Text; }
        set { txtStreet.Text = value; }
    }

    /// <summary>
    /// Gets or sets a value for the city of the address block.
    /// </summary>
    public String City
    {
        get { return txtCity.Text; }
        set { txtCity.Text = value; }
    }

    /// <summary>
    /// Gets or sets a value for the province of the address block.
    /// </summary>
    public String Province
    {
        get { return ddlProv.SelectedValue; }
        set { ddlProv.SelectedValue = value; }
    }

    /// <summary>
    /// Gets or sets a value for the postal code of the address block.
    /// </summary>
    public String PostalCode
    {
        get { return txtPostalCode.Text; }
        set { txtPostalCode.Text = value; }
    }
}