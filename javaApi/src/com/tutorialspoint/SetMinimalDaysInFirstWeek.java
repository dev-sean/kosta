package com.tutorialspoint;

import java.util.*;

public class SetMinimalDaysInFirstWeek {

   public static void main(String[] args) {

      // create a calendar
      Calendar cal = Calendar.getInstance();

      // get what is the minimal days required in the first week
      int min = cal.getMinimalDaysInFirstWeek();
      System.out.println("Minimal Days in Week: " + min);

      // set the minimal days required in the first week
      cal.setMinimalDaysInFirstWeek(2);

      // print the result
      min = cal.getMinimalDaysInFirstWeek();
      System.out.println("Minimal Days in Week: " + min);
   }
}