package model.Reader;

import java.util.Comparator;

public class SortReaderByTotalBor implements Comparator<Reader> {
    @Override
    public int compare(Reader o1, Reader o2) {
        return o1.getTotalBor() - o2.getTotalBor();
    }
}
