import DataControl.DataFileControl;
import model.Book.*;
import model.BookReaderManagements.BookReaderManagement;
import model.BookReaderManagements.SortBRMByDateBor;
import model.BookReaderManagements.SortBRMByReaderName;
import model.Reader.Reader;
import model.Reader.SortReaderByID;
import model.Reader.SortReaderByName;
import model.Reader.SortReaderByTotalBor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class RunMain {

    static final String FILE_BOOK = "BOOK.DAT";
    static final String FILE_READER = "READER.DAT";
    static final String FILE_BRM = "BRM.DAT";

    static final String REGEX_ID = "^\\d{10}$";
    static final String REGEX_PHONE = "^0\\d{9}$";

    static Pattern pattern;
    static Date date;
    static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static List<Book> listBook = new ArrayList<>();
    static List<Reader> listReader = new ArrayList<>();
    static List<BookReaderManagement> listBRM = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static DataFileControl dataFileControl = new DataFileControl();
    static String[] specializes =  {"Science", "Art", "Economic", "IT"};

    public static void main(String[] args) {
        listBook = dataFileControl.ReadBookFromFile(FILE_BOOK);
        listReader = dataFileControl.ReadReaderFromFile(FILE_READER);
        listBRM = dataFileControl.ReadBRMFromFile(FILE_BRM, listBook, listReader);
        int choice;
        do {
            System.out.printf("%70s\n","QUẢN LÝ THƯ VIỆN");
            System.out.println("1. Thêm sách vào thư viện.");
            System.out.println("2. Hiển thị tất cả sách trong thư viện.");
            System.out.println("3. Sửa, xóa thông tin sách");
            System.out.println("4. Sắp xếp danh sách các cuốn sách trong thư viện");
            System.out.println("5. Tìm sách");
            System.out.println("6. Thêm người đọc vào danh sách độc giả");
            System.out.println("7. Hiển thị danh sách độc giả");
            System.out.println("8. Sửa, xóa thông tin độc giả");
            System.out.println("9. Sắp xếp danh sách độc giả");
            System.out.println("10.Tìm kiếm thông tin độc giả");
            System.out.println("11.Danh sách mượn sách");
            System.out.println("12.Mượn sách");
            System.out.println("13.Trả sách");
            System.out.println("14.Sắp xếp danh sách mượn sách");
            System.out.println("15.Tìm kiếm thông tin mượn sách");
            System.out.println("0. Thoát.");
            System.out.print("Nhập lựa chọn : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("1. Thêm sách vào thư viện");
                    AddBook(listBook, FILE_BOOK);
                    break;
                case 2:
                    System.out.println("2. Hiển thị tất cả sách trong thư viện.");
                    ShowAllBook(listBook);
                    break;
                case 3:
                    System.out.println("3. Sửa, xóa thông tin sách");
                    EditBooks(listBook, FILE_BOOK);
                    break;
                case 4:
                    System.out.println("4. Sắp xếp danh sách các cuốn sách trong thư viện");
                    SortBook(listBook, FILE_BOOK);
                    System.out.println("Sắp xếp thành công.");
                    break;
                case 5:
                    System.out.println("5. Tìm sách");
                    SearchBook(listBook);
                    break;
                case 6:
                    System.out.println("6. Thêm người đọc vào danh sách độc giả");
                    AddReader(listReader, FILE_READER);
                    break;
                case 7:
                    System.out.println("7. Hiển thị danh sách độc giả");
                    ShowAllReader(listReader);
                    break;
                case 8:
                    System.out.println("8. Sửa, xóa thông tin độc giả");
                    EditReaders(listReader, FILE_READER);
                    break;
                case 9:
                    System.out.println("9. Sắp xếp danh sách độc giả");
                    SortReader(listReader, FILE_READER);
                    break;
                case 10:
                    System.out.println("10.Tìm kiếm thông tin độc giả");
                    SearchReader(listReader);
                    break;
                case 11:
                    System.out.println("11.Danh sách mượn sách");
                    ShowAllBRM(listBRM);
                    break;
                case 12:
                    System.out.println("12.Mượn sách");
                    BorrowBook(listBRM, FILE_BRM);
                    break;
                case 13:
                    System.out.println("13.Trả sách");
                    GiveBackBook(listBRM, FILE_BRM);
                    break;
                case 14:
                    System.out.println("14.Sắp xếp danh sách mượn sách");
                    SortBRM(listBRM, FILE_BRM);
                    break;
                case 15:
                    System.out.println("15.Tìm kiếm thông tin mượn sách");
                    SearchBRM(listBRM);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        } while(choice != 0);
    }
//    ========================== Book =======================
    private static void AddBook(List<Book> listBook, String fileBook) {
        Book book = new Book();
        do {
            System.out.print("Nhập id sách : ");
            book.setBookID(sc.nextLong());
            if(!CheckRegex(book.getBookID(),REGEX_ID))
                System.out.println("ID phải có đủ 10 chữ số. Vui lòng nhập lại.");
        } while(!CheckRegex(book.getBookID(),REGEX_ID));
        sc.nextLine();
        System.out.print("Nhập tên sách : ");
        book.setBookName(sc.nextLine());
        System.out.print("Nhập tên tác giả : ");
        book.setAuthor(sc.nextLine());
        int specialize;
        do {
            System.out.println("Chọn thể loại sách : ");
            System.out.println("1. Science");
            System.out.println("2. Art");
            System.out.println("3. Economic");
            System.out.println("4. IT");
            System.out.print("Chọn : ");
            specialize = sc.nextInt();
            if(specialize >= 1 && specialize <= 4) {
                book.setSpecialization(specializes[specialize - 1]);
            } else {
                System.out.println("Lựa chọn không hợp lệ");
            }
        } while(specialize < 1 || specialize > 4);
        System.out.print("Nhập năm xuất bản : ");
        book.setPublishYear(sc.nextInt());
        System.out.print("Nhập số lượng : ");
        book.setQuantity(sc.nextInt());
        System.out.print("Nhập giá tiền : ");
        book.setPrice(sc.nextLong());
        listBook.add(book);
        dataFileControl.WriteBookToFile(book, fileBook);
    }
    private static void ShowAllBook(List<Book> listBook) {
        for(Book book : listBook) {
            System.out.println(book);
        }
    }
    private static void EditBooks(List<Book> listBook, String fileBook) {
        int choose;
        do {
            System.out.println("Bạn muốn tìm sách bằng :");
            System.out.println("1. ID");
            System.out.println("2. Tên sách");
            System.out.print("Chọn : ");
            choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    System.out.print("Nhập id sách bạn muốn tìm : ");
                    long id  = sc.nextLong();
                    if(CheckExistBookID(id, listBook) == -1) {
                        System.out.println("Không tìm thấy id sách này.");
                    } else {
                        Book book = listBook.get(CheckExistBookID(id, listBook));
                        System.out.println(book);
                        editBook(book, listBook);
                    }
                    break;
                case 2:
                    System.out.print("Nhập tên sách bạn muốn tìm : ");
                    String nameBook = sc.nextLine();
                    List<Book> listSearch = SearchBookByName(nameBook, listBook);
                    if(listSearch.size() == 0) {
                        System.out.println("Không thấy tên cuốn sách này.");
                    } else {
                        int choice;
                        ShowAllBook(listSearch);
                        do {
                            System.out.println("Cuốn sách bạn muốn sửa là : ");
                            for(int i = 0 ; i < listSearch.size() ; i++) {
                                System.out.println((i+1) + " " + listSearch.get(i).getBookName());
                            }
                            System.out.print("Chọn : ");
                            choice = sc.nextInt();
                            if(choice < 1 || choice > listSearch.size())
                                System.out.println("Lựa chọn không hợp lệ.");
                            else {
                                Book book = listSearch.get(choice - 1);
                                editBook(book, listBook);
                            }
                        } while(choice < 1 || choice > listSearch.size());
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while(choose < 1 || choose > 2);
        dataFileControl.UpdateFileBook(listBook, fileBook);
    }
    private static void editBook(Book book, List<Book> listBook) {
        int luachon;
        do {
            System.out.println("Bạn muốn :");
            System.out.println("1. Sửa thông tin");
            System.out.println("2. Xóa thông tin");
            System.out.println("3. Không thay đổi");
            System.out.print("Chọn : ");
            luachon = sc.nextInt();
            switch (luachon) {
                case 1:
                    int choice;
                    do {
                        System.out.println("Bạn muốn sửa : ");
                        System.out.println("1. Tên sách");
                        System.out.println("2. Tên tác giả");
                        System.out.println("3. Thể loại");
                        System.out.println("4. Năm xuất bản");
                        System.out.println("5. Số lượng");
                        System.out.println("6. Giá");
                        System.out.println("0. Đã xong");
                        choice = sc.nextInt();
                        sc.nextLine();
                        switch (choice) {
                            case 1:
                                System.out.println("Nhập tên sách : ");
                                book.setBookName(sc.nextLine());
                                break;
                            case 2:
                                System.out.print("Nhập tên tác giả : ");
                                book.setAuthor(sc.nextLine());
                                break;
                            case 3:
                                int specialize;
                                do {
                                    System.out.println("Chọn thể loại sách : ");
                                    System.out.println("1. Science");
                                    System.out.println("2. Art");
                                    System.out.println("3. Economic");
                                    System.out.println("4. IT");
                                    System.out.print("Chọn : ");
                                    specialize = sc.nextInt();
                                    if(specialize >= 1 && specialize <= 4) {
                                        book.setSpecialization(specializes[specialize - 1]);
                                    } else {
                                        System.out.println("Lựa chọn không hợp lệ");
                                    }
                                } while(specialize < 1 || specialize > 4);
                                break;
                            case 4:
                                System.out.print("Nhập năm xuất bản : ");
                                book.setPublishYear(sc.nextInt());
                                break;
                            case 5:
                                System.out.print("Nhập số lượng : ");
                                book.setQuantity(sc.nextInt());
                                break;
                            case 6:
                                System.out.print("Nhập giá tiền : ");
                                book.setPrice(sc.nextLong());
                                break;
                            case 0:
                                System.out.println("Đã sửa xong");
                                break;
                            default:
                                System.out.println("Cú pháp không hợp lệ");
                                break;
                        }
                    } while (choice != 0);
                    System.out.println("Sửa thành công.");
                    break;
                case 2:
                    listBook.remove(book);
                    System.out.println("Xóa thành công.");
                    break;
                case 3:
                    System.out.println("Không thay đổi.");
                    break;
                default:
                    System.out.println("Sai cú pháp");
                    break;
            }
        } while(luachon < 1 || luachon > 3);
    }
    private static void SortBook(List<Book> listBook, String fileBook) {
        int choose;
        do {
            System.out.println("Bạn muốn sắp xếp theo : ");
            System.out.println("1. ID");
            System.out.println("2. Tên sách");
            System.out.println("3. Thể loại");
            System.out.println("4. Số lượng");
            System.out.println("5. Giá thành");
            System.out.print("Chọn : ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    Collections.sort(listBook, new SortBookByID());
                    break;
                case 2:
                    Collections.sort(listBook, new SortBookByName());
                    break;
                case 3:
                    Collections.sort(listBook, new SortBookBySpecialization());
                    break;
                case 4:
                    Collections.sort(listBook, new SortBookByQuantity());
                    break;
                case 5:
                    Collections.sort(listBook, new SortBookByPrice());
                    break;
                default:
                    System.out.println("Sai cú pháp.");
                    break;
            }
        } while( choose < 1 || choose > 5);
        dataFileControl.UpdateFileBook(listBook,fileBook);
    }
    private static void SearchBook(List<Book> listBook) {
        int choice;
        do {
            System.out.println("Tìm sách theo : ");
            System.out.println("1. ID");
            System.out.println("2. Tên sách");
            System.out.println("3. Thể loại");
            System.out.print("Chọn : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Nhập id sách muốn tìm : ");
                    long id = sc.nextLong();
                    if(CheckExistBookID(id, listBook) == -1) {
                        System.out.println("Không tìm thấy id này.");
                    } else {
                        System.out.println(listBook.get(CheckExistBookID(id, listBook)));
                    }
                    break;
                case 2:
                    System.out.print("Nhập tên sách muốn tìm : ");
                    String nameBook = sc.nextLine();
                    List<Book> listSearch = SearchBookByName(nameBook, listBook);
                    if(listSearch.size() == 0) {
                        System.out.println("Không tìm thấy cuốn sách này.");
                    } else {
                        ShowAllBook(listSearch);
                    }
                    break;
                case 3:
                    int luachon;
                    do {
                        System.out.println("Chọn thể loại muốn tìm : ");
                        System.out.println("1. Science");
                        System.out.println("2. Art");
                        System.out.println("3. Economic");
                        System.out.println("4. IT");
                        System.out.print("Chọn : ");
                        luachon = sc.nextInt();
                        if(luachon < 1 || luachon > 4) {
                            System.out.println("Sai cú pháp.");
                        } else {
                            String specialize = specializes[luachon - 1];
                            List<Book> listSearchSpecial = SearchBookBySpecialization(specialize, listBook);
                            if(listSearchSpecial.size() == 0) {
                                System.out.println("Không tìm thấy cuốn sách thuộc thể loại này.");
                            } else {
                                ShowAllBook(listSearchSpecial);
                            }
                        }
                    } while(luachon < 1 || luachon > 4);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }while (choice < 1 || choice > 3);
    }

//    ====================== Reader ===========================
    private static void AddReader(List<Reader> listReader, String fileReader) {
        Reader reader = new Reader();
        do {
            System.out.print("Nhập id đọc giả : ");
            reader.setReaderID(sc.nextLong());
            if(!CheckRegex(reader.getReaderID(),REGEX_ID))
                System.out.println("ID phải có đủ 10 chữ số. Vui lòng nhập lại.");
        } while(!CheckRegex(reader.getReaderID(),REGEX_ID));
        sc.nextLine();
        System.out.print("Nhập tên độc giả : ");
        reader.setFullName(sc.nextLine());
        System.out.print("Nhập địa chỉ độc giả : ");
        reader.setAddress(sc.nextLine());
        do {
            System.out.print("Nhập số điện thoại độc giả : ");
            reader.setPhone(sc.nextLine());
            if(!CheckRegex(reader.getPhone(),REGEX_PHONE))
                System.out.println("Số điện thoại phải có đủ 10 chữ số và bắt đầu bằng số 0. Vui lòng nhập lại.");
        } while(!CheckRegex(reader.getPhone(),REGEX_PHONE));
        reader.setTotalBor(0);
        listReader.add(reader);
        dataFileControl.WriteReaderToFile(reader, fileReader);
    }
    private static void ShowAllReader(List<Reader> listReader) {
        for(Reader reader : listReader) {
            System.out.println(reader);
        }
    }
    private static void EditReaders(List<Reader> listReader, String fileReader) {
        int choose;
        do {
            System.out.println("Bạn muốn tìm độc giả bằng :");
            System.out.println("1. ID");
            System.out.println("2. Tên độc giả");
            System.out.print("Chọn : ");
            choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    System.out.print("Nhập id độc giả bạn muốn tìm : ");
                    long id  = sc.nextLong();
                    if(CheckExistReaderID(id, listReader) == -1) {
                        System.out.println("Không tìm thấy id độc giả này.");
                    } else {
                        Reader reader = listReader.get(CheckExistReaderID(id, listReader));
                        System.out.println(reader);
                        editReader(reader, listReader);
                    }
                    break;
                case 2:
                    System.out.print("Nhập tên độc giả bạn muốn tìm : ");
                    String fullName = sc.nextLine();
                    List<Reader> listSearch = SearchReaderByName(fullName, listReader);
                    if(listSearch.size() == 0) {
                        System.out.println("Không tìm thấy tên độc giả này.");
                    } else {
                        int choice;
                        ShowAllReader(listSearch);
                        do {
                            System.out.println("Độc giả bạn muốn sửa thông tin là : ");
                            for(int i = 0 ; i < listSearch.size() ; i++) {
                                System.out.println((i+1) + " " + listSearch.get(i).getFullName());
                            }
                            System.out.print("Chọn : ");
                            choice = sc.nextInt();
                            if(choice < 1 || choice > listSearch.size())
                                System.out.println("Lựa chọn không hợp lệ.");
                            else {
                                Reader reader = listSearch.get(choice - 1);
                                editReader(reader, listReader);
                            }
                        } while(choice < 1 || choice > listSearch.size());
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while(choose < 1 || choose > 2);
        dataFileControl.UpdateFileReader(listReader, fileReader);
    }
    private static void editReader(Reader reader, List<Reader> listReader) {
        int luachon;
        do {
            System.out.println("Bạn muốn :");
            System.out.println("1. Sửa thông tin");
            System.out.println("2. Xóa thông tin");
            System.out.println("3. Không thay đổi");
            System.out.print("Chọn : ");
            luachon = sc.nextInt();
            switch (luachon) {
                case 1:
                    int choice;
                    do {
                        System.out.println("Bạn muốn sửa : ");
                        System.out.println("1. Tên độc giả");
                        System.out.println("2. Địa chỉ độc giả");
                        System.out.println("3. Số điện thoại");
                        System.out.println("0. Đã xong");
                        choice = sc.nextInt();
                        sc.nextLine();
                        switch (choice) {
                            case 1:
                                System.out.println("Nhập tên độc giả : ");
                                reader.setFullName(sc.nextLine());
                                break;
                            case 2:
                                System.out.print("Nhập địa chỉ độc giả : ");
                                reader.setAddress(sc.nextLine());
                                break;
                            case 3:
                                System.out.print("Nhập số điện thoại : ");
                                reader.setPhone(sc.nextLine());
                                break;
                            case 0:
                                System.out.println("Đã sửa xong");
                                break;
                            default:
                                System.out.println("Cú pháp không hợp lệ");
                                break;
                        }
                    } while (choice != 0);
                    System.out.println("Sửa thành công.");
                    break;
                case 2:
                    listReader.remove(reader);
                    System.out.println("Xóa thành công.");
                    break;
                case 3:
                    System.out.println("Không thay đổi.");
                    break;
                default:
                    System.out.println("Sai cú pháp");
                    break;
            }
        } while(luachon < 1 || luachon > 3);
    }
    private static void SortReader(List<Reader> listReader, String fileReader) {
        int choose;
        do {
            System.out.println("Bạn muốn sắp xếp theo : ");
            System.out.println("1. ID");
            System.out.println("2. Tên độc giả");
            System.out.println("3. Số lượng sách mượn");
            System.out.print("Chọn : ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    Collections.sort(listReader, new SortReaderByID());
                    break;
                case 2:
                    Collections.sort(listReader, new SortReaderByName());
                    break;
                case 3:
                    Collections.sort(listReader, new SortReaderByTotalBor());
                default:
                    System.out.println("Sai cú pháp.");
                    break;
            }
        } while( choose < 1 || choose > 3);
        dataFileControl.UpdateFileReader(listReader,fileReader);
    }
    private static void SearchReader(List<Reader> listReader) {
        int choice;
        do {
            System.out.println("Tìm độc giả theo : ");
            System.out.println("1. ID");
            System.out.println("2. Tên độc giả");
            System.out.print("Chọn : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Nhập id độc giả muốn tìm : ");
                    long id = sc.nextLong();
                    if(CheckExistReaderID(id, listReader) == -1) {
                        System.out.println("Không tìm thấy id này.");
                    } else {
                        System.out.println(listReader.get(CheckExistReaderID(id, listReader)));
                    }
                    break;
                case 2:
                    System.out.print("Nhập tên độc giả muốn tìm : ");
                    String fullName = sc.nextLine();
                    List<Reader> listSearch = SearchReaderByName(fullName, listReader);
                    if(listSearch.size() == 0) {
                        System.out.println("Không tìm thấy tên độc giả này.");
                    } else {
                        ShowAllReader(listSearch);
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }while (choice < 1 || choice > 2);
    }

// ========================== Book Reader Managements ===================
    private static void BorrowBook(List<BookReaderManagement> listBRM, String fileBRM) {
        int luachon;
        boolean check = true;
        Book book = new Book();
        Reader reader = new Reader();
        do {
            System.out.println("Tìm độc giả mượn sách theo : ");
            System.out.println("1. ID");
            System.out.println("2. Tên độc giả : ");
            System.out.print("Chọn : ");
            luachon = sc.nextInt();
            sc.nextLine();
            switch (luachon) {
                case 1:
                    System.out.print("Nhập id độc giả muốn mượn sách : ");
                    long id = sc.nextLong();
                    if(CheckExistReaderID(id, listReader) == -1) {
                        System.out.println("Không tìm thấy id này.");
                        check = false;
                    } else {
                        System.out.println(listReader.get(CheckExistReaderID(id, listReader)));
                        reader = listReader.get(CheckExistReaderID(id, listReader));
                        check = true;
                    }
                    break;
                case 2:
                    System.out.print("Nhập tên độc giả muốn mượn sách : ");
                    String fullName = sc.nextLine();
                    List<Reader> listSearch = SearchReaderByName(fullName, listReader);
                    if(listSearch.size() == 0) {
                        System.out.println("Không tìm thấy tên độc giả này.");
                        check = false;
                    } else {
                        int choice;
                        ShowAllReader(listSearch);
                        do {
                            System.out.println("Độc giả muốn mượn sách là : ");
                            for(int i = 0 ; i < listSearch.size() ; i++) {
                                System.out.println((i+1) + " " + listSearch.get(i).getFullName());
                            }
                            System.out.print("Chọn : ");
                            choice = sc.nextInt();
                            if(choice < 1 || choice > listSearch.size())
                                System.out.println("Lựa chọn không hợp lệ.");
                            else {
                                reader = listSearch.get(choice - 1);
                            }
                        } while(choice < 1 || choice > listSearch.size());
                        check = true;
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    check = false;
                    break;
            }
        }while (!check);
        List<BookReaderManagement> listSearch = SearchReaderBorrowed(reader.getReaderID(), listBRM);
        ShowAllBRM(listSearch);
        if(listSearch.size() >= 5) {
            System.out.println("Đã mượn tối đã 5 đầu sách khác nhau.");
            return;
        }
        do {
            System.out.println("Tìm sách muốn mượn theo : ");
            System.out.println("1. ID");
            System.out.println("2. Tên sách");
            System.out.println("3. Thể loại");
            System.out.println("0. Không mượn.");
            System.out.print("Chọn : ");
            luachon = sc.nextInt();
            sc.nextLine();
            switch (luachon) {
                case 1:
                    System.out.print("Nhập id sách muốn mượn : ");
                    long id = sc.nextLong();
                    if(CheckExistBookID(id, listBook) == -1) {
                        System.out.println("Không tìm thấy id này.");
                        check = false;
                    } else {
                        System.out.println(listBook.get(CheckExistBookID(id, listBook)));
                        if(CheckBookBorrowed(id, listSearch) != -1) {
                            System.out.println("Bạn đã mượn cuốn sách này và chưa trả lại.");
                            check = false;
                        } else {
                            book = listBook.get(CheckExistBookID(id, listBook));
                            if(book.getQuantity() == 0) {
                                System.out.println("Sách này đã hết.");
                                check = false;
                            } else {
                                System.out.println("Mượn thành công.");
                                check = true;
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.print("Nhập tên sách muốn mượn : ");
                    String nameBook = sc.nextLine();
                    List<Book> listBookSearch = SearchBookByName(nameBook, listBook);
                    if(listBookSearch.size() == 0) {
                        System.out.println("Không tìm thấy cuốn sách này.");
                        check = false;
                    } else {
                        int choice;
                        ShowAllBook(listBookSearch);
                        do {
                            System.out.println("Cuốn sách bạn muốn mượn là : ");
                            for(int i = 0 ; i < listBookSearch.size() ; i++) {
                                System.out.println((i+1) + " " + listBookSearch.get(i).getBookName());
                            }
                            System.out.print("Chọn : ");
                            choice = sc.nextInt();
                            if(choice < 1 || choice > listBookSearch.size())
                                System.out.println("Lựa chọn không hợp lệ.");
                            else {
                                book = listBookSearch.get(choice - 1);
                                if(CheckBookBorrowed(book.getBookID(), listSearch) != -1) {
                                    System.out.println("Bạn đã mượn cuốn sách này và chưa trả lại.");
                                    check = false;
                                } else {
                                    if(book.getQuantity() == 0) {
                                        System.out.println("Sách này đã hết.");
                                        check = false;
                                    } else {
                                        System.out.println("Mượn thành công.");
                                        check = true;
                                    }
                                }
                            }
                        } while(choice < 1 || choice > listBookSearch.size());
                    }
                    break;
                case 3:
                    int choice;
                    do {
                        System.out.println("Chọn thể loại muốn tìm : ");
                        System.out.println("1. Science");
                        System.out.println("2. Art");
                        System.out.println("3. Economic");
                        System.out.println("4. IT");
                        System.out.print("Chọn : ");
                        choice = sc.nextInt();
                        if(choice < 1 || choice > 4) {
                            System.out.println("Sai cú pháp.");
                        } else {
                            String specialize = specializes[choice - 1];
                            List<Book> listSearchSpecial = SearchBookBySpecialization(specialize, listBook);
                            if(listSearchSpecial.size() == 0) {
                                System.out.println("Không tìm thấy cuốn sách thuộc thể loại này.");
                                check = false;
                            } else {
                                ShowAllBook(listSearchSpecial);
                                int choose;
                                do {
                                    System.out.println("Cuốn sách bạn muốn mượn là : ");
                                    for(int i = 0 ; i < listSearchSpecial.size() ; i++) {
                                        System.out.println((i+1) + " " + listSearchSpecial.get(i).getBookName());
                                    }
                                    System.out.print("Chọn : ");
                                    choose = sc.nextInt();
                                    if(choose < 1 || choose > listSearchSpecial.size())
                                        System.out.println("Lựa chọn không hợp lệ.");
                                    else {
                                        book = listSearchSpecial.get(choose - 1);
                                        if(CheckBookBorrowed(book.getBookID(), listSearch) != -1) {
                                            System.out.println("Bạn đã mượn cuốn sách này và chưa trả lại.");
                                            check = false;
                                        } else {
                                            if(book.getQuantity() == 0) {
                                                System.out.println("Sách này đã hết.");
                                                check = false;
                                            } else {
                                                System.out.println("Mượn thành công.");
                                                check = true;
                                            }
                                        }
                                    }
                                } while(choose < 1 || choose > listSearchSpecial.size());
                            }
                        }
                    } while(choice < 1 || choice > 4);
                    break;
                case 0:
                    System.out.println("Không mượn sách.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    check = false;
                    break;
            }
        }while (!check);
        int numOfBor;
        do {
            System.out.print("Nhập số lượng mượn (tối đa 3 cuốn) : ");
            numOfBor = sc.nextInt();
            if(book.getQuantity() < numOfBor) {
                System.out.println("Sách này chỉ còn " + book.getQuantity() + " cuốn.");
            }
            if(numOfBor == 0) return;
        } while (numOfBor < 0 || numOfBor > 3 || book.getQuantity() < numOfBor);
        int totalBor = reader.getTotalBor() + numOfBor;
        reader.setTotalBor(totalBor);
        int quantity = book.getQuantity() - numOfBor;
        book.setQuantity(quantity);
        sc.nextLine();
        System.out.print("Nhập tình trạng sách khi mượn : ");
        String status = sc.nextLine();
        date = new Date();
        String dateString = dateFormat.format(date);
        BookReaderManagement brm = new BookReaderManagement(book, reader, numOfBor, status, dateString);
        listBRM.add(brm);
        dataFileControl.WriteBRMToFile(brm, fileBRM);
        dataFileControl.UpdateFileBook(listBook, FILE_BOOK);
        dataFileControl.UpdateFileReader(listReader, FILE_READER);
    }
    private static void GiveBackBook(List<BookReaderManagement> listBRM, String fileBRM) {
        int choice;
        boolean check = true;
        Reader reader = new Reader();
        do {
            System.out.println("Tìm độc giả trả sách theo : ");
            System.out.println("1. ID");
            System.out.println("2. Tên độc giả");
            System.out.print("Chọn : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Nhập id độc giả muốn trả sách : ");
                    long id = sc.nextLong();
                    List<BookReaderManagement> listSearch = SearchReaderBorrowed(id, listBRM);
                    if(listSearch.size() == 0) {
                        System.out.println("Không tìm thấy độc giả trong danh sách mượn sách.");
                    } else {
                        ShowAllBRM(listSearch);
                        int choose;
                        do {
                            System.out.println(listSearch.get(0).getReader().getFullName() + " muốn trả : ");
                            for(int i = 0 ; i < listSearch.size() ;i++){
                                System.out.println((i+1) + listSearch.get(i).getNumOfBor() + " cuốn " + listSearch.get(i).getBook().getBookName());
                            }
                            System.out.println("0 Không trả nữa");
                            System.out.print("Chọn : ");
                            choose = sc.nextInt();
                            if(choose < 0 || choose > listSearch.size()) {
                                System.out.println("Sai cú pháp.");
                            } else if(choose == 0) {
                                return;
                            } else {
                                BookReaderManagement brm = listSearch.get(choose - 1);
                                int quantity = brm.getBook().getQuantity() + brm.getNumOfBor();
                                brm.getBook().setQuantity(quantity);
                                int totalBor = brm.getReader().getTotalBor() - brm.getNumOfBor();
                                brm.getReader().setTotalBor(totalBor);
                                listBRM.remove(brm);
                            }
                        } while (choose < 0 || choose > listSearch.size());
                    }
                    break;
                case 2:
                    System.out.print("Nhập tên độc giả muốn trả sách : ");
                    String fullName = sc.nextLine();
                    List<BookReaderManagement> listSearch2 = SearchReaderBorrowed(fullName, listBRM);
                    if(listSearch2.size() == 0) {
                        System.out.println("Không tìm thấy độc giả trong danh sách mượn sách.");
                    } else {
                        ShowAllBRM(listSearch2);
                        int choose;
                        do {
                            System.out.println("Độc giả  muốn trả : ");
                            for(int i = 0 ; i < listSearch2.size() ;i++){
                                System.out.println((i+1) + " " + listSearch2.get(i).getReader().getFullName() + " trả "
                                        + listSearch2.get(i).getNumOfBor() + " cuốn "
                                        + listSearch2.get(i).getBook().getBookName());
                            }
                            System.out.println("0 Không trả nữa");
                            System.out.print("Chọn : ");
                            choose = sc.nextInt();
                            if(choose < 0 || choose > listSearch2.size()) {
                                System.out.println("Sai cú pháp.");
                            } else if(choose == 0) {
                                return;
                            } else {
                                BookReaderManagement brm = listSearch2.get(choose - 1);
                                int quantity = brm.getBook().getQuantity() + brm.getNumOfBor();
                                brm.getBook().setQuantity(quantity);
                                int totalBor = brm.getReader().getTotalBor() - brm.getNumOfBor();
                                brm.getReader().setTotalBor(totalBor);
                                listBRM.remove(brm);
                                System.out.println("Trả sách thành công.");
                            }
                        } while (choose < 0 || choose > listSearch2.size());
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while(choice < 1 || choice > 2);
        dataFileControl.UpdateFileBRM(listBRM, fileBRM);
        dataFileControl.UpdateFileBook(listBook, FILE_BOOK);
        dataFileControl.UpdateFileReader(listReader, FILE_READER);
    }
    private static void SortBRM(List<BookReaderManagement> listBRM, String fileBRM) {
        int choice;
        do {
            System.out.println("Bạn muốn sắp xếp danh sách mượn sách theo : ");
            System.out.println("1. Tên người mượn");
            System.out.println("2. Ngày mượn");
            System.out.print("Chọn : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Collections.sort(listBRM, new SortBRMByReaderName());
                    break;
                case 2:
                    Collections.sort(listBRM, new SortBRMByDateBor());
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice < 1 || choice > 2);
        dataFileControl.UpdateFileBRM(listBRM, fileBRM);
    }
    private static void SearchBRM(List<BookReaderManagement> listBRM) {
        int choice;
        do {
            System.out.println("Tìm kiếm thông tin mượn sách theo : ");
            System.out.println("1. ID sách");
            System.out.println("2. Tên sách");
            System.out.println("3. ID độc giả");
            System.out.println("4. Tên độc giả");
            System.out.println("0. Thoát");
            System.out.print("Chọn : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Nhập id sách muốn tìm kiếm : ");
                    long bookID = sc.nextLong();
                    if(SearchBookBorrowed(bookID, listBRM).size() == 0) {
                        System.out.println("Không tìm thấy thông tin id sách này.");
                    } else {
                        ShowAllBRM(SearchBookBorrowed(bookID, listBRM));
                    }
                    break;
                case 2:
                    System.out.print("Nhập tên sách muốn tìm kiếm : ");
                    String bookName = sc.nextLine();
                    if(SearchBookBorrowed(bookName, listBRM).size() == 0) {
                        System.out.println("Không tìm thấy thông tin tên sách này.");
                    } else {
                        ShowAllBRM(SearchBookBorrowed(bookName, listBRM));
                    }
                    break;
                case 3:
                    System.out.print("Nhập id độc giả muốn tìm kiếm : ");
                    long readerID = sc.nextLong();
                    if(SearchReaderBorrowed(readerID, listBRM).size() == 0) {
                        System.out.println("Không tìm thấy thông tin id độc giả này.");
                    } else {
                        ShowAllBRM(SearchReaderBorrowed(readerID, listBRM));
                    }
                    break;
                case 4:
                    System.out.print("Nhập tên độc giả muốn tìm kiếm : ");
                    String fullName = sc.nextLine();
                    if(SearchReaderBorrowed(fullName, listBRM).size() == 0) {
                        System.out.println("Không tìm thấy thông tin tên độc giả này.");
                    } else {
                        ShowAllBRM(SearchReaderBorrowed(fullName, listBRM));
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        } while( choice < 1 || choice > 4);
    }
    private static void ShowAllBRM(List<BookReaderManagement> listBRM) {
        for(BookReaderManagement brm : listBRM)
            System.out.println(brm);
    }
    private static List<Book> SearchBookByName(String source, List<Book> listBook) {
        List<Book> listSearch = new ArrayList<>();
        for(Book book : listBook) {
            if(book.getBookName().contains(source))
                listSearch.add(book);
        }
        return listSearch;
    }
    private static List<Reader> SearchReaderByName(String source, List<Reader> listReader) {
        List<Reader> listSearch = new ArrayList<>();
        for(Reader reader : listReader) {
            if(reader.getFullName().contains(source))
                listSearch.add(reader);
        }
        return listSearch;
    }
    private static List<Book> SearchBookBySpecialization(String source, List<Book> listBook) {
        List<Book> listSearch = new ArrayList<>();
        for(Book book : listBook) {
            if(book.getSpecialization().compareTo(source) == 0)
                listSearch.add(book);
        }
        return listSearch;
    }
    private static int CheckExistBookID(long id, List<Book> listBook) {
        for(int i = 0 ; i < listBook.size() ; i++) {
            if(listBook.get(i).getBookID() == id)
                return i;
        }
        return -1;
    }
    private static int CheckExistReaderID(long id, List<Reader> listReader) {
        for(int i = 0 ; i < listReader.size();i++) {
            if(listReader.get(i).getReaderID() == id)
                return i;
        }
        return -1;
    }
    private static List<BookReaderManagement> SearchReaderBorrowed (long readerID, List<BookReaderManagement> listBRM) {
        List<BookReaderManagement> listSearch = new ArrayList<>();
        for(BookReaderManagement brm : listBRM) {
            if(brm.getReader().getReaderID() == readerID)
                listSearch.add(brm);
        }
        return listSearch;
    }
    private static List<BookReaderManagement> SearchReaderBorrowed (String fullName, List<BookReaderManagement> listBRM) {
        List<BookReaderManagement> listSearch = new ArrayList<>();
        for(BookReaderManagement brm : listBRM) {
            if(brm.getReader().getFullName().contains(fullName))
                listSearch.add(brm);
        }
        return listSearch;
    }
    private static List<BookReaderManagement> SearchBookBorrowed(long id, List<BookReaderManagement> listBRM) {
        List<BookReaderManagement> listSearch = new ArrayList<>();
        for(BookReaderManagement brm : listBRM) {
            if(brm.getBook().getBookID() == id)
                listSearch.add(brm);
        }
        return listSearch;
    }
    private static List<BookReaderManagement> SearchBookBorrowed(String nameBook, List<BookReaderManagement> listBRM) {
        List<BookReaderManagement> listSearch = new ArrayList<>();
        for(BookReaderManagement brm : listBRM){
            if(brm.getBook().getBookName().contains(nameBook))
                listSearch.add(brm);
        }
        return listSearch;
    }
    private static int CheckBookBorrowed(long bookID, List<BookReaderManagement> listBRM) {
        for(int i = 0 ; i < listBRM.size() ; i++) {
            if(listBRM.get(i).getBook().getBookID() == bookID)
                return i;
        }
        return -1;
    }
    private static boolean CheckRegex(long id, String regex) {
        String ID = String.valueOf(id);
        pattern = Pattern.compile(regex);
        return pattern.matcher(ID).find();
    }
    private static boolean CheckRegex(String phone, String regex) {
        pattern = Pattern.compile(regex);
        return pattern.matcher(phone).find();
    }

}
