//I, Chao Zhang, 000306946 certify that this material is my original work. 
//No other person's work has been used without due acknowledgement.

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Lab05
{
    public partial class Form1 : Form
    {
        private Graphics graphic;                         //Encapsulates a GDI+ drawing surface
        private Pen pen;                              //Pens are used to draw objects
        private SolidBrush brush;                       //Brushes are used to fill graphics shapes
        private Color colour = Color.White;              //Represents a color, initially set to white

        public Form1()
        {
            InitializeComponent();
            this.Paint += new PaintEventHandler(Form1_Paint);  //Registers the Paint event handler
        }

        /* Clicking the Exit button exits the application */
        private void btnExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        /* Clicking the Set Colour button opens the Color Dialog box so the user can select a new colour to draw with */
        private void btnColour_Click(object sender, EventArgs e)
        {
            colorDialog1.Color = colour;                //Display with the previous colour already chosen
            colorDialog1.ShowDialog();             //Display the actual dialog box
            colour = colorDialog1.Color;                //Save the colour choice the user made
        }

        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            graphic = e.Graphics;                          //Get the Graphics object from the PaintEventArgs
            pen = new Pen(colour);                          //Create a new Pen using the current colour

            //Initial container

            graphic.DrawLine(pen, 75, 300, 75, 450);
            graphic.DrawLine(pen, 275, 300, 275, 450);
            graphic.DrawLine(pen, 75, 450, 275, 450);
        }

        int i = 450; // Iterate the fill level of the container
        bool full = false;

        private void trackBar1_Scroll(object sender, EventArgs e)
        {
            graphic = this.CreateGraphics();  
            brush = new SolidBrush(colour);
            if (full)
            {
                graphic.Clear(Color.Black);
                graphic.DrawLine(pen, 75, 300, 75, 450);
                graphic.DrawLine(pen, 275, 300, 275, 450);
                graphic.DrawLine(pen, 75, 450, 275, 450);
            }
            timer1.Interval = (11 - trackBar1.Value) * 10;
            timer1.Start();
            graphic.FillRectangle(brush, 135, 210, 18, 240);
            full = false;
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            graphic = this.CreateGraphics();        
            if (i == 320)
            {
                timer1.Stop();
                i = 450;
                brush = new SolidBrush(Color.Black);
                graphic.FillRectangle(brush, 135, 210, 18, 111);
                full = true;
            }           
            graphic.DrawLine(pen, 75, i, 275, i);
            i--;
        }
    }
}
