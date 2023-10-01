public class IntHolder {
    private int value;
    public IntHolder(int value) {
        this.value = value;
    }
    public static IntHolder valueOf(int value) {
        return new IntHolder(value);
    }
    public IntHolder subtract(IntHolder other) {
        return new IntHolder(this.value - other.value);
    }
    public IntHolder add(IntHolder other) {
        return new IntHolder(this.value + other.value);    
    }
    public IntHolder multiply(IntHolder other) {
        return new IntHolder(this.value * other.value);
    }
    public IntHolder remainder(IntHolder other) {
        return new IntHolder(this.value % other.value);
    }
    public IntHolder divide(IntHolder other) {
        if (other.value == 0) {
            throw new ArithmeticException("Division by zero prohibited");
        }
        return new IntHolder(this.value / other.value);
    }
    public static void swap(IntHolder value1, IntHolder value2) {
        int tempr = value1.value;
        value1.value = value2.value;
        value2.value = tempr;
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
    public static void main(String[] args) {
        IntHolder v1 = IntHolder.valueOf(10);
        IntHolder v2 = IntHolder.valueOf(5);
        swap(v1, v2);
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v1.subtract(v2));
        System.out.println(v1.add(v2));
        System.out.println(v1.multiply(v2));
        System.out.println(v1.remainder(v2));
        System.out.println(v1.divide(v2));
    }
}
