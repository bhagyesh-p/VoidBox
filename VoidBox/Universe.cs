using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Deveel.Math;
using System.IO;

namespace newTest
{
    class Universe
    {
        static void Main(string[] args)
        {
            BigInteger a =  BigInteger.Parse("1391400037");
            BigInteger b =  BigInteger.Parse("1990000000000000000000000000000");
            BigDecimal c =  BigDecimal.Parse(".007");
            BigDecimal d =  BigDecimal.Parse(".1");
            BigInteger two =  BigInteger.Parse("2");
            //BigInteger a = range(BigInteger.Parse("100"), BigInteger.Parse("10"));
            //stars star = new stars("Average_Star", a, b, 5778, c, d);
            stars star = new stars();
            
            star.starinfo();    
            Console.ReadKey();


        }

       

        
        

    }
}
