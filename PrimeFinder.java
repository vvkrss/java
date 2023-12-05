import java.util.*;

public class PrimeFinder {
    public static List<Integer> findPrimes(int n) {
        Set<Integer> primes = new HashSet<>();
        for (int num = 2; num <= n; num++) {
            primes.add(num);
        }
        for (int num = 2; num <= n; num++) {
            if (primes.contains(num)) {
                for (int multiple = 2 * num; multiple <= n; multiple += num) {
                    primes.remove(multiple);
                }
            }
        }
        List<Integer> result = new ArrayList<>(primes);
        Collections.sort(result);
        return result;
    }
}
