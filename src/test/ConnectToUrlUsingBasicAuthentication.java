/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author sowjanya
 */
public class ConnectToUrlUsingBasicAuthentication {
    public static void main(String[] args) {

		try {
			String webPage = "https://ws.interhome.com/test/irent/pushsvc/v1";
			String name = "INWEBUSR";
			String password = "incoming";

			String authString = name + ":" + password;
			System.out.println("auth string: " + authString);
			byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
			String authStringEnc = new String(authEncBytes);
			System.out.println("Base64 encoded auth string: " + authStringEnc);

			URL url = new URL(webPage);
			URLConnection urlConnection = url.openConnection();
			urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);

			int numCharsRead;
			char[] charArray = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numCharsRead = isr.read(charArray)) > 0) {
				sb.append(charArray, 0, numCharsRead);
			}
			String result = sb.toString();

			System.out.println("*** BEGIN ***");
			System.out.println(result);
			System.out.println("*** END ***");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//	}

//    public static void main(String[] args) {
//
//        try {
//            URL url = new URL("https://ws.interhome.com/test/irent/pushsvc/v1");
//            String encoding = "INWEBUSR:incoming";
////            String encoding = Base64Encoder.encode("test1:test1");
//            Base64.encodeBase64(encoding.getBytes());
//
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("POST");
//            connection.setDoOutput(true);
//            connection.setRequestProperty("Authorization", "Basic " + encoding);
//            InputStream content = (InputStream) connection.getInputStream();
//            BufferedReader in
//                    = new BufferedReader(new InputStreamReader(content));
//            String line;
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//            }

//            URL url = new URL("ftp://ihpushpartner:2xvBjlPq@ftp.interhome.com");
//            URLConnection urlc = url.openConnection();
//            InputStream is = urlc.getInputStream(); // To download
//
//            InputStreamReader isr = new InputStreamReader(is);
//
//            int numCharsRead;
//            char[] charArray = new char[1024];
//            StringBuffer sb = new StringBuffer();
//            while ((numCharsRead = isr.read(charArray)) > 0) {
//                sb.append(charArray, 0, numCharsRead);
//            }
//            String result = sb.toString();
//
//            System.out.println("*** BEGIN ***");
//            System.out.println(result);
//            System.out.println("*** END ***");
//            
//            ConnectToUrlUsingBasicAuthentication ctuuba= new ConnectToUrlUsingBasicAuthentication();
//            ctuuba.downloadFile();

//            OutputStream os = urlc.getOutputStream(); // To upload
         catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void downloadFile() {

        try {

            FTPClient client = new FTPClient();
            FileOutputStream fos = null;

            client.connect("ftp.interhome.com");
            client.login("ihpushpartner", "2xvBjlPq");

            String filename = "Push_SVC.wsdl";
            fos = new FileOutputStream(filename);

            client.retrieveFile("/" + filename, fos);
            System.out.println("FILENAME::"+client.getRemoteAddress());
            fos.close();
            client.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
