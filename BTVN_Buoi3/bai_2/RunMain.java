package bai_2;

import bai_2.Dog;

public class RunMain {
    public static void main(String[] args) {
        Dog a = new Dog();
        a.InputName("Gover");
        for (int i = 0 ; i < 3 ; i++){
            a.Bark();
            a.ShowMP();
        }
    }
}
