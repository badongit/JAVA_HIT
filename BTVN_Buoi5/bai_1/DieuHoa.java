package bai_1;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class DieuHoa extends SanPham{
    private int congSuat;
    private double giaBan;

    static Locale localeVN = new Locale("vi", "VN");
    static NumberFormat curVN = NumberFormat.getCurrencyInstance(localeVN);
    public void input(){
        Scanner scanner = new Scanner(System.in);
        super.input();
        System.out.print("Nhập công suất : ");
        congSuat = scanner.nextInt();
        System.out.print("Nhập giá bán : ");
        giaBan = scanner.nextDouble();
    }
    public void output(){
        super.output();
        System.out.printf("%-15d%-20s\n", congSuat, curVN.format(giaBan));
    }
    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getCongSuat() {
        return congSuat;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public DieuHoa(String maSanPham, String tenSanPham, String tenHangSanXuat, String ngayNhap, int congSuat, double giaBan) {
        super(maSanPham, tenSanPham, tenHangSanXuat, ngayNhap);
        this.congSuat = congSuat;
        this.giaBan = giaBan;
    }

    public DieuHoa() {
    }
}
