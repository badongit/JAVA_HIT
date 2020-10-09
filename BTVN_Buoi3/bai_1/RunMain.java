package bai_1;


public class RunMain {
    public static void main(String[] args) {
        PerSon DoanXinhGai = new PerSon();
        PerSon DiepBueDe = new PerSon();
        DoanXinhGai.setName("Vũ Văn Doan");
        DoanXinhGai.setDateOfBirth("1/2/2000");
        DoanXinhGai.setGender("Nam");
        DoanXinhGai.setHobby("Phương");
        DiepBueDe.setName("Nguyễn Đức Điệp");
        DiepBueDe.setDateOfBirth("2/3/2000");
        DiepBueDe.setGender("không tiết lộ");
        DiepBueDe.setHobby("ĐTCL");
        System.out.println("Thông tin của DoanXinhGai");
        System.out.println("Tên : " + DoanXinhGai.getName());
        System.out.println("Date of birth : " + DoanXinhGai.getDateOfBirth());
        System.out.println("Giới tính : " + DoanXinhGai.getGender());
        System.out.println("Sở thích : " + DoanXinhGai.getHobby());
        System.out.println("Thông tin của DiepBueDe");
        System.out.println("Tên : " + DiepBueDe.getName());
        System.out.println("Date of birth : " + DiepBueDe.getDateOfBirth());
        System.out.println("Giới tính : " + DiepBueDe.getGender());
        System.out.println("Sở thích : " + DiepBueDe.getHobby());
    }
}
