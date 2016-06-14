import com.cultuzz.availrs.AvailUpdateNotifRQ;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.codec.binary.Base64;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sowjanya
 */
public class decodeXML {

    private static JAXBContext availUpdate_jxbc;

    public static void main(String[] args) {
        try {

            String file = "/home/sowjanya/NetBeansProjects/Utils/test/sampleAvailUpdate.xml";
            decodeXML dexml = new decodeXML();

            AvailUpdateNotifRQ availUpdateNotifRQ = (AvailUpdateNotifRQ) dexml.getAvailUpdateUnmarshaller().unmarshal(new File(file));
            System.out.println("AVAIl::" + availUpdateNotifRQ);
           
            
            
        } catch (JAXBException ex) {
            Logger.getLogger(decodeXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public JAXBContext getAvailUpdateJaxbContext() {
        try {
            if (availUpdate_jxbc == null) {
                availUpdate_jxbc = JAXBContext.newInstance("com.cultuzz.availrs");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return availUpdate_jxbc;
    }

    //=============== Tiscover Unmarshaller =================
    public Unmarshaller getAvailUpdateUnmarshaller() {
        Unmarshaller tiscover_unm = null;
        try {
            tiscover_unm = getAvailUpdateJaxbContext().createUnmarshaller();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tiscover_unm;
    }

}
