//I, Chao Zhang, 000306946 certify that this material is my original work. 
//No other person's work has been used without due acknowledgement.

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Text.RegularExpressions;

namespace Lab4B
{
    class Program
    {
        static void Main(string[] args)
        {
            //Prompt user to enter a html file name
            Console.WriteLine("Please enter the name of the HTML file: ");
            string input = Console.ReadLine();

            //Read all text into a string from user input file
            string file = File.ReadAllText(input);

            //Create string typed stack tagList
            //Regular expression pattern regex to match content of html tags
            Stack<string> tagList = new Stack<string>();
            string regex = "(?<=</?)([^ >]+)";
            var tags = Regex.Matches(file, regex);
       
            //Add each matched tag into tagList
            for (int i = 0; i < tags.Count; i++)
                 {
                     tagList.Push(tags[i].ToString().ToLower());
                 }

            //For each tag in tagList, determine proper output
            foreach (string tag in tagList.Reverse()){

                //non-container tags
                if (tag == "br" || tag == "hr" || tag == "img")
                {
                    Console.WriteLine("Found non-container tag: <{0}>", tag);
                }
                
                //check if there is a corresponding closing tag
                else if (tagList.Contains("/" + tag))
                {
                    Console.WriteLine("Found open tag: <{0}>", tag);
                }

                //closing tags
                else if (tag.IndexOf("/") == 0)
                {
                    Console.WriteLine("Found closing tag: <{0}>", tag);
                }

                else
                {
                    Console.WriteLine("Tags don't balance.");
                    break;
                }
            }
        }
    }
}
