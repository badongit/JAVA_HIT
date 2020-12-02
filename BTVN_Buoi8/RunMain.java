import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class RunMain {

    static final String REGEX_USERNAME = "^[A-Za-z\\d]{6,}$";
    static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    static final String REGEX_EMAIL = "^[\\w-\\.]+@gmail.com$";
    static final String REGEX_PHONE = "^0\\d{9}$";
    static final String FILE_NAME = "ACC.DAT";

    static Date date;
    static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static Pattern pattern;
    static Scanner scanner = new Scanner(System.in);
    static List<Account> listAccounts = new ArrayList<>();
    static DataControl dataControl = new DataControl();
    static boolean check = false;

    public static void main(String[] args) {
        dataControl.OpenFileToWrite(FILE_NAME);
        dataControl.CloseFileAfterWrite();
        listAccounts = dataControl.CreateAccountsFromFile(FILE_NAME);
        int choice;
        do {
            System.out.println("*********************************");
            System.out.println("1. Đăng kí.");
            System.out.println("2. Đăng nhập.");
            System.out.println("3. Sắp xếp danh sách tài khoản.");
            System.out.println("4. Thoát.");
            System.out.println("*********************************");
            System.out.print("Nhập lựa chọn : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("\t\t\t================ ĐĂNG KÝ TÀI KHOẢN ================");
                    SignUp();
                    break;
                case 2:
                    System.out.println("\t\t\t================ ĐĂNG NHẬP TÀI KHOẢN ================");
                    Login();
                    break;
                case 3:
                    Collections.sort(listAccounts, new SortByUserName());
                    dataControl.UpdateFile(FILE_NAME, listAccounts);
                    System.out.println("\t\t\t================ DANH SÁCH TÀI KHOẢN ================");
                    for(Account account : listAccounts) {
                        System.out.println(account);
                    }
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while(choice != 4);
    }

    private static boolean checkRegex(String string, String regex) {
        pattern = Pattern.compile(regex);
        return pattern.matcher(string).find();
    }

    private static boolean checkExistId(long id) {
        for(Account account : listAccounts) {
            if(account.getId() == id)
                return false;
        }
        return true;
    }
    private static boolean checkExistUserName( String userName) {
        for(Account account : listAccounts) {
            if(account.getUserName().compareTo(userName) == 0)
                return false;
        }
        return true;
    }
    private static boolean checkExistPassword(String password, String repassword) {
        if(password.compareTo(repassword) == 0)
            return true;
        return false;
    }
    private static int checkExistAccount(String userName, String password) {
        for(int i = 0; i < listAccounts.toArray().length;i++) {
            if(listAccounts.get(i).getUserName().compareTo(userName) == 0)
                if(checkExistPassword(listAccounts.get(i).getPassword(), password))
                    return i;
        }
        return -1;
    }
    private static void SignUp() {
        Account account = new Account();
        do {
            System.out.print("Nhập id : ");
            account.setId(scanner.nextLong());
            check = checkExistId(account.getId());
            if(!check) {
                System.out.println("Id đã tồn tại.");
            }
        }while(!check);
        scanner.nextLine();
        System.out.print("Nhập họ tên : ");
        account.setFullName(scanner.nextLine());
        do {
            System.out.print("Nhập tên người dùng : ");
            account.setUserName(scanner.nextLine());
            check = checkRegex(account.getUserName(), REGEX_USERNAME);
            if(!check) {
                System.out.println("Tên người dùng chứa các kí tự thường, hoa, số, ít nhất 6 kí tự.");
            } else {
                check = checkExistUserName(account.getUserName());
                if(!check) System.out.println("Tên người dùng đã tồn tại.");
            }
        }while(!check);
        do {
            System.out.print("Nhập mật khẩu : ");
            account.setPassword(scanner.nextLine());
            check = checkRegex(account.getPassword(), REGEX_PASSWORD);
            if(!check) {
                System.out.println("Mật khẩu tối thiểu 8 kí tự, ít nhất một chữ cái viết hoa, " +
                        "một chữ cái viết thường, một số và một ký tự đặc biệt.");
            } else {
                System.out.print("Xác nhận lại mật khẩu : ");
                String repassword = scanner.nextLine();
                check = checkExistPassword(account.getPassword(), repassword);
                if(!check) {
                    System.out.println("Xác nhận thất bại! Nhập lại.");
                }
            }
        } while (!check);
        do {
            System.out.print("Nhập email : ");
            account.setEmail(scanner.nextLine());
            check = checkRegex(account.getEmail(), REGEX_EMAIL);
            if(!check)
                System.out.println("Email phải có đuôi @gmail.com");
        } while (!check);
        do {
            System.out.print("Nhập số điện thoại : ");
            account.setPhone(scanner.nextLine());
            check = checkRegex(account.getPhone(), REGEX_PHONE);
            if(!check)
                System.out.println("Số điện thoại phải là dãy 10 chữ số bắt đầu từ số 0.");
        } while (!check);
        date = new Date();
        account.setCreatAt(dateFormat.format(date));
        listAccounts.add(account);
        dataControl.WriteAccountToFile(FILE_NAME, account);
    }
    private static void Login() {
        System.out.print("Tên người dùng : ");
        String userName = scanner.nextLine();
        System.out.print("Mật khẩu : ");
        String password = scanner.nextLine();
        if(checkExistAccount(userName, password) == -1) {
            System.out.println("Tên người dùng hoặc mật khẩu không đúng.");
        } else {
            int index = checkExistAccount(userName, password);
            System.out.println("Đăng nhập thành công.");
            int choose;
            do {
                System.out.println("******************************");
                System.out.println("1. Thông tin tài khoản.");
                System.out.println("2. Thay đổi mật khẩu.");
                System.out.println("3. Đăng xuất.");
                System.out.println("******************************");
                System.out.print("Nhập lựa chọn : ");
                choose = scanner.nextInt();
                scanner.nextLine();
                switch (choose) {
                    case 1:
                        System.out.printf("%50s%s\n", " ", "THÔNG TIN NGƯỜI DÙNG");
                        System.out.printf("%-10s%-30d%-20s%s\n", "ID: ", listAccounts.get(index).getId(),
                                "Tên người dùng: ", listAccounts.get(index).getUserName());
                        System.out.printf("%-10s%-30s%-20s%s\n", "Họ tên : ", listAccounts.get(index).getFullName(),
                                "Email : ", listAccounts.get(index).getEmail());
                        System.out.printf("%-10s%-30s%-20s%s\n", "SĐT : ", listAccounts.get(index).getPhone(),
                                "Ngày tạo : ", listAccounts.get(index).getCreatAt());
                        break;
                    case 2:
                        System.out.printf("%50s%s\n", " ", "THAY ĐỔI MẬT KHẨU");
                        System.out.print("Nhập mật khẩu cũ : ");
                        String oldPassword = scanner.nextLine();
                        check = checkExistPassword(oldPassword, listAccounts.get(index).getPassword());
                        if(!check) {
                            System.out.println("Mật khẩu không đúng.");
                        } else {
                            System.out.print("Nhập mật khẩu mới : ");
                            String newPassword = scanner.nextLine();
                            check = checkRegex(newPassword, REGEX_PASSWORD);
                            if(!check) {
                                System.out.println("Mật khẩu tối thiểu 8 kí tự, ít nhất một chữ cái viết hoa, " +
                                        "một chữ cái viết thường, một số và một ký tự đặc biệt.");
                            } else {
                                System.out.print("Xác nhận lại mật khẩu : ");
                                String repassword = scanner.nextLine();
                                check = checkExistPassword(newPassword, repassword);
                                if(!check) {
                                    System.out.println("Xác nhận thất bại! Thay đổi mật khẩu không thành công.");
                                } else {
                                    listAccounts.get(index).setPassword(newPassword);
                                    dataControl.UpdateFile(FILE_NAME, listAccounts);
                                    System.out.println("Thay đổi mật khẩu thành công.");
                                }
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Đăng xuất thành công.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                        break;
                }
            }while (choose != 3);
        }
    }

}
