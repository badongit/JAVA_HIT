package bai_4;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    private int n;
    private int[] a;

    Scanner sc = new Scanner(System.in);
    public void InputData(){
        System.out.println("Nhập số lượng phần tử : ");
        n = sc.nextInt();
        a = new int [n];
        for(int i = 0; i < n ; i++){
            System.out.print("Nhập a[" + (i+1) + "] = ");
            a[i] = sc.nextInt();
        }
    }
    public void Show(){
        System.out.println(Arrays.toString(a));
    }
    public double Sum(){
        double sum = 0;
        for(int i : a){
            sum += i;
        }
        return sum;
    }

    public Array() {
    }

    public Array(int n, int[] a, Scanner sc) {
        this.n = n;
        this.a = a;
        this.sc = sc;
    }

    public int getN() {
        return n;
    }

    public int[] getA() {
        return a;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setA(int[] a) {
        this.a = a;
    }
}
