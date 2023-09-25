public class IntHolder {
    private int value;

    public IntHolder(int value) {
        this.value = value;
    }

    public static IntHolder valueOf(int value) {
        return new IntHolder(value);
    }

    public IntHolder add(IntHolder other) {
        return new IntHolder(this.value + other.value);
    }

    public IntHolder subtract(IntHolder other) {
        return new IntHolder(this.value - other.value);
    }

    public IntHolder multiply(IntHolder other) {
        return new IntHolder(this.value * other.value);
    }

    public IntHolder divide(IntHolder other) {
        if (other.value == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return new IntHolder(this.value / other.value);
    }

    public IntHolder remainder(IntHolder other) {
        return new IntHolder(this.value % other.value);
    }

    public static void swap(IntHolder i, IntHolder j) {
        int temp = i.value;
        i.value = j.value;
        j.value = temp;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static void main(String[] args) {
        IntHolder i1 = IntHolder.valueOf(10);
        IntHolder i2 = IntHolder.valueOf(5);

        System.out.println(i1.add(i2)); // 15
        System.out.println(i1.subtract(i2)); // 5
        System.out.println(i1.multiply(i2)); // 50
        System.out.println(i1.divide(i2)); // 2
        System.out.println(i1.remainder(i2)); // 0

        swap(i1, i2);
        System.out.println(i1); // 5
        System.out.println(i2); // 10
    }
}