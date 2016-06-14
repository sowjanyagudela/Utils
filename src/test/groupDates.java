/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grouping;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author sowjanya
 */
public class groupDates {

    public ArrayList interval_days(String str_date, String end_date) {

        ArrayList listDates = new ArrayList();
        DateFormat formatter;
        try {
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date startDate = (java.util.Date) formatter.parse(str_date);
            java.util.Date endDate = (java.util.Date) formatter.parse(end_date);
            long interval = 24 * 1000 * 60 * 60; // 1 hour in millis
            long endTime = endDate.getTime(); // create your endtime here, possibly using Calendar or Date
            long curTime = startDate.getTime();
            while (curTime <= endTime) {
                String ds = formatter.format(new java.util.Date(curTime));
                listDates.add(ds);
                curTime += interval;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return listDates;
    }

    public List groupingDate(ArrayList al) {
        ArrayList finalList = new ArrayList();
        try {

            Iterator itr = al.iterator();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date endDt = new Date();
            Date stDt = new Date();

            String first_date = (String) itr.next();

            stDt = sdf.parse(first_date);

            Date tmpStDt = stDt;

            String start;
            String end;


            Calendar endCal = null;

            if (itr.hasNext()) {
                while (itr.hasNext()) {

                    String curr_date = (String) itr.next();

                    Date tmpDt = sdf.parse(curr_date);

                    long diff = tmpDt.getTime() - tmpStDt.getTime();
                    long days = diff / (1000 * 60 * 60 * 24);

                    if (days == 1) {
                    } else {


                        endDt = tmpStDt;
                        start = sdf.format(stDt);
                        end = sdf.format(endDt);

                        finalList.add(start + "#" + end);

                        stDt = tmpDt;

                    }

                    if (!itr.hasNext()) {
                        endDt = sdf.parse(curr_date);
                        endCal = Calendar.getInstance();
                        endCal.setTime(endDt);
                        start = sdf.format(stDt);
                        end = sdf.format(endCal.getTime());
                        finalList.add(start + "#" + end);
                        stDt = sdf.parse(curr_date);

                    }
                    tmpStDt = sdf.parse(curr_date);

                }
            } else {
                start = sdf.format(stDt);
                endCal = Calendar.getInstance();
                endCal.setTime(stDt);
                end = sdf.format(endCal.getTime());
                finalList.add(start + "#" + end);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

        return finalList;
    }

    public HashMap groupKeyValues(HashMap hm) {
        HashMap finalList = new HashMap();
        try {

            Map sorted_hm = new TreeMap(hm);

            Set keys = sorted_hm.keySet();

            Iterator dates_itr = keys.iterator();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            java.util.Date endDt = new java.util.Date();
            java.util.Date stDt = new java.util.Date();

            String first_date = (String) dates_itr.next();

            stDt = sdf.parse(first_date);

            java.util.Date tmpStDt = sdf.parse(first_date);

            Object value = (String) sorted_hm.get(first_date);


            if (dates_itr.hasNext()) {
                while (dates_itr.hasNext()) {

                    String curr_date = (String) dates_itr.next();

                    java.util.Date tmpDt = sdf.parse(curr_date);

                    long diff = tmpDt.getTime() - tmpStDt.getTime();
                    long days = diff / (1000 * 60 * 60 * 24);

                    String currValue = (String) sorted_hm.get(curr_date);

                    if (days == 1 && currValue.equalsIgnoreCase((String) value)) {
                    } else {
                        endDt = tmpStDt;
                        Calendar endCal = Calendar.getInstance();
                        endCal.setTime(endDt);
                        endCal.add(Calendar.DAY_OF_MONTH, 1);
                        String start = sdf.format(stDt);
                        String end = sdf.format(endCal.getTime());
                        Date endDate = endCal.getTime();

                        long diffd = endDate.getTime() - stDt.getTime();
                        long dayss = diffd / (1000 * 60 * 60 * 24);

                        finalList.put(start + "#" + end, value);
                        stDt = sdf.parse(curr_date);
                        value = currValue;
                    }
                    if (!dates_itr.hasNext()) {
                        endDt = sdf.parse(curr_date);
                        Calendar endCal = Calendar.getInstance();
                        endCal.setTime(endDt);
                        endCal.add(Calendar.DAY_OF_MONTH, 1);
                        String start = sdf.format(stDt);
                        String end = sdf.format(endCal.getTime());

                        Date endDate = endCal.getTime();

                        long diffd = endDate.getTime() - stDt.getTime();
                        long dayss = diffd / (1000 * 60 * 60 * 24);


                        finalList.put(start + "#" + end, value);
                        stDt = sdf.parse(curr_date);
                        value = currValue;
                    }
                    tmpStDt = sdf.parse(curr_date);
                }
            } else {
                String start = sdf.format(stDt);
                Calendar endCal = Calendar.getInstance();
                endCal.setTime(stDt);
                endCal.add(Calendar.DAY_OF_MONTH, 1);
                String end = sdf.format(endCal.getTime());

                Date endDate = endCal.getTime();

                long diffd = endDate.getTime() - stDt.getTime();
                long dayss = diffd / (1000 * 60 * 60 * 24);
                System.out.println("diffeence in days::::::::::" + dayss);

                finalList.put(start + "#" + end, value);
            }

            Map finaldatesmap = new TreeMap(finalList);
            Set finalKeys = finaldatesmap.keySet();
            Iterator itr = finalKeys.iterator();
            while (itr.hasNext()) {

                String key = (String) itr.next();
                String final_value = (String) finaldatesmap.get(key);


            }




        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalList;
    }

    public void groupbyString() {

        try {

            HashMap<Date, List<Integer>> hm = new HashMap();

            List<Integer> list = new ArrayList();
            List<Integer> list1 = new ArrayList();
            List<Integer> list2 = new ArrayList();

            list.add(11);
            list.add(22);

            list1.add(22);
            list1.add(33);

            list2.add(22);
            list2.add(11);
            list2.add(33);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            hm.put(sdf.parse("2013-08-12"), list);
//            hm.put(sdf.parse("2013-08-13"), list1);
//            hm.put(sdf.parse("2013-08-14"), list2);
//            hm.put(sdf.parse("2013-08-15"), list);
//            hm.put(sdf.parse("2013-08-16"), list1);

            System.out.println("HASHMP:::"+hm);
            HashMap<Integer, List<DatesBean>> prepareMap = prepareMap(hm);
            System.out.println("Updated Map" + prepareMap);

            Set<Integer> roomId = prepareMap.keySet();
            for (Integer rId : roomId) {


                List<DatesBean> datesBeans = prepareMap.get(rId);
                System.out.println("Room #" + rId + " : " + datesBeans.size());
                for (DatesBean datesBean : datesBeans) {
                    System.out.println("From Date :" + sdf.format(datesBean.getFromDate()));
                    System.out.println("To Date :" + sdf.format(datesBean.getToDate()));
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap prepareMap(HashMap<Date, List<Integer>> hm) {
        HashMap<Integer, List<DatesBean>> responseMap = null;
        try {
            if (hm != null && !hm.isEmpty()) {
                responseMap = new HashMap();
                TreeSet<Date> dateSet = new TreeSet(hm.keySet());
                System.out.println("DATESET::::" + dateSet);
                for (Date date : dateSet) {
                    List<Integer> roomIdList = hm.get(date);
//                    System.out.println("DAte:::" + date);
                    for (Integer roomId : roomIdList) {
                        if (responseMap.get(roomId) == null) {
                            responseMap.put(roomId, new ArrayList<DatesBean>());
                        }
//                        System.out.println("ROomMAP::" + responseMap);

                        List<DatesBean> updatedList = processRoomDatesList(responseMap.get(roomId), date);

                        responseMap.put(roomId, updatedList);
                       
                    }
                }
                System.out.println("Response::"+responseMap);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseMap;
    }

    private List<DatesBean> processRoomDatesList(List<DatesBean> listBean, Date date) {

        if (listBean != null) {

            if (listBean.isEmpty()) {
                listBean.add(new DatesBean());
            }
            DatesBean datesBean = listBean.get(listBean.size() - 1);

            /*
             * to set from/to Dates
             */
            if (datesBean.getFromDate() == null) {
                datesBean.setFromDate(date);
                datesBean.setToDate(date);
            }

            if (!datesBean.getToDate().equals(date)) {

                Date tempDate1 = new Date(datesBean.getToDate().getTime() + 24 * 60 * 60 * 1000);
                if (tempDate1.equals(date)) {
                    datesBean.setToDate(date);
                } else {
                    DatesBean datesBean1 = new DatesBean();
                    datesBean1.setFromDate(date);
                    datesBean1.setToDate(date);

                    listBean.add(datesBean1);

                    //}
                }
            }
        }
        return listBean;
    }

    public static void main(String[] args) {


        ArrayList al = new ArrayList();
        al.add("2013-08-02");
        al.add("2013-09-12");
        al.add("2013-08-03");
        al.add("2013-08-04");

        groupDates d = new groupDates();
//        List group = d.groupingDate(al);
//        System.out.println("Final List of Dates::" + group);

        HashMap hm = new HashMap();
        hm.put("2009-05-29", "a");
        hm.put("2009-05-22", "mno");
        hm.put("2009-05-21", "c");
        hm.put("2009-05-26", "xyz");
        hm.put("2009-05-27", "xyz");
        hm.put("2009-05-25", "pqr");
        hm.put("2009-05-30", "c");
        hm.put("2009-05-13", "mno");
        hm.put("2009-05-12", "mno");
        hm.put("2009-05-14", "abc");
        hm.put("2009-05-16", "abc");
        hm.put("2009-05-15", "abc");
//        HashMap groupKeyValues = d.groupKeyValues(hm);
//        TreeMap finaldatesmap = new TreeMap(groupKeyValues);
//        System.out.println("GROUPKEYVALUES:::;;" + finaldatesmap);

        d.groupbyString();
    }
}
