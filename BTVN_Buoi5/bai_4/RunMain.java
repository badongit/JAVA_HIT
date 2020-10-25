package bai_4;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        ArrayList<SinhVien> listSinhVien = new ArrayList<>();
        int luaChon;
        do{
            System.out.println("/****************************************/");
            System.out.println("1.Thêm sinh viên.");
            System.out.println("2.Sửa thông tin sinh viên.");
            System.out.println("3.Xóa thông tin sinh viên.");
            System.out.println("4.Sắp xếp sinh viên theo điểm trung bình.");
            System.out.println("5.Sắp xếp sinh viên theo tên.");
            System.out.println("6.Xem danh sách sinh viên");
            System.out.println("0.Thoát");
            System.out.print("Nhập lựa chọn : ");
            luaChon = scanner.nextInt();
            switch (luaChon){
                case 1:
                    System.out.println("1.Thêm sinh viên");
                    addStudent(listSinhVien);
                    break;
                case 2:
                    System.out.println("2.Sửa thông tin sinh viên.");
                    editStudent(listSinhVien);
                    break;
                case 3:
                    System.out.println("3.Xóa thông tin sinh viên.");
                    deleteStudent(listSinhVien);
                    break;
                case 4:
                    System.out.println("4.Sắp xếp sinh viên theo điểm trung bình.");
                    sortStudentByGPA(listSinhVien);
                    System.out.println("Sắp xếp theo điểm trung bình thành công.");
                    break;
                case 5:
                    System.out.println("5.Sắp xếp sinh viên theo tên.");
                    sortStudentByName(listSinhVien);
                    System.out.println("Sắp xếp theo tên thành công.");
                    break;
                case 6:
                    if(listSinhVien.size() == 0) System.out.println("Chưa có sinh viên nào trong danh sách.");
                    else {
                        System.out.println("\t\t\t========================= DANH SÁCH SINH VIÊN =========================");
                        System.out.printf("%-15s%-25s%-10s%-35s%-10s\n","MSV", "Họ và tên", "Tuổi", "Địa chỉ", "Điểm TB");
                        for (SinhVien sinhVien : listSinhVien){
                            sinhVien.output();
                        }
                    }
                    break;
                case 0:
                    System.out.println("Thoát.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ vui lòng nhập lại.");
                    break;
            }
        }while(luaChon != 0);
    }
    public static Scanner scanner = new Scanner(System.in);
    public static void addStudent(ArrayList<SinhVien> list){
        boolean checkID;
        int id = 0;
        do {
            checkID = true;
            System.out.print("Nhập id : ");
            id = scanner.nextInt();
            for (int i = 0; i < list.size(); i++) {
                if (id == list.get(i).getId()) {
                       checkID = false;
                       break;
                }
            }
            if(!checkID) System.out.println("ID đã tồn tại.");
        }while(!checkID);
        scanner.nextLine();
        System.out.print("Nhập tên : ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi : ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập địa chỉ : ");
        String address = scanner.nextLine();
        System.out.print("Nhập điểm trung bình : ");
        double gpa = scanner.nextDouble();
        list.add(new SinhVien(id, name, age, address, gpa));
        System.out.println("Thêm sinh viên thành công.");
    }
    public static void editStudent(ArrayList<SinhVien> list){
        if(list.size() == 0){
            System.out.println("Chưa có sinh viên nào trong danh sách.");
        } else {
            boolean checkID = false;
            System.out.print("Nhập id muốn sửa : ");
            int id = scanner.nextInt();
            for(int i = 0 ; i < list.size() ; i++){
                if(id == list.get(i).getId()){
                    System.out.println("Nhập thông tin thay thế : ");
                    SinhVien sinhVien = new SinhVien();
                    sinhVien.input();
                    list.set(i,sinhVien);
                    System.out.println("Sửa thông tin thành công.");
                    checkID = true;
                    break;
                }
            }
            if(!checkID) System.out.println("Không có sinh viên nào trong danh sách có id là " + id);
        }
    }
    public static void deleteStudent(ArrayList<SinhVien> list){
        if(list.size() == 0){
            System.out.println("Chưa có sinh viên nào trong danh sách.");
        } else {
            System.out.print("Nhập id sinh viên muốn xóa : ");
            int id = scanner.nextInt();
            boolean checkID = false;
            for(int i = 0 ; i < list.size(); i++){
                if(id == list.get(i).getId()){
                    checkID = true;
                    list.remove(i);
                    System.out.println("Xóa thành công.");
                    break;
                }
            }
            if(!checkID) System.out.println("Không có sinh viên nào trong danh sách có id là " + id);
        }
    }
    public static void sortStudentByGPA(ArrayList<SinhVien> list){
        for(int i = 0 ; i < list.size() -1 ; i++){
            for(int j = i +1 ; j < list.size();j++){
                if(list.get(i).getGpa() > list.get(j).getGpa()){
                    SinhVien temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }
    public static void sortStudentByName(ArrayList<SinhVien> list){
        for(int i = 0 ; i < list.size() -1 ; i++){
            for(int j = i +1 ; j < list.size();j++){
                if(list.get(i).getName().compareTo(list.get(j).getName()) > 0){
                    SinhVien temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }
}
