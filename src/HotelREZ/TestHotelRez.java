/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelREZ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import javax.xml.ws.Service;
import org.w3c.dom.Document;

/**
 *
 * @author sowjanya
 */
public class TestHotelRez {

    public static void main(String[] args) {

        try {

            String soapXml = getSource("/home/sowjanya/NetBeansProjects/Utils/src/HotelREZ/newXMLDocument3.xml");
            

          
            String wsURL = "https://pms.test.hotelrez.co.uk/cultuzz/1.0.0/ARIAndReservation";
            
            
                        
            PingRequest(soapXml, wsURL);
//            callRez( soapXml,  wsURL);
            
       


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
    
    public static  String callRez(String soapXml, String wsURL){
       String responseString = "";
            String outputString = "";
        try {
                 URL url = new URL(wsURL);
            URLConnection connection = url.openConnection();
            HttpsURLConnection httpConn = (HttpsURLConnection) connection;
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            String xmlInput
                    = " <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n"
                    + " <soapenv:Header/>\n"
                    + " <soapenv:Body>\n"
                    + soapXml
                    + " </soapenv:Body>\n"
                    + " </soapenv:Envelope>";

            System.out.println("XML INPUT:::" + xmlInput);
            byte[] buffer = new byte[xmlInput.length()];
            buffer = xmlInput.getBytes();
            bout.write(buffer);
            byte[] b = bout.toByteArray();
            String SOAPAction = "https://pms.test.hotelrez.co.uk/cultuzz/1.0.0/ARIAndReservation/";
// Set the appropriate HTTP parameters.
            httpConn.setRequestProperty("Content-Length",
                    String.valueOf(b.length));

            httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            httpConn.setRequestProperty("UserName", "cultuzz_pms");
          
            httpConn.setRequestProperty("Password", "yEJo;£-0Nv16");
//            httpConn.setRequestProperty("SOAPAction", SOAPAction);
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            OutputStream out = httpConn.getOutputStream();
//Write the content of the request to the outputstream of the HTTP Connection.
            out.write(b);
            out.close();
//Ready with sending the request.

//Read the response.
            InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
            BufferedReader in = new BufferedReader(isr);

//Write the SOAP message response to a String.
            while ((responseString = in.readLine()) != null) {
                outputString = outputString + responseString;
            }
            System.out.println("outputString::" + outputString);




        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputString;
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
    
    
    public static String PingRequest(String Req, String urlpath) {
        String pingResponse = "";
        Socket socket = null;
        BufferedReader rd = null;
        BufferedWriter wr = null;
        String line;
        try {

            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {

            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }
            };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {

                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }

             
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

            URL url = new URL(urlpath);
            URLConnection con = url.openConnection();
            con.setDoOutput(true);
            con.setRequestProperty("UserName", "cultuzz_pms");
            con.setRequestProperty("Password", "yEJo;£-0Nv16");

            System.out.println("REQUESY::"+Req);
            OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
            out.write(Req);
            out.flush();
            out.close();
            //out.write("requestor_id=" + requestor_id + "res_id=" + res_id + "resstatus=" + resstatus);
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

//	while (true) {
//	int ch = reader.read();
//	if (ch==-1) {
//	break;
//	}
//	System.out.print((char)ch);
//	}


            System.out.println("the path ::"+urlpath);

            while ((line = reader.readLine()) != null) {
                System.out.println(line + "\n");
                pingResponse = pingResponse + line + "\r\n";

            }
            System.out.println("the response is" + pingResponse);
        } catch (Exception ex) {
            ex.printStackTrace();
            //EmailNotif.sendMail("CA4(GR)-Expedia:Failed in the pingRequest method", EmailNotif.createMessage(ex));
        } finally {
            socket = null;
            rd = null;
            wr = null;
            line = null;
        }
        return pingResponse.trim();
    }

}
