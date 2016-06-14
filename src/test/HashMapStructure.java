/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
  import java.util.HashMap;  
import java.util.Iterator; 
/**
 *
 * @author sowjanya
 */

public class HashMapStructure {  
    
    /** 
     * @author Arpit Mandliya 
     */  
    public static void main(String[] args) { 
        
        String s1= "AaAa";
        String s2= "BBBB";
        System.out.println("SSSS::"+s1.hashCode()+":::"+s2.hashCode());
        
        
        
    
//            
        Country india=new Country(s1,1000);  
        Country japan=new Country(s2,10000);  
            
        Country france=new Country("France",2000);  
        Country russia=new Country("Russia",20000);  
            
        HashMap<Country,String> countryCapitalMap=new HashMap<Country,String>();  
        countryCapitalMap.put(india,"Delhi");  
        countryCapitalMap.put(japan,"Tokyo");  
        countryCapitalMap.put(france,"Paris");  
        countryCapitalMap.put(russia,"Moscow");  
            
        Iterator<Country> countryCapitalIter=countryCapitalMap.keySet().iterator();//put debug point at this line  
        while(countryCapitalIter.hasNext())  
        {  
            Country countryObj=countryCapitalIter.next();  
            String capital=countryCapitalMap.get(countryObj);  
            System.out.println(countryObj.getName()+"----"+capital);  
            }  
        }  
    
    
}   


    

