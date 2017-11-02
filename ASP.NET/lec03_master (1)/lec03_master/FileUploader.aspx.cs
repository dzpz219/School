using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.IO; // Added for Path class

public partial class FileUploader : System.Web.UI.Page
{
    /// <summary>
    /// Reset error label.
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        lblError.Text = "";
    }

    /// <summary>
    /// Save image file to file system if it is of correct type.
    /// </summary>
    /// <param name="sender">btnAdd</param>
    /// <param name="e">Event data</param>
    protected void btnAdd_Click(object sender, EventArgs e)
    {
        if (upImage.HasFile)
        {
            if (CheckFileType(upImage.FileName))
            {
                String filePath = "~/UploadImages/" + upImage.FileName;
                upImage.SaveAs(MapPath(filePath));
            }
            else
            {
                lblError.Text = "File type must be gif, png, jpg or jpeg.";
            }
        }
    }

    /// <summary>
    /// Determines if the fileName is of type gif, png, jpg or jpeg.
    /// </summary>
    /// <param name="fileName">A System.String that represents the name of the
    /// file that is potentially about to be uploaded.</param>
    /// <returns>True if the file is of the expected type.</returns>
    bool CheckFileType(string fileName)
    {
        string ext = Path.GetExtension(fileName);
        switch (ext.ToLower())
        {
            case ".gif":
                return true;
            case ".png":
                return true;
            case ".jpg":
                return true;
            case ".jpeg":
                return true;
            default:
                return false;
        }
    }

    /// <summary>
    /// Update datalist with images.
    /// </summary>
    void Page_PreRender()
    {
        string upFolder = MapPath("~/UploadImages/");
        DirectoryInfo dir = new DirectoryInfo(upFolder);
        dlstImages.DataSource = dir.GetFiles();
        dlstImages.DataBind();
    }
}