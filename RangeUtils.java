import java.util.AbstractList;
import java.util.List;

public class RangeUtils {

    public static List<Integer> rangeList(int from, int to) {
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                if (index < 0 || index >= size()) {
                    throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
                }
                return from + index;
            }

            @Override
            public int size() {
                return Math.max(0, to - from);
            }

            @Override
            public int indexOf(Object o) {
                if (o instanceof Integer) {
                    int value = (Integer) o;
                    if (value >= from && value < to) {
                        return value - from;
                    }
                }
                return -1;
            }

            @Override
            public int lastIndexOf(Object o) {
                return indexOf(o);
            }

            @Override
            public boolean contains(Object o) {
                return indexOf(o) != -1;
            }
        };
    }

    public static void main(String[] args) {
        List<Integer> range = rangeList(1, 5);
        System.out.println("Range: " + range);

        int target = 3;
        System.out.println("Index of " + target + ": " + range.indexOf(target));
        System.out.println("Last index of " + target + ": " + range.lastIndexOf(target));
        System.out.println("Contains " + target + ": " + range.contains(target));
    }
}