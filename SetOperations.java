import java.util.Set;
import java.util.HashSet;
public class SetOperations {
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> unionSet = new HashSet<>(s1);
        unionSet.addAll(s2);
        return unionSet;
    }

    public static <E> Set<E> intersection(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> intersectionSet = new HashSet<>(s1);
        intersectionSet.retainAll(s2);
        return intersectionSet;
    }

    public static <E> Set<E> difference(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> differenceSet = new HashSet<>(s1);
        differenceSet.removeAll(s2);
        return differenceSet;
    }

    public static <E> Set<E> symmetricDifference(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> symmetricDifferenceSet = new HashSet<>(s1);
        Set<E> tmp = new HashSet<>(s2);
        symmetricDifferenceSet.removeAll(s2);
        tmp.removeAll(s1);
        symmetricDifferenceSet.addAll(tmp);
        return symmetricDifferenceSet;
    }
}
