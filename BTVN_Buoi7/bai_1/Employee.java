package bai_1;

public class Employee extends Person{
    int salary;

    @Override
    public void display() {
        System.out.println("Employee name : "+name);
        System.out.println("Employee address : " + address);
        System.out.println("Employee salary: " + salary);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(String name, String address, int salary) {
        super(name, address);
        this.salary = salary;
    }

    public Employee() {
    }
}
