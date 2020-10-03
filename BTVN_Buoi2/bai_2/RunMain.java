package bai_2;

import java.util.Arrays;
import java.util.Scanner;

public class RunMain {
    public static int maxArr(int[] a){
        int m = a[0];
        for(int i = 1 ; i < a.length - 1 ; i++){
            m = Math.max(a[i],a[i+1]);
        }
        return m;
    }
    public static int minArr(int[] a){
        int m = a[0];
        for(int i = 1 ; i < a.length - 1 ; i++){
            m = Math.min(a[i],a[i+1]);
        }
        return m;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Nhập số lượng phần tử : ");
        n = sc.nextInt();
        int[] a = new int [n];
        System.out.println("Nhập mảng : \n");
        for(int i = 0 ; i < n ; i++){
            a[i] = sc.nextInt();
        }
        System.out.println("Max = " + maxArr(a));
        System.out.println("Min = " + minArr(a));
        Arrays.sort(a);
        System.out.println("Mảng sau khi sắp xếp : " + Arrays.toString(a));
    }
}
