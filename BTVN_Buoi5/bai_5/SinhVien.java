package bai_5;

import java.util.Scanner;

public class SinhVien extends  Nguoi{
    private String maSv;
    private String nganh;
    private int khoa;

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sinh viên : ");
        maSv = scanner.nextLine();
        super.input();
        System.out.print("Nhập ngành : ");
        nganh = scanner.nextLine();
        System.out.print("Nhập khóa : ");
        khoa = scanner.nextInt();
        scanner.nextLine();
    }
    public void output(){
        System.out.printf("%-15s", maSv);
        super.output();
        System.out.printf("%-20s%-10d\n", nganh, khoa);
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public int getKhoa() {
        return khoa;
    }

    public void setKhoa(int khoa) {
        this.khoa = khoa;
    }

    public SinhVien(String hoTen, String ngaySinh, String queQuan, String maSv, String nganh, int khoa) {
        super(hoTen, ngaySinh, queQuan);
        this.maSv = maSv;
        this.nganh = nganh;
        this.khoa = khoa;
    }

    public SinhVien() {
    }
}
