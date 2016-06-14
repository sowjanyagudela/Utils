/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despegar;

import org.apache.commons.codec.binary.Base64;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URI;
import javax.net.ssl.SSLSocketFactory;

/**
 *
 * @author sowjanya
 */
public class Testing {

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

       String crendentials = "Channel-User api-key=\"" + apikey + "\", username=\"" + username + "\", password=\"" + password + "\", hotel=" + hotel;

        String myurl = "https://channel-sandbox.despegar.com/v1/hotels/availability/list/";

        
     String reqxml=  getSource("/home/sowjanya/NetBeansProjects/Utils/src/Despegar/availRQ.xml");
        try {

            URI uri = new URI(myurl);
            String host = uri.getHost();
            String path = uri.getRawPath();
            int port = uri.getPort();
            String protocol = uri.getScheme();

            if (port == -1) {
                if (protocol.equals("http")) {
                    System.out.println("in if");
                    port = 80; // http port 
                } else if (protocol.equals("https")) {
                    System.out.println("in https");
                    port = 443; // https port 
                } else {
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
            System.out.println("auth :: " + crendentials);
            rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            if (encodingStyle != null && !encodingStyle.isEmpty()) {
                wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), encodingStyle));
            } else {
                wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            }
           
            wr.write("POST" + " " + path + " HTTP/1.0\r\n");
            wr.write("Content-Length: " + reqxml.trim().length() + "\r\n");
            wr.write("Host: " + host + ":" + port + "\r\n");
            wr.write("Content-Type:text/xml\r\n");
//                wr.write("Authorization: Channel-User "+auth1.toString()+" \r\n");
            wr.write("Authorization: "+  crendentials + "\r\n");
//            wr.write("trace: true \r\n");
            wr.write("\r\n");
//            wr.write("Connection: Close \r\n");
            wr.write(reqxml.trim());
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
    
      public static String getSource(String filePath) {
        File file = null;
        FileReader freader = null;
        StringBuffer buffer = null;
        String postData = null;
        try {
            file = new File(filePath);
            freader = new FileReader(file);
            buffer = new StringBuffer();
            char[] src = new char[(int) file.length()];
            freader.read(src);
            buffer.append(src);
            postData = buffer.toString();
        } catch (Exception e) {
            System.out.println("Exception :" + e);
        }
        return postData;
    }

}
