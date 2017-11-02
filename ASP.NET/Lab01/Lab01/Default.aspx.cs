// I, Chao Zhang, student number 00306946, certify that this material is my
// original work. No other person's work has been used without due
// acknowledgement and I have not made my work available to anyone else.

using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : System.Web.UI.Page
{
    private int randomNumber() {
        Random rndNum = new Random();
        return rndNum.Next(2, 24);
    }

    protected void Page_Load(object sender, EventArgs e)
    {
        if (!Page.IsPostBack)
        {
            int number = randomNumber();
            Session["rndNum"] = number;
            int counter = 1;
            Session["numCounter"] = counter;
        }
        lblCorrect.Text = Session["rndNum"].ToString();
        lblCount.Text = Session["numCounter"].ToString();
    }

    //The event that triggers when btnGuess is clicked -NU
    protected void btnGuess_Click(object sender, EventArgs e)
    {
        int count = (int)Session["numCounter"];
        int correctNum = (int)Session["rndNum"];
        int output;
        string inputVal = inputNum.Value;

        if (Int32.TryParse(inputVal, out output) && (1 < output && output < 10))
        {
            count = count + 1;
            if (output == correctNum)
            {
                lblTest.Text = "CORRECT! The integer is " + correctNum + " it took you " + count.ToString() + " tries";
            }
            else {
                lblTest.Text = (output < correctNum) ? "The correct integer is higher than " + output.ToString() : lblTest.Text = "The correct integer is lower than " + output.ToString();
            }
        }
        else {
            lblTest.Text = "Please enter integer between 1 to 25";
        }
        
    }
    protected void btnGiveup_Click(object sender, EventArgs e)
    {
        btnNew.Visible = true;
        btnGuess.Enabled = false;
        btnGiveup.Enabled = false;
        inputNum.Disabled = true;
    }
    protected void btnNew_Click(object sender, EventArgs e)
    {
        int numberNew = randomNumber();
        Session["rndNum"] = numberNew;
        btnNew.Visible = false;
        btnGuess.Enabled = true;
        btnGiveup.Enabled = true;
        inputNum.Disabled = false;
    }
}