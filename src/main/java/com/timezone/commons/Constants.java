/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.timezone.commons;

/**
 *
 * @author abdalrahman.sharawy
 */
public class Constants {
  public final static String timeDateFormat = "yyyy-MM-dd HH:mm";
  public static class RestApi{
        public final static String getTimeZoneUrl = "/timeZones";
        public final static String convertTimeZoneUrl = "/convertTimeZone";     
        
  }
  public static class messages{
   public final static String notFound = "not found";
        public final static String failed = "failed";
        public final static String success = "success";
        public final static String timeNotNull="time field should not be null";
        public final static String internalError = "internal server error contact with web admin.";
       public final static String illegalValues = "Illegal request, please verify  your payload.";

  }
}
