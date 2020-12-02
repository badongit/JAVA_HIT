import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataControl {
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
            scanner = new Scanner(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void CloseFileAfterRead() {
        scanner.close();
    }
    public void WriteAccountToFile(String fileName, Account account) {
        OpenFileToWrite(fileName);
        printWriter.println(account.getId() + "|" + account.getFullName() + "|"
            + account.getUserName() + "|" + account.getPassword() + "|"
            + account.getEmail() + "|" + account.getPhone() + "|" + account.getCreatAt());
        CloseFileAfterWrite();
    }
    public List<Account> CreateAccountsFromFile(String fileName) {
        OpenFileToRead(fileName);
        List<Account> listAccounts = new ArrayList<>();
        while(scanner.hasNext()) {
            String data = scanner.nextLine();
            String[] accStr = data.split("\\|");
            Account account = new Account(Long.parseLong(accStr[0]), accStr[1], accStr[2],
                    accStr[3], accStr[4], accStr[5], accStr[6]);
            listAccounts.add(account);
        }
        CloseFileAfterRead();
        return listAccounts;
    }
    public void UpdateFile(String fileName, List<Account> listAccounts) {
        File file = new File(fileName);
        if(file.exists()) {
            file.delete();
        }
        for(Account account : listAccounts) {
            WriteAccountToFile(fileName, account);
        }
    }
}
