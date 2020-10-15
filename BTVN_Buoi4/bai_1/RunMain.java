package bai_1;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        ArrayList<Sach> listBook = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng sách : ");
        int n = scanner.nextInt();
        for( int i = 0 ; i < n ; i++){
            Sach sach = new Sach();
            System.out.println("\t\t\t========= NHẬP THÔNG TIN CUỐN SÁCH THỨ " + (i+1) + " =========");
            sach.Input();
            listBook.add(sach);
        }
        System.out.printf("%-20s%-20s%-20s%-20s%-20s","Mã Sách","Tên sách","NXB","Số trang","Giá tiền");
        System.out.println();
        for (int i = 0 ; i < listBook.size() ; i++){
            listBook.get(i).output();
        }
    }
}
