/*
 * Chao Zhang 000306946
 * Friday March 4th 2016
 * Purpose:
 * This program reads the data in the text
 * file Data.txt and manipulates the data
 * based on user input from a select menu
 * 
 * StAuth10068: I Chao Zhang, 000306946 certify that this material is my original work. 
 * No other person's work has been used without due acknowledgement. 
 * I have not made my work available to anyone else.
 */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Lab3
{
    class Program
    {
        static void Main(string[] args)
        {
            bool exit = false;
            Media[] MediaArray = ReadData("Data.txt");   
            string message = "Enter Your Choice: ";
            int count;
            
            while (!exit)
            {
                Console.WriteLine("1. List All Books\n2. List All Movies\n3. List All Songs\n4. List All Media\n5. Search All Media by Title\n6. Exit Program\n");
                string input;
                string searchInput;
                Book book;
                Movie movie;
                Song song;
                Console.WriteLine(message);
                input = Console.ReadLine();

                switch (input)
                {
                    case "6":
                        exit = true;
                        
                        break;
                    case "1":
                        for (count = 0; count < MediaArray.Length; count++)
                        {
                            if (MediaArray[count] is Book)
                            {
                                book = (Book)MediaArray[count];
                                Console.WriteLine("Book Title: {0} <{1}> \nAuthor: {2}\n-------------------------", book.Title, book.Year, book.Author);
                            }
                        }
                        break;
                    case "2":
                        for (count = 0; count < MediaArray.Length; count++)
                        {
                            if (MediaArray[count] is Movie)
                            {
                                movie = (Movie)MediaArray[count];
                                Console.WriteLine("Movie Title: {0} <{1}> \nDirector: {2}\n-------------------------", movie.Title, movie.Year, movie.Director);
                            }
                        }
                        break;
                    case "3":
                        for (count = 0; count < MediaArray.Length; count++)
                        {
                            if (MediaArray[count] is Song)
                            {
                                song = (Song)MediaArray[count];
                                Console.WriteLine("Song Title: {0} <{1}> \nAlbum: {2}  Artist: {3}\n-------------------------", song.Title, song.Year, song.Album, song.Artist);
                            }
                        }
                        break;
                    case "4":
                        for (count = 0; count < MediaArray.Length; count++)
                        {
                            if (MediaArray[count] is Book)
                            {
                                book = (Book)MediaArray[count];
                                Console.WriteLine("Book Title: {0} <{1}> \nAuthor: {2}\n-------------------------", book.Title, book.Year, book.Author);
                            }
                            else if (MediaArray[count] is Movie)
                            {
                                movie = (Movie)MediaArray[count];
                                Console.WriteLine("Movie Title: {0} <{1}> \nDirector: {2}\n-------------------------", movie.Title, movie.Year, movie.Director);
                            }
                            else if (MediaArray[count] is Song)
                            {
                                song = (Song)MediaArray[count];
                                Console.WriteLine("Song Title: {0} <{1}> \nAlbum: {2}  Artist: {3}\n-------------------------", song.Title, song.Year, song.Album, song.Artist);
                            }
                        }
                        break;
                    case "5":
                        Console.WriteLine("Enter a search string: ");
                        searchInput = Console.ReadLine();
                        for (count = 0; count < MediaArray.Length; count++)
                        {
                            if (MediaArray[count] is Book && MediaArray[count].Search(searchInput))
                            {
                                book = (Book)MediaArray[count];
                                Console.WriteLine("Book Title: {0} <{1}> \nAuthor: {2}\n\n {3}\n-------------------------", book.Title, book.Year, book.Author, book.Decrypt());
                            }
                            else if (MediaArray[count] is Movie && MediaArray[count].Search(searchInput))
                            {
                                movie = (Movie)MediaArray[count];
                                Console.WriteLine("Movie Title: {0} <{1}> \nDirector: {2}\n\n {3}\n-------------------------", movie.Title, movie.Year, movie.Director, movie.Decrypt());
                            }
                            else if (MediaArray[count] is Song && MediaArray[count].Search(searchInput))
                            {
                                song = (Song)MediaArray[count];
                                Console.WriteLine("Song Title: {0} <{1}> \nAlbum: {2}  Artist: {3}\n-------------------------", song.Title, song.Year, song.Album, song.Artist);
                            }
                        }
                        break;
                    default:
                        Console.WriteLine("Invalid Choice, Please Try Again");
                        break;
                }
                Console.WriteLine("Press any key to continue...");
                Console.ReadLine();
                Console.Clear();
            }
        }

        static Media[] ReadData(string FileName)
        {
            Media[] MediaArray = new Media[100];
            string[] TxtArray;
            string[] MediaInfo;
            int count;

            try
            {
                using (StreamReader sr = new StreamReader(FileName))
                {
                    String AllText = sr.ReadToEnd();
                    TxtArray = AllText.Replace("-----", "@").Split('@');

                    for (count = 0; count < TxtArray.Length - 1; count++)
                    {
                        MediaInfo = TxtArray[count].Split('|');
                        switch (MediaInfo[0].Trim())
                        {
                            case "BOOK":
                                Book book = new Book(MediaInfo[1], Int32.Parse(MediaInfo[2]), MediaInfo[3].Split('\n')[0].Trim(), MediaInfo[3].Split('\n')[1].Trim());
                                MediaArray[count] = book;
                                break;

                            case "SONG":
                                Song song = new Song(MediaInfo[1], Int32.Parse(MediaInfo[2]), MediaInfo[3], MediaInfo[4].Trim());
                                MediaArray[count] = song;
                                break;

                            case "MOVIE":
                                Movie movie = new Movie(MediaInfo[1], Int32.Parse(MediaInfo[2]), MediaInfo[3].Split('\n')[0].Trim(), MediaInfo[3].Split('\n')[1].Trim());
                                MediaArray[count] = movie;
                                break;

                        }
                    }
                }
            }
            catch (Exception e)
            {
                Console.WriteLine("The file could not be read:");
                Console.WriteLine(e.Message);
            }
            return MediaArray;
        }
    }
}
