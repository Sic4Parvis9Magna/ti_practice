package practice.algorithms.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static practice.algorithms.sorting.DijkstrasQuickSort.shuffle;

class DijkstrasQuickSortTest {

    int[] array;

    @BeforeEach
    void setUp() {
        array = SortUtil.generateRandomArray(10,100);
        System.out.println(Arrays.toString(array));

    }

    @Test
    void sort() {
        assertThat(SortUtil.isSorted(array), is(false));
        DijkstrasQuickSort.sort(array);
        System.out.println(Arrays.toString(array));
        assertThat(SortUtil.isSorted(array), is(true));
    }


}