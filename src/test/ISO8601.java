/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author sowjanya
 */
public class ISO8601 {

    public static String convertLocalTimeToUTC(String p_city, String p_localDateTime) throws Exception {

        String lv_dateFormateInUTC = "";//Will hold the final converted date
        Date lv_localDate = null;
        String lv_localTimeZone = "";
        SimpleDateFormat lv_formatter;
        SimpleDateFormat lv_parser;

//Temp for testing(mapping of cities and timezones will eventually be in a properties file
        if (p_city.equals("LON")) {
            lv_localTimeZone = "Europe/London";
        } else if (p_city.equals("NBI")) {
            lv_localTimeZone = "EAT";
        } else if (p_city.equals("BRS")) {
            lv_localTimeZone = "Europe/Brussels";
        } else if (p_city.equals("MNT")) {
            lv_localTimeZone = "America/Montreal";
        } else if (p_city.equals("LAS")) {
            lv_localTimeZone = "PST";
        }

//create a new Date object using the timezone of the specified city
        lv_parser = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        lv_parser.setTimeZone(TimeZone.getTimeZone(lv_localTimeZone));
        lv_localDate = lv_parser.parse(p_localDateTime);

//Set output format prints "2007/10/25  18:35:07 EDT(-0400)"
        lv_formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z'('Z')'");
        lv_formatter.setTimeZone(TimeZone.getTimeZone(lv_localTimeZone));

        System.out.println("convertLocalTimeToUTC: " + p_city + ": " + " The Date in the local time zone " + lv_formatter.format(lv_localDate));

//Convert the date from the local timezone to UTC timezone
        lv_formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        lv_dateFormateInUTC = lv_formatter.format(lv_localDate);
        System.out.println("convertLocalTimeToUTC: " + p_city + ": " + " The Date in the UTC time zone " + lv_dateFormateInUTC);

        return lv_dateFormateInUTC;
    }
}
