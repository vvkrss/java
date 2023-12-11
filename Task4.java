import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
public class Task4 {
    public static <T, R> Optional<R> processElements(List<T> elements, Predicate<T> predicate, Function<T, R> mapper, BinaryOperator<R> operator) {
        return elements.stream()
                .filter(predicate)
                .map(mapper)
                .reduce(operator);
    }
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Predicate<Integer> predicate = n -> n / 3 == 1;
        Function<Integer, String> mapper = n -> "mod" + " = " + n % 2;
        BinaryOperator<String> operator = (result, element) -> result + " and " + element;
        Optional<String> result = processElements(numbers, predicate, mapper, operator);
        result.ifPresent(System.out::println);
    }
}