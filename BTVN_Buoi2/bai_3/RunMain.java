package bai_3;

import java.util.Arrays;
import java.util.Scanner;

public class RunMain {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int luaChon, n;
        int[] a = null;
        do {
            System.out.println("============ MENU ============\n");
            System.out.println("1. Nhập mảng");
            System.out.println("2. Hiển thị mảng");
            System.out.println("3. Thêm phần tử");
            System.out.println("4. Xóa phần tử");
            System.out.println("5. Đảo ngược mảng");
            System.out.println("6. Hiển thị a[1] và các số chia hết a[1]");
            System.out.println("7. Thoát");
            System.out.println("Nhập lựa chọn : ");
            luaChon = sc.nextInt();
            switch (luaChon) {
                case 1:
                    System.out.println("Nhập số lương phần tử : ");
                    n = sc.nextInt();
                    a = new int[n];
                    System.out.println("Nhập mảng : ");
                    for (int i = 0; i < n; i++) {
                        a[i] = sc.nextInt();
                    }
                    break;
                case 2:
                    System.out.print("Mảng vừa tạo : ");
                    System.out.println(Arrays.toString(a));
                    break;
                case 3:
                    a = insertArr(a);
                    System.out.print("Mảng sau khi thêm : ");
                    System.out.println(Arrays.toString(a));
                    break;
                case 4:
                    a = delArr(a);
                    System.out.print("Mảng sau khi xóa : ");
                    System.out.println(Arrays.toString(a));
                    break;
                case 5:
                    a = reverseArr(a);
                    System.out.print("Mảng sau khi đảo ngược : ");
                    System.out.println(Arrays.toString(a));
                    break;
                case 6:
                    multi(a);
                    break;
                case 7:
                    System.out.println("End!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!!!");
            }
        } while (luaChon != 7);
    }
    public static int[] insertArr(int[] a){
        System.out.println("Nhập vị trí muốn thêm : ");
        int k = sc.nextInt();
        System.out.println("Nhập phần tử muốn thêm : ");
        int x = sc.nextInt();
        int[] temp = new int [a.length + 1];
        int tempIndex = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if(tempIndex == k - 1) {
                temp[tempIndex++] = x;
                i--;
            } else {
                temp[tempIndex++] = a[i];
            }
        }
        return temp;
    }
    public static int[] delArr(int[] a){
        System.out.println("Nhập vị trí muốn xóa : ");
        int k = sc.nextInt();
        int[] temp =  new int [a.length - 1];
        int tempIndex = 0;
        for(int i = 0; i < a.length; i++){
            if(i != k - 1){
                temp[tempIndex++] = a[i];
            }
        }
        return temp;
    }
    public static int[] reverseArr(int[] a){
        int[] temp = new int [a.length];
        for (int i = 0; i < a.length; i++) {
             temp[temp.length - i - 1] = a[i] ;
        }
        return temp;
    }
    public static void multi(int[] a){
        System.out.println("a[1] = " + a[1]);
        int[] temp = new int [0];
        for(int i = 0 ;i < a.length ; i++){
            if(i!=1 && a[i]%a[1]==0 && Arrays.binarySearch(temp,a[i]) < 0 ){
                int[] temp2 = Arrays.copyOf(temp,temp.length +1);
                temp2[temp.length] = a[i];
                temp = Arrays.copyOf(temp2,temp2.length);
            }
        }
        if(temp.length == 0) {
            System.out.println("Không có phần tử nào trong mảng chia hết cho a[1].");
        } else {
            System.out.println("Các số thuộc mảng a chia hết cho a[1] là : " + Arrays.toString(temp));
        }
    }
}
