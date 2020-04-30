package train_tasks;

import java.util.Arrays;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 */
public class RotateArrayMain {

    public static void rotate(int[] nums, int k){
        int len = nums.length;
        if (len < 2 || k == 0) return;

        if ( len % k == 0){
            rotate(nums, k-1);
        }

        int p = len % k == 0 ? 1: k;
        int current = 0;
        int next; // = current + k >= len ? (current + k) / len : current + k;
        int saved; // = nums[next];
        int toTransfer = nums[current]; // = nums[current];

        for (int i = 0; i < len; i++){
            next = current + p > len -1 ? (current + p) % len : current + p;
            saved = nums[next];
            nums[next] = toTransfer;
            toTransfer = saved;
            current = next;
        }


    }

    public static void main(String[] args) {
        int[] arr = {1,2};
        int k = 2;
        rotate(arr, k);
        System.out.println("Arr: " + Arrays.toString(arr));
    }
}
