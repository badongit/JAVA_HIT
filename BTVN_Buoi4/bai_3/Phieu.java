package bai_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Phieu {
    private String maPhieu;
    private ArrayList<Hang> listItem = new ArrayList<>();
    private int n;

    public void input(){
        Scanner scanner  = new Scanner(System.in);
        System.out.print("Nhập mã phiếu : ");
        maPhieu = scanner.nextLine();
        System.out.print("Nhập số lượng hàng : ");
        n = scanner.nextInt();
        for(int i = 0 ; i < n ; i++){
            System.out.println("\n\t\t\t=========== NHẬP THÔNG TIN MẶT HÀNG THỨ " + (i+1) + " ===========");
            Hang a = new Hang();
            a.input();
            listItem.add(a);
        }
    }
    public void output(){
        System.out.println("\n\t\t\t=========== PHIẾU MUA HÀNG ===========");
        System.out.println("Mã phiếu : " + maPhieu);
        System.out.println("\t\t\t----------- DANH SÁCH HÀNG HÓA -----------");
        System.out.printf("%-10s%-20s%-15s", "Mã hàng", "Tên hàng", "Đơn giá");
        System.out.println();
        for(int i = 0 ; i < listItem.size() ; i++){
            listItem.get(i).output();
        }
    }
    public double total(){
        double sum = 0;
        for(int i = 0 ; i < listItem.size() ; i++){
            sum += listItem.get(i).getDonGia();
        }
        return sum;
    }

    public Phieu() {
    }

    public Phieu(String maPhieu, ArrayList<Hang> listItem, int n) {
        this.maPhieu = maPhieu;
        this.listItem = listItem;
        this.n = n;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public void setListItem(ArrayList<Hang> listItem) {
        this.listItem = listItem;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public ArrayList<Hang> getListItem() {
        return listItem;
    }

    public int getN() {
        return n;
    }
}
