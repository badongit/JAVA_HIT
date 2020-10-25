package bai_2;

import java.util.Scanner;

public class SoPhuc {
    private double thuc;
    private double ao;

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập phần thực : ");
        thuc = scanner.nextDouble();
        System.out.print("Nhập phần ảo : ");
        ao = scanner.nextDouble();
    }
    public void output(){
        System.out.print(thuc);
        if(ao >= 0) System.out.print(" +");
        System.out.println(" " + ao + "i");
    }
    public SoPhuc cong(SoPhuc a){
        SoPhuc temp = new SoPhuc();
        temp.thuc = this.thuc + a.thuc;
        temp.ao = this.ao + a.ao;
        return temp;
    }
    public SoPhuc tru(SoPhuc a){
        SoPhuc temp = new SoPhuc();
        temp.thuc = this.thuc - a.thuc;
        temp.ao = this.ao - a.ao;
        return temp;
    }
    public double getThuc() {
        return thuc;
    }

    public void setThuc(double thuc) {
        this.thuc = thuc;
    }

    public double getAo() {
        return ao;
    }

    public void setAo(double ao) {
        this.ao = ao;
    }

    public SoPhuc(double thuc, double ao) {
        this.thuc = thuc;
        this.ao = ao;
    }

    public SoPhuc() {
    }
}
