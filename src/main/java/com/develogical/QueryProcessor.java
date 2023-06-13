package com.develogical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import com.sun.tools.javac.util.List;

public class QueryProcessor {

  public String process(String query) {

    System.out.println("Received query:" + query);

    if (query.toLowerCase().contains("shakespeare")) {
      return "William Shakespeare (26 April 1564 - 23 April 1616) was an "
          + "English poet, playwright, and actor, widely regarded as the greatest "
          + "writer in the English language and the world's pre-eminent dramatist.";
    }

    if (query.toLowerCase().contains("your name")) {
      return "Tushita";
    }

    if (query.toLowerCase().contains("largest")) {
      String numbers = query.replace("Which of the following numbers is the largest: ", "");
      String number = numbers.replace("?", "");

      String[] singleNumbers = number.split(",");
      ArrayList<Integer> trimmedNos = new ArrayList<>();


      for (String s: singleNumbers) {
        trimmedNos.add(Integer.parseInt(s.trim()));
      }

      int max = trimmedNos.stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax();

      
      return String.valueOf(max);
    }

    if (query.toLowerCase().contains("plus")) {

      String splitQuery = query.replace("What is", "");
      String removePlus = splitQuery.replace("plus", "");
      String removeQuestion = removePlus.replace("?", "");
      String[] numbers = removeQuestion.trim().split("  ");
      int sum = 0;

      for (String n: numbers) {
        sum += (int)Integer.parseInt(n.trim());
      }

      return String.valueOf(sum);
    }

    return "";
  }
}
