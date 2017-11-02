﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab3
{
/*
    Interface: ISearchable.cs
    Author:    Nicholas J. Corkigian
    Date:      February 18, 2010

    Purpose: This interface has one method that classes making use of must
            implement. 

            The class implementing the Search() method will be assumed to
            use a string search key as a parameter and return a boolean
            value to indicate if that key was successfully found.

            This code is not to be altered.
*/

    interface ISearchable
    {
        bool Search(string key);
    }
}
