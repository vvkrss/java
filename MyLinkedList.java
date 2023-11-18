import java.util.List;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class MyLinkedList<E> implements List<E>, Iterable<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(E element, Node<E> prev, Node<E> next) {
            this.data = element;
            this.prev = prev;
            this.next = next;
        }
    }

    public boolean add(E el) {
        Node<E> newNode = new Node<>(el, tail, null);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        size++;
        return true;
    }

    public void insertHead(E el) {
        Node<E> newNode = new Node<>(el, null, head);
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    public E getFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        return head.data;
    }

    // Получение последнего элемента списка
    public E getLast() {
        if (tail == null) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.data;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>(head);
    }

    private static class MyIterator<T> implements Iterator<T> {
        private Node<T> current;

        MyIterator(Node<T> head) {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            T data = current.data;
            current = current.next;
            return data;
        }

        public boolean hasPrevious() {
            return current != null && current.prev != null;
        }

        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException("No more elements");
            }
            T data = current.prev.data;
            current = current.prev;
            return data;
        }
    }
}