import java.util.Iterator;
import java.util.Arrays;
public class MyHashSet<E> implements BaseSet<E> {

    private static final int DEFAULT_CAPACITY = 1 << 4;
    private static final int MAX_CAPACITY = 1 << 30;
    private static final float LOAD_FACTOR = 0.75f;

    private Node<E>[] table;
    private int size;
    private final float loadFactor = LOAD_FACTOR;
    private int threshold;

    public MyHashSet() {
        table = new Node[DEFAULT_CAPACITY];
        threshold = (int) (DEFAULT_CAPACITY * LOAD_FACTOR);
    }

    private static int hash(Object key) {
        return key == null ? 0 : key.hashCode();
    }
    
    private void resize() {
        int newCapacity = table.length * 2;
        if (newCapacity > MAX_CAPACITY) {
            return;
        }

        Node<E>[] newTable = new Node[newCapacity];
        threshold = (int) (newCapacity * loadFactor);

        for (Node<E> node : table) {
            while (node != null) {
                Node<E> next = node.next;
                int index = indexFor(node.hash, newCapacity);
                node.next = newTable[index];
                newTable[index] = node;
                node = next;
            }
        }
        table = newTable;
    }

    private int indexFor(int hash, int capacity) {
        return hash & (capacity - 1);
    }

    @Override
    public void add(E e) {
        if (size + 1 >= threshold) {
            resize();
        }

        int hash = hash(e);
        int index = indexFor(hash, table.length);

        Node<E> newNode = new Node<>(hash, e, table[index]);
        table[index] = newNode;
        size++;
    }

    @Override
    public void remove(Object o) {
        int hash = hash(o);
        int index = indexFor(hash, table.length);

        Node<E> prev = null;
        Node<E> current = table[index];

        while (current != null) {
            if (current.key.equals(o)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    @Override
    public void clear() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        int hash = hash(o);
        int index = indexFor(hash, table.length);

        Node<E> current = table[index];

        while (current != null) {
            if (current.key.equals(o)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyHashSet<?> myHashSet = (MyHashSet<?>) o;
        return size == myHashSet.size && Arrays.equals(table, myHashSet.table);
    }
    
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }

    static class Node<T> {
        final int hash;
        final T key;
        Node<T> next;

        public Node(int hash, T key, Node<T> next) {
            this.hash = hash;
            this.key = key;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public String toString() {
            return null;
        }
    }
}
interface BaseSet<E> {
    void add(E e);
    void remove(Object o);
    void clear();
    boolean contains(Object o);
    boolean isEmpty();
    int size();
}