import java.util.function.Function;

public class Task4 {
    public static void main(String[] args) {
        Function<Integer, String> checkNumber = (number) -> {
            if (number > 0) {
                return "Положительное число";
            } else if (number < 0) {
                return "Отрицательное число";
            } else {
                return "Ноль";
            }
        };

        int num1 = 100000;
        int num2 = -1000000;
        int num3 = 0;

        System.out.println(checkNumber.apply(num1));
        System.out.println(checkNumber.apply(num2));
        System.out.println(checkNumber.apply(num3));
    }
}