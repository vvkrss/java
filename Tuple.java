public class Tuple<E> {
    private Object[] elements;
    private int size;

    public Tuple(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity should be greater than 0");
        }
        elements = new Object[capacity];
        size = 0;
    }
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return (E) elements[index];
    }
    public void add(E el) {
        if (size < elements.length) {
            elements[size] = el;
            size++;
        } else {
            throw new IllegalStateException("Tuple is already at its maximum capacity");
        }
    }
    public void add(E el, int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        elements[index] = el;
        size = Math.max(size, index + 1);
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }
    public void remove(E el) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(el)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            remove(index);
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public E orElse(int i, E defaultValue) {
        if (i < 0 || i >= size) {
            return defaultValue;
        }
        return (E) elements[i];
    }
}