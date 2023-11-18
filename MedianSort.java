import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MedianSort {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 3, 7, 2, 5));
        List<Integer> sortedList = medianSort(numbers);
        System.out.println(sortedList);
    }

    public static List<Integer> medianSort(List<Integer> list) {
        Collections.sort(list, Comparator.comparingInt(num -> (int) Math.abs(num - findMedian(list))));
        return list;
    }

    private static double findMedian(List<Integer> list) {
        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        int middle = sortedList.size() / 2;
        if (sortedList.size() % 2 == 0) {
            return (sortedList.get(middle - 1) + sortedList.get(middle)) / 2.0;
        } else {
            return sortedList.get(middle);
        }
    }
}