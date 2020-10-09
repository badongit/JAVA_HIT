package bai_2;

public class Dog {
    private String name;
    private int MP = 100;
    public void InputName(String name){
        this.name = name;
    }
    public void ShowMP(){
        System.out.println(MP);
    }
    public void Bark(){
        if(name.length() != 0) {
            System.out.println(name + " sủa");
            MP -= 20;
        } else {
            System.out.println("Xin lỗi bạn chưa điền tên");
        }
    }
}
