using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab3
{
    /// <summary>
    /// Movie class inherited from Media Class
    /// Implements the Interface IEncryptable
    /// Contains information of a Movie
    /// </summary>
    public class Movie : Media, IEncryptable
    {
        public string Director;
        public string Summary;

        public Movie(string title, int year, string director, string summary)
            : base(title, year)
        {
            Director = director;
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
