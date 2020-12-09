package model.Book;

import model.SlugString;

import java.util.Comparator;

public class SortBookByName implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        SlugString slugString = new SlugString();
        return slugString.Slug(o1.getBookName()).compareTo(slugString.Slug(o2.getBookName()));
    }
}
