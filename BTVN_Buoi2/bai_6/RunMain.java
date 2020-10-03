package bai_6;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr = sc.nextLine();
        arr = arr.trim();
        while(arr.indexOf("  ") != -1){
            arr = arr.replace("  ", " ");
        }
        String[] temp = arr.split(" ");
        arr = "";
        for(int i = 0 ; i < temp.length ; i++){
            arr += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if(i < temp.length - 1 ){
                arr += " ";
            }
        }
        System.out.println(arr);
    }
}
