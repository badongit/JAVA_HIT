package model.Reader;

import model.SlugString;

import java.util.Comparator;

public class SortReaderByName implements Comparator<Reader> {
    @Override
    public int compare(Reader o1, Reader o2) {
        String[] nameBefore = o1.getFullName().trim().split("\\s+");
        String[] nameAfter= o2.getFullName().trim().split("\\s+");
        SlugString slugString = new SlugString();
        return slugString.Slug(nameBefore[nameBefore.length -1]).compareTo(slugString.Slug(nameAfter[nameAfter.length -1]));
    }
}
