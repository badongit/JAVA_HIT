package model.Book;

import java.util.Comparator;

public class SortBookByID implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        if(o1.getBookID() - o2.getBookID() < 0)
            return  -1;
        else if(o1.getBookID() - o2.getBookID() > 0)
            return 1;
        else return 0;
    }
}
