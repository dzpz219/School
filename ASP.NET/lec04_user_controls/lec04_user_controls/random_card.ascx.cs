using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.IO; // Added for Directory and Path classes

public partial class random_card : System.Web.UI.UserControl
{
    /// <summary>
    /// Update the image and label with a random image.
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        String imageToDisplay = GetRandomImage();
        imgRandom.ImageUrl = "~/images/" + imageToDisplay;
        lblRandom.Text = imageToDisplay;
    }

    /// <summary>
    /// Determine the number of images and randomly return the file name of one of them.
    /// </summary>
    /// <returns>The name of a file randomly chosen from the images folder.</returns>
    private String GetRandomImage()
    {
        Random rnd = new Random();
        String[] images = Directory.GetFiles(MapPath("~/images"), "*.png");
        String imageToDisplay = images[rnd.Next(images.Length)];
        return Path.GetFileName(imageToDisplay);
    }
}