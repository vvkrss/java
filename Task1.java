import java.util.function.BiFunction;
import java.util.function.Function;
public class Task1 {
    static <A, B, C> Function<B, C> bind(BiFunction<A, B, C> fn, A a) {
        return b -> fn.apply(a, b);
    }
    public static void main(String[] args) {
        Integer num = 10;
        multiplyByTwo(num);
    }
    static void multiplyByTwo(Integer n) {
        Function<Integer, Integer> result = bind((a, b) -> a * b, 2);
        System.out.println(result.apply(n));
    }
}