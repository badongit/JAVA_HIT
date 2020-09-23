import java.util.Arrays;

public class Bai_1 {
    public static void main(String[] args) {
        int m = 5, n = 3;
        for(int i = 0 ; i < m ; i++){
            System.out.print("*");
        }
        for(int i = 1 ; i < n-1 ; i++){
            System.out.print("\n*");
            for(int j = 0 ; j < m - 2 ; j++){
                System.out.print(" ");
            }
            System.out.print("*");
        }
        System.out.println();
        for(int i = 0 ; i < m ; i++){
            System.out.print("*");
        }
    }
}
