package Leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Utils {
    public static <T> T getLast(List<T> list) {
        assert !list.isEmpty(): "should have at least one element in list";
        return list.get(list.size() -1);
    }
}

public class MinimumSequence {
    public static List findMinimumSequence(int array[]) {
        if (array.length <= 1)
            return Arrays.asList(array);

        List seqList = new ArrayList<List>();

        List resList = Arrays.stream(array)
                .mapToObj(v -> List.of(v))
                .reduce(
                        new ArrayList<>(),
                        (result, curList) -> {
                            if (result.isEmpty()) return curList;

                            int last = (int) Utils.getLast(result);
                            int cur = Utils.getLast(curList);

                            if (cur == last + 1) {
                                //result.add(cur);
                                List concatedList = Stream.concat(result.stream(), Stream.of(cur)).toList();
                                return concatedList;
                            }
                            seqList.add(result);
                            return curList;
                        }
                );

        if (!resList.isEmpty())
            seqList.add(resList);

        return seqList;
    }

    static List<List<Integer>> findMinimumSequence2(int array[]) {
        List<List<Integer>> seqList = new ArrayList();

        List<Integer> numList = new ArrayList();
        for (int i=0; i<array.length; i++) {
            if (numList.size() == 0) {
                numList.add(array[i]);
                continue;
            }

            int cur = array[i];
            int last = numList.get(numList.size() - 1);

            if (cur == last+1) {
                numList.add(cur);
            } else {
                seqList.add(List.copyOf(numList));
                numList.clear();
                numList.add(cur);
            }
        }

        if (numList.size() > 0) seqList.add(new ArrayList<>(numList));

        return seqList;
    }

    public static void main(String[] args) {
        int[] array = new int[]{ 0, 1, 2, 4, 5, 7};

        List<List<Integer>> seqList = MinimumSequence.findMinimumSequence2(array);
        seqList.forEach(seq -> {
            seq.forEach(v -> System.out.print(v + ","));
            System.out.println();
        });
    }
}
