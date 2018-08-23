package practice.algorithms.sorting;

import static java.util.Arrays.copyOfRange;

public final class MergeSort {
    private MergeSort(){}

    public static void TopDownSort(int[] array) {

        TopDownSplitMerge(array,0,array.length);
    }

    private static void TopDownSplitMerge(int[] array, int start, int end) {
        if((end - start)<2) return;
        int middle = (start + end)/2;
        TopDownSplitMerge(array,start,middle);
        TopDownSplitMerge(array,middle,end);
        TopDownMerge(array,start,end);
    }

    private static void TopDownMerge(int[] array, int start, int end) {
        int middle = (start + end)/2;
        int left = start;
        int right = middle;
        int[] buffer  =  copyOfRange(array,start,end+1);
        for(int i = start; i < end; i++){
            if(left < middle && (right >= end||buffer[left]> buffer [right])){
                array[i] = buffer[left++];
            }else {
                array[i] = buffer[right++];
            }
        }

    }
}
