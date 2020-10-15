package bai_3;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Hang {
    private String maHang;
    private String tenHang;
    private double donGia;

    static Locale localeVN = new Locale("vi","VN");
    static NumberFormat curVN = NumberFormat.getCurrencyInstance(localeVN);
    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã hàng : ");
        maHang = scanner.nextLine();
        System.out.print("Nhập tên hàng : ");
        tenHang = scanner.nextLine();
        System.out.print("Nhập đơn giá : ");
        donGia = scanner.nextDouble();
    }

    public void output(){
        System.out.printf("%-10s%-20s%-15s",maHang, tenHang, curVN.format(donGia));
        System.out.println();
    }
    public Hang() {
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public double getDonGia() {
        return donGia;
    }

    public Hang(String maHang, String tenHang, double donGia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donGia = donGia;
    }
}
