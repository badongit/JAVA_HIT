package bai_5;

public class RunMain {
    public static void main(String[] args) {
        Guns toKuDoan = new Guns();
        Guns ozaKhanh = new Guns();
        toKuDoan.Load(100);
        ozaKhanh.Load(100);
        while(toKuDoan.getAmmoNumber() != 0 && ozaKhanh.getAmmoNumber() != 0){
            int x = (int)(Math.random()*10 + 1);
            toKuDoan.Shoot(x);
            x = (int)(Math.random()*10 + 1);
            ozaKhanh.Shoot(x);
            if(toKuDoan.getAmmoNumber() == 0 && ozaKhanh.getAmmoNumber() == 0){
                System.out.println("Hòa");
            } else if(toKuDoan.getAmmoNumber() == 0){
                System.out.println("TokuDoan thua.");
                System.out.println("OzaKhanh còn " + ozaKhanh.getAmmoNumber() + " viên đạn.");
            } else if(ozaKhanh.getAmmoNumber() == 0){
                System.out.println("OzaKhanh thua.");
                System.out.println("TokuDoan còn " + toKuDoan.getAmmoNumber() + " viên đạn.");
            }
        }
    }
}
