/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashMap;

/**
 *
 * @author sowjanya
 */
public enum  Parent {
    
    
    INSTANCE;
    
    
    public static  void  sayHello(){
        System.out.println("hiii");
    }
    public static void main(String[] args) {
        INSTANCE.sayHello();
        
        HashMap<String,String> hm= new HashMap();
        hm.put("1","abc");
        hm.put("2", "def");
        
        
        for(String key:hm.keySet()){
            String value = hm.get(key);
            System.out.println("KEY::"+key+"::Value:"+value);
        }
        
    }
    
    
    
    
}
