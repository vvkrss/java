public interface IntSequence {
    int get(int n);

    static IntSequence of(int... values) {
        return new IntSequence() {
            private int[] sequence = values;

            @Override
            public int get(int n) {
                if (n < sequence.length) {
                    return sequence[n];
                } else {
                    throw new IndexOutOfBoundsException("Index " + n + " is out of bounds.");
                }
            }
        };
    }

    static IntSequence constant(int value) {
        return new IntSequence() {
            @Override
            public int get(int n) {
                return value;
            }
        };
    }
}