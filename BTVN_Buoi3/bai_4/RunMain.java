package bai_4;

public class RunMain {
    public static void main(String[] args) {
        Array arr1 = new Array();
        Array arr2 = new Array();
        System.out.println("Nhập mảng 1 : ");
        arr1.InputData();
        System.out.println("Nhập mảng 2 : ");
        arr2.InputData();
        System.out.print("Mảng 1 : ");
        arr1.Show();
        System.out.print("Mảng 2 : ");
        arr2.Show();
        double temp = arr1.Sum()/arr1.getN() - arr2.Sum()/arr2.getN();
        if(temp > 0){
            System.out.println("arr1 có TBC lớn hơn arr2.");
        } else if(temp < 0){
            System.out.println("arr2 có TBC lớn hơn arr1.");
        } else if(temp == 0 ){
            System.out.println("Hi");
        }
    }
}
