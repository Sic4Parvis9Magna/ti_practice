package practice.algorithms.sorting;

import static practice.algorithms.sorting.SortUtil.swap;

public final class SelectionSort {
    private SelectionSort(){}

    public static void sort(int[] array){
        for(int i=0;i< array.length-1;i++){

            int indexOfMin = i;
            for(int j = i+1; j < array.length; j++){
                if(array[indexOfMin] > array[j]) indexOfMin = j;
            }
            swap(array,i,indexOfMin);
        }
    }


}
