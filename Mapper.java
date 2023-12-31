import java.util.List;
import java.util.function.Function;
import java.util.ArrayList;

public class Mapper {
    public static <T, R> List<R> map(List<T> list, Function<? super T, ? extends R> mapper) {
        List<R> result = new ArrayList<>();
        for (T item : list) {
            R mappedItem = mapper.apply(item);
            result.add(mappedItem);
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        Function<Integer, String> intToString = Object::toString;
        List<String> stringList = map(integerList, intToString);
        System.out.println(stringList);
    }
}