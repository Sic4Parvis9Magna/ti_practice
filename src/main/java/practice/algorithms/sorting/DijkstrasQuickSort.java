package practice.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

import static practice.algorithms.sorting.SortUtil.swap;

public class DijkstrasQuickSort {

    public static void sort(int[] array){
        shuffle(array);
        System.out.println(Arrays.toString(array));
       mySort(array,0,array.length-1);
    }

    public static void mySort(int[] array,int lowerIndex,int higherIndex){
        int j = partitioning(array,lowerIndex,higherIndex);
        mySort(array,lowerIndex,j-1);
        mySort(array,j+1,higherIndex);
    }

    private static int partitioning(int[] array, int lowerIndex, int higherIndex) {
        int pivot = array[lowerIndex];
        int lower = lowerIndex+1;
        int higher = higherIndex;
        int current = lower;
        while(current != higher){
            System.out.printf("low = %d cur = %d max =%d%n",lower, current,higher);
            System.out.printf("low = %d cur = %d max =%d%n",array[lower], array[current],array[higher]);
            if(array[current] < pivot) {

                swap(array, lower, current);
                lower++;
                current++;
                System.out.println("1");
            }else
            if(array[current] > pivot){

                swap(array,higher,current);
                higher--;
                System.out.println("1");
            }else
            {

                current++;
                System.out.println("3");

            }
        }
        swap(array,lowerIndex,lower);
        return current;
    }

    public static void shuffle(int[] array) {
        Random random = new Random();
        int size  = array.length;
        for(int i=0; i < size; i++) swap(array,
                random.nextInt(size), random.nextInt(size));
    }
}
