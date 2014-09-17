package com.tutorialspoint;

import java.io.PrintWriter;
import java.util.*;

public class List1 {

   public static void main(String[] args) {
      Properties prop = new Properties();
      PrintWriter writer = new PrintWriter(System.out);

      // add some properties
      prop.put("Height", "200");
      prop.put("Width", "150");
      prop.put("Scannable", "true");

      // print the list with a PrintWriter object
      prop.list(writer);

      // flush the stream
      writer.flush();

   }
}