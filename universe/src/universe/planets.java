/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universe;

/**
 *
 * @author bhagyesh
 */
public class planets {
    private String[] planetNames = {"Eurystenes", "Evenios", "Gallus", "Glaukos", "Dismas", "Antaeus", "Antiphones", "Arcas", "Andokides", "Anaxos", "Antaeus", "BelosAnchimolios", "Chalcodon", "Butacidas", "Carpophorus", "Chares", "Casambus", "Chrysolorus", "Lysis", "Pelicles"};
    private int[] planeDiameter = {10000, 5000, 6000, 4356, 1568, 44563, 9651, 47562, 7851, 3535, 2562, 8543, 1235, 7612, 4589, 8685, 5886, 7856, 8956, 48961, 2546, 1546, 11455, 25465, 7856, 4585, 41451, 15434, 46525, 48652, 45562, 45563, 9546, 8946, 8632, 5566, 5935, 1546, 57843, 5254, 1596, 1596, 1598, 1520, 45243, 4645, 4739, 9462, 2455, 20543};
    private int[] planetOrbit = {46, 59, 42, 10, 2, 5, 9, 7, 18, 38, 100, 15, 38, 95, 154, 34, 45, 16, 28, 38, 17, 29, 55, 54, 46, 43, 41, 87, 82, 30};
    private int[] planetDay = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 26, 45, 37, 32, 30, 35, 46, 45, 42, 40};    
    private String Name;
    private int Diameter,Orbit,Day;

    public String getName() {
        return Name;
    }

    public int getDiameter() {
        return Diameter;
    }

    public int getOrbit() {
        return Orbit;
    }

    public int getDay() {
        return Day;
    }
    public planets(){
        int RanName =1 + (int)(Math.random() * planetNames.length-1); 
        int RanDia =1 + (int)(Math.random() * planeDiameter.length-1); 
        int RanOrb =1 + (int)(Math.random() * planetOrbit.length-1); 
        int RanDay =1 + (int)(Math.random() * planetDay.length-1); 
        
        Name =planetNames[RanName];
        Diameter =planeDiameter[RanDia];
        Orbit = planetOrbit[RanOrb];
        Day = planetDay[RanDay];
    }
    
    public void planetinfo(){
        
        System.out.println("======[PLANET]======");
        System.out.println("name :" + getName() );
        System.out.println("Diameter :" + getDiameter() +" miles" );
        System.out.println("Orbit :" + getOrbit() +" years");
        System.out.println("Day :" + getDay() +" earth hours");

    }
    
    
    
}
