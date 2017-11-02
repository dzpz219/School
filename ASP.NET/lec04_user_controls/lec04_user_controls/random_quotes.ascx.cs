using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class random_quotes : System.Web.UI.UserControl
{
    /// <summary>
    /// Update lblQuote with a new Yoda quote when called.
    /// </summary>
    /// <param name="sender">Page</param>
    /// <param name="e">Event data</param>
    protected void Page_Load(object sender, EventArgs e)
    {
        List<string> quotes = new List<string>();
        quotes.Add("Fear is the path to the dark side. Fear leads to anger. Anger leads to hate. Hate leads to suffering.");
        quotes.Add("Do or do not... there is no try.");
        quotes.Add("Size matters not. Look at me. Judge me by my size, do you? Hmm? Hmm. And well you should not. For my ally is the Force, and a powerful ally it is.");
        quotes.Add("Remember, a Jedi's strength flows from the Force. But beware. Anger, fear, aggression. The dark side are they.");
        quotes.Add("Soon will I rest, yes, forever sleep. Earned it I have. Twilight is upon me, soon night must fall.");
        quotes.Add("When 900 years old you reach, look as good you will not, hmm?");
        quotes.Add("Adventure. Heh. Excitement. Heh. A Jedi craves not these things.");
        quotes.Add("Ready are you? What know you of ready? For 800 years have I trained Jedi. My own counsel will I keep on who is to be trained.");
        quotes.Add("May the force be with you.");
        Random rnd = new Random();
        lblQuote.Text = quotes[rnd.Next(quotes.Count)];
    }
}