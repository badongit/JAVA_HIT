package model.Reader;

public class Reader {
    private long readerID;
    private String fullName;
    private String address;
    private String phone;
    private int totalBor;

    public Reader() {
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerID=" + readerID +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", totalBor=" + totalBor +
                '}';
    }

    public long getReaderID() {
        return readerID;
    }

    public void setReaderID(long readerID) {
        this.readerID = readerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getTotalBor() {
        return totalBor;
    }

    public void setTotalBor(int totalBor) {
        this.totalBor = totalBor;
    }

    public Reader(long readerID, String fullName, String address, String phone, int totalBor) {
        this.readerID = readerID;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.totalBor = totalBor;
    }
}
