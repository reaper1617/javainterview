package algo;

import java.util.Arrays;

public class QuickSort {


    static int partition(int[] array, int beginIndex, int endIndex){
        int counter = beginIndex;

        for(int i = beginIndex; i < endIndex; i++){
            if (array[i] < array[endIndex]){
                int tmp = array[counter];
                array[counter] = array[i];
                array[i] = tmp;
                counter++;
            }
        }
        int temp = array[endIndex];
        array[endIndex] = array[counter];
        array[counter] = temp;
        return counter;
    }

    public static void qSort(int[] array, int beginIndex, int endIndex){
        if (array.length < 2 || beginIndex >=endIndex){
            return;
        }
        int pivot = partition(array, beginIndex, endIndex);
        qSort(array, 0, pivot-1);
        qSort(array, pivot+1, endIndex);
    }


    public static void main(String[] args) {
        int[] arr = {1,5,3,7,45,3,66,22,4,3,77,43};
        qSort(arr,0,11);
        System.out.println(Arrays.toString(arr));
    }
}
