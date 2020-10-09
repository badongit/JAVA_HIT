package bai_5;

public class Guns {
    private String weaponName;
    private int ammoNumber;

    public void Load(int x){
        ammoNumber += x;
    }
    public void Shoot(int x){
        if(ammoNumber - x >= 0) {
            ammoNumber -= x;
        } else {
            ammoNumber = 0;
        }
        if(ammoNumber == 0) {
            System.out.println("Hết đạn");
        }
    }

    public Guns() {
    }

    public Guns(String weaponName, int ammoNumber) {
        this.weaponName = weaponName;
        this.ammoNumber = ammoNumber;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public int getAmmoNumber() {
        return ammoNumber;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public void setAmmoNumber(int ammoNumber) {
        this.ammoNumber = ammoNumber;
    }
}
