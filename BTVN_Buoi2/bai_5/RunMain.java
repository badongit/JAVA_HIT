package bai_5;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dem = 0, sum = 0;
        String arr = sc.nextLine();
        for(int i = 0 ; i < arr.length() ; i++){
            char ch = arr.charAt(i);
            if(Character.isDigit(ch)){
                dem++;
                sum += Integer.parseInt(String.valueOf(ch));
            }
        }
        System.out.println((double) sum/dem);
    }
}
