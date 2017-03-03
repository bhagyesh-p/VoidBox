using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Deveel.Math;
namespace newTest
{
    abstract public class StarInfoPicker
    {

        public BigDecimal num2 = BigDecimal.Parse("2.0");
        int counter = 0;
        private String type;
        private BigDecimal massUsedUp, massAtCenter, density;
        public BigInteger mass, spin;
        private BigInteger diameter;
        private int surfaceTemperature;

        //Mass of stars at max lim.
        private BigInteger Average_Starmax = BigInteger.Parse("994460000572291800000000000000");
        private BigInteger Massive_Starmax = BigInteger.Parse("59667600034337510000000000000000");
        private BigInteger Red_Giantmax = BigInteger.Parse("596676000343375100000000000000");
        private BigInteger Red_Super_Giantmax = BigInteger.Parse("9944600005722918000000000000000");
        private BigInteger White_Dwarfmax = BigInteger.Parse("994460000572291800000000000000");
        private BigInteger Neutron_Starmax = BigInteger.Parse("2366814801362054400000000000000");
        private BigInteger Black_holemax = BigInteger.Parse("596676000343375100000000000000000000");

        //Mass of stars at min lim.
        private BigInteger Average_Starmin = BigInteger.Parse("15911360009156669000000000000000");
        private BigInteger Massive_Starmin = BigInteger.Parse("298338000171687530000000000000000");
        private BigInteger Red_Giantmin = BigInteger.Parse("15911360009156669000000000000000");
        private BigInteger Red_Super_Giantmin = BigInteger.Parse("29833800017168753000000000000000");
        private BigInteger White_Dwarfmin = BigInteger.Parse("2764598801590971000000000000000");
        private BigInteger Neutron_Starmin = BigInteger.Parse("3977840002289167000000000000000");
        private BigInteger Black_holemin = BigInteger.Parse("39778400022891673000000000000000000000000");

        public void chooseInfo(String type)
        {
            this.type = type;
            counter++;
            if (type==("Average_Star"))
            {
                Average_Star();

            }
            if (type==("Massive_Star"))
            {
                Massive_Star();
            }
            if (type==("Red_Giant"))
            {
                Red_Giant();
            }
            if (type==("Red_Super_Giant"))
            {
                Red_Super_Giant();
            }
            if (type==("White_Dwarf"))
            {
                White_Dwarf();
            }
            if (type==("Neutron_Star"))
            {
                Neutron_Star();
            }
            else if (type==("Black_hole"))
            {
                Black_hole();

            }


        }

        public void Average_Star()
        {
            Random ran = new Random();
            diameter = range(BigInteger.Parse("1000000000"), BigInteger.Parse("5000000000"));
            mass = range(Average_Starmax, Average_Starmin);
            surfaceTemperature = ran.Next(5000, 6000);
            this.massUsedUp = BigDecimal.Parse(".007");
            this.massAtCenter = BigDecimal.Parse(".1");
            BigDecimal dia = BigDecimal.Parse(diameter);
            spin = BigInteger.Parse("2");
            density = calDens(dia.Divide(num2));
        }
        public void Massive_Star()
        {
            Random ran = new Random();
            diameter = range(BigInteger.Parse("5000000000"), BigInteger.Parse("100000000000"));
            mass = range(Massive_Starmax, Massive_Starmin);
            surfaceTemperature = ran.Next(30000,60000);
            this.massUsedUp = BigDecimal.Parse(".007");
            this.massAtCenter = BigDecimal.Parse(".24");
            BigDecimal dia = BigDecimal.Parse(diameter);
            spin = range(BigInteger.Parse("200"), BigInteger.Parse("350"));
            density = calDens(dia.Divide(num2));

        }
        public void Red_Giant()
        {
            Random ran = new Random();
            diameter = range(BigInteger.Parse("100000000000"), BigInteger.Parse("1000000000000"));
            mass = range(Red_Giantmax, Red_Giantmin);
            surfaceTemperature = ran.Next(1000, 3500);
            this.massUsedUp = BigDecimal.Parse("0.00147441058");
            this.massAtCenter = BigDecimal.Parse(".4");
            BigDecimal dia = BigDecimal.Parse(diameter);
            spin = BigInteger.Parse("1");
            density = calDens(dia.Divide(num2));

        }
        public void Red_Super_Giant()
        {
            Random ran = new Random();
            diameter = range(BigInteger.Parse("1000000000000"), BigInteger.Parse("2000000000000"));
            mass = range(Red_Super_Giantmax, Red_Super_Giantmin);
            surfaceTemperature = ran.Next(1000, 3500);
            this.massUsedUp = BigDecimal.Parse("0.00147441058");
            this.massAtCenter = BigDecimal.Parse(".4");
            BigDecimal dia = BigDecimal.Parse(diameter);
            spin = BigInteger.Parse("1");
            density = calDens(dia.Divide(num2));

        }
        public void White_Dwarf()
        {
            Random ran = new Random();
            diameter = range(BigInteger.Parse("6000000"), BigInteger.Parse("12000000"));
            mass = range(White_Dwarfmax, White_Dwarfmin);
            surfaceTemperature = ran.Next(500000, 100000);
            this.massUsedUp = BigDecimal.Parse(".007");
            this.massAtCenter = BigDecimal.Parse("1");
            BigDecimal dia = BigDecimal.Parse(diameter);
            spin = BigInteger.Parse("2000");
            density = calDens(dia.Divide(num2));

        }
        public void Neutron_Star()
        {
            Random ran = new Random();
            diameter = range(BigInteger.Parse("20000"), BigInteger.Parse("50000"));
            mass = range(Neutron_Starmax, Neutron_Starmin);
            surfaceTemperature = ran.Next(1000000, 10000000);
            this.massUsedUp = BigDecimal.Parse(".007");
            this.massAtCenter = BigDecimal.Parse("1");
            BigDecimal dia = BigDecimal.Parse(diameter);
            spin = range(BigInteger.Parse("1000"), BigInteger.Parse("10000"));
            density = calDens(dia.Divide(num2));
        }
        public void Black_hole()
        {
            Random ran = new Random();
            diameter = range(BigInteger.Parse("100000000000"), BigInteger.Parse("10000000000000000"));
            mass = range(Black_holemax, Black_holemin);
            surfaceTemperature = 1;
            this.massUsedUp = BigDecimal.Parse(".007");
            this.massAtCenter = BigDecimal.Parse("1");
            BigDecimal dia = BigDecimal.Parse(diameter);
            spin = range(BigInteger.Parse("50000"), BigInteger.Parse("251825"));
            density = calDens(dia.Divide(num2));

        }

        public BigDecimal calDens(BigDecimal radius)
        {

            BigDecimal vol = BigDecimal.Parse("0.0");
            BigDecimal num = BigDecimal.Parse("1.33333333333");
            BigDecimal pi = BigDecimal.Parse(Math.PI.ToString());
            BigDecimal mass = BigInteger.Parse("1990000000000000000000000000000");
            BigDecimal dens = BigDecimal.Parse("0.0");

            num = num.Multiply(pi);
            vol = radius.Pow(3);
            vol = num.Multiply(vol);
            dens = mass / (vol);

            //while (mass.compareTo(vol.toBigInteger()) < 0)
            while (mass.CompareTo(( (BigInteger)vol )) < 0 ){
                if (type == ("Average_Star"))
                {
                    mass = range(Average_Starmax, Average_Starmin);
                }
                if (type == ("Massive_Star"))
                {
                    mass = range(Massive_Starmax, Massive_Starmin);
                }
                if (type == ("White_Dwarf"))
                {
                    mass = range(White_Dwarfmax, White_Dwarfmin);
                }
                if (type == ("Neutron_Star"))
                {
                    mass = range(Neutron_Starmax, Neutron_Starmin);
                }
                if (type == ("Black_hole"))
                {
                    mass = range(Black_holemax, Black_holemin);
                }
                else
                {
                    break;
                }

            }


            dens = mass/(vol);
            density = dens;
            //if(density.compareTo(BigDecimal.Parse("1")) < 0 ){
            //   Console.WriteLine("its 0");
            //    System.exit(0);
            //}
            return dens;

        }
        public BigDecimal getMassUsedUp()
        {
            return massUsedUp;
        }
        public BigDecimal getdensity()
        {
            return density;
        }
        public BigDecimal getMassAtCenter()
        {
            return massAtCenter;
        }
        public int getSurfaceTemperature()
        {
            return surfaceTemperature;
        }
        public void setMass(BigInteger mass)
        {
            this.mass = mass;
        }
        public BigInteger getDiameter()
        {
            return diameter;
        }
        public BigInteger getSpin()
        {
            return spin;
        }


        public static BigInteger range(BigInteger max, BigInteger min)
        {
            Random rnd = new Random();
            BigInteger diff = BigInteger.Parse("0");

            BigInteger a = RandomIntegerBelow1(max);
            BigInteger b = RandomIntegerBelow1(min);
            BigInteger aRandomBigInt;

            diff = a - b;
            while (diff <= 0)
            {
                a = RandomIntegerBelow1(max);
                b = RandomIntegerBelow1(min);
                diff = a - b;

            }

            aRandomBigInt = diff;
            return aRandomBigInt;
        }
        public static BigInteger RandomIntegerBelow1(BigInteger N)
        {
            byte[] bytes = N.ToByteArray();
            BigInteger R;
            Random random = new Random();

            do
            {
                random.NextBytes(bytes);
                bytes[bytes.Length - 1] &= (byte)0x7F; //force sign bit to positive
                System.Array.Reverse(bytes);
                R = new BigInteger(1, bytes);
            } while (R >= N);

            return R;
        }
    }
}
