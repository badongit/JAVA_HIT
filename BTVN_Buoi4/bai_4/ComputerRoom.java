package bai_4;

import java.util.ArrayList;
import java.util.Scanner;

public class ComputerRoom {
    private String id;
    private String name;
    private double acreage;
    private Manage x;
    private ArrayList<Computer> listComputer = new ArrayList<>();
    private int n;

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the room id : ");
        id = scanner.nextLine();
        System.out.print("Enter the room name : ");
        name = scanner.nextLine();
        System.out.print("Enter the area of the room : ");
        acreage = scanner.nextDouble();
        x = new Manage();
        x.input();
        System.out.print("Enter the number of computers available in the room : ");
        n = scanner.nextInt();
        for(int i = 0 ; i < n ; i++){
            System.out.println("\t\t\t=========== Computer " + (i+1) + " ===========");
            Computer computer = new Computer();
            computer.input();
            listComputer.add(computer);
        }
    }
    public void output(){
        System.out.println("\t\t\t============= COMPUTER ROOM INFORMATION =============");
        System.out.printf("%-15s%-25s\n", "Room id : ", id);
        System.out.printf("%-15s%-25s%-15s%-25s\n", "Room name : ", name, "Room area : ", acreage);
        x.output();
        System.out.println("\t\t\t--------- LIST OF COMPUTERS --------- ");
        System.out.printf("%-15s%-20s%-20s\n", "Computer ID", "Model", "Status");
        for(int i = 0 ; i < listComputer.size() ; i++){
            listComputer.get(i).output();
        }
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAcreage(double acreage) {
        this.acreage = acreage;
    }

    public void setX(Manage x) {
        this.x = x;
    }

    public void setListComputer(ArrayList<Computer> listComputer) {
        this.listComputer = listComputer;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAcreage() {
        return acreage;
    }

    public Manage getX() {
        return x;
    }

    public ArrayList<Computer> getListComputer() {
        return listComputer;
    }

    public int getN() {
        return n;
    }

    public ComputerRoom(String id, String name, double acreage, Manage x, ArrayList<Computer> listComputer, int n) {
        this.id = id;
        this.name = name;
        this.acreage = acreage;
        this.x = x;
        this.listComputer = listComputer;
        this.n = n;
    }

    public ComputerRoom() {
    }
}
