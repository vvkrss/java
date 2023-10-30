public class Task3 {
    public static void executePrint(Printable printable) {
        printable.print();
    }

    public static void main(String[] args) {
        Printable myLambda = () -> System.out.println("HELLO WORLD");

        executePrint(myLambda);
    }
}
