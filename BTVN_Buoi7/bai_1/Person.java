package bai_1;

public abstract class Person {
    protected String name;
    protected String address;

    public abstract void display();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Person() {
    }
}
