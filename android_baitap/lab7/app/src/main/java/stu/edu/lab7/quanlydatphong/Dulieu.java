package stu.edu.lab7.quanlydatphong;

import stu.edu.lab7.model.DatPhong;
import java.util.ArrayList;
public class Dulieu {
    public static ArrayList<DatPhong> dsDatPhong;
    static{
        dsDatPhong = new ArrayList<>();
    }
    public static DatPhong layDatPhong (int index) {
        if (index > 0 && index < dsDatPhong.size())
            return dsDatPhong.get(index); return null;
    }
    public static void themDatPhong (DatPhong datPhong){
         dsDatPhong.add(datPhong);
    }

    public static void xoaDatPhong (int index) {
        if (index >= 0 && index < dsDatPhong.size())
            dsDatPhong.remove (index);
    }
}
