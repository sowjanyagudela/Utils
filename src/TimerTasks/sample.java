/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimerTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSON;
import net.sf.json.JSONSerializer;

/**
 *
 * @author sowjanya
 */
public class sample {

    public static void main(String[] args) {
        try {

            char[] chrArr = {'a', 'c', 'd', 'y', 'e', 'q', 'b'};
            int index = Arrays.binarySearch(chrArr, 0, chrArr.length - 1, 'q');
            System.out.println("Char 'q' index is: " + index);

            int myarr[] = {1, 2, 3, 4, 5};
            System.out.println("ArrySize:" + myarr.length);
            int[] copyOf = Arrays.copyOf(myarr, 10);
            System.out.println("new ArrySize" + copyOf.length);

            String arr[] = {"a", "z", "b", "f", "s"};
            
            Arrays.sort(arr, new Comparator<String>(){
            
            
         public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }});


        for(String atr:arr){
            System.out.println("atr:"+atr);
        }
        
//            sample s= new sample();
////            s.test();
//            HashMap mainMap = new HashMap();
//
//            HashMap h1 = new HashMap();
//
//            h1.put("api_version", 1);
//            h1.put("currency", "CUR");
//            h1.put("start_date", "2015-04-28");
//////
//
//            List hotelList = new ArrayList();
//            for (int i = 0; i < 2; i++) {
//                HashMap h2 = new HashMap();
//                h2.put("hotel_id", "123");
//                hotelList.add(h2);
////
//                HashMap h3 = new HashMap();
//                List roomList = new ArrayList();
////            
//                HashMap h4 = new HashMap();
////            
//                h4.put("breakfast_included", "true");
//                h3.put("roomName", h4);
////            
//                roomList.add(h3);
////
//                h2.put("roomTypes", roomList);
//            }
//            h1.put("hotels", hotelList);
//            mainMap.put("root", h1);
//
//            org.json.JSONObject tripadvisorJsonvlaues = new org.json.JSONObject(mainMap);
//            System.out.println(" TRIPADVISOR::" + tripadvisorJsonvlaues.toString(1));

        } catch (Exception ex) {
            Logger.getLogger(sample.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public void test() {

        try {
            System.out.println("in TST");

            List objList = new ArrayList();
            objList.add("obj1");
            objList.add("obj2");
            objList.add("obj3");

            System.out.println("objList:" + objList);
            HashMap objMap = new HashMap();
            objMap.put("key1", "value1");
            objMap.put("key2", "value2");
            objMap.put("key3", "value3");
            System.out.println("objMap" + objMap);
            JSON toJSON = JSONSerializer.toJSON(objList);

            System.out.println("JSONArray :: " + toJSON.toString());
//        System.out.println("JSONObject :: " + (JSONObject) JSONSerializer.toJSON(objMap));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
