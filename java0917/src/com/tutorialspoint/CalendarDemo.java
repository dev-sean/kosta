package com.tutorialspoint;

import java.util.*;

public class CalendarDemo {

   public static void main(String[] args) {

      // create a calendar
      Calendar cal = Calendar.getInstance();
      Calendar cal1 = Calendar.getInstance();
      Calendar cal2 = Calendar.getInstance();

      // get what is the minimal days required in the first week
      int min = cal.getMinimalDaysInFirstWeek();
      System.out.println("Minimal Days in Week: " + min);

      // set the minimal days required in the first week
      cal.setMinimalDaysInFirstWeek(30);
      cal.set(2014, 10, 1);
      cal1.set(2014, 11, 1);
      
      // print the result
      min = cal.getMinimalDaysInFirstWeek();
      System.out.println("Minimal Days in Week: " + min);
   }
}