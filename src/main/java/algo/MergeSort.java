package algo;

import java.util.Arrays;

public class MergeSort {

    private static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        if (merged.length == 0) return merged;
        int leftCounter = 0;
        int rightCounter = 0;
        for(int i = 0; i < merged.length; i++){
            if (leftCounter == left.length){
                merged[i] = right[rightCounter];
                rightCounter++;
            }
            else if (rightCounter == right.length){
                merged[i] = left[leftCounter];
            }
            else if (left[leftCounter] >= right[rightCounter]){
                merged[i] = right[rightCounter];
                rightCounter++;
            }
            else {
                merged[i] = left[leftCounter];
                leftCounter++;
            }
        }
        return merged;
    }

    public static int[] sort(int[] arr) {
        int length = arr.length;
        if (length < 2) {
            return arr;
        }
        int mid = length / 2;
        int[] left = new int[mid];

        System.arraycopy(arr, 0, left, 0, left.length);
        int[] right = new int[length - mid];

        System.arraycopy(arr, mid, right, 0, right.length);
        int[] sortedLeft = sort(left);
        int[] sortedRight = sort(right);
        return merge(sortedLeft, sortedRight);
    }


    public static void main(String[] args) {


        int[] arr = {1, 3, 4, 5, 2, 6, 7, 8, 3};

        int[] res = sort(arr);

        System.out.println(Arrays.toString(res));

    }
}
