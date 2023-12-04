public interface TwoDMatrix<T> {
    void addElement(T element);
    void removeElement(int row, int col);
    T getElement(int row, int col);
}
