/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author sowjanya
 */
public class sample2 {

    static void staticMethod() {
        System.out.println("Static Method");
    }

    public static void main(String[] args) {
//        System.out.println("MIN:" + Double.MIN_VALUE);
//        System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
//
//        HashMap hm = new HashMap();
//        hm.put("1", "abc");
//        hm.put("2", "ass");
//        hm.put("3", "dfg");
//        hm.put("4", "xyz");
//        hm.put(NULL, "xyz");
//
//        System.out.println("HASHMAP SET:" + hm);
//        Set<String> keys = hm.keySet();
//        for (String key : keys) {
//
//            System.out.println("Key = " + key);
//
//            System.out.println("Values = " + hm.get(key) );
//
//        }

        sample2 a = null;

        a.staticMethod();

        long startTime = System.currentTimeMillis();

        Date d1 = new Date();

        System.out.println("Time Start time ");
        for (int i = 100000; i > 0; i--) {
        }

        Date d2 = new Date();
        long diff = d2.getTime() - d1.getTime();
        
        long diffSeconds = diff / 1000 % 60;

        System.out.println("decrementing:: " + diffSeconds);

    }
}
