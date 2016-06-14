/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despegar;

import org.apache.commons.codec.binary.Base64;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URI;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author srinivas
 */
public class Testing1 {

    public static void main(String args[]) {
        String pingResponse = "";
        Socket socket = null;
        BufferedReader rd = null;
        BufferedWriter wr = null;
        String encodingStyle = null;
        String line;

        String apikey = "pq6XVVdqSaLY8oCOXwmfk1oV";
        String username = "test_username_638049";
        String password = "test_password_638049";
        String hotel = "638049";
//        String auth = "Channel-User api-key=" + apikey + ",username=" + username + ",password=" + password + ",hotel=" + hotel;
        String auth = "Channel-User api-key=\"" + apikey + "\",username=\"" + username + "\",password=\"" + password + "\",hotel=" + hotel;
        byte[] encoded = Base64.encodeBase64(auth.getBytes());

//             String enc_str = null;
//             enc_str = new String(encoded);
//             System.out.println("enc_str :: "+enc_str);
            String myurl="https://channel-sandbox.despegar.com/v1/hotels/availability/list/";

            String reqxml="<OTA_HotelAvailGetRQ xmlns=\"http://www.despegar.com/hotels/ota/v1/\" Version=\"1.000\">\n" +
                            "  <HotelAvailRequests>\n" +
                            "    <HotelAvailRequest>\n" +
                            "      <HotelRef HotelCode=\"638049\" />\n" +
                            "    </HotelAvailRequest>\n" +
                            "  </HotelAvailRequests>\n" +
                            "</OTA_HotelAvailGetRQ>";

        try {


            URI uri = new URI(myurl);
            String host = uri.getHost( ); 
            String path = uri.getRawPath( ); 
            int port = uri.getPort( ); 
            String protocol = uri.getScheme( );

            if (port == -1) {
                if (protocol.equals("http")) {
                    System.out.println("in if");
                    port = 80; // http port 
                }
                else if (protocol.equals("https")) {
                    System.out.println("in https");
                    port = 443; // https port 
                }
                else {
                    System.out.println("res null");
                }
            }
            if (port == 443 || port == 8443) {
                socket = SSLSocketFactory.getDefault().createSocket(host, port);
            } else {
                socket = new Socket(host, port);
            }
            // socket.setSoTimeout(socket_timeout);
            System.out.println("protocol :: " + protocol);
            System.out.println("myurl :: " + myurl);
            System.out.println("xml :: " + reqxml);
            System.out.println("port ::: " + port);
            System.out.println("socket ::: " + socket);
            System.out.println("path ::: " + path);
            System.out.println("host ::: " + host);
            System.out.println("auth :: " + auth);
            rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            if (encodingStyle != null && !encodingStyle.isEmpty()) {
                wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), encodingStyle));
            } else {
                wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            }

            wr.write("POST" + " " + path + " HTTP/1.0\r\n");
            wr.write("Content-Length: " + reqxml.trim().length() + "\r\n");
            wr.write("Host: " + host + ":" + port + "\r\n");
            wr.write("Content-Type:text/xml");
//                wr.write("Authorization: Channel-User "+auth1.toString()+" \r\n");
            wr.write("Authorization : " + auth + "\r\n");

              wr.write("trace: true \r\n");
            wr.write("\r\n");
            wr.write("Connection: Close \r\n");
            wr.write(reqxml.trim());
//            wr.write("Connection:close");
            wr.flush();
            

            while ((line = rd.readLine()) != null) {
                pingResponse = pingResponse + line + "\r\n";
            }
            pingResponse = pingResponse.substring(pingResponse.indexOf("\r\n\r\n") + 4);
            System.out.println("pingResponse : " + pingResponse);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                    socket = null;
                }
                if (rd != null) {
                    rd.close();
                    rd = null;
                }
                if (wr != null) {
                    wr.close();
                    wr = null;
                }
            } catch (Exception ec) {
                ec.printStackTrace();
            }
            line = null;
        }
    }
}
