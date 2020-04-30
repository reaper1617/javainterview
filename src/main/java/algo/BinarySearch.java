package algo;


import java.util.Arrays;

public class BinarySearch {

    private static int binarySearch(Comparable[] arr, Comparable toFind) {
        // check if unsorted!
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int current = (low + high) / 2;
            if (arr[current].compareTo(toFind) == 0) return current;
            if (arr[current].compareTo(toFind) < 0) {
                low = low + current;
            } else {
                high = high - current;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Integer[] nums = new Integer[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = i * 2;
        }
        int found = binarySearch(nums, 4);
        System.out.println("Given arr = " + Arrays.toString(nums));
        System.out.println("found pos = " + found);
    }
}
