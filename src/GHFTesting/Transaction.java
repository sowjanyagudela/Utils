/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GHFTesting;

import de.cultuzz.cpcchannel.ghf.LocalizedText;
import de.cultuzz.cpcchannel.ghf.ObjectFactory;
import de.cultuzz.cpcchannel.ghf.RoomPriceDataType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author sowjanya
 */
public class Transaction {

    static int n = 5;

    public static void main(String[] args) {
        try {
//            ObjectFactory objectFactory = new ObjectFactory();
//            objectFactory.createTransaction();
//            de.cultuzz.cpcchannel.ghf.Transaction.Result createTransactionResult = objectFactory.createTransactionResult();
//            
//            List<RoomPriceDataType> roomBundle = createTransactionResult.getRoomBundle();
//            RoomPriceDataType roomPriceDataType = objectFactory.createRoomPriceDataType();
//            RoomPriceDataType packageData = roomPriceDataType.getPackageData();
//            RoomPriceDataType roomData = roomPriceDataType.getRoomData();
//            LocalizedText localizedText = objectFactory.createLocalizedText();
//            LocalizedText.Text text = objectFactory.createLocalizedTextText();
//            text.getLanguage();
//            text.getText();
//            roomData.setName(localizedText);
//            
//            packageData.setRatePlanID("");
//            packageData.setOccupancy(Integer.SIZE);
//            

//            XMLGregorianCalendar s = Transaction.convertStringTimeToXmlGregorianCalendar("13:00:00", "HH:mm:ss", true, true);
//
////            System.out.println("stringToXMLGregorianCalendar:::" + s);
//
//            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
//            Date date = sdf.parse("13:00:00");
//            GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
//
//            XMLGregorianCalendar xmlGreCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
//
//            xmlGreCal.setTime(23,59,59);
//
////       XMLGregorianCalendar time = DatatypeFactory.newInstance().newXMLGregorianCalendarTime(xmlGreCal.getHour(), xmlGreCal.getMinute(), xmlGreCal.getSecond(),xmlGreCal.getTimezone());
//            XMLGregorianCalendar time = DatatypeFactory.newInstance().newXMLGregorianCalendarTime(xmlGreCal.getHour(), xmlGreCal.getMinute(), xmlGreCal.getSecond(), xmlGreCal.getFractionalSecond(), xmlGreCal.getTimezone());
//            time.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
//
//            System.out.println("== :: " + time);
//            
            String effectiveDate = "2016-06-27";
            SimpleDateFormat sdf_date = new SimpleDateFormat("yyyy-MM-dd");
            Calendar start = Calendar.getInstance();
            start.setTime(sdf_date.parse(effectiveDate));

            Date endReqDt = null;
            endReqDt = new Date();
            Calendar currClndr = Calendar.getInstance();
            currClndr.setTime(sdf_date.parse(effectiveDate));
            currClndr.add(Calendar.DATE, 4);
            endReqDt.setTime(currClndr.getTime().getTime());
            Calendar end = Calendar.getInstance();
            end.setTime(endReqDt);

            System.out.println("START::" + start.getTime());
            System.out.println("END::" + endReqDt.toString());
            for (Date date = start.getTime(); !start.after(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                System.out.println("DATE ::" + date);
            }
            
//            Double price=0.0;
//             price += Double.parseDouble("110");
//             System.out.println("Price::"+price);
//            Transaction t = new Transaction();
//
//            t.getNight();

//            XMLGregorianCalendar T = Transaction.convertStringDateToXmlGregorianCalendar("2015-06-25", "YYYY-mm-dd",  true);
//            
//            XMLGregorianCalendar xgc=DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-06-25");
//            System.out.println("TTTTTTTTTTTTT::"+xgc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static XMLGregorianCalendar convertStringDateToXmlGregorianCalendar(String dateStr, String dateFormat, boolean noTimezone) {
        try {
            // this may throw DatatypeConfigurationException
            DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
            GregorianCalendar calendar = new GregorianCalendar();
            // reset all fields
            calendar.clear();

            Calendar parsedCalendar = Calendar.getInstance();
            // eg "yyyy-MM-dd"
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            // this may throw ParseException
            Date rawDate = sdf.parse(dateStr);
            parsedCalendar.setTime(rawDate);

            // set date from parameter and leave time as default calendar values
            calendar.set(parsedCalendar.get(Calendar.YEAR),
                    parsedCalendar.get(Calendar.MONTH),
                    parsedCalendar.get(Calendar.DATE));

            XMLGregorianCalendar xmlCalendar = datatypeFactory.newXMLGregorianCalendar(calendar);
            // clears default timezone
            if (noTimezone) {
                xmlCalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
            }

            return xmlCalendar;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static XMLGregorianCalendar convertStringTimeToXmlGregorianCalendar(String timeStr, String timeFormat, boolean noFractionalSecs, boolean noTimezone) {
        try {
            // this may throw DatatypeConfigurationException
            DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
            GregorianCalendar calendar = new GregorianCalendar();
            // reset all fields
            calendar.clear();

            Calendar parsedCalendar = Calendar.getInstance();
            // eg "HH:mm:ss"
            SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
            // this may throw ParseException
            Date rawDate = sdf.parse(timeStr);
            parsedCalendar.setTime(rawDate);

            // set time from time parameter and set date to default values
            calendar.set(parsedCalendar.get(Calendar.HOUR),
                    parsedCalendar.get(Calendar.MINUTE),
                    parsedCalendar.get(Calendar.SECOND));

            XMLGregorianCalendar xmlCalendar = datatypeFactory.newXMLGregorianCalendar(calendar);
            // clears default timezone
            if (noTimezone) {
                xmlCalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
            }
            // clears default fractional seconds
            if (noFractionalSecs) {
                xmlCalendar.setFractionalSecond(null);
            }
            System.out.println("xmlCalendar::" + xmlCalendar);
            return xmlCalendar;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void getNight() {
        try {
            for (int i = 1; i <= n; i++) {

                System.out.println("hiii" + i);
//                for (int j = 1; j <= i; j++) {
////                    for (int k = 1; k < j; k++) {
//                        System.out.println("hello#####" + i);
////                    }
//                }
            }

//            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date startDate = new Date();
//            
//            System.out.println(dateFormat.format(startDate));
//            
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(startDate);
//            cal.add(Calendar.DATE, 180); // add 10 days
//            Date endDate = cal.getTime();
//            
//            
//            
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            Calendar start = Calendar.getInstance();
//            start.setTime(formatter.parse(dateFormat.format(startDate)));
//            Calendar end = Calendar.getInstance();
//            end.setTime(formatter.parse(dateFormat.format(endDate)));
//            
//            System.out.println("StarteDate::"+startDate);
//            System.out.println("EndDate::"+endDate);
//            for (Date d = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), d = start.getTime()) {
//                System.out.println("Date::"+d);
//                 for (int j = 1; j <= n; j++) {
//                    
//                    System.out.println("hello" + j);
//                    
//                }
//                
//            }
        } catch (Exception ex) {
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getStringDate(Date date) {

        String stringDate = null;
        SimpleDateFormat dateFormat = null;
        try {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            stringDate = dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            dateFormat = null;
        }
        return stringDate;
    }

}
