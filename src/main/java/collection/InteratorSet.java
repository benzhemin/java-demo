package collection;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InteratorSet {
    public static void main(String[] args) {

        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);

        ListIterator<Integer> iterator = numberList.listIterator();

        while (iterator.hasNext()) {
            int current = iterator.next();
            iterator.set(current * 2);
        }

        numberList.forEach(i -> log.info(i.toString()));
    }

}
