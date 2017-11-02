using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab3
{
    /// <summary>
    /// Book class inherited from Media Class
    /// Implements the Interface IEncryptable
    /// Contains information of a Book
    /// </summary>
    public class Book : Media, IEncryptable
    {
        public string Author;
        public string Summary;

        /* Four-argument constructor sets the Four properties that all Book objects have */
        public Book(string title, int year, string author, string summary)
            : base(title, year)
        {
            Author = author;
            Summary = summary;
        }

        #region IEncryptable

        /// <summary>
	    /// Performs the ROT13 character rotation to encrypt.
	    /// </summary>
        public string Encrypt()
	    {
	        char[] array = Summary.ToCharArray();
	        for (int i = 0; i < array.Length; i++)
	        {
		    int number = (int)array[i];

		    if (number >= 'a' && number <= 'z')
		    {
		        if (number > 'm')
		        {
			    number += 13;
		        }
		        else
		        {
			    number -= 13;
		        }
		    }
		    else if (number >= 'A' && number <= 'Z')
		    {
		        if (number > 'M')
		        {
			    number += 13;
		        }
		        else
		        {
			    number -= 13;
		        }
		    }
		    array[i] = (char)number;
	        }
	        return new string(array);
        }

        /// <summary>
        /// Performs the ROT13 character rotation to decrypt.
        /// </summary>
        public string Decrypt()
        {
            char[] array = Summary.ToCharArray();
            for (int i = 0; i < array.Length; i++)
            {
                int number = (int)array[i];

                if (number >= 'a' && number <= 'z')
                {
                    if (number > 'm')
                    {
                        number -= 13;
                    }
                    else
                    {
                        number += 13;
                    }
                }
                else if (number >= 'A' && number <= 'Z')
                {
                    if (number > 'M')
                    {
                        number -= 13;
                    }
                    else
                    {
                        number += 13;
                    }
                }
                array[i] = (char)number;
            }
            return new string(array);
        }
        #endregion
    }
}
