package collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InteratorSet {
    public static void main(String[] args) {

        List<Integer> numList = IntStream.rangeClosed(1, 5).boxed().toList();

        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);

        ListIterator<Integer> iterator = numberList.listIterator();

        while (iterator.hasNext()) {
            int current = iterator.next();
            iterator.set(current*2);
        }

        numberList.forEach(System.out::println);
    }



}
