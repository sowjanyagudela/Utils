/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GHFTesting;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Calendar;
import org.apache.commons.lang.StringEscapeUtils;

/**
 *
 * @author sowjanya
 */
public class decode {

    final static int speedlimit = 90;//final variable  

    public static String encode(String input) {
        StringBuilder resultStr = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (isUnsafe(ch)) {
                resultStr.append('%');
                resultStr.append(toHex(ch / 16));
                resultStr.append(toHex(ch % 16));
            } else {
                resultStr.append(ch);
            }
        }
        return resultStr.toString();
    }

    private static char toHex(int ch) {
        return (char) (ch < 10 ? '0' + ch : 'A' + ch - 10);
    }

    private static boolean isUnsafe(char ch) {
        if (ch > 128 || ch < 0) {
            return true;
        }
        return " %$&+,/:;=?@<>#%".indexOf(ch) >= 0;
    }

    public static String forHTML(String aText) {
        final StringBuilder result = new StringBuilder();
        final StringCharacterIterator iterator = new StringCharacterIterator(aText);
        char character = iterator.current();
        while (character != CharacterIterator.DONE) {
            if (character == '<') {
                result.append("&lt;");
            } else if (character == '>') {
                result.append("&gt;");
            } else if (character == '&') {
                result.append("&amp;");
            } else if (character == '\"') {
                result.append("&quot;");
            } else if (character == '\t') {
                addCharEntity(9, result);
            } else if (character == '!') {
                addCharEntity(33, result);
            } else if (character == '#') {
                addCharEntity(35, result);
            } else if (character == '$') {
                addCharEntity(36, result);
            } else if (character == '%') {
                addCharEntity(37, result);
            } else if (character == '\'') {
                addCharEntity(39, result);
            } else if (character == '(') {
                addCharEntity(40, result);
            } else if (character == ')') {
                addCharEntity(41, result);
            } else if (character == '*') {
                addCharEntity(42, result);
            } else if (character == '+') {
                addCharEntity(43, result);
            } else if (character == ',') {
                addCharEntity(44, result);
            } else if (character == '-') {
                addCharEntity(45, result);
            } else if (character == '.') {
                addCharEntity(46, result);
            } else if (character == '/') {
                addCharEntity(47, result);
            } else if (character == ':') {
                addCharEntity(58, result);
            } else if (character == ';') {
                addCharEntity(59, result);
            } else if (character == '=') {
                addCharEntity(61, result);
            } else if (character == '?') {
                addCharEntity(63, result);
            } else if (character == '@') {
                addCharEntity(64, result);
            } else if (character == '[') {
                addCharEntity(91, result);
            } else if (character == '\\') {
                addCharEntity(92, result);
            } else if (character == ']') {
                addCharEntity(93, result);
            } else if (character == '^') {
                addCharEntity(94, result);
            } else if (character == '_') {
                addCharEntity(95, result);
            } else if (character == '`') {
                addCharEntity(96, result);
            } else if (character == '{') {
                addCharEntity(123, result);
            } else if (character == '|') {
                addCharEntity(124, result);
            } else if (character == '}') {
                addCharEntity(125, result);
            } else if (character == '~') {
                addCharEntity(126, result);
            } else {
                //the char is not a special one
                //add it to the result as is
                result.append(character);
            }
            character = iterator.next();
        }
        return result.toString();
    }

    private static void addCharEntity(Integer aIdx, StringBuilder aBuilder) {
        String padding = "";
        if (aIdx <= 9) {
            padding = "00";
        } else if (aIdx <= 99) {
            padding = "0";
        } else {
            //no prefix
        }
        String number = padding + aIdx.toString();
        aBuilder.append("&#" + number + ";");
    }

    public static String forURL(String aURLFragment) {
        String result = null;
        try {
            result = URLEncoder.encode(aURLFragment, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("UTF-8 not supported", ex);
        }
        return result;
    }

    public static void main(String[] args) {

        String str = "https://cultbooking.com/central1/?agentcode=50410&GC=2&hotelcode=(PARTNER-HOTEL-ID)&lang=en&CheckInDate=(CHECKINDAY).(CHECKINMONTH).(CHECKINYEAR)&CheckOutDate=(CHECKOUTDAY).(CHECKOUTMONTH).(CHECKOUTYEAR)&PC=RatePlanID";
        String results = StringEscapeUtils.escapeHtml(str);
        System.out.println(results);
  
    }

}
