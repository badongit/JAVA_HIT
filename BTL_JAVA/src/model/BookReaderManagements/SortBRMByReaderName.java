package model.BookReaderManagements;

import model.SlugString;

import java.util.Comparator;

public class SortBRMByReaderName implements Comparator<BookReaderManagement> {
    @Override
    public int compare(BookReaderManagement o1, BookReaderManagement o2) {
        String[] nameBefore = o1.getReader().getFullName().trim().split("\\s+");
        String[] nameAfter= o2.getReader().getFullName().trim().split("\\s+");
        SlugString slugString = new SlugString();
        return slugString.Slug(nameBefore[nameBefore.length -1]).compareTo(slugString.Slug(nameAfter[nameAfter.length -1]));
    }
}
