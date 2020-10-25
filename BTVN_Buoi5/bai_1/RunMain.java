package bai_1;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng điều hòa : ");
        int n = scanner.nextInt();
        ArrayList<DieuHoa> listDieuHoa = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            System.out.println("\t\t\t============ NHẬP THÔNG TIN ĐIỀU HÒA THỨ " + (i+1) + " ============");
            DieuHoa dieuHoa = new DieuHoa();
            dieuHoa.input();
            listDieuHoa.add(dieuHoa);
        }
        filter(listDieuHoa);
    }
    public static Locale localeVN = new Locale("vi", "VN");
    public static NumberFormat curVN = NumberFormat.getCurrencyInstance(localeVN);
    public static void filter(ArrayList<DieuHoa> list){
        boolean check = false;
        double min = 0;
        for(int i = 0 ; i < list.size() ; i++){
            if(list.get(i).getTenHangSanXuat().equals("Electrolux")){
                check = true;
                min = list.get(i).getGiaBan();
                break;
            }
        }
        if(check){
            System.out.println("\t\t\t============ DANH SÁCH ĐIỀU HÒA ELECTROLUX ============");
            titleDieuHoa();
            for(int i = 0 ; i < list.size(); i++){
                if(list.get(i).getTenHangSanXuat().equals("Electrolux")){
                    list.get(i).output();
                    if(list.get(i).getGiaBan() < min) {
                        min = list.get(i).getGiaBan();
                    }
                }
            }
            System.out.println("\t\t\t\tGiá bán điều hòa Electrolux thấp nhất là : " + curVN.format(min));
        }
        else{
            System.out.println("Không có điều hòa hãng ELectrolux trong danh sách.");
        }
    }
    public static void titleDieuHoa(){
        System.out.printf("%-15s%-25s%-20s%-12s%-15s%-20s\n","Mã sản phẩm", "Tên sản phẩm", "Tên hãng", "Ngày nhập", "Công suất", "Giá bán");
    }
}
