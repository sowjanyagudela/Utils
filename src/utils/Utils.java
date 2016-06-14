/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sowjanya
 */
public class Utils {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            
            
            
            URL url = new URL("http://collaboration.cultuzz.de:8080");
            
            url.getHost();
            url.getPath();
            
            System.out.println("DETAILS:::"+url.getHost()+":"+url.getPath()+":"+url.getPort());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
