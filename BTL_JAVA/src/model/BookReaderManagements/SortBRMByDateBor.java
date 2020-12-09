package model.BookReaderManagements;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class SortBRMByDateBor implements Comparator<BookReaderManagement> {
    @Override
    public int compare(BookReaderManagement o1, BookReaderManagement o2) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            Date dateBefore = dateFormat.parse(o1.getDateBor());
            Date dateAfter = dateFormat.parse(o2.getDateBor());
            return dateBefore.compareTo(dateAfter);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
