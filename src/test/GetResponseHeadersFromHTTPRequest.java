/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author sowjanya
 */
public class GetResponseHeadersFromHTTPRequest {

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://cpc.cultuzz.com:8080/ChannelComponent/availability.jsp");
        URLConnection conn = url.openConnection();

        Map<String, List<String>> headerFields = conn.getHeaderFields();

        Set<String> headerFieldsSet = headerFields.keySet();
        Iterator<String> hearerFieldsIter = headerFieldsSet.iterator();

        while (hearerFieldsIter.hasNext()) {

            String headerFieldKey = hearerFieldsIter.next();
            List<String> headerFieldValue = headerFields.get(headerFieldKey);

            StringBuilder sb = new StringBuilder();
            for (String value : headerFieldValue) {
                sb.append(value);
                sb.append("");
            }

            System.out.println(headerFieldKey + "=" + sb.toString());

        }
        String s1 = "www.ramada.com/hotels/germany/erfurt/ramada-erfurt/hotel-overview";
        System.out.println("s1Length::" + s1.length());

//        String s3 = null;
//
//        String[] splitByNumber = splitByNumber(s1, 1000);
//        for (int i = 0; i < splitByNumber.length - 1; i++) {
//            s3 = splitByNumber[0];
//
//        }
//
//        if (s3 != null) {
//            String desc = s3.substring(0, s3.lastIndexOf(".")).concat(".");
//
//        }

    }

    private static String[] splitByNumber(String s, int chunkSize) {
        int chunkCount = (s.length() / chunkSize) + (s.length() % chunkSize == 0 ? 0 : 1);
        String[] returnVal = new String[chunkCount];
        for (int i = 0; i < chunkCount; i++) {
            returnVal[i] = s.substring(i * chunkSize, Math.min((i + 1) * chunkSize - 1, s.length()));
        }
        return returnVal;
    }

}





