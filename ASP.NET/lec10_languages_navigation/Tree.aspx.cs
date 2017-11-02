using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Tree : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    /// <summary>
    /// Loop through all selected nodes and add them to the bulleted list.
    /// </summary>
    /// <param name="sender">btnOrder</param>
    /// <param name="e">Event data</param>
    protected void btnOrder_Click(object sender, EventArgs e)
    {
        bltMeals.Items.Clear();

        foreach (TreeNode node in treMeals.CheckedNodes)
        {
            if (node.Parent == null)
                bltMeals.Items.Add(node.Text + " which is the root node");
            else if (node.Parent.Parent == null)
                bltMeals.Items.Add(node.Text + " from " + node.Parent.Text);
            else
                bltMeals.Items.Add(node.Text + " from " + node.Parent.Text + " which is itself a child of " + node.Parent.Parent.Text);
        }
    }
}