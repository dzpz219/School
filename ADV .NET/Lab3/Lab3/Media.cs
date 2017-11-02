﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab3
{
/*
    Class:  Media.cs
    Author: Nicholas J. Corkigian
    Date:   February 18, 2010

    Purpose: This abstract class represents a single object of a media type,
            be it something like a book, movie, or song.

            Other classes must be derived from this class.
 
            Because it implements the ISearchable interface, all derived
            classes will also need to implement the methods of that
            interface as well.

            This code is not to be altered.
*/

    public abstract class Media : ISearchable
    {
        public string Title { get; protected set; }          // Title of the media object
        public int Year { get; protected set; }              // The year this media object was released

        /* Two-argument constructor sets the two properties that all Media objects have */
        public Media(string title, int year)
        {
            Title = title;
            Year = year;
        }

        #region ISearchable

        /*
            All Media objects are searchable on their Title property. 
     
            For an individual Media object, this means that given a string as a
            search key, the Search() method will either locate that string in
            the Title property or it will not.

            If not overridden, this method can be used by all derived classes 'as is'.
        */
        public bool Search(string key)
        {
            // Make the search case insensitive by treating strings as lowercase
            string temp = Title.ToLower();

            if (temp.IndexOf(key.ToLower()) >= 0)
                return true;                        // Found it
            else
                return false;                       // Didn't find it
        }

        #endregion  // End ISearchable
    }

}


