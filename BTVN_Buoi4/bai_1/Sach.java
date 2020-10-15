package bai_1;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Sach {
    private String maSach;
    private String tenSach;
    private String nxb;
    private int soTrang;
    private double giaTien;

    static Locale localeVN = new Locale("vi","VN");
    static NumberFormat curVN = NumberFormat.getCurrencyInstance(localeVN);
    public void Input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sách : ");
        maSach = scanner.nextLine();
        System.out.print("Nhập tên sách : ");
        tenSach = scanner.nextLine();
        System.out.print("Nhập NXB : ");
        nxb = scanner.nextLine();
        System.out.print("Nhập số trang : ");
        soTrang = scanner.nextInt();
        System.out.print("Nhập giá tiền : ");
        giaTien = scanner.nextDouble();
    }

//    public void Output(){
//        System.out.print("Mã sách : " + maSach);
//        System.out.print("\tTên sách : " + tenSach);
//        System.out.print("\tNXB : " + nxb);
//        System.out.print("\tSố trang : " + soTrang);
//        System.out.println("\tGiá tiền : " + curVN.format(giaTien));
//    }
    public void output(){
        System.out.printf("%-20s%-20s%-20s%-20d%-20s",maSach, tenSach, nxb, soTrang, curVN.format(giaTien) );
        System.out.println();
    }
    public Sach() {
    }

    public Sach(String maSach, String tenSach, String nxb, int soTrang, double giaTien) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.nxb = nxb;
        this.soTrang = soTrang;
        this.giaTien = giaTien;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getNxb() {
        return nxb;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public double getGiaTien() {
        return giaTien;
    }
}
