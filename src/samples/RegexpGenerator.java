/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samples;

import java.util.regex.Pattern;

/**
 *
 * @author sowjanya
 */
public class RegexpGenerator {

    public static Pattern generateRegexp(String prototype) {
        return Pattern.compile(generateRegexpFrom(prototype));
    }

    private static String generateRegexpFrom(String prototype) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < prototype.length(); i++) {
            char c = prototype.charAt(i);

            if (Character.isDigit(c)) {
                stringBuilder.append("\\d");
            } else if (Character.isLetter(c)) {
                stringBuilder.append("\\w");
            } else { // falltrought: literal
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }

    private static void test(String prototype) {
        Pattern pattern = generateRegexp(prototype);
        System.out.println(String.format("%s -> %s", prototype, pattern));

        if (!pattern.matcher(prototype).matches()) {
            throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        String[] prototypes = {
            "2009-11-12"
        };

        for (String prototype : prototypes) {
            test(prototype);
        }
    }

}
