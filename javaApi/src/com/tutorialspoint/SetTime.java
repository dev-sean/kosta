package com.tutorialspoint;

import java.util.*;

public class SetTime {

   public static void main(String[] args) {

      // create a calendar
      Calendar cal = Calendar.getInstance();

      // get the current time
      System.out.println("Current time is :" + cal.getTime());

      // create new date and set it
      Date date = new Date(95, 10, 10);
      cal.setTime(date);
	  
      // print the new time
      System.out.println("After setting Time:  " + cal.getTime());
   }
}