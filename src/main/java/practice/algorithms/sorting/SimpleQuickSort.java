package practice.algorithms.sorting;

import static practice.algorithms.sorting.SortUtil.*;
import static practice.algorithms.sorting.SortUtil.swap;

public class SimpleQuickSort {

    public static void sort(int[] array){
        shuffle(array);
        sort(array,0,array.length-1);
    }
    private static void sort(int[] array,int start, int end){
        if(start >= end)return;
        int index  = partition(array,start, end);
        sort(array,start,index-1);
        sort(array,index,end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[(start+end)/2];
        while (start <= end){
             while (array[start] < pivot){
                start++;
            }
             while (array[end] > pivot){
                end--;
            }
            if(start <= end){
                swap(array,start,end);
                start++;
                end--;
            }
        }
        return start;
    }


}
