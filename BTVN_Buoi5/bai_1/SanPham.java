package bai_1;

import java.util.Scanner;

public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private String tenHangSanXuat;
    private String ngayNhap;

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sản phầm : ");
        maSanPham = scanner.nextLine();
        System.out.print("Nhập tên sản phầm : ");
        tenSanPham = scanner.nextLine();
        System.out.print("Nhập tên hãng sản xuất : ");
        tenHangSanXuat = scanner.nextLine();
        System.out.print("Nhập ngày nhập hàng : ");
        ngayNhap = scanner.nextLine();
    }

    public void output(){
        System.out.printf("%-15s%-25s%-20s%-12s", maSanPham, tenSanPham, tenHangSanXuat, ngayNhap);
    }

    public SanPham() {
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public void setTenHangSanXuat(String tenHangSanXuat) {
        this.tenHangSanXuat = tenHangSanXuat;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public String getTenHangSanXuat() {
        return tenHangSanXuat;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public SanPham(String maSanPham, String tenSanPham, String tenHangSanXuat, String ngayNhap) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.tenHangSanXuat = tenHangSanXuat;
        this.ngayNhap = ngayNhap;
    }
}
