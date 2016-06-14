/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author sowjanya
 */
import java.io.IOException;
import java.math.BigDecimal;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.NameValuePair;
//import org.apache.commons.httpclient.methods.PostMethod;

/**
 *
 * @author ramesh
 */
public class Test {

//    String name;
//    int age;
//
//    public Test(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
    public static void main(String args[]) throws ParseException {
        try {
            //        double lat = 99.99999999;
//        BigDecimal bd = new BigDecimal(lat);
//
//        
//        System.out.println("lat::"+bd.floatValue());

            InetAddress ip = InetAddress.getLocalHost();
            String canonicalHostName = ip.getCanonicalHostName();
            System.out.println("canonicalHostName:" + canonicalHostName);
//    DateFormat sdfTime = new SimpleDateFormat("hh:mm:ss");
//
//    Date now = new Date();
//
//    String strTime = sdfTime.format(now);
//
//    System.out.println("Time: " + strTime);
//        Time valueOf = Time.valueOf(strTime);
//
//
//
//        
//        System.out.println("DARTEE::"+valueOf);
//
//        Calendar cal1 = Calendar.getInstance();
//    Calendar cal2 = Calendar.getInstance();
//    cal2.add(Calendar.HOUR, 2);
//    cal2.add(Calendar.MINUTE, 42);
//    cal2.add(Calendar.SECOND, 12);
//    long secs = (cal2.getTimeInMillis() - cal1.getTimeInMillis()) / 1000;
//    String display = String.format("%02d:%02d:%02d", secs / 3600, (secs % 3600) / 60, (secs % 60));
//
//    
//    System.out.println(sdfTime.parse(display));
//    
        } catch (UnknownHostException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
