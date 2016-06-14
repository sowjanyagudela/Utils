/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despegar;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author sowjanya
 */
public class ConnectToUrlUsingBasicAuthentication {

    public static void main(String[] args) {
        try {
            final String urlString = "https://channel-sandbox.despegar.com/v1/hotels/rate-plans/get";

            String apikey = "J6wCzWVy1LrB50tTwyqD7kO2";

            String username = "test_username_282445";
            String password = "test_password_282445";
            String hotel = "282445";

            String auth = "Channel-User api-key=\"" + apikey + "\", username=\"" + username + "\", password=\"" + password + "\", hotel=" + hotel;
            byte[] encoded = Base64.encodeBase64(auth.getBytes());
//            final String userName = "admin";
//            final String password = "admin";

            // open url connection
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // set up url connection to get retrieve information back
            con.setRequestMethod("GET");
            con.setDoInput(true);

            // stuff the Authorization request header
//            byte[] encodedPassword = (userName + ":" + password).getBytes();
//            Base64.encodeBase64 encoder = new BASE64Encoder();
            con.setRequestProperty("Authorization",
                    "Basic " + Base64.encodeBase64(encoded));

            // pull the information back from the URL
            InputStream is = con.getInputStream();
            StringBuffer buf = new StringBuffer();
            int c;
            while ((c = is.read()) != -1) {
                buf.append((char) c);
                
            }
            
            System.out.println("ssssssss::"+buf);
            con.disconnect();

            // output the information
            System.out.println(buf);
        } catch (Exception ex) {
            Logger.getLogger(ConnectToUrlUsingBasicAuthentication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
