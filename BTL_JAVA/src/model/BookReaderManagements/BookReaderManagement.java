package model.BookReaderManagements;

import model.Book.Book;
import model.Reader.Reader;

public class BookReaderManagement {
    private Book book;
    private Reader reader;
    private int numOfBor;
    private String status;
    private String dateBor;
    @Override
    public String toString() {
        return "BRM{" +
                "bookID=" + book.getBookID() +
                ", bookName='" + book.getBookName() + '\'' +
                ", readerID=" + reader.getReaderID() +
                ", readerName='" + reader.getFullName() + '\'' +
                ", numOfBor=" + numOfBor +
                ", status='" + status + '\'' +
                ", dateBor='" + dateBor + '\'' +
                '}';
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public int getNumOfBor() {
        return numOfBor;
    }

    public void setNumOfBor(int numOfBor) {
        this.numOfBor = numOfBor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateBor() {
        return dateBor;
    }

    public void setDateBor(String dateBor) {
        this.dateBor = dateBor;
    }

    public BookReaderManagement() {
    }

    public BookReaderManagement(Book book, Reader reader, int numOfBor, String status, String dateBor) {
        this.book = book;
        this.reader = reader;
        this.numOfBor = numOfBor;
        this.status = status;
        this.dateBor = dateBor;
    }
}
