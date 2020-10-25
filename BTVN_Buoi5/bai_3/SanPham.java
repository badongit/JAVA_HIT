package bai_3;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class SanPham {
    private String maSP;
    private String tenSP;
    private int soLuong;
    private double donGia;

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sản phầm : ");
        maSP = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm : ");
        tenSP = scanner.nextLine();
        System.out.print("Nhập số lượng : ");
        soLuong = scanner.nextInt();
        System.out.print("Nhập đơn giá : ");
        donGia = scanner.nextDouble();
    }
    public void output(){
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat curVN = NumberFormat.getCurrencyInstance(localeVN);
        System.out.printf("%-15s%-25s%-15d%-20s%-20s\n", maSP, tenSP, soLuong, curVN.format(donGia), curVN.format(donGia*soLuong));
    }
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public SanPham(String maSP, String tenSP, int soLuong, double donGia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public SanPham() {
    }
}
