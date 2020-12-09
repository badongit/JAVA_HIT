package model.Book;

import java.util.Comparator;

public class SortBookBySpecialization implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getSpecialization().compareTo(o2.getSpecialization());
    }
}
