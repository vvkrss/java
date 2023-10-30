public class Main {
//task6
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
        } catch (ArithmeticException ex) {
            System.out.println("Деление на ноль");
        } catch (Throwable ex) {
            System.out.println("Что-то не так");
        }
    }
    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
//task7, tak8, task9
        try {
            int k = 42 / 0;
        } catch (ArithmeticException ex) {
            System.out.println("Ошибка деления на ноль: " + ex.getMessage());
        }
        try {
            String s = null;
            String m = s.toLowerCase();
        } catch (NullPointerException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }
        try {
            int[] m = new int[2];
            m[8] = 5;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }
    }
}
