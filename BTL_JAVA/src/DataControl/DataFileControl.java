package DataControl;

import model.*;
import model.Book.*;
import model.Reader.*;
import model.BookReaderManagements.*;
import model.Reader.Reader;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataFileControl {
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private Scanner scanner;

    public void OpenFileToWrite(String fileName) {
        try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void CloseFileAfterWrite() {
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void OpenFileToRead(String fileName) {
        try {
            File file = new File(fileName);
            if(!file.exists()) {
                file.createNewFile();
            }
            scanner = new Scanner(Paths.get(fileName),"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void CloseFileAfterRead() {
        scanner.close();
    }
    public void WriteBookToFile(Book book, String fileName) {
        OpenFileToWrite(fileName);
        printWriter.println(book.getBookID() + "|" + book.getBookName() + "|" +
                book.getAuthor() + "|" + book.getSpecialization() + "|" +
                book.getPublishYear() + "|" + book.getQuantity() + "|" + book.getPrice());
        CloseFileAfterWrite();
    }
    public List<Book> ReadBookFromFile(String fileName) {
        List<Book> listBook = new ArrayList<>();
        OpenFileToRead(fileName);
        while(scanner.hasNext()) {
            String bookString = scanner.nextLine();
            String[] bookData = bookString.split("\\|");
            Book book = new Book(Long.parseLong(bookData[0]), bookData[1], bookData[2], bookData[3],
                    Integer.parseInt(bookData[4]), Integer.parseInt(bookData[5]), Long.parseLong(bookData[6]));
            listBook.add(book);
        }
        CloseFileAfterRead();
        return listBook;
    }
    public void UpdateFileBook(List<Book> listBook, String fileName) {
        File file = new File(fileName);
        if(file.exists()) {
            file.delete();
        }
        OpenFileToWrite(fileName);
        for(int i = 0 ; i < listBook.toArray().length;i++) {
            printWriter.println(listBook.get(i).getBookID() + "|" + listBook.get(i).getBookName() + "|" +
                    listBook.get(i).getAuthor() + "|" + listBook.get(i).getSpecialization() + "|" +
                    listBook.get(i).getPublishYear() + "|" + listBook.get(i).getQuantity() + "|" +
                    listBook.get(i).getPrice());
        }
        CloseFileAfterWrite();
    }
    public void WriteReaderToFile(Reader reader, String fileName) {
        OpenFileToWrite(fileName);
        printWriter.println(reader.getReaderID() + "|" + reader.getFullName() + "|" +
                reader.getAddress() + "|" + reader.getPhone() + "|" + reader.getTotalBor());
        CloseFileAfterWrite();
    }
    public List<Reader> ReadReaderFromFile(String fileName) {
        List<Reader> listReader = new ArrayList<>();
        OpenFileToRead(fileName);
        while(scanner.hasNext()) {
            String readerString = scanner.nextLine();
            String[] readerData = readerString.split("\\|");
            Reader reader = new Reader(Long.parseLong(readerData[0]), readerData[1], readerData[2],
                    readerData[3], Integer.parseInt(readerData[4]));
            listReader.add(reader);
        }
        CloseFileAfterRead();
        return listReader;
    }
    public void UpdateFileReader(List<Reader> listReader, String fileName) {
        File file = new File(fileName);
        if(file.exists()) {
            file.delete();
        }
        OpenFileToWrite(fileName);
        for(int i = 0 ; i < listReader.toArray().length;i++) {
            printWriter.println(listReader.get(i).getReaderID() + "|" + listReader.get(i).getFullName() + "|" +
                    listReader.get(i).getAddress() + "|" + listReader.get(i).getPhone() + "|" +
                    listReader.get(i).getTotalBor());
        }
        CloseFileAfterWrite();
    }
    public void WriteBRMToFile(BookReaderManagement brm, String fileName){
        OpenFileToWrite(fileName);
        printWriter.println(brm.getBook().getBookID() + "|" + brm.getReader().getReaderID() + "|" +
                brm.getNumOfBor() + "|" + brm.getStatus() + "|" + brm.getDateBor());
        CloseFileAfterWrite();
    }
    public List<BookReaderManagement> ReadBRMFromFile(String fileBRM, List<Book> listBook, List<Reader> listReader) {
        List<BookReaderManagement> listBRM = new ArrayList<>();
        OpenFileToRead(fileBRM);
        while(scanner.hasNext()) {
            String brmString = scanner.nextLine();
            String[] brmData = brmString.split("\\|");
            Book book = getBook(listBook, Long.parseLong(brmData[0]));
            Reader reader = getReader(listReader, Long.parseLong(brmData[1]));
            BookReaderManagement brm = new BookReaderManagement(book, reader, Integer.parseInt(brmData[2]),
                    brmData[3], brmData[4]);
            listBRM.add(brm);
        }
        CloseFileAfterRead();
        return listBRM;
    }
    public void UpdateFileBRM(List<BookReaderManagement> listBRM, String fileName) {
        File file = new File(fileName);
        if(file.exists()) {
            file.delete();
        }
        OpenFileToWrite(fileName);
        for(int i = 0 ; i < listBRM.toArray().length;i++) {
            printWriter.println(listBRM.get(i).getBook().getBookID() + "|" +
                    listBRM.get(i).getReader().getReaderID() + "|" +
                    listBRM.get(i).getNumOfBor() + "|" +
                    listBRM.get(i).getStatus() + "|" +
                    listBRM.get(i).getDateBor());
        }
        CloseFileAfterWrite();
    }
    private Book getBook(List<Book> listBook, long bookId) {
        for(int i = 0 ; i < listBook.toArray().length ; i++) {
            if(listBook.get(i).getBookID() == bookId)
                return listBook.get(i);
        }
        return null;
    }
    private Reader getReader(List<Reader> listReader, long readerId) {
        for(int i = 0 ; i < listReader.toArray().length; i++) {
            if(listReader.get(i).getReaderID() == readerId)
                return listReader.get(i);
        }
        return null;
    }

}
