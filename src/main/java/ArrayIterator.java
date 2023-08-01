import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private int index;
    private T[] values;

    public ArrayIterator(T[] values) {
        this.values = values;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.values.length;
    }

    @Override
    public T next() {
        return this.values[index++];
    }
}
