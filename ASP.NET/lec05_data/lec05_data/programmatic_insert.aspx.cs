using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class programmatic_insert : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    /// <summary>
    /// Populate the data source insert parameters, call the insert method, then re-direct
    /// to a page with a completion message passing the nursing unit as a query string.
    /// </summary>
    /// <param name="sender">btnCreateNew</param>
    /// <param name="e">Event data</param>
    protected void btnCreateNew_Click(object sender, EventArgs e)
    {
        try
        {
            sqlNursingUnits.InsertParameters["NursingUnitID"].DefaultValue = txtNursingUnitID.Text;
            sqlNursingUnits.InsertParameters["Specialty"].DefaultValue = txtSpecialty.Text;
            sqlNursingUnits.InsertParameters["ManagerFirstName"].DefaultValue = txtManagerFirstName.Text;
            sqlNursingUnits.InsertParameters["ManagerLastName"].DefaultValue = txtManagerLastName.Text;
            sqlNursingUnits.InsertParameters["Beds"].DefaultValue = txtBeds.Text;
            sqlNursingUnits.InsertParameters["Extension"].DefaultValue = txtExtension.Text;
            sqlNursingUnits.Insert();
            Response.Redirect("programmatic_insert_results.aspx?nursing_unit_id=" + txtNursingUnitID.Text);
        }
        catch (Exception ex)
        {
            lblError.Text = ex.Message;
        }
    }
}