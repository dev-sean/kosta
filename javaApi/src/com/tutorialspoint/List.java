package com.tutorialspoint;

import java.util.*;

public class List {

   public static void main(String[] args) {
      Properties prop = new Properties();

      // add some properties
      prop.put("Height", "200");
      prop.put("Width", "150");
      prop.put("Scannable", "true");

      // print the list with System.out
      prop.list(System.out);

   }
}