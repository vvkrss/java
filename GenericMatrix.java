public class GenericMatrix<T> implements TwoDMatrix<T> {
    private int numRows;
    private int numCols;
    private T[][] matrix;

    public GenericMatrix(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        matrix = (T[][]) new Object[numRows][numCols];
    }
    public GenericMatrix(T[][] values) {
        this.numRows = values.length;
        this.numCols = values[0].length;
        matrix = (T[][]) new Object[numRows][numCols];

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                matrix[row][col] = values[row][col];
            }
        }
    }
    @Override
    public void addElement(T element) {
        // Добавляем элемент в следующую свободную ячейку матрицы
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (matrix[row][col] == null) {
                    matrix[row][col] = element;
                    return;
                }
            }
        }
    }
    @Override
    public void removeElement(int row, int col) {
        if (row >= 0 && row < numRows && col >= 0 && col < numCols) {
            matrix[row][col] = null;
        }
    }
    @Override
    public T getElement(int row, int col) {
        if (row >= 0 && row < numRows && col >= 0 && col < numCols) {
            return matrix[row][col];
        }
        return null;
    }
}
