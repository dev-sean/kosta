package com.tutorialspoint;

import java.util.*;

public class GetProperty1 {

   public static void main(String[] args) {
      Properties prop = new Properties();

      // add some properties
      prop.put("Height", "200");
      prop.put("Width","250");
      prop.put("Scannable", "true");

      // get two properties and print them
      System.out.println("" + prop.getProperty("Scannable","false"));
      System.out.println("" + prop.getProperty("Width","150"));

   }
}