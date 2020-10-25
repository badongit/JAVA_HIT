package bai_5;

import java.util.Scanner;

public class Nguoi {
    private String hoTen;
    private String ngaySinh;
    private String queQuan;

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập họ tên : ");
        hoTen = scanner.nextLine();
        System.out.print("Nhập ngày sinh : ");
        ngaySinh = scanner.nextLine();
        System.out.print("Nhập quê quán : ");
        queQuan = scanner.nextLine();
    }
    public void output(){
        System.out.printf("%-25s%-12s%-30s", hoTen, ngaySinh, queQuan);
    }
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public Nguoi(String hoTen, String ngaySinh, String queQuan) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
    }

    public Nguoi() {
    }
}
