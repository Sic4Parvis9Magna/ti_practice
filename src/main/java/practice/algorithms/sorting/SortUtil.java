package practice.algorithms.sorting;

import java.util.Random;

public final class SortUtil {
    private SortUtil(){}

    public  static int[] generateRandomArray(int size,int maxVal){
        Random random = new Random();
        int[] array= new int[size];
        for(int i = 0; i<size; i++){
            array[i] = random.nextInt(maxVal)+1;
        }
        return array;
    }

    public static boolean isSorted(int[] array ){
        for(int i=0; i < array.length-1; i++){
            if (array[i] > array[i+1]) return false;
        }
        return true;
    }
    public static void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }

    public static void shuffle(int[] array){
        Random random = new Random();
        int size  = array.length;
        for(int i=0; i < size; i++)
            swap(array, random.nextInt(size), random.nextInt(size));
    }

}
