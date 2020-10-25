package bai_2;

public class RunMain {
    public static void main(String[] args) {
        SoPhuc p1 = new SoPhuc();
        SoPhuc p2 = new SoPhuc();
        System.out.println("Nhập số thực thứ nhất : ");
        p1.input();
        System.out.println("Nhập số thực thứ hai : ");
        p2.input();
        System.out.print("p1 + p2 = ");
        p1.cong(p2).output();
        System.out.println();
        System.out.print("p1 - p2 =  ");
        p1.tru(p2).output();
    }
}
