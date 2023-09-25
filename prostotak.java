public class prostotak {
    public static void main(String[] args) {
        System.out.println(isSimple(44));
    }

    static boolean isSimple(int n) {
        int col = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                col += 1;
            }
        }
        if (col > 0) {
            return false;
        } else {
            return true;
        }
    }
}
