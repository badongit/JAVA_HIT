package bai_3;

import java.text.NumberFormat;
import java.util.Locale;

public class HangHoa {
    private String maHang;
    private String tenHang;
    private double donGia;
    private int soLuong;

    public Locale localeVN = new Locale ("vi", "VN");
    public NumberFormat curVN = NumberFormat.getCurrencyInstance(localeVN);
    public HangHoa() {
    }

    public HangHoa(String maHang, String tenHang, double donGia, int soLuong) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public double getDonGia() {
        return donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public void Xuat(){
        System.out.println("Mã hàng : " + maHang);
        System.out.println("Tên hàng : " + tenHang);
        System.out.println("Đơn giá : " + curVN.format(donGia) );
        System.out.println("Số lượng : " + soLuong);
        System.out.println("Thành tiền : " + curVN.format(soLuong*donGia) );
   }
}
