package model.Book;

import java.text.NumberFormat;
import java.util.Locale;

public class Book {
    private long bookID;
    private String bookName;
    private String author;
    private String specialization;
    private int publishYear;
    private int quantity;
    private long price;
    @Override
    public String toString() {
        Locale localeVN = new Locale("vi","VN");
        NumberFormat curVN = NumberFormat.getCurrencyInstance(localeVN);
        return "Book{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", specialization='" + specialization + '\'' +
                ", publishYear=" + publishYear +
                ", quantity=" + quantity +
                ", price=" + curVN.format(price) +
                '}';
    }

    public long getBookID() {
        return bookID;
    }

    public void setBookID(long bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Book(long bookID, String bookName, String author, String specialization, int publishYear, int quantity, long price) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.specialization = specialization;
        this.publishYear = publishYear;
        this.quantity = quantity;
        this.price = price;
    }

    public Book() {
    }
}
