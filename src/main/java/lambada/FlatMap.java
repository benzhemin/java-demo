package lambada;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class FlatMap {
    public static void main(String[] args) {
        List<Integer> fList= Arrays.asList(1, 2, 3);
        List<Integer> sList = Arrays.asList(4, 5, 6);

        List<List<Integer>> wrapList = Arrays.asList(fList, sList);

        List<Integer> flatList = wrapList.stream()
                .flatMap(Collection::stream).toList();

        flatList.forEach(System.out::println);
    }
}
