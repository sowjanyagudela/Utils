/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grouping;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author sowjanya
 */
public class sample {

    int fact(int n) {
        int result;
        if (n == 1) {
            return n;

        }
        result = fact(n - 1) * n;
        System.out.println("result::" + result);
        return result;
    }

    public static void main(String[] args) {
        sample s = new sample();
//        int fact = s.fact(5);
//        System.out.println("FAct::" + fact);

        float cs_amount = 0;

        cs_amount += 70.30;
        System.out.println("CSAMount::" + cs_amount);

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date d = new Date();
        System.out.println(dateFormat.format(d));

    }
}
