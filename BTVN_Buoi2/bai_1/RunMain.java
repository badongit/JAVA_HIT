package bai_1;

import java.util.Scanner;

public class RunMain {
    public static int max(int a,int b,int c){
        return Math.max(a,Math.max(b,c));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b,c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        System.out.println("Max = " + max(a,b,c));
    }
}
