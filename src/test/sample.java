package test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;

public class sample {

    private static final String PLAIN_ASCII
            = "AaEeIiOoUu" // grave
            + "AaEeIiOoUuYy" // acute
            + "AaEeIiOoUuYy" // circumflex
            + "AaOoNn" // tilde
            + "AaEeIiOoUuYy" // umlaut
            + "Aa" // ring
            + "Cc" // cedilla
            + "OoUu" // double acute
            ;

    private static final String UNICODE
            = "\u00C0\u00E0\u00C8\u00E8\u00CC\u00EC\u00D2\u00F2\u00D9\u00F9"
            + "\u00C1\u00E1\u00C9\u00E9\u00CD\u00ED\u00D3\u00F3\u00DA\u00FA\u00DD\u00FD"
            + "\u00C2\u00E2\u00CA\u00EA\u00CE\u00EE\u00D4\u00F4\u00DB\u00FB\u0176\u0177"
            + "\u00C3\u00E3\u00D5\u00F5\u00D1\u00F1"
            + "\u00C4\u00E4\u00CB\u00EB\u00CF\u00EF\u00D6\u00F6\u00DC\u00FC\u0178\u00FF"
            + "\u00C5\u00E5"
            + "\u00C7\u00E7"
            + "\u0150\u0151\u0170\u0171";

    // private constructor, can't be instanciated!
    private sample() {
    }

    // remove accentued from a string and replace with ascii equivalent
    public static String convertNonAscii(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int pos = UNICODE.indexOf(c);
            if (pos > -1) {
                sb.append(PLAIN_ASCII.charAt(pos));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) throws Exception {
//            String httpsURL = "https://your.https.url.here/";
//            URL myurl = new URL(httpsURL);
//            HttpsURLConnection con = (HttpsURLConnection) myurl.openConnection();
//            InputStream ins = con.getInputStream();
//          
//            InputStreamReader isr = new InputStreamReader(ins);
//           
//            BufferedReader in = new BufferedReader(isr);
//
//            String inputLine;
//
//            while ((inputLine = in.readLine()) != null) {
//                System.out.println(inputLine);
//            }
//
//            in.close();
//            StringBuffer sb = new StringBuffer("MYSQLF");
//            StringBuffer reverse = sb.reverse();
//            System.out.println("RESVERS:::"+reverse.toString());
//        String currentTimezoneOffset = getCurrentTimezoneOffset();
//        System.out.println("currentTimezoneOffset:" + currentTimezoneOffset);
//        TimeZone tz = TimeZone.getTimeZone("UTC");
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        
      DateFormat df =   new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss ");
//        df.setTimeZone(tz);
      
      Calendar cal = new GregorianCalendar();
   
      df.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
//      TimeZone tz = TimeZone.getTimeZone();
        String nowAsISO = df.format(cal.getTime());

        System.out.println(nowAsISO);

        
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
       sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
       Date date = new Date();
       System.out.println("   UTC : "+sdf.format(date));
//        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
////nowAsISO = "2013-05-31T00:00:00Z";
//        Date finalResult = df1.parse(nowAsISO);
//
//        System.out.println(finalResult);

    }

    public static long getLocalToUtcDelta() {
        Calendar local = Calendar.getInstance();
        local.clear();
        local.set(1970, Calendar.JANUARY, 1, 0, 0, 0);
        return local.getTimeInMillis();
    }

    public static String getCurrentTimezoneOffset() {

        TimeZone tz = TimeZone.getDefault();
        Calendar cal = GregorianCalendar.getInstance(tz);
        int offsetInMillis = tz.getOffset(cal.getTimeInMillis());

        String offset = String.format("%02d:%02d", Math.abs(offsetInMillis / 3600000), Math.abs((offsetInMillis / 60000) % 60));
        offset = (offsetInMillis >= 0 ? "+" : "-") + offset;

        return offset;
    }

}
