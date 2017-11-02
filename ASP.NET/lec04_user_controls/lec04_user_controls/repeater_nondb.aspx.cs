using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.IO; // Added for Directory and Path classes

public partial class repeater_nondb : System.Web.UI.Page
{
    /// <summary>
    /// Bind photos to Repeater.
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!Page.IsPostBack)
        {
            rptPhotos.DataSource = GetPhotos();
            rptPhotos.DataBind();
        }
    }

    /// <summary>
    /// Get list of photos from Photo folder.
    /// </summary>
    /// <returns>List of strings containing file names in images folder.</returns>
    public List<String> GetPhotos()
    {
        List<string> photos = new List<string>();
        string photoPath = MapPath("~/images");
        string[] files = Directory.GetFiles(photoPath, "*.png");
        foreach (string photo in files)
            photos.Add("~/images/" + Path.GetFileName(photo));
        return photos;
    }
}