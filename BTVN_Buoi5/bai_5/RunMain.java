package bai_5;

public class RunMain {
    public static void main(String[] args) {
        LopHoc lopHoc = new LopHoc();
        lopHoc.input();
        lopHoc.output();
        int dem = 0;
        for (int i = 0 ; i < lopHoc.getListSinhVien().size() ; i++){
            if(lopHoc.getListSinhVien().get(i).getKhoa() == 14){
                dem++;
            }
        }
        System.out.println("Có " + dem + " sinh viên K14.");
        sortByKhoa(lopHoc);
        lopHoc.output();
    }
    public static void sortByKhoa(LopHoc lopHoc){
        int n = lopHoc.getListSinhVien().size();
        for(int i = 0 ; i < n -1 ; i++){
            SinhVien sinhVien1 = lopHoc.getListSinhVien().get(i);
            for(int j = i + 1 ; j < n ; j++){
                SinhVien sinhVien2 = lopHoc.getListSinhVien().get(j);
                if(sinhVien1.getKhoa() > sinhVien2.getKhoa()){
                    lopHoc.getListSinhVien().set(i, sinhVien2);
                    lopHoc.getListSinhVien().set(j, sinhVien1);
                }
            }
        }
    }
}
