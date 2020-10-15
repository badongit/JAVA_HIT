package bai_4;

import java.util.Scanner;

public class Computer {
    private String id;
    private String model;
    private String status;

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the computer id : ");
        id = scanner.nextLine();
        System.out.print("Enter the computer model : ");
        model = scanner.nextLine();
        System.out.print("Enter the computer status : ");
        status = scanner.nextLine();
    }
    public void output(){
        System.out.printf("%-15s%-20s%-20s", id, model, status);
        System.out.println();
    }
    public Computer() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getStatus() {
        return status;
    }

    public Computer(String id, String model, String status) {
        this.id = id;
        this.model = model;
        this.status = status;
    }
}
