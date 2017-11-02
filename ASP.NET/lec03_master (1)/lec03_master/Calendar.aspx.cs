using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Calendar : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    /// <summary>
    /// When the selected date(s) change, refresh the bulleted list.
    /// </summary>
    /// <param name="sender">Calendar1</param>
    /// <param name="e">Event data</param>
    protected void Calendar1_SelectionChanged(object sender, EventArgs e)
    {
        RefreshBulletedList();
    }

    /// <summary>
    /// When the drop down list changes, change the selection mode of the
    /// calendar, unselect any dates and refresh the bulleted list.
    /// </summary>
    /// <param name="sender">ddlSelectionMode</param>
    /// <param name="e">Event data</param>
    protected void ddlSelectionMode_SelectedIndexChanged(object sender, EventArgs e)
    {
        switch (ddlSelectionMode.SelectedValue)
        {
            case "d":
                Calendar1.SelectionMode = CalendarSelectionMode.Day;
                break;
            case "dw":
                Calendar1.SelectionMode = CalendarSelectionMode.DayWeek;
                break;
            case "dwm":
                Calendar1.SelectionMode = CalendarSelectionMode.DayWeekMonth;
                break;
            case "n":
                Calendar1.SelectionMode = CalendarSelectionMode.None;
                break;
        }
        // Clear the selected date(s)
        Calendar1.SelectedDate = new DateTime();
        RefreshBulletedList();
    }

    /// <summary>
    /// Refresh the bulleted list by binding to the selected dates property of the calendar.
    /// </summary>
    private void RefreshBulletedList()
    {
        bltResults.DataSource = Calendar1.SelectedDates;
        bltResults.DataBind();
    }
}