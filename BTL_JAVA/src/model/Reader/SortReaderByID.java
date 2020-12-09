package model.Reader;

import java.util.Comparator;

public class SortReaderByID implements Comparator<Reader> {
    @Override
    public int compare(Reader o1, Reader o2) {
        if(o1.getReaderID() > o2.getReaderID())
            return 1;
        else  if(o1.getReaderID() < o2.getReaderID())
            return -1;
        else return 0;
    }
}
