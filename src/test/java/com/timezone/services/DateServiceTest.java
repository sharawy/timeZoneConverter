/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.timezone.services;

import com.timezone.commons.Constants;
import com.timezone.models.TimeZoneModel;
import com.timezone.services.impl.DateServiceImpl;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author abdalrahman.sharawy
 */
public class DateServiceTest {
    static DateService instance; 
   
    @BeforeClass
    public static void setUpClass() {
        instance = new DateServiceImpl();
    }
    


    /**
     * Test of convertToTimeZone method, of class DateService.
     */
    @org.junit.Test
    public void testConvertToTimeZone() {
        System.out.println("convertToTimeZone");
        TimeZoneModel timeZone = new TimeZoneModel();
        timeZone.setTime("2016-11-16 04:06");
        timeZone.setZoneId("Asia/Riyadh");
        
        String expResult = "Fri Dec 16 15:06:00 GMT+02:00 2016";
        Date result = instance.convertToTimeZone(timeZone);
        System.out.println("expResult: "+expResult+" result: "+result);
        assertEquals(expResult, result.toString());
       
    }

    /**
     * Test of formateDate method, of class DateService.
     */
    @org.junit.Test
    public void testFormateDate() {
        System.out.println("formateDate");
        Date date = null;
        String format = Constants.timeDateFormat;
        String expResult = "2013-10-25 01:45";
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, 9);
        cal.set(Calendar.DATE, 24);
        cal.set(Calendar.YEAR, 2013);
        cal.set(Calendar.HOUR,13);
        cal.set(Calendar.MINUTE,45);
        cal.set(Calendar.SECOND,52);
        date = cal.getTime();
        String result = instance.formateDate(date, format);
        System.out.println("expResult: "+expResult+" result: "+result);

        assertEquals(expResult, result);
        
    }

   
    
}
