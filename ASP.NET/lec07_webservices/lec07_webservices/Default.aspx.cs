using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using com.wikia.lyrics; // Web service name import

public partial class _Default : System.Web.UI.Page
{
    /// <summary>
    /// Give focus to artist text box on 1st load
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            txtArtist.Focus();
        }
    }

    /// <summary>
    /// Search for artist at Lyrics Wiki Web Service
    /// </summary>
    /// <param name="sender">btnArtist</param>
    /// <param name="e">Event data</param>
    protected void btnArtistSearch_Click(object sender, EventArgs e)
    {
        LyricWiki wiki = new LyricWiki();
        string[] artists = wiki.searchArtists(txtArtist.Text); // This line of code will execute on http://lyrics.wikia.com/server.php in San Francisco
        lblArtistInfo.Text = "";

        // If artists are returned, populate list box
        if (artists.Length > 0)
        {
            lstArtists.DataSource = artists;
            lstArtists.DataBind();

            // Ensure all artists are shown, a maximum of 10 will be returned
            if (artists.Length > 4)
            {
                lstArtists.Rows = artists.Length;
            }
            else
            {
                lstArtists.Rows = 4;
            }
        }
    }

    /// <summary>
    /// Once an artist is selected, get home town data
    /// </summary>
    /// <param name="sender">lstArtists</param>
    /// <param name="e">Event data</param>
    protected void lstArtists_SelectedIndexChanged(object sender, EventArgs e)
    {
        string state;
        string hometown;
        LyricWiki wiki = new LyricWiki();
        string country = wiki.getHometown(lstArtists.SelectedValue, out state, out hometown);  // This line of code will execute on http://lyrics.wikia.com/server.php in San Francisco
        lblArtistInfo.Text = hometown + "<br>" + state + "<br>" + country;
        ltlOutput.Text = "";
        txtSong.Focus();
    }

    /// <summary>
    /// Get lyrics of song
    /// </summary>
    /// <param name="sender">btnGetLyrics</param>
    /// <param name="e">Event data</param>
    protected void btnGetLyrics_Click(object sender, EventArgs e)
    {
        if (lstArtists.SelectedValue != "")
        {
            LyricWiki wiki = new LyricWiki();
            LyricsResult lyrics = wiki.getSong(lstArtists.SelectedValue, txtSong.Text);  // This line of code will execute on http://lyrics.wikia.com/server.php in San Francisco
            ltlOutput.Text = "<pre>" + lyrics.lyrics + "</pre>";
        }
        else
        {
            ltlOutput.Text = "<b>Must select artist.</b>";
        }
    }
}