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
public class Universe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BigInteger a = new BigInteger("1391400037");
        BigInteger b = new BigInteger("1990000000000000000000000000000");
        BigDecimal c = new BigDecimal(".007");
        BigDecimal d = new BigDecimal(".1");
        BigInteger two = new BigInteger("2");
        int num1 = 0 , num2 = 0;
        stars star = new stars("Average_Star", a , b , 5778,c,d );
        
          //stars star = new stars();
                    star.starinfo();
            
            
        }

        
        /*planets [] listofPlanets = new planets [10];
        
        for(int i=0; i<10;i++){
            listofPlanets[i] = new planets();
        }
        listofPlanets [1].planetinfo();
        for(planets boi:listofPlanets){
           boi.planetinfo(); 
        }
        System.out.println(listofPlanets.length);
        System.out.println("*****************************************************************************");
        listofPlanets = planetsInOrder(listofPlanets);
        for(planets boi:listofPlanets){
           boi.planetinfo(); 
        }
        System.out.println(listofPlanets.length);
          */
        //       public stars(String type,BigInteger diameter,BigInteger mass,int surfaceTemperature,BigDecimal massUsedUp,BigDecimal massAtCenter ){

        
 
    
    public static planets[] planetsInOrder(planets[] list){
        planets[] newlist = new planets[list.length];
        for(int i=0;i<10;i++){
            for(int k=i+1;k<10;k++){
            int biggest = list[i].getOrbit() ;
                if(list[k].getOrbit() < biggest){
                    planets temp = list[k];
                    list[k] = list[i];
                    list[i] = temp;
                }
            }
        }
        newlist = list;
        return newlist;
    }

    
}
