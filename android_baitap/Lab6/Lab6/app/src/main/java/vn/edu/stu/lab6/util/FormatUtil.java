package vn.edu.stu.lab6.util;

import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Date;


public class FormatUtil  {
    static SimpleDateFormat sdfDaTeTime
            = new SimpleDateFormat ("dd/MM/yyyy hh:mm aa");
    static SimpleDateFormat sdfDaTe =
            new SimpleDateFormat("dd/MM/yyyy");
    static SimpleDateFormat sdfTime =
            new SimpleDateFormat("hh:mm aa");
    public static String formatDateTime(Date date) {
        return sdfDaTeTime.format(date);
    }
    public  static String formatDate(Date date) {
        return sdfDaTe.format(date);
    }
    public static String formatTime(Date date) {
        return sdfTime.format(date);
    }

}