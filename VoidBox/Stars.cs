using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Deveel.Math;
using System.Threading.Tasks;


namespace newTest
{
    public class stars : StarInfoPicker
    {
        private String type;
        private BigDecimal starluminosity, massUsedUp, massAtCenter, energy, age, density, vol, gavatationalPull;
        private int surfaceTemperature;
        private BigInteger mass, diameter;
        private String[] starType = { "Average_Star", "Massive_Star", "Red_Giant", "Red_base_Giant", "White_Dwarf", "Neutron_Star", "Black_hole" };

        public stars()
        {
            Random ran = new Random();
            int RanType = ran.Next(0, starType.Length);
            type = starType[RanType - 1];
            base.chooseInfo(type);
            this.diameter = base.getDiameter();
            this.surfaceTemperature = base.getSurfaceTemperature();
            this.massUsedUp = base.getMassUsedUp();
            this.massAtCenter = base.getMassAtCenter();
            this.mass = base.mass;
            //this.mass = base.mass;
        }

        public stars(String type, BigInteger diameter, BigInteger mass, int surfaceTemperature, BigDecimal massUsedUp, BigDecimal massAtCenter)
        {
            this.massAtCenter = massAtCenter;
            this.massUsedUp = massUsedUp;
            base.setMass(mass);
            this.type = type;
            this.diameter = diameter;
            this.mass = mass;
            this.surfaceTemperature = surfaceTemperature;
        }

        private BigDecimal luminosityOfAStar(BigInteger dia, int surtemp)
        {
            BigDecimal radi = BigDecimal.Parse("0.0");
            BigDecimal surfaceAreaOfTheStar = BigDecimal.Parse("0.0");
            BigInteger two = BigDecimal.Parse("2");
            dia = dia.Divide(two);
            radi = BigDecimal.Parse(dia);
            radi = radi.Pow(2);
            surfaceAreaOfTheStar = radi * (BigDecimal.Parse( (4 * Math.PI).ToString() ));
            BigDecimal luminosity = surfaceAreaOfTheStar * ( BigDecimal.Parse(".0000000567"));
            luminosity = luminosity * (BigDecimal.Parse(surtemp.ToString()).Pow(4));

            setStarluminosity(luminosity);
            return luminosity;
        }
        public BigDecimal StarsEnergy(BigInteger mass, BigDecimal massUsedUp, BigDecimal massAtCenter)
        {
            BigDecimal eng = BigDecimal.Parse("0");
            BigInteger speedOfLightSq = BigInteger.Parse("89875517900000000");
            BigDecimal mass2 = BigDecimal.Parse(mass);
            //.007
            eng = massUsedUp.Multiply(massAtCenter);
            eng = eng.Multiply(mass2);
            eng = eng.Multiply(BigDecimal.Parse(speedOfLightSq));
            setEnergy(eng);
            return eng;
        }
        public BigDecimal StarsLifeSpan(BigDecimal lum, BigDecimal eng)
        {
            BigInteger energy = eng;
            BigInteger luminosity = lum;

            BigDecimal age = energy.Divide(luminosity).Divide(BigDecimal.Parse("31579200"));
            //convertion for sec to years ^^^^^^^^
            setage(age);
            return age;
        }
        public void starinfo()
        {

            Console.WriteLine("======[Star]======");
            Console.WriteLine("name :" + getType());
            Console.WriteLine("Diameter :" + getDiameter() + " m");
            Console.WriteLine("Mass :" + getMass() + " Kg");
            Console.WriteLine("Temp :" + getSurfaceTemperature() + " K");
            BigDecimal dia = BigDecimal.Parse(diameter);

            this.density = base.calDens(dia.Divide(2));

            Console.WriteLine("Density : " + base.getdensity() + " Kg / m³");
            BigDecimal lum = luminosityOfAStar(getDiameter(), getSurfaceTemperature());
            volume(getDiameter());
            Console.WriteLine("Volume : " + getVolume().ToBigIntegerExact() + "  m³");
            Console.WriteLine("luminosity :" + getStarluminosity().ToBigIntegerExact() + " watts");
            BigDecimal eng = StarsEnergy(this.mass, this.massUsedUp, this.massAtCenter);
            Console.WriteLine("Energy :" + getEnergy().ToBigIntegerExact() + " J");
            StarsLifeSpan(lum.ToBigIntegerExact(), eng.ToBigIntegerExact());
            Console.WriteLine("Life Span: " + getAge() + " Years");
            gPull(mass, BigInteger.Parse("5972000000000000000000000"));
            Console.WriteLine("Gravitaional Pull: " + getgp() + " Newtons");
            if(base.getSpin() == null)
            {
                Console.WriteLine("Spin: Null Km/S");
                return;
            }
            Console.WriteLine("Spin: " + base.getSpin() + " Km/S");
        }
        public BigDecimal volume(BigInteger diameter)
        {
            BigDecimal vol = BigDecimal.Parse("0");
            BigDecimal radi = BigDecimal.Parse(diameter);
            BigDecimal two = BigDecimal.Parse("2.0");
            BigDecimal FOT = BigDecimal.Parse("1.33333333333");
            BigDecimal PI = BigDecimal.Parse(Math.PI.ToString());


            radi = radi.Divide(two);
            vol = FOT * (PI);
            vol = vol * (radi.Pow(3));

            setVolume(vol);
            return vol;
        }
        public BigDecimal gPull(BigInteger mass, BigInteger planetMass)
        {
            BigDecimal mass2 = BigDecimal.Parse(mass);
            Console.WriteLine(""+mass);
            BigDecimal planetMass2 = BigDecimal.Parse(planetMass);
            Console.WriteLine("" + mass);
            BigDecimal distance = BigDecimal.Parse("0");

            BigInteger gp = BigInteger.Parse("0");
            BigDecimal G = BigDecimal.Parse("0.0000000000667");

            distance = BigDecimal.Parse("149000000000");
            gp = G.Multiply(mass2);
            gp = gp.Multiply(planetMass2);
            gp = gp.Divide(distance.Pow(2));
            setgp(gp);
            return gp;
        }

        public BigDecimal coreTemp()
        {
            BigDecimal temp = BigDecimal.Parse("0");


            return temp;
        }


        public BigDecimal getgp()
        {
            return gavatationalPull;
        }
        public void setgp(BigDecimal gavatationalPull)
        {
            this.gavatationalPull = gavatationalPull;
        }
        public BigDecimal getVolume()
        {
            return vol;
        }
        public void setVolume(BigDecimal vol)
        {
            this.vol = vol;
        }
        public String getType()
        {
            return type;
        }
        public BigDecimal getStarluminosity()
        {
            return starluminosity;
        }
        public void setStarluminosity(BigDecimal luminosity)
        {
            starluminosity = luminosity;
        }
        public int getSurfaceTemperature()
        {
            return surfaceTemperature;
        }
        public BigInteger getDiameter()
        {
            return diameter;
        }
        public BigInteger getMass()
        {
            return mass;
        }
        public BigDecimal getEnergy()
        {
            return energy;
        }
        public void setEnergy(BigDecimal eng)
        {
            energy = eng;
        }
        public BigDecimal getAge()
        {
            return age;
        }
        public void setage(BigDecimal age)
        {
            this.age = age;
        }
    }
}

