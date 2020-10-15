package bai_2;

public class RunMain {
    public static void main(String[] args) {
        NhanSu a = new NhanSu();
        a.input();
        System.out.printf("%-15s%-20s%-12s", "Mã nhân sự", "Họ tên", "Ngày sinh");
        System.out.println();
        a.output();
    }
}
