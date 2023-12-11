import java.util.function.BiFunction;
import java.util.function.Function;
public class Task3 {
    static <A, B, C> Function<A, Function<B, C>> curry(BiFunction<A, B, C> fn) {
        return a -> b -> fn.apply(a, b);
    }
    public static void main(String[] args) {
        String hello = "Hello";
        String name = "Vova";
        saySmth(hello, name);
    }
    static void saySmth(String word, String name) {
        Function<String, Function<String, String>> greet = curry((a, b) -> a + ", " + b);
        System.out.println(greet.apply(word).apply(name));
    }
}
