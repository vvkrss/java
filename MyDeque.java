import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class MyDeque<T> implements Deque<T> {
    private Deque<T> stack1 = new ArrayDeque<>();
    private Deque<T> stack2 = new ArrayDeque<>();

    @Override
    public void addFirst(T element) {
        stack1.push(element);
    }

    @Override
    public void addLast(T element) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(element);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    @Override
    public boolean offerFirst(T element) {
        addFirst(element);
        return true;
    }

    @Override
    public boolean offerLast(T element) {
        addLast(element);
        return true;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return stack1.pop();
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return stack1.removeLast();
    }

    @Override
    public T pollFirst() {
        return isEmpty() ? null : stack1.pop();
    }

    @Override
    public T pollLast() {
        return isEmpty() ? null : stack1.pollLast();
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return stack1.peek();
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return stack1.peekLast();
    }

    @Override
    public T peekFirst() {
        return isEmpty() ? null : stack1.peek();
    }

    @Override
    public T peekLast() {
        return isEmpty() ? null : stack1.peekLast();
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        throw new UnsupportedOperationException("RemoveFirstOccurrence is not supported");
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        throw new UnsupportedOperationException("RemoveLastOccurrence is not supported");
    }

    @Override
    public boolean add(T t) {
        addLast(t);
        return true;
    }

    @Override
    public boolean offer(T t) {
        return offerLast(t);
    }

    @Override
    public T remove() {
        return removeFirst();
    }

    @Override
    public T poll() {
        return pollFirst();
    }

    @Override
    public T element() {
        return getFirst();
    }

    @Override
    public T peek() {
        return peekFirst();
    }

    @Override
    public void push(T t) {
        addFirst(t);
    }

    @Override
    public T pop() {
        return removeFirst();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Remove is not supported");
    }

    @Override
    public boolean contains(Object o) {
        return stack1.contains(o);
    }

    @Override
    public int size() {
        return stack1.size();
    }

    @Override
    public Iterator<T> iterator() {
        return stack1.iterator();
    }

    @Override
    public Iterator<T> descendingIterator() {
        return stack1.descendingIterator();
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    @Override
    public void clear() {
        stack1.clear();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("addAll is not supported");
    }
}