package practice.algorithms.sorting;

import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static practice.algorithms.sorting.SortUtil.generateRandomArray;

@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
class SortUtilTest {
    int[] array;

    @BeforeEach
    void setUp() {
        array = generateRandomArray(10,100);
        System.out.println( Arrays.toString(array));
    }

    @Test
    @DisplayName("Check if array is sorted")
    void isSorted() {
        assertThat(SortUtil.isSorted(array), is(false));
        Arrays.sort(array);

        assertThat(SortUtil.isSorted(array), is(true));
    }
}