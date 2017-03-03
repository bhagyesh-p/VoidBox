/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universe;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 *
 * @author bhagyesh
 */
public class stars extends StarInfoPicker {
     private String type;
     private BigDecimal starluminosity, massUsedUp,massAtCenter,energy,age,density , vol, gavatationalPull ;
     private int surfaceTemperature;
     private BigInteger mass,diameter;
     private String[] starType = {"Average_Star", "Massive_Star", "Red_Giant", "Red_Super_Giant", "White_Dwarf", "Neutron_Star", "Black_hole"};

    public stars(){
        int RanType = 0 + (int)(Math.random() * starType.length+1);
        type =starType[RanType-1];
        super.chooseInfo(type);
        this.diameter =super.getDiameter();
        this.surfaceTemperature = super.getSurfaceTemperature();
        this.massUsedUp = super.getMassUsedUp();
        this.massAtCenter = super.getMassAtCenter();
        this.mass = super.mass;
        //this.mass = super.mass;
    }

    public stars(String type,BigInteger diameter,BigInteger mass,int surfaceTemperature,BigDecimal massUsedUp,BigDecimal massAtCenter ){
        this.massAtCenter = massAtCenter;
        this.massUsedUp = massUsedUp;
        super.setMass(mass);
        this.type = type;
        this.diameter =diameter;
        this.mass = mass;
        this.surfaceTemperature = surfaceTemperature;
    }
    
    private BigDecimal luminosityOfAStar(BigInteger dia, int surtemp){
        BigDecimal radi = new BigDecimal ("0.0") ;
        BigDecimal surfaceAreaOfTheStar = new BigDecimal ("0.0") ;
        BigInteger two = new BigInteger ("2") ;
        dia  =dia.divide(two);
        radi = BigDecimal.valueOf(dia.longValue());
        radi = radi.pow(2);
        surfaceAreaOfTheStar =  radi.multiply(BigDecimal.valueOf(4*Math.PI));
        BigDecimal luminosity= surfaceAreaOfTheStar.multiply(new BigDecimal (".0000000567"));  
        luminosity= luminosity.multiply(BigDecimal.valueOf(surtemp).pow(4));
        
        setStarluminosity(luminosity);
        return luminosity;
    }   
    public BigDecimal StarsEnergy(BigInteger mass, BigDecimal massUsedUp, BigDecimal massAtCenter){
        BigDecimal eng= new BigDecimal("0");
        BigInteger speedOfLightSq= new BigInteger("89875517900000000");
        BigDecimal mass2= new BigDecimal(mass);
        //.007
        eng = massUsedUp.multiply(massAtCenter);
        eng = eng.multiply( mass2 );
        eng = eng.multiply(BigDecimal.valueOf(speedOfLightSq.longValue()));
        setEnergy(eng);
        return eng;
    }    
    public BigDecimal StarsLifeSpan(BigDecimal lum , BigDecimal eng){
        BigDecimal age = new BigDecimal("0");
        age = eng.divide(lum, 2, RoundingMode.HALF_UP);
        age = age.divide(BigDecimal.valueOf(31579200), 2, RoundingMode.HALF_UP);
        //convertion for sec to years ^^^^^^^^
        setage(age);
        return age;
    }    
    public void starinfo(){
        
        System.out.println("======[Star]======");
        System.out.println("name :" + getType() );
        System.out.println("Diameter :" + getDiameter() +" m" );
        System.out.println("Mass :" + getMass() +" Kg");
        System.out.println("Temp :" + getSurfaceTemperature() +" K");
        BigDecimal dia = new BigDecimal(diameter);

        this.density = super.calDens(dia.divide(num2));

        System.out.println("Density : "+super.getdensity()+" Kg / m³");
        luminosityOfAStar(getDiameter(),getSurfaceTemperature());
        volume(getDiameter());
        System.out.println("Volume : "+getVolume()+"  m³");
        System.out.println("luminosity :" + getStarluminosity() +" watts");
        StarsEnergy(this.mass, this.massUsedUp, this.massAtCenter);
        System.out.println("Energy :"+getEnergy()+" J");
        StarsLifeSpan(starluminosity,energy);
        System.out.println("Life Span: "+getAge()+" Years");
        gPull(mass,new BigInteger("5972000000000000000000000"));
        System.out.println("Gravitaional Pull: "+getgp()+" Newtons");
        System.out.println("Spin: "+super.getSpin() + " Km/S");
    }    
    public BigDecimal volume(BigInteger diameter){
        BigDecimal vol = new BigDecimal("0");
        BigDecimal radi = BigDecimal.valueOf(diameter.longValue());
        BigDecimal two = new BigDecimal ("2.0") ;
        BigDecimal FOT = new BigDecimal ("1.33333333333") ;
        BigDecimal PI = new BigDecimal (Math.PI) ;
                

        radi = radi.divide(two);
        vol = FOT.multiply(PI) ;
        vol = vol.multiply(radi.pow(3));
        setVolume(vol);
        return vol;
    }    
    public BigDecimal gPull(BigInteger mass, BigInteger planetMass){
        BigDecimal mass2= new BigDecimal(mass);
        BigDecimal planetMass2= new BigDecimal(planetMass);
        BigDecimal distance= new BigDecimal("0");

        BigDecimal gp = new BigDecimal ("0");
        BigDecimal G = new BigDecimal("0.0000000000667");
        
        distance= new BigDecimal("149000000000");
        gp = G.multiply(mass2);
        gp = gp.multiply(planetMass2);
        gp = gp.divide(distance.pow(2), 2, RoundingMode.HALF_UP);
        setgp(gp);
        return gp;
    }
    public BigDecimal coreTemp(){
        BigDecimal temp = new BigDecimal("0");
        
        
        return temp;
    }
    
    
    public BigDecimal getgp() {
        return gavatationalPull;
    }
    public void setgp(BigDecimal gavatationalPull) {
        this.gavatationalPull =gavatationalPull;
    }    
    public BigDecimal getVolume() {
        return vol;
    }
    public void setVolume(BigDecimal vol) {
        this.vol =vol;
    }
    public String getType() {
        return type;
    }
    public BigDecimal getStarluminosity() {
        return starluminosity;
    }    
    public void setStarluminosity(BigDecimal luminosity) {
        starluminosity = luminosity;
    }
    public int getSurfaceTemperature() {
        return surfaceTemperature;
    }
    public BigInteger getDiameter() {
        return diameter;
    }
    public BigInteger getMass() {
        return mass;
    }
    public BigDecimal getEnergy() {
        return energy;
    }
    public void setEnergy(BigDecimal eng) {
        energy =eng;
    }
    public BigDecimal getAge() {
        return age;
    }
    public void setage(BigDecimal age) {
        this.age =age;
    }
}
