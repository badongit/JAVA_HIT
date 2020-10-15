package bai_4;

import java.util.Scanner;

public class Manage {
    private String id;
    private String name;

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter management id : ");
        id = scanner.nextLine();
        System.out.print("Enter the manager name : ");
        name = scanner.nextLine();
    }
    public void output(){
        System.out.printf("%-15s%-25s%-15s%-25s", "ID: ", id, "Full name : ", name);
        System.out.println();
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Manage(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Manage() {
    }
}
