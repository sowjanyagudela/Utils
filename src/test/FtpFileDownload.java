/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author sowjanya
 */
import org.apache.commons.net.ftp.FTPClient;
	import java.io.IOException;
	import java.io.FileOutputStream;

public class FtpFileDownload {

    public static void main(String[] args) {

        FTPClient client = new FTPClient();

        FileOutputStream fos = null;

        try {

            client.connect("ftp.interhome.com");

            client.login("ihpushpartner", "2xvBjlPq");

            // Create an OutputStream for the file
            String filename = "Push_SVC.wsdl";

            fos = new FileOutputStream(filename);

            // Fetch file from server
            client.retrieveFile("/" + filename, fos);

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (fos != null) {

                    fos.close();

                }

                client.disconnect();

            } catch (IOException e) {

                e.printStackTrace();

            }
        }

    }
}
