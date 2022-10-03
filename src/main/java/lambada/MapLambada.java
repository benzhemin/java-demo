package lambada;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapLambada {

    public static void main(String[] args) {

        Map<String, Set<String>> map = new HashMap<>();

        map.computeIfAbsent("first", key -> {
            Set<String> set =new HashSet<>();
            set.add(key + ": " + "One");
            return set;
        });

        map.computeIfPresent("first", (key, set) -> {
            set.add("Two");
            return set;
        });

        map.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });
    }
}
