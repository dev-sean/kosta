package com.tutorialspoint;

import java.util.*;

public class SetTimeZone {

   public static void main(String[] args) {

      // create a calendar
      Calendar cal = Calendar.getInstance();

      // print current time zone
      String name=cal.getTimeZone().getDisplayName();
      System.out.println("Current Time Zone:" + name );
      TimeZone tz = TimeZone.getTimeZone("GMT");

      // set the time zone with the given time zone value 
      // and print it
      cal.setTimeZone(tz);
      System.out.println(cal.getTimeZone().getDisplayName());
   }
}