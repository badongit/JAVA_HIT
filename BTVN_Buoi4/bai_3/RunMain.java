package bai_3;

import java.text.NumberFormat;
import java.util.Locale;

public class RunMain {
    public static Locale localeVN = new Locale("vi","VN");
    public static NumberFormat curVN = NumberFormat.getCurrencyInstance(localeVN);
    public static void main(String[] args) {
        Phieu a = new Phieu();
        a.input();
        a.output();
        System.out.println("\t\t\t\t Tổng hóa đơn = " + curVN.format(a.total()));
    }
}
