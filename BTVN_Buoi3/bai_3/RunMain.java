package bai_3;

public class RunMain {
    public static void main(String[] args) {
        HangHoa a = new HangHoa("123","IPX",12000000,2);
        HangHoa b = new HangHoa();
        b.setMaHang("234");
        b.setTenHang("IP12");
        b.setDonGia(24000000);
        b.setSoLuong(3);
        System.out.println("Thông tin mặt hàng thứ nhất");
        a.Xuat();
        System.out.println("Thông tin mặt hàng thứ hai");
        b.Xuat();
    }
}
