/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.timezone.services.impl;

import com.timezone.models.TimeZoneModel;
import com.timezone.services.DateService;
import com.timezone.commons.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalrahman.sharawy
 */
@Service
public class DateServiceImpl implements DateService{
    
    @Override
    public Date convertToTimeZone(TimeZoneModel timeZone){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.timeDateFormat);
        Calendar localTime = Calendar.getInstance();

        LocalDateTime dateTime = LocalDateTime.parse(timeZone.getTime(), formatter);
        localTime.set(Calendar.HOUR, dateTime.getHour());
        localTime.set(Calendar.MINUTE, dateTime.getMinute());
        localTime.set(Calendar.SECOND, dateTime.getSecond());
        localTime.set(Calendar.DAY_OF_MONTH, dateTime.getDayOfMonth());
        localTime.set(Calendar.MONTH, dateTime.getMonthValue());
        localTime.set(Calendar.YEAR, dateTime.getYear());
        localTime.setTimeZone(java.util.TimeZone.getTimeZone(timeZone.getZoneId()));
        ///convert timeZone
        Calendar convertedTime = new GregorianCalendar(java.util.TimeZone.getTimeZone(timeZone.getZoneId()));
        convertedTime.setTimeInMillis(localTime.getTimeInMillis());
        int hour = convertedTime.get(Calendar.HOUR);
	int minute = convertedTime.get(Calendar.MINUTE);
	int second = convertedTime.get(Calendar.SECOND);
	int year = convertedTime.get(Calendar.YEAR);
        
        return convertedTime.getTime();
    }
    
    @Override
    public String formateDate(Date date,String format){
    String formatedTimeDate = new SimpleDateFormat(format).format(date);
    return formatedTimeDate;
    }
}
