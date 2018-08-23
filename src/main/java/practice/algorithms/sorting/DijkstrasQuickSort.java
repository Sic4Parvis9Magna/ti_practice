package practice.algorithms.sorting;

import java.util.Arrays;

import static practice.algorithms.sorting.SortUtil.shuffle;
import static practice.algorithms.sorting.SortUtil.swap;

public class DijkstrasQuickSort {

    public static void sort(int[] array){
        shuffle(array);
        mySort(array,0,array.length-1);
    }

    public static void mySort(int[] array,int lowerIndex,int higherIndex){
        if(lowerIndex >= higherIndex) return;
        int[] couple  = partitioning(array,lowerIndex,higherIndex);
        mySort(array, lowerIndex, couple[0]-1);
        mySort(array, couple[1]+1, higherIndex);
    }

    private static int[] partitioning(int[] array, int lowerIndex, int higherIndex) {
        int pivot = array[lowerIndex];
        int current = lowerIndex+1;
        while(current <= higherIndex){
            if(array[current] < pivot) {
                swap(array, lowerIndex, current);
                ++lowerIndex;++current;

            }
            else if(array[current] > pivot){
                swap(array,higherIndex,current);
                --higherIndex;

            }
            else{
                ++current;
            }
        }
        return new int[]{lowerIndex,higherIndex};
    }

}
