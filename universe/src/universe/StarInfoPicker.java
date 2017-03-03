/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universe;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Random;

/**
 *
 * @author bhagyesh
 */
public abstract class StarInfoPicker {

    BigDecimal num2 = new BigDecimal("2.0");
    int counter = 0;
    private String type;
    private BigDecimal massUsedUp, massAtCenter, density;
    public BigInteger mass,spin;
    private BigInteger diameter;
    private int surfaceTemperature;

    //Mass of stars at max lim.
    private BigInteger Average_Starmax = new BigInteger("994460000572291800000000000000");
    private BigInteger Massive_Starmax = new BigInteger("59667600034337510000000000000000");
    private BigInteger Red_Giantmax = new BigInteger("596676000343375100000000000000");
    private BigInteger Red_Super_Giantmax = new BigInteger("9944600005722918000000000000000");       
    private BigInteger White_Dwarfmax = new BigInteger("994460000572291800000000000000");       
    private BigInteger Neutron_Starmax = new BigInteger("2366814801362054400000000000000");       
    private BigInteger Black_holemax = new BigInteger("596676000343375100000000000000000000");  
    
    //Mass of stars at min lim.
    private BigInteger Average_Starmin = new BigInteger("15911360009156669000000000000000");
    private BigInteger Massive_Starmin = new BigInteger("298338000171687530000000000000000");
    private BigInteger Red_Giantmin = new BigInteger("15911360009156669000000000000000");
    private BigInteger Red_Super_Giantmin = new BigInteger("29833800017168753000000000000000");       
    private BigInteger White_Dwarfmin = new BigInteger("2764598801590971000000000000000");       
    private BigInteger Neutron_Starmin = new BigInteger("3977840002289167000000000000000");       
    private BigInteger Black_holemin = new BigInteger("39778400022891673000000000000000000000000");        

    public void chooseInfo(String type) {
        this.type = type;
        counter++;
        if(type.equals("Average_Star")){
            Average_Star();
            
        }
        if(type.equals("Massive_Star")){
            Massive_Star();
        }
        if(type.equals("Red_Giant")){
            Red_Giant();
        }
        if(type.equals("Red_Super_Giant")){
            Red_Super_Giant();
        }
        if(type.equals("White_Dwarf")){
            White_Dwarf();
        }
        if(type.equals("Neutron_Star")){
            Neutron_Star();
        }
        else if(type.equals("Black_hole")){
            Black_hole();

        }


    }

    public void Average_Star() {
        diameter = range(new BigInteger("1000000000"), new BigInteger("5000000000"));
        mass = range(Average_Starmax, Average_Starmin);
        surfaceTemperature = 5000 + (int)(Math.random() * ((6000 - 5000) + 1));
        this.massUsedUp = new BigDecimal(".007");
        this.massAtCenter = new BigDecimal( ".1");
        BigDecimal dia = new BigDecimal(diameter);
        spin = new BigInteger("2");
        density = calDens(dia.divide(num2));
    }
    public void Massive_Star() {

        diameter = range(new BigInteger("5000000000"), new BigInteger("100000000000"));
        mass = range(Massive_Starmax, Massive_Starmin);
        surfaceTemperature = 30000 + (int)(Math.random() * ((60000 - 30000) + 1));
        this.massUsedUp = new BigDecimal(".007");
        this.massAtCenter = new BigDecimal( ".24");
        BigDecimal dia = new BigDecimal(diameter);
        spin = range(new BigInteger("350"), new BigInteger("250"));
        density = calDens(dia.divide(num2));

    }
    public void Red_Giant() {
     
        diameter = range(new BigInteger("100000000000"), new BigInteger("1000000000000"));
        mass = range(Red_Giantmax, Red_Giantmin);
        surfaceTemperature = 1000 + (int)(Math.random() * ((3500 - 1000) + 1));
        this.massUsedUp = new BigDecimal("0.00147441058");
        this.massAtCenter = new BigDecimal( ".4");
        BigDecimal dia = new BigDecimal(diameter);
        spin = new BigInteger("1");       
        density = calDens(dia.divide(num2));

    }
    public void Red_Super_Giant() {
       
        diameter = range(new BigInteger("1000000000000"), new BigInteger("2000000000000"));
        mass = range( Red_Super_Giantmax ,Red_Super_Giantmin );
        surfaceTemperature = 1000 + (int)(Math.random() * ((3500 - 1000) + 1));
        this.massUsedUp = new BigDecimal("0.00147441058");
        this.massAtCenter = new BigDecimal( ".4");
        BigDecimal dia = new BigDecimal(diameter);
        spin = new BigInteger("1");
        density = calDens(dia.divide(num2));

    }
    public void White_Dwarf() {
    
        diameter = range(new BigInteger("6000000"), new BigInteger("12000000"));
        mass = range( White_Dwarfmax ,White_Dwarfmin );
        surfaceTemperature = 100000 + (int)(Math.random() * ((500000 - 100000) + 1));
        this.massUsedUp = new BigDecimal(".007");
        this.massAtCenter = new BigDecimal( "1");
        BigDecimal dia = new BigDecimal(diameter);
        spin = new BigInteger("2000");
        density = calDens(dia.divide(num2));

    }
    public void Neutron_Star() {
  
        diameter = range(new BigInteger("20000"), new BigInteger("50000"));
        mass = range(Neutron_Starmax, Neutron_Starmin );
        surfaceTemperature = 1000000 + (int)(Math.random() * ((10000000  - 1000000) + 1));
        this.massUsedUp = new BigDecimal(".007");
        this.massAtCenter = new BigDecimal( "1");
        BigDecimal dia = new BigDecimal(diameter);
        spin = range(new BigInteger("1000"), new BigInteger("10000"));
        density = calDens(dia.divide(num2));
    }
    public void Black_hole() {
        diameter = range(new BigInteger("100000000000"), new BigInteger("10000000000000000"));
        mass = range(Black_holemax,Black_holemin );
        surfaceTemperature = 1;
        this.massUsedUp = new BigDecimal(".007");
        this.massAtCenter = new BigDecimal( "1");
        BigDecimal dia = new BigDecimal(diameter);
        spin = range(new BigInteger("251825"), new BigInteger("50000"));
        density = calDens(dia.divide(num2));

    }
    
    public BigDecimal calDens(BigDecimal radius) {
        
        BigDecimal vol = new BigDecimal("0.0");
        BigDecimal num = new BigDecimal("1.33333333333");
        BigDecimal pi = new BigDecimal(Math.PI);
        BigDecimal dens = new BigDecimal("0.0");

        BigDecimal mass1 = new BigDecimal(this.mass);
        
        num = num.multiply(pi);
        vol = radius.pow(3);
        vol = num.multiply(vol);
        dens = mass1.divide(vol,2, RoundingMode.HALF_UP);

        while (mass.compareTo(vol.toBigInteger()) < 0 ) {
            if (type.equalsIgnoreCase("Average_Star")) {
                mass = range(Average_Starmax, Average_Starmin);
            }
            if (type.equals("Massive_Star")) {
                mass = range(Massive_Starmax, Massive_Starmin);
            }
            if (type.equalsIgnoreCase("White_Dwarf")) {
                mass = range(White_Dwarfmax, White_Dwarfmin);
            }
            if (type.equalsIgnoreCase("Neutron_Star")) {
                mass = range(Neutron_Starmax, Neutron_Starmin);
            } if (type.equalsIgnoreCase("Black_hole")) {
                mass = range(Black_holemax, Black_holemin);
            }
            else{
                break;
            }
            
        }

        
        dens = mass1.divide(vol,2, RoundingMode.HALF_UP);
        density = dens;
        //if(density.compareTo(new BigDecimal("1")) < 0 ){
        //    System.out.println("its 0");
        //    System.exit(0);
        //}
        return dens;
        
    }
    public BigDecimal getMassUsedUp() {
        return massUsedUp;
    }    
    public BigDecimal getdensity() {
        return density;
    }   
    public BigDecimal getMassAtCenter() {
        return massAtCenter;
    }
    public int getSurfaceTemperature() {
        return surfaceTemperature;
    }
    public void setMass(BigInteger mass) {
        this.mass = mass;
    }
    public BigInteger getDiameter() {
        return diameter;
    }
    public BigInteger getSpin() {
        return spin;
    }


    
    
    public static BigInteger range(BigInteger max ,BigInteger min) {
        Random rnd = new Random();
        BigInteger diff = new BigInteger("0");
        BigInteger z = new BigInteger("0");

        BigInteger a = randomBigInteger1(max);
        BigInteger b = randomBigInteger2(min);
        BigInteger aRandomBigInt;
        
        diff=a.subtract(b);
        while(diff.compareTo(z) < 0){
             a = randomBigInteger1(max);
             b = randomBigInteger2(min);
             diff=a.subtract(b);
        }

        aRandomBigInt = diff;
        return aRandomBigInt;
    }
    private static BigInteger randomBigInteger1(BigInteger b) {
        Random rnd = new Random();
        int maxNumBitLength = b.bitLength();

        BigInteger aRandomBigInt;
        do {
            aRandomBigInt = new BigInteger(maxNumBitLength, rnd);
            // compare random number less than given number
        } while (aRandomBigInt.compareTo(b) > 0  ); 
        return aRandomBigInt;
    }
    private static BigInteger randomBigInteger2(BigInteger l) {
        Random rnd = new Random();
        int minNumBitLength = l.bitLength();

        BigInteger aRandomBigInt;
        do {
            aRandomBigInt = new BigInteger(minNumBitLength, rnd);
            // compare random number less than given number
        } while (aRandomBigInt.compareTo(l) > 0 ); 
        return aRandomBigInt;
    }
}
