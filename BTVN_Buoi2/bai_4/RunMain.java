package bai_4;

import java.util.Scanner;

public class RunMain {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử : ");
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] prime = new int[n];
        int dem = 2,sum = 0;
        System.out.println("Nhập mảng : ");
        for(int i = 0 ; i < n ; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n ; i++){
            do{
                if(isPrime(dem))
                    prime[i] = dem;
            }while(!isPrime(dem++));
        }
        for(int i = 0 ; i < n ; i++){
            sum += isPrime(a[i]) ? a[i] + prime[i] - i : a[i] ;
        }
        System.out.println("S = " + sum);
    }
    public static boolean isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n) ; i++){
            if(n%i == 0)
                return false;
        }
        return n > 1;
    }
}
