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
            try
            {
                string file = File.ReadAllText(input);
                Stack<string> tagList = new Stack<string>();
                Stack<string> openTagList = new Stack<string>();
                Stack<string> closingTagList = new Stack<string>();
                Stack<string> nonContainerTagList = new Stack<string>();

                //Create string typed stack tagList
                //Regular expression pattern regex to match content of html tags
                string regex = "(?<=</?)([^ >]+)";

                var tags = Regex.Matches(file, regex);
                string[] nonContainerTags = new string[13] { "br", "hr", "img", "meta", "link", "base", "embed", "param", "area", "col", "input", "frame", "option" };

                //Add each matched tag into tagList
                for (int i = 0; i < tags.Count; i++)
                {
                    tagList.Push(tags[i].ToString().ToLower());
                }

                for (int i = 0; i < tags.Count; i++)
                {
                    string tag = tagList.Pop();

                    //if (tag == "br" || tag == "hr" || tag == "img" || tag == "meta" || tag == "link" || tag == "base" || tag == "embed" || tag == "param" || tag == "" || tag == "" || tag == "" ||)
                    if (nonContainerTags.Contains(tag))
                    {
                        nonContainerTagList.Push(tag);
                    }
                    //closing tags
                    else if (tag.IndexOf("/") == 0)
                    {
                        closingTagList.Push(tag);
                    }
                    //opening tags
                    else
                    {
                        openTagList.Push(tag);
                    }
                }

                foreach (var tag in nonContainerTagList)
                {
                    Console.WriteLine("Found non-container tag: <{0}>", tag);
                }

                foreach (var tag in closingTagList)
                {
                    Console.WriteLine("Found closing tag: <{0}>", tag);
                }

                foreach (var tag in openTagList)
                {
                    Console.WriteLine("Found open tag: <{0}>", tag);
                }

                if (closingTagList.Count == openTagList.Count)
                {
                    Console.WriteLine("Tags are balance.");
                }

                else
                {
                    Console.WriteLine("Tags don't balance.");
                }
            }
            catch (FileNotFoundException)
            {
                Console.WriteLine("Invalid file name, don't forget the file extension.");
            }
        }
    }
}
