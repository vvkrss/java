public class Pair<T extends Comparable<T>> {
    private T first;
    private T second;
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    public T getFirst() {
        return first;
    }
    public T getSecond() {
        return second;
    }
    public T min() {
        return (first.compareTo(second) < 0) ? first : second;
    }
    public T max() {
        return (first.compareTo(second) > 0) ? first : second;
    }
    public static <T extends Comparable<T>> Pair<T> minMax(T[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        T min = arr[0];
        T max = arr[0];
        for (T element : arr) {
            if (element.compareTo(min) < 0) {
                min = element;
            }
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return new Pair<>(min, max);
    }
}