package ck.rockman;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        checkBinarySearch(null, list(), null, 0);
        checkBinarySearch(1, list(1), 1, 0);
        checkBinarySearch(0, list(1), null, 0);
        checkBinarySearch(2, list(1), null, 1);
        checkBinarySearch(1, list(0, 1), 1, 1);
        checkBinarySearch(0, list(0, 1), 0, 0);
        checkBinarySearch(0, list(0, 1, 2), 0, 0);
        checkBinarySearch(2, list(0, 1, 2), 2, 2);
        checkBinarySearch(1, list(0, 1, 2), 1, 1);
        checkBinarySearch(-1, list(0, 1, 2), null, 0);
        checkBinarySearch(6, list(0, 1, 2), null, 3);
        checkBinarySearch(6, list(0, 1, 2, 6, 7, 8, 9, 23, 76, 192, 465), 6, 3);
        checkBinarySearch(10, list(0, 1, 2, 6, 7, 8, 9, 23, 76, 192, 465), null, 7);
        checkBinarySearch(193, list(0, 1, 2, 6, 7, 8, 9, 23, 76, 192, 465), null, 10);
    }

    private void checkBinarySearch(Integer searchTerm, List<Integer> list, Integer expectedItem, int expectedIndex) {
        assertEquals(new BinarySearchResult<>(expectedItem, expectedIndex), BinarySearch.searchIndex(searchTerm, list));
    }

    private List<Integer> list(Integer... values) {
        return Arrays.asList(values);
    }
}