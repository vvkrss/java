import java.util.function.BiFunction;
import java.util.function.Function;
public class Task2 {
    static <A, B, C> Function<B, C> bind(BiFunction<A, B, C> fn, A a) {
        return b -> fn.apply(a, b);
    }
    public static void main(String[] args) {
        String str = "HelloWorld";
        substringFiveSymbols(str);
    }
    static void substringFiveSymbols(String str) {
        Function<String, String> result = bind((a, b) -> b.substring(0, a), 5);
        System.out.println(result.apply(str));
    }
}