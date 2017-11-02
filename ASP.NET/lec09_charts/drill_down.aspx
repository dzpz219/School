<%@ Page Language="C#" AutoEventWireup="true" CodeFile="drill_down.aspx.cs" Inherits="drill_down" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Sales by Category Drill Down with Preview</title>
    <link href="StyleSheet.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <h1>Sales by Category Drill Down with Preview</h1>
        <asp:Chart ID="chtCategories" runat="server">
            <Series>
                <asp:Series Name="Series1"></asp:Series>
            </Series>
            <ChartAreas>
                <asp:ChartArea Name="ChartArea1"></asp:ChartArea>
            </ChartAreas>
        </asp:Chart>
        <p><asp:Label ID="lblError" runat="server"></asp:Label></p>
        <p><a href="Default.aspx">Default.aspx</a></p>
    </div>

	<style type="text/css">.fadingTooltip { BORDER-RIGHT: darkgray 1px outset; BORDER-TOP: darkgray 1px outset; FONT-SIZE: 12pt; BORDER-LEFT: darkgray 1px outset; WIDTH: auto; COLOR: black; BORDER-BOTTOM: darkgray 1px outset; HEIGHT: auto; BACKGROUND-COLOR: lemonchiffon; MARGIN: 3px 3px 3px 3px; padding: 3px 3px 3px 3px; borderBottomWidth: 3px 3px 3px 3px }
	</style>
	<div class="fadingTooltip" id="fadingTooltip" style="Z-INDEX: 999; VISIBILITY: hidden; POSITION: absolute"></div>
	<script type="text/javascript">
		var fadingTooltip;
		var wnd_height, wnd_width;
		var tooltip_height, tooltip_width;
		var tooltip_shown = false;
		var transparency = 100;
		var timer_id = 1;
		var tooltiptext;

		// override events
		window.onload = WindowLoading;
		window.onresize = UpdateWindowSize;
		document.onmousemove = AdjustToolTipPosition;

		function DisplayTooltip(tooltip_text) {
			fadingTooltip.innerHTML = tooltip_text;
			tooltip_shown = (tooltip_text != "") ? true : false;
			if (tooltip_text != "") {
			    // Get tooltip window height
			    tooltip_height = (fadingTooltip.style.pixelHeight) ? fadingTooltip.style.pixelHeight : fadingTooltip.offsetHeight;
			    transparency = 0;
			    ToolTipFading();
			}
			else {
			    clearTimeout(timer_id);
			    fadingTooltip.style.visibility = "hidden";
			}
		}

		function AdjustToolTipPosition(e) {
			if (tooltip_shown) {
			    // Depending on IE/Firefox, find out what object to use to find mouse position
			    var ev;
			    if (e)
			        ev = e;
			    else
			        ev = event;

			    fadingTooltip.style.visibility = "visible";
			    offset_y = (ev.clientY + tooltip_height - document.body.scrollTop + 30 >= wnd_height) ? -15 - tooltip_height : 20;
			    fadingTooltip.style.left = Math.min(wnd_width - tooltip_width - 10, Math.max(3, ev.clientX + 6)) + document.body.scrollLeft + 'px';
			    fadingTooltip.style.top = ev.clientY + offset_y + document.body.scrollTop + 'px';
			}
		}

		function WindowLoading() {
			fadingTooltip = document.getElementById('fadingTooltip');

			// Get tooltip  window width				
			tooltip_width = (fadingTooltip.style.pixelWidth) ? fadingTooltip.style.pixelWidth : fadingTooltip.offsetWidth;

			// Get tooltip window height
			tooltip_height = (fadingTooltip.style.pixelHeight) ? fadingTooltip.style.pixelHeight : fadingTooltip.offsetHeight;

			UpdateWindowSize();
		}

		function ToolTipFading() {
			if (transparency <= 100) {
			    fadingTooltip.style.filter = "alpha(opacity=" + transparency + ")";
			    fadingTooltip.style.opacity = transparency / 100;
			    transparency += 5;
			    timer_id = setTimeout('ToolTipFading()', 35);
			}
		}

		function UpdateWindowSize() {
			wnd_height = document.body.clientHeight;
			wnd_width = document.body.clientWidth;
		}
	</script>
    </form>
</body>
</html>