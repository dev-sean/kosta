package com.tutorialspoint;

import java.text.DateFormat;
import java.util.*;

public class SetWeekDate {

   public static void main(String[] args) {

      // create a calendar
      Calendar cal = Calendar.getInstance();

      cal.setWeekDate(1, 3, 2);
     
      System.out.println(cal.getTime());
   }
}