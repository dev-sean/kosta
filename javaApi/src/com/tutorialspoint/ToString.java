package com.tutorialspoint;

import java.util.*;

public class ToString {

   public static void main(String[] args) {

      // create a calendar
      Calendar cal = Calendar.getInstance();
      
      // return a string representation of this calendar.
      System.out.println(cal.getTime().toString());
   }
}