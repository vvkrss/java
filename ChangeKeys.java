import java.util.*;

class ChageKeys {
    public static <K, V> Map<V, Collection<K>> inverse(Map<? extends K, ? extends V> map) {
        Map<V, Collection<K>> inversedMap = new HashMap<>();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();
            if (!inversedMap.containsKey(value)) {
                inversedMap.put(value, new ArrayList<>());
            }
            inversedMap.get(value).add(key);
        }
        return inversedMap;
    }
}