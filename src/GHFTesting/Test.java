/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GHFTesting;

/**
 *
 * @author sowjanya
 */
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.codec.binary.Base64;

class Test extends Thread {

    boolean keepRunning = true;

    public void run() {
        while (keepRunning) {
            //keepRunning = false;
            //System.out.println("Debug @ stmt :: keepRunning in run ");
        }

        System.out.println("Thread terminated.");
    }

    public static void main(String[] args) throws InterruptedException {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<OTA_HotelRoomListRQ EchoToken=\"9876\" Target=\"Production\" Version=\"1.002\" xmlns=\"http://www.opentravel.org/OTA/2003/05\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.opentravel.org/OTA/2003/05 OTA_HotelRoomListRQ.xsd\">\n"
                + "    <POS>\n"
                + "        <Source>\n"
                + "            <RequestorID Type=\"10\" ID=\"12400\"/>\n"
                + "            <BookingChannel Type=\"7\"/>\n"
                + "        </Source>\n"
                + "    </POS>\n"
                + "    <HotelRoomLists>\n"
                + "        <HotelRoomList>\n"
                + "            <RoomStays>\n"
                + "                <RoomStay>\n"
                + "                    <RoomTypes>\n"
                + "                          <RoomType RoomTypeCode=\"82665\">\n"
                + "                            <RoomDescription Name=\"EZ Komfort\">\n"
                + "                                <Text><![CDATA[EZ Komfort]]></Text>\n"
                + "                            </RoomDescription>\n"
                + "                            <AdditionalDetails>\n"
                + "                                <AdditionalDetail Code=\"7\" Type=\"4\"/>\n"
                + "                            </AdditionalDetails>\n"
                + "                        </RoomType>\n"
                + "                          <RoomType IsRoom=\"false\" NumberOfUnits=\"50\" RoomTypeCode=\"PD107637\"/>\n"
                + "                    </RoomTypes>\n"
                + "              <RatePlans>\n"
                + "                        <RatePlan RatePlanID=\"108637\" RatePlanName=\"EZ Komfort\" RatePlanType=\"11\">\n"
                + "                            <Guarantee GuaranteeCode=\"1\" GuaranteeType=\"None\"/>\n"
                + "                            <AdditionalDetails/>\n"
                + "                            <RatePlanDescription Name=\"Single Room Comfort         \">\n"
                + "                                <Text Formatted=\"true\" Language=\"en\"><![CDATA[Single Room Comfort]]></Text>\n"
                + "                            </RatePlanDescription>\n"
                + "                            <CancelPenalties/>\n"
                + "                            <MealsIncluded Breakfast=\"true\" MealPlanCodes=\"[11]\"/>\n"
                + "                            <CancelPenalties>\n"
                + "                                <CancelPenalty ConfirmClassCode=\"CancelPolicy\">\n"
                + "                                    <Deadline OffsetDropTime=\"BeforeArrival\"\n"
                + "                                              OffsetTimeUnit=\"Hour\" OffsetUnitMultiplier=\"24\"/>\n"
                + "                                    <AmountPercent BasisType=\"FullStay\" NmbrOfNights=\"0\" Amount=\"0.00\"/>\n"
                + "                                </CancelPenalty>\n"
//                + "                                <CancelPenalty ConfirmClassCode=\"CancelPolicy\">\n"
//                + "                                    <Deadline OffsetDropTime=\"BeforeArrival\"\n"
//                + "                                              OffsetTimeUnit=\"Day\" OffsetUnitMultiplier=\"10\"/>\n"
//                + "                                    <AmountPercent BasisType=\"FullStay\" NmbrOfNights=\"1\" Percent=\"30.00\"/>\n"
//                + "                                </CancelPenalty>\n"
//                + "                                <CancelPenalty ConfirmClassCode=\"CancelPolicy\">\n"
//                + "                                    <Deadline OffsetDropTime=\"BeforeArrival\"\n"
//                + "                                              OffsetTimeUnit=\"Day\" OffsetUnitMultiplier=\"5\"/>\n"
//                + "                                    <AmountPercent BasisType=\"FullStay\" NmbrOfNights=\"1\" Percent=\"20.00\"/>\n"
//                + "                                </CancelPenalty>\n"
//                + "                                <CancelPenalty ConfirmClassCode=\"NoShowPolicy\">\n"
//                + "                                    <Deadline/>\n"
//                + "                                    <AmountPercent BasisType=\"FullStay\" Percent=\"40.00\"/>\n"
//                + "                                </CancelPenalty>\n"
                + "                            </CancelPenalties>\n"
                + "                        </RatePlan>\n"
                + "                    </RatePlans>\n"
                + "                    <RoomRates>\n"
                + "                        <RoomRate NumberOfUnits=\"1\" RatePlanID=\"108637\"\n"
                + "                                  RatePlanType=\"11\" RoomTypeCode=\"82665\"/>\n"
                + "                        <RoomRate RatePlanID=\"108637\" RatePlanType=\"11\" RoomTypeCode=\"PD108637\">\n"
                + "                            <Rates>\n"
                + "                                <Rate Duration=\"1\" EffectiveDate=\"2015-07-26\"\n"
                + "                                           GuaranteedInd=\"true\" MaxLOS=\"999\" MinLOS=\"1\" NumberOfUnits=\"9\">\n"
                + "                                    <RateDescription\n"
                + "                                        LastModifyDateTime=\"2014-04-09T00:00:00\" Name=\"AvailabilityReport\">\n"
                + "                                        <ListItem ListItem=\"11\"><![CDATA[InventoryValidityAvail]]></ListItem>\n"
                + "                                        <ListItem ListItem=\"31\"><![CDATA[InventoryNoOfUnitsAvail]]></ListItem>\n"
                + "                                        <ListItem ListItem=\"51\"><![CDATA[InventoryDayPriceAvail]]></ListItem>\n"
                + "                                        <ListItem ListItem=\"17\"><![CDATA[ProductValidityAvail]]></ListItem>\n"
                + "                                        <ListItem ListItem=\"18\"><![CDATA[ProductArrivalDayAvail]]></ListItem>\n"
                + "                                        <ListItem ListItem=\"10\"><![CDATA[ProductDepartureDayAvail]]></ListItem>\n"
                + "                                        <ListItem ListItem=\"16\"><![CDATA[ProductAvailableDayAvail]]></ListItem>\n"
                + "                                        <ListItem ListItem=\"14\"><![CDATA[ProductNonRoomValidity]]></ListItem>\n"
                + "                                    </RateDescription>\n"
                + "                                    <Base AmountAfterTax=\"75.00\" CurrencyCode=\"EUR\"/>\n"
                + "                                    <CancelPolicies/>\n"
                + "                                    <PaymentPolicies>\n"
                + "                                        <GuaranteePayment GuaranteeCode=\"1\"\n"
                + "                                                          GuaranteeType=\"None\" RPH=\"GuaranteePolicy\"/>\n"
                + "                                    </PaymentPolicies>\n"
                + "                                    <TPA_Extensions>\n"
                + "                                        <Descriptions>\n"
                + "                                            <Description Name=\"RateDescription\">\n"
                + "                                                <Text Language=\"EN\"><![CDATA[Price breakup description for 2 adult(s)]]></Text>\n"
                + "                                                <Text Language=\"EN\"><![CDATA[Price is calculated for 2 adult(s)]]></Text>\n"
                + "                                                <Text Language=\"EN\"><![CDATA[Added Child amount of '0.0' to Total calculated price of '65.0': [ 65.0 ]]]></Text>\n"
                + "                                            </Description>\n"
                + "                                        </Descriptions>\n"
                + "                                    </TPA_Extensions>\n"
                + "                                </Rate>\n"
                + "                                <Rate Duration=\"1\" EffectiveDate=\"2015-07-27\"\n"
                + "                                      GuaranteedInd=\"true\" MaxLOS=\"999\" MinLOS=\"1\" NumberOfUnits=\"18\">\n"
                + "                                    <RateDescription\n"
                + "                                        LastModifyDateTime=\"2014-04-09T00:00:00\" Name=\"AvailabilityReport\">\n"
                + "                                        <ListItem ListItem=\"9\"><![CDATA[InventoryValidityAvail]]></ListItem>\n"
                + "                                        <ListItem ListItem=\"99\"><![CDATA[InventoryNoOfUnitsAvail]]></ListItem>\n"
                + "                                        <ListItem ListItem=\"12\"><![CDATA[InventoryDayPriceAvail]]></ListItem>\n"
                + "                                        <ListItem ListItem=\"23\"><![CDATA[ProductValidityAvail]]></ListItem>\n"
                + "                                        <ListItem ListItem=\"56\"><![CDATA[ProductArrivalDayAvail]]></ListItem>\n"
                + "                                        <ListItem ListItem=\"85\"><![CDATA[ProductDepartureDayAvail]]></ListItem>\n"
                + "                                        <ListItem ListItem=\"98\"><![CDATA[ProductAvailableDayAvail]]></ListItem>\n"
                + "                                        <ListItem ListItem=\"75\"><![CDATA[ProductNonRoomValidity]]></ListItem>\n"
                + "                                    </RateDescription>\n"
                + "                                    <Base AmountAfterTax=\"65.00\" CurrencyCode=\"EUR\"/>\n"
                + "                                    <CancelPolicies/>\n"
                + "\n"
                + "\n"
                + "                                    <PaymentPolicies>\n"
                + "                                        <GuaranteePayment GuaranteeCode=\"1\"\n"
                + "                                                          GuaranteeType=\"None\" RPH=\"GuaranteePolicy\"/>\n"
                + "                                    </PaymentPolicies>\n"
                + "                                    <TPA_Extensions>\n"
                + "                                        <Descriptions>\n"
                + "                                            <Description Name=\"RateDescription\">\n"
                + "                                                <Text Language=\"EN\"><![CDATA[Price breakup description for 1 adult(s)]]></Text>\n"
                + "                                                <Text Language=\"EN\"><![CDATA[Price is calculated for 1 adult(s)]]></Text>\n"
                + "                                                <Text Language=\"EN\"><![CDATA[Added Child amount of '0.0' to Total calculated price of '65.0': [ 65.0 ]]]></Text>\n"
                + "                                            </Description>\n"
                + "                                        </Descriptions>\n"
                + "                                    </TPA_Extensions>\n"
                + "                                </Rate>\n"
                + "                            </Rates>\n"
                + "                        </RoomRate>\n"
                + "                    </RoomRates>\n"
                + "                    <GuestCounts>\n"
                + "                        <GuestCount AgeQualifyingCode=\"10\" Count=\"1\"/>\n"
                + "                    </GuestCounts>\n"
                + "                    <TimeSpan End=\"2015-07-28\" Start=\"2015-07-26\"/>\n"
                + "                    <BasicPropertyInfo HotelCode=\"12400\" HotelName=\"CultSwitchDocHotel\">\n"
                + "                        <Address FormattedInd=\"false\">\n"
                + "                            <StreetNmbr><![CDATA[3rd Lane Ganta Arcade]]></StreetNmbr>\n"
                + "                            <CityName><![CDATA[Visakhapatnam]]></CityName>\n"
                + "                            <PostalCode><![CDATA[859623]]></PostalCode>\n"
                + "                            <StateProv><![CDATA[Berlin]]></StateProv>\n"
                + "                            <CountryName Code=\"de\"><![CDATA[Deutschland]]></CountryName>\n"
                + "                        </Address>\n"
                + "                    </BasicPropertyInfo>\n"
                + "                </RoomStay>\n"
                + "            </RoomStays>\n"
                + "        </HotelRoomList>\n"
                + "    </HotelRoomLists>\n"
                + "</OTA_HotelRoomListRQ>";
        String start = str.substring(str.indexOf("<?xml"), str.indexOf("<HotelRoomList>"));
        String end = str.substring(str.indexOf("</HotelRoomList>") + 16, str.indexOf("</OTA_HotelRoomListRQ>") + 22);

//        System.out.println("start::" + start);
//        System.out.println("end::" + end);

        int first = str.indexOf("<HotelRoomList>");
        int second = str.indexOf("</HotelRoomList>");
        String newString = str.substring(first, second + 16);
        String encodingString = new String(Base64.encodeBase64(newString.getBytes()));
//                System.out.println("encodingString:"+encodingString);
        StringBuffer sb = new StringBuffer();
        Integer objektID = 12400;
        String CSUUID = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
        sb.append("<OTA_HotelRoomListRQ xmlns=\"http://www.opentravel.org/OTA/2003/05\" TimeStamp=\"" + sdf.format(new Date()) + "\" TransactionIdentifier=\"" + CSUUID + "\" Target=\"Production\" Version=\"3.00\" >");
        sb.append("<POS>");
        sb.append("\n<Source>\n");
        sb.append("<RequestorID Type=\"10\" ID=\"" + objektID + "\"/>");
        sb.append("<BookingChannel Type=\"7\"/>\n</Source>\n");
        sb.append("</POS>\n");
        sb.append("<HotelRoomLists>");
        sb.append(encodingString);
        sb.append("</HotelRoomLists></OTA_HotelRoomListRQ>");

                        System.out.println("SBBBB::"+sb.toString());
//        String descodeString = new String(Base64.decodeBase64(sb.toString().getBytes()));

//        System.out.println("DECODEDDDDDDDDD:::" + descodeString);
                        
                 

    }

    public static long getNoOfDaysBetween(String inputString1, String inputString2) {

        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date date2 = null;
        long convert = -1;
        try {
            date1 = myFormat.parse(inputString1);

            date2 = myFormat.parse(inputString2);

            long diff = date2.getTime() - date1.getTime();
            System.out.println("date2.getTime() - date1.getTime():" + diff);
            convert = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        } catch (ParseException e) {
            e.printStackTrace();

        } finally {
            date1 = null;
            date2 = null;
            myFormat = null;
        }

        return convert;
    }

}
