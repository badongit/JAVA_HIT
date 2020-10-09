package bai_5;

public class RunMain {
    public static void main(String[] args) {
        Guns s1 = new Guns();
        Guns s2 = new Guns();
        s1.setWeaponName("TokuDoan");
        s2.setWeaponName("OzaKhanh");
        s1.Load(100);
        s2.Load(100);
        do{
            int x = (int)(Math.random()*10 + 1);
            s1.Shoot(x);
            x = (int)(Math.random()*10 + 1);
            s2.Shoot(x);
            if(s1.getAmmoNumber() == 0 && s2.getAmmoNumber() == 0){
                System.out.println("Hòa");
            } else if(s1.getAmmoNumber() == 0){
                System.out.println(s1.getWeaponName() + " thua.");
                System.out.println(s2.getWeaponName()+ " còn " + s2.getAmmoNumber() + " viên đạn.");
            } else if(s2.getAmmoNumber() == 0){
                System.out.println(s2.getWeaponName() +" thua.");
                System.out.println(s1.getWeaponName() + " còn " + s1.getAmmoNumber() + " viên đạn.");
            }
        }while(s1.getAmmoNumber() != 0 && s2.getAmmoNumber() != 0);
    }
}
