using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Lab1
{
    class Program
    {
        static void Main(string[] args)
        {            
            Employee testA = new Employee("A", 1, 10.0m, 50);
            Employee testB = new Employee("B", 1, 10.0m, 50);
            Employee testC = new Employee("C", 1, 10.0m, 50);
            Employee testD = new Employee("D", 1, 10.0m, 50);
            Employee[] testEmp = new Employee[4]{testB, testA, testD, testC};
            //Read("employees.txt");
            Sort(testEmp, "name");
            Console.WriteLine(testEmp[0].GetName());
            Console.WriteLine(testEmp[1].GetName());
            Console.WriteLine(testEmp[2].GetName());
            Console.WriteLine(testEmp[3].GetName());
        }

        static void Read(string FileName)
        {
            int FileLength = File.ReadAllLines(FileName).Length;
            Employee[] empArray = new Employee[FileLength];
            string[] TxtLine;
            int count;
            string name;
            int number;
            double hours;
            decimal rate;
            try
            {
                using (StreamReader sr = new StreamReader(FileName))
                {

                    for (count = 0; count < FileLength; count++)
                    {
                        String line = sr.ReadLine();
                        TxtLine = line.Split(',');
                        name = TxtLine[0].Trim();
                        number = Int32.Parse(TxtLine[1].Trim());
                        hours = Double.Parse(TxtLine[2].Trim());
                        rate = Decimal.Parse(TxtLine[3].Trim());
                        Employee emp = new Employee(name, number, rate, hours);
                        empArray[count] = emp;
                        
                        //Console.WriteLine(empArray[count].GetName());
                    }
                }
            }
            catch (Exception e)
            {
                Console.WriteLine("The file could not be read:");
                Console.WriteLine(e.Message);
            }
        }

        static Employee[] Sort(Employee[] empArray, String key)
        {
            if (key == "name")
            {
                Array.Sort(empArray, delegate(Employee first, Employee next)
                {
                    return first.GetName().CompareTo(next.GetName());
                });   
            }
            return empArray;
        }
    }



    //Employee class
    class Employee
    {
        //private variables
        private string name;
        private int number;
        private decimal rate;
        private double hours;
        private decimal gross;
        
        public Employee(string name, int number, decimal rate, double hours) {
            this.name = name;
            this.number = number;
            this.rate = rate;
            this.hours = hours;
        }

        //public methods

        public decimal GetGross()
        {
            if (hours <= 40)
            {
                gross = rate * (decimal)hours;
            }
            else
            {
                gross = (rate * 40) + (rate * (decimal)1.5 * (decimal)(hours - 40));
            }

            return gross;
        }

        public double GetHours()
        {
            return hours;
        }

        public string GetName()
        {
            return name;
        }

        public int GetNumber()
        {
            return number;
        }
        public decimal GetRate()
        {
            return rate;
        }

        public void SetHours(double hours)
        {
            this.hours = hours;
        }
        public void SetName(string name)
        {
            this.name = name;
        }
        public void SetNumber(int number)
        {
            this.number = number;
        }
        public void SetRate(decimal rate)
        {
            this.rate = rate;
        }

        public void PrintEmployee()
        {
            Console.WriteLine(
                this.name +
                this.number +
                this.rate +
                this.hours +
                this.GetGross()
                );
        }
    }   
}
