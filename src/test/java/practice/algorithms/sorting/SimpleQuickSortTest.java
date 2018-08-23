package practice.algorithms.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static practice.algorithms.sorting.SortUtil.*;
import static practice.algorithms.sorting.SortUtil.generateRandomArray;

class SimpleQuickSortTest {

    int[] array;

    @BeforeEach
    void setUp() {
        array = generateRandomArray(10,250);
        System.out.println("Initial array!");
        System.out.println(Arrays.toString(array));
    }

    @Test
    @DisplayName("Quick sort test")
    void sort() {
        assertThat(isSorted(array), is(false));
        SimpleQuickSort.sort(array);
        System.out.println("After quick sort:");
        System.out.println(Arrays.toString(array));
        assertThat(isSorted(array), is(true));
    }
}