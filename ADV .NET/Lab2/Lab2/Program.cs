using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Lab2
{
    class Program
    {
        static void Main(string[] args)
        {
            Shape[] ShapeArray = new Shape[100];
            bool flag = false;
            bool flag2 = false;
            int count = 0;
            while (!flag)
            {
                string input;
                string line1 = String.Format("{0,-17} {1,-15} {2,-15}", "1 - Rectangle", "5 - Ellipse", "9 - Triangle");
                string line2 = String.Format("{0,-17} {1,-15} {2,-15}", "2 - Square", "6 - Circle", "10 - Tetrahedron");
                string line3 = String.Format("{0,-17} {1,-15} {2,-15}", "3 - Box", "7 - Cylinder", "0 - Exit");
                string line4 = String.Format("{0,-17} {1,-15}", "4 - Cube", "8 - Sphere");
                Console.WriteLine(line1 + "\n" + line2 + "\n" + line3 + "\n" + line4 + "\n");
                Console.WriteLine("Enter your choice: {0, 30}", "<"+ count + " shapes entered so far>");
                input = Console.ReadLine();
                while (!flag2) {
                    if (!Regex.IsMatch(input, @"^([0-9]|10)$")) {
                        Console.WriteLine("Invalid Entry, Please try again");
                        input = Console.ReadLine();
                    }
                    else { flag2 = true; }
                }
                    switch (input)
                    {
                        case "0":
                            flag = true;
                            break;
                        case "1":
                            Rectangle rectangle = new Rectangle();
                            rectangle.SetData();
                            ShapeArray[count] = rectangle;
                            break;
                        case "2":
                            Square square = new Square();
                            square.SetData();
                            ShapeArray[count] = square;
                            break;
                        case "3":
                            Box box = new Box();
                            box.SetData();
                            ShapeArray[count] = box;
                            break;
                        case "4":
                            Cube cube = new Cube();
                            cube.SetData();
                            ShapeArray[count] = cube;
                            break;
                        case "5":
                            Ellipse ellipse = new Ellipse();
                            ellipse.SetData();
                            ShapeArray[count] = ellipse;
                            break;
                        case "6":
                            Circle circle = new Circle();
                            circle.SetData();
                            ShapeArray[count] = circle;
                            break;
                        case "7":
                            Cylinder cylinder = new Cylinder();
                            cylinder.SetData();
                            ShapeArray[count] = cylinder;
                            break;
                        case "8":
                            Sphere sphere = new Sphere();
                            sphere.SetData();
                            ShapeArray[count] = sphere;
                            break;
                        case "9":
                            Triangle triangle = new Triangle();
                            triangle.SetData();
                            ShapeArray[count] = triangle;
                            break;
                        case "10":
                            Tetrahedron tetrahedron = new Tetrahedron();
                            tetrahedron.SetData();
                            ShapeArray[count] = tetrahedron;
                            break;
                    }
                count++;
                flag2 = false;
                Console.Clear();
            }
            for (int i = 0; i < count - 1; i++)
            {
                Console.WriteLine(ShapeArray[i].ToString());
            }
        }
    }
    /*
      Class:  Shape.cs
      Author: Nicholas J. Corkigian
      Date:   February 4, 2010

      Purpose: This abstract class is the base class of an object hierarchy
               that describes many other two-dimensional and three-dimensional
               shapes.

               As it is an abstract class, there can be no instances of it.

               This code is not to be altered.
    */
    public abstract class Shape
    {
        public string Type { get; protected set; }         //The type of shape
        private static int count = 0;                      //Number of instantiated shapes
        protected const double PI = 3.141592653589793;     //Constant value for pi

        //All this constructor does is increment the number of Shape instances
        public Shape()
        {
            count++;
        }

        public abstract double CalculateArea();            //Calculate the Shape's area (surface area if 3-d)
        public abstract double CalculateVolume();          //Calculate the Shape's volume (if 3-d)
        public abstract void SetData();                    //Prompts the user for dimensions
        public override string ToString() { return ""; }   //Used for printing Shape data

        //Retrieves the current number of Shape instances
        public static int GetCount()
        {
            return count;
        }
    }

    public class Square : Shape
    {
        public double width;
        public string output;

        /// <summary>
        /// Prompts user to enter width for shape
        /// Convert width to type double
        /// </summary>
        public override void SetData()
        {
            Console.WriteLine("Enter Width");
            Double.TryParse(Console.ReadLine(), out width);
        }

        /// <summary>
        /// calculate area of shape
        /// </summary>
        /// <returns>area</returns>
        public override double CalculateArea()
        {
            return width * width;
        }

        /// <summary>
        /// volume not used for shape
        /// </summary>
        /// <returns></returns>
        public override double CalculateVolume()
        {
            throw new NotImplementedException();
        }

        /// <summary>
        /// return shape data in string form
        /// </summary>
        /// <returns>output</returns>
        public override string ToString()
        {
            return output = String.Format("Shape: {2, -10} || Width: {0, -2} || Area: {1, -2}", width, CalculateArea().ToString(), "Square");
        }
    }

    public class Rectangle : Square
    {
        public double length;

        /// <summary>
        /// Prompts user to enter length for shape
        /// Convert length to type double
        /// </summary>
        public override void SetData()
        {
            base.SetData();
            Console.WriteLine("Enter Length");
            Double.TryParse(Console.ReadLine(), out length);
        }

        /// <summary>
        /// calculate area of shape
        /// </summary>
        /// <returns>area</returns>
        public override double CalculateArea()
        {
            return length * width;
        }

        /// <summary>
        /// volume not used for shape
        /// </summary>
        /// <returns></returns>
        public override double CalculateVolume()
        {
            throw new NotImplementedException();
        }

        /// <summary>
        /// return shape data in string form
        /// </summary>
        /// <returns>output</returns>
        public override string ToString()
        {
            return output = String.Format("Shape: {3, -10} || Width: {0, -2} || Length: {1, -2} || Area: {2, -2}", width, length, CalculateArea().ToString(), "Rectangle");
        }
    }

    public class Cube : Square
    {
        /// <summary>
        /// Prompts user to enter width for shape
        /// Convert width to type double
        /// using base method SetData()
        /// </summary>
        public override void SetData()
        {
            base.SetData();
        }

        /// <summary>
        /// calculate area of shape
        /// </summary>
        /// <returns>surface area</returns>
        public override double CalculateArea()
        {
            return width * width * 6;
        }

        /// <summary>
        /// calculate volume of shape
        /// </summary>
        /// <returns>volume</returns>
        public override double CalculateVolume()
        {
            return width * width * width;
        }

        /// <summary>
        /// return shape data in string form
        /// </summary>
        /// <returns>output</returns>
        public override string ToString()
        {
            return output = String.Format("Shape: {3, -10} || Width: {0, -2} || Area: {1, -2} || Volume: {2, -2}", width, CalculateArea().ToString(), CalculateVolume().ToString(), "Cube");
        }
    }

    public class Box : Rectangle
    {
        public double height;
        /// <summary>
        /// Prompts user to enter height for shape
        /// Convert height to type double
        /// using base method SetData()
        /// </summary>
        public override void SetData()
        {
            base.SetData();
            Console.WriteLine("Enter Height");
            Double.TryParse(Console.ReadLine(), out height);
        }

        /// <summary>
        /// calculate area of shape
        /// </summary>
        /// <returns>surface area</returns>
        public override double CalculateArea()
        {
            return length * width * 4 + width * height * 2;
        }

        /// <summary>
        /// calculate volume of shape
        /// </summary>
        /// <returns>volume</returns>
        public override double CalculateVolume()
        {
            return length * width * height;
        }

        /// <summary>
        /// return shape data in string form
        /// </summary>
        /// <returns>output</returns>
        public override string ToString()
        {
            return output = String.Format("Shape: {5, -10} || Width: {0, -2} || Length: {1, -2} || Height: {2, -2} || Area: {3, -2} || Volume: {4, -2}", width, length, height, CalculateArea().ToString(), CalculateVolume().ToString(), "Box");
        }
    }

    public class Triangle : Shape
    {
        public double edge;
        public double length;
        public string output;

        /// <summary>
        /// Prompts user to enter edge and length for shape
        /// Convert edge and length to type double
        /// </summary>
        public override void SetData()
        {
            Console.WriteLine("Enter Edge");
            Double.TryParse(Console.ReadLine(), out edge);
            Console.WriteLine("Enter Length");
            Double.TryParse(Console.ReadLine(), out length);
        }

        /// <summary>
        /// calculate area of shape
        /// </summary>
        /// <returns>area</returns>
        public override double CalculateArea()
        {
            return edge * length * 0.5;
        }

        /// <summary>
        /// volume not used for shape
        /// </summary>
        /// <returns></returns>
        public override double CalculateVolume()
        {
            throw new NotImplementedException();
        }

        /// <summary>
        /// return shape data in string form
        /// </summary>
        /// <returns>output</returns>
        public override string ToString()
        {
            return output = String.Format("Shape: {3, -10} || Edge: {0, -2} || Length: {1, -2} || Area: {2, -2}", edge, length, CalculateArea().ToString(), "Triangle");
        }
    }

    public class Tetrahedron : Triangle
    {
        public double height;

        /// <summary>
        /// Prompts user to enter edge, length and height for shape
        /// Convert edge, length and height to type double
        /// using base method SetData()
        /// </summary>
        public override void SetData()
        {
            base.SetData();
            Console.WriteLine("Enter Height");
            Double.TryParse(Console.ReadLine(), out height);
        }

        /// <summary>
        /// calculate surface area of shape
        /// </summary>
        /// <returns>surface area</returns>
        public override double CalculateArea()
        {
            return edge * length * 2.5;
        }

        /// <summary>
        /// calculate volume of shape
        /// </summary>
        /// <returns>volume</returns>
        public override double CalculateVolume()
        {
            return (edge * length * height) / 6;
        }

        /// <summary>
        /// return shape data in string form
        /// </summary>
        /// <returns>output</returns>
        public override string ToString()
        {
            return output = String.Format("Shape: {5, -10} || Edge: {0, -2} || Length: {1, -2} || Height: {2, -2} || Area: {3, -2} || Volume: {4, -2}", edge, length, height, CalculateArea().ToString(), CalculateVolume().ToString(), "Tetrahedron");
        }
    }

    public class Circle : Shape
    {
        public double radius;
        public string output;

        /// <summary>
        /// Prompts user to enter radius for shape
        /// Convert radius to type double
        /// </summary>
        public override void SetData()
        {
            Console.WriteLine("Enter radius");
            Double.TryParse(Console.ReadLine(), out radius);
        }

        /// <summary>
        /// calculate area of shape
        /// </summary>
        /// <returns>area</returns>
        public override double CalculateArea()
        {
            return radius * radius * PI;
        }

        /// <summary>
        /// volume not used for shape
        /// </summary>
        /// <returns></returns>
        public override double CalculateVolume()
        {
            throw new NotImplementedException();
        }

        /// <summary>
        /// return shape data in string form
        /// </summary>
        /// <returns>output</returns>
        public override string ToString()
        {
            return output = String.Format("Shape: {2, -10} || Radius: {0, -2} || Area: {1, -2}", radius, CalculateArea().ToString(), "Circle");
        }
    }

    public class Ellipse : Circle
    {
        public double minor;

        /// <summary>
        /// Prompts user to enter semi-major and semi-minor for shape
        /// Convert semi-major and semi-minor to type double
        /// </summary>
        public override void SetData()
        {
            Console.WriteLine("Enter Semi-Major Axis");
            Double.TryParse(Console.ReadLine(), out radius);
            Console.WriteLine("Enter Semi-Minor Axis");
            Double.TryParse(Console.ReadLine(), out minor);
        }

        /// <summary>
        /// calculate area of shape
        /// </summary>
        /// <returns>area</returns>
        public override double CalculateArea()
        {
            return radius * minor * PI;
        }

        /// <summary>
        /// volume not used for shape
        /// </summary>
        /// <returns></returns>
        public override double CalculateVolume()
        {
            throw new NotImplementedException();
        }

        /// <summary>
        /// return shape data in string form
        /// </summary>
        /// <returns>output</returns>
        public override string ToString()
        {
            return output = String.Format("Shape: {3, -10} || Semi-Major Axis: {0, -2} || Semi-Minor Axis: {1, -2} || Area: {2, -2}", radius, minor, CalculateArea().ToString(), "Ellipse");
        }
    }

    public class Sphere : Circle
    {
        /// <summary>
        /// Prompts user to enter radius for shape
        /// Convert radius to type double
        /// using base method SetData()
        /// </summary>
        public override void SetData()
        {
            base.SetData();
        }

        /// <summary>
        /// calculate area of shape
        /// </summary>
        /// <returns>area</returns>
        public override double CalculateArea()
        {
            return radius * radius * PI * 4;
        }

        /// <summary>
        /// calculate volume of shape
        /// </summary>
        /// <returns>volume</returns>
        public override double CalculateVolume()
        {
            return ((radius * radius * radius) * PI * 4) / 3;
        }

        /// <summary>
        /// return shape data in string form
        /// </summary>
        /// <returns>output</returns>
        public override string ToString()
        {
            return output = String.Format("Shape: {3, -10} || Radius: {0, -2} || Area: {1, -2} || Volume: {2, -2}", radius, CalculateArea().ToString(), CalculateVolume().ToString(), "Sphere");
        }
    }

    public class Cylinder : Circle
    {
        public double height;

        /// <summary>
        /// Prompts user to enter radius and height for shape
        /// Convert radius and height to type double
        /// using base method SetData()
        /// </summary>
        public override void SetData()
        {
            base.SetData();
            Console.WriteLine("Enter Height");
            Double.TryParse(Console.ReadLine(), out height);
        }

        /// <summary>
        /// calculate area of shape
        /// </summary>
        /// <returns>area</returns>
        public override double CalculateArea()
        {
            return (radius * radius * PI * 2) + (radius + radius * PI * height);
        }

        /// <summary>
        /// calculate volume of shape
        /// </summary>
        /// <returns>volume</returns>
        public override double CalculateVolume()
        {
            return radius * radius * PI * height;
        }

        /// <summary>
        /// return shape data in string form
        /// </summary>
        /// <returns>output</returns>
        public override string ToString()
        {
            return output = String.Format("Shape: {3, -10} || Radius: {0, -2} || Area: {1, -2} || Volume: {2, -2}", radius, CalculateArea().ToString(), CalculateVolume().ToString(), "Cylinder");
        }
    }
}
