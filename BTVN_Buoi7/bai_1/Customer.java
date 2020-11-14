package bai_1;

public class Customer extends Person{
    private int balance;

    @Override
    public void display() {
        System.out.println("Customer name : "+ name);
        System.out.println("Customer address : " + address);
        System.out.println("Customer salary: " + balance);
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Customer(String name, String address, int balance) {
        super(name, address);
        this.balance = balance;
    }

    public Customer() {
    }
}
