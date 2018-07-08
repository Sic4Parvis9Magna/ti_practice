package practice.algorithms.sorting;

import java.util.Arrays;

public final class InsertionSort {
    private InsertionSort(){}

    public static void sort(int[] array){
        for(int i=0; i< array.length-1; i++){
            if(array[i] > array[i+1]){
                int element = array[i+1];
               for(int j = i; j >=0; j--){
                   if(array[j] < element){
                       array[j+1] = element;
                       break;
                   }
                   array[j+1]=array[j];
               }
               if(element < array[0]) array[0] = element;
            }
        }
    }
}
