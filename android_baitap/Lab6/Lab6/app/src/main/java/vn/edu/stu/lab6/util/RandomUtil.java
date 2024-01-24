package vn.edu.stu.lab6.util;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import vn.edu.stu.lab6.R;

public class RandomUtil  {
    public static String getAphaNumericString(int n) {
        String alphaNumericString = "ACDADSASDÁDASDASDASDAS";
        StringBuilder sb = new StringBuilder(n);
        for (int i =0; i < n; i++) {
            int index = (int) (alphaNumericString.length() * Math.random());
            sb.append(alphaNumericString.charAt(index));
        }
        return  sb.toString();

        }
}