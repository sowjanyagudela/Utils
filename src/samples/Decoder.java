/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samples;

/**
 *
 * @author sowjanya
 */
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decoder {

    // The encoded character of each character escape.
    // This array functions as the keys of a sorted map, from encoded characters to decoded characters.
    static final char[] ENCODED_ESCAPES = { '\"', '\'', '\\',  'b',  'f',  'n',  'r',  't' };

    // The decoded character of each character escape.
    // This array functions as the values of a sorted map, from encoded characters to decoded characters.
    static final char[] DECODED_ESCAPES = { '\"', '\'', '\\', '\b', '\f', '\n', '\r', '\t' };

    // A pattern that matches an escape.
    // What follows the escape indicator is captured by group 1=character 2=octal 3=Unicode.
    static final Pattern PATTERN = Pattern.compile("\\\\(?:(b|t|n|f|r|\\\"|\\\'|\\\\)|((?:[0-3]?[0-7])?[0-7])|u+(\\p{XDigit}{4}))");

    public static CharSequence decodeString(CharSequence encodedString) {
        Matcher matcher = PATTERN.matcher(encodedString);
        StringBuffer decodedString = new StringBuffer();
        // Find each escape of the encoded string in succession.
        while (matcher.find()) {
            char ch;
            if (matcher.start(1) >= 0) {
                // Decode a character escape.
                ch = DECODED_ESCAPES[Arrays.binarySearch(ENCODED_ESCAPES, matcher.group(1).charAt(0))];
            } else if (matcher.start(2) >= 0) {
                // Decode an octal escape.
                ch = (char)(Integer.parseInt(matcher.group(2), 8));
            } else /* if (matcher.start(3) >= 0) */ {
                // Decode a Unicode escape.
                ch = (char)(Integer.parseInt(matcher.group(3), 16));
            }
            // Replace the escape with the decoded character.
            matcher.appendReplacement(decodedString, Matcher.quoteReplacement(String.valueOf(ch)));
        }
        // Append the remainder of the encoded string to the decoded string.
        // The remainder is the longest suffix of the encoded string such that the suffix contains no escapes.
        matcher.appendTail(decodedString);
        return decodedString;
    }

    public static void main(String args[]) {
        String str=null;
        str="<b> Hotel Villa Sonnwend <\\/b>\\n<br><\\/br>\\nAMBIENTE UND INTENTION\\n\\nDie VILLA SONNWEND ist ein Ort zum Zurückziehen, Entspannen und Wohlfühlen. Erholen Sie sich in unserem eleganten und warmen Ambiente.\\n\\nUm auf jeden Gast eingehen zu können legt Familie Maier und Ihre Mitarbeiter viel Wert auf die persönliche Ansprache und das Wahrnehmen der Vorlieben Ihrer Gäste.\\n\\nALLE NEUN DOPPELZIMMER UND DIE FÜNF SUITEN DER VILLA SIND L I E B E V O L L IM MEDITERRANEM STIL EINGERICHTET. JEDES UNSERER HOTELZIMMER HAT EINEN ROMANTISCHEN BALKON ZUM G E N I E S S E N DER HERRLICHEN LANDSCHAFT. Eine Besonderheit unserer VILLA ist das \\\"open end\\\"  Frühstück. Es bietet Ihnen alles für einen guten Start in den Tag. Weitab vom Alltagsstreß können Sie in den Bergen die Ruhe auf sich wirken lassen. Die Umgebung und das Klima lassen Sie aufatmen\\n\\n<br><\\/br>\"";
        System.out.println(decodeString(str));
    }
}