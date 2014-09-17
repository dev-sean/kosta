package com.tutorialspoint;

import java.util.*;

public class GetProperty {

   public static void main(String[] args) {
      Properties prop = new Properties();

      // add some properties
      prop.put("Height", "200");
      prop.put("Width", "150");
      prop.put("Scannable", "true");

      // get two properties and print them
      System.out.println("" + prop.getProperty("Scannable"));
      System.out.println("" + prop.getProperty("Width"));

   }
}