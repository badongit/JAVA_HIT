package bai_2;

import java.util.Scanner;

public class NhanSu {
    private String maNhanSu;
    private String hoTen;
    private Date ngaySinh;

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã nhân sự : ");
        maNhanSu = scanner.nextLine();
        System.out.print("Nhập họ tên : ");
        hoTen = scanner.nextLine();
        ngaySinh = new Date();
        ngaySinh.input();
    }
    public void output(){
        System.out.printf("%-15s%-20s",maNhanSu, hoTen);
        ngaySinh.output();
        System.out.println();
    }
    public NhanSu() {
    }

    public NhanSu(String maNhanSu, String hoTen, Date ngaySinh) {
        this.maNhanSu = maNhanSu;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
    }

    public void setMaNhanSu(String maNhanSu) {
        this.maNhanSu = maNhanSu;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getMaNhanSu() {
        return maNhanSu;
    }

    public String getHoTen() {
        return hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }
}
