package bai_5;

import java.util.ArrayList;
import java.util.Scanner;

public class LopHoc {
    private String maLH;
    private String tenLH;
    private String ngayMo;
    private ArrayList<SinhVien> listSinhVien = new ArrayList<>();
    private int n;
    private String giaoVien;

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\t================ NHẬP THÔNG TIN LỚP HỌC ================");
        System.out.print("Nhập mã lớp học : ");
        maLH = scanner.nextLine();
        System.out.print("Nhập tên lớp học : ");
        tenLH = scanner.nextLine();
        System.out.print("Nhập ngày mở lớp : ");
        ngayMo = scanner.nextLine();
        System.out.print("Nhập tên giáo viên : ");
        giaoVien = scanner.nextLine();
        System.out.print("Nhập số lương học sinh : ");
        n = scanner.nextInt();
        scanner.nextLine();
        for(int i  = 0 ; i < n ; i++){
            System.out.println("\t\t\t================ NHẬP THÔNG TIN SINH VIÊN THỨ " + (i+1) + " ================");
            SinhVien sinhVien = new SinhVien();
            sinhVien.input();
            listSinhVien.add(sinhVien);
        }

    }
    public void output(){
        System.out.println("\t\t\t================= THÔNG TIN LỚP HỌC =================");
        System.out.printf("%-20s%-20s%-20s%-20s\n", "Mã lớp học : ", maLH, "Tên lớp học : " , tenLH);
        System.out.printf("%-20s%-20s%-20s%-20s\n", "Ngày mở : ", ngayMo, "Giáo viên : ", giaoVien);
        System.out.println("\t\t\t================== DANH SÁCH HỌC SINH ==================");
        System.out.printf("%-15s%-25s%-12s%-30s%-20s%-10s\n", "MSV", "Họ tên", "Ngày sinh", "Quê quán", "Ngành", "Khóa");
        for(int i  = 0 ; i < listSinhVien.size() ; i++){
            listSinhVien.get(i).output();
        }
    }

    public String getMaLH() {
        return maLH;
    }

    public void setMaLH(String maLH) {
        this.maLH = maLH;
    }

    public String getTenLH() {
        return tenLH;
    }

    public void setTenLH(String tenLH) {
        this.tenLH = tenLH;
    }

    public String getNgayMo() {
        return ngayMo;
    }

    public void setNgayMo(String ngayMo) {
        this.ngayMo = ngayMo;
    }

    public ArrayList<SinhVien> getListSinhVien() {
        return listSinhVien;
    }

    public void setListSinhVien(ArrayList<SinhVien> listSinhVien) {
        this.listSinhVien = listSinhVien;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(String giaoVien) {
        this.giaoVien = giaoVien;
    }

    public LopHoc(String maLH, String tenLH, String ngayMo, ArrayList<SinhVien> listSinhVien, int n, String giaoVien) {
        this.maLH = maLH;
        this.tenLH = tenLH;
        this.ngayMo = ngayMo;
        this.listSinhVien = listSinhVien;
        this.n = n;
        this.giaoVien = giaoVien;
    }

    public LopHoc() {
    }
}
