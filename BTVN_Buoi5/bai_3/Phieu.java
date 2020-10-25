package bai_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Phieu {
    private String maPhieu;
    private String tenPhieu;
    private DateTime a;
    private ArrayList<SanPham> listSanPham = new ArrayList<>();
    int n;

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\t============== NHẬP THÔNG TIN PHIẾU MUA HÀNG ==============");
        System.out.print("Nhập mã phiếu : ");
        maPhieu = scanner.nextLine();
        System.out.print("Nhập tên phiếu : ");
        tenPhieu = scanner.nextLine();
        a = new DateTime();
        a.input();
        System.out.print("Nhập số lượng hàng hóa : ");
        n = scanner.nextInt();
        for(int i = 0 ; i < n ; i++){
            SanPham sanPham = new SanPham();
            System.out.println("\t\t\t============== NHẬP THÔNG TIN SẢN PHẢM THỨ " + (i+1) + " ==============");
            sanPham.input();
            listSanPham.add(sanPham);
        }
    }
    public void output(){
        System.out.println("\t\t\t================ PHIẾU MUA HÀNG ================");
        System.out.println("Mã phiếu : " + maPhieu);
        System.out.println("Tên phiếu : " + tenPhieu);
        System.out.print("Ngày : ");
        a.output();
        System.out.println();
        System.out.println("\t\t\t-------------- DANH SÁCH SẢN PHẨM --------------");
        System.out.printf("%-15s%-25s%-15s%-20s%-20s\n", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền");
        for(SanPham sanPham : listSanPham){
            sanPham.output();
        }
    }
    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getTenPhieu() {
        return tenPhieu;
    }

    public void setTenPhieu(String tenPhieu) {
        this.tenPhieu = tenPhieu;
    }

    public DateTime getA() {
        return a;
    }

    public void setA(DateTime a) {
        this.a = a;
    }

    public ArrayList<SanPham> getListSanPham() {
        return listSanPham;
    }

    public void setListSanPham(ArrayList<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Phieu(String maPhieu, String tenPhieu, DateTime a, ArrayList<SanPham> listSanPham, int n) {
        this.maPhieu = maPhieu;
        this.tenPhieu = tenPhieu;
        this.a = a;
        this.listSanPham = listSanPham;
        this.n = n;
    }

    public Phieu() {
    }
}
