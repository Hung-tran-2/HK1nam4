package stu.edu.lab7.util;

public class RandomUtil {
   public static String getALphaNumericString(int n){
       String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
       StringBuilder sb = new StringBuilder(n);
       for (int i = 0; i < n; i++) {
           int index = (int)(alphaNumericString.length() * Math.random());
       }

       return sb.toString();
   }
}
