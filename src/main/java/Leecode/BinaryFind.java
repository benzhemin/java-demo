package Leecode;

import java.util.Arrays;

public class BinaryFind {

//    public static int binaryFind(int array[], int target, int start, int end) {
//
//        int mid = array.length / 2;
//        int value = array[mid];
//
//        if (value == target) {
//            return mid;
//        }
//
//        else if (target > value) {
//
//            start = mid + 1;
//            if (start > array.length - 1)
//                return -1;
//
//            return binaryFind(Arrays.copyOfRange(array, start, array.length-1), target);
//        } else {
//            int end = mid - 1;
//            if (end < 0)
//                return -1;
//
//            return binaryFind(Arrays.copyOfRange(array, 0, end), target);
//        }
//    }

    public static void main(String[] args) {
        int array[] = new int[] { 4, 5, 6, 7, 0, 1, 2};

//        int index = binaryFind(array, 0);
//        System.out.println("target index " + index);
    }
}
