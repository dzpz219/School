using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab3
{
    /// <summary>
    /// Song class inherited from Media Class
    /// Contains information of a song
    /// </summary>
    public class Song : Media
    {
        public string Album;
        public string Artist;

        /* Four-argument constructor sets the Four properties that all Song objects have */
        public Song(string title, int year, string album, string artist)
            : base(title, year)
        {
            Album = album;
            Artist = artist;
        }

    }
}
