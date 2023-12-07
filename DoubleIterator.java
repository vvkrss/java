import java.util.Iterator;

public class DoubleIterator<T> implements Iterator<T> {

    private final Iterator<T> firstIterator;
    private final Iterator<T> secondIterator;
    private Iterator<T> currentIterator;

    public DoubleIterator(Iterator<T> firstIterator, Iterator<T> secondIterator) {
        this.firstIterator = firstIterator;
        this.secondIterator = secondIterator;
        this.currentIterator = firstIterator;
    }

    @Override
    public boolean hasNext() {
        while (currentIterator.hasNext()) {
            return true;
        }
        if (currentIterator == firstIterator) {
            currentIterator = secondIterator;
            return hasNext();
        }
        return false;
    }

    @Override
    public T next() {
        if (hasNext()) {
            return currentIterator.next();
        }
        return null;
    }
}