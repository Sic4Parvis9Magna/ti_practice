package practice.algorithms.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class DijkstrasQuickSortTest {

    int[] array;

    @BeforeEach
    void setUp() {
        array = SortUtil.generateRandomArray(10,100);
        for (int i = 0; i <3; i++)
            array[i] = 13;
        SortUtil.shuffle(array);
        System.out.println("Initial array!");
        System.out.println(Arrays.toString(array));
    }

    @Test
    void sort() {
        assertThat(SortUtil.isSorted(array), is(false));
        DijkstrasQuickSort.sort(array);
        System.out.println("After di sort:");
        System.out.println(Arrays.toString(array));
        assertThat(SortUtil.isSorted(array), is(true));
    }


}