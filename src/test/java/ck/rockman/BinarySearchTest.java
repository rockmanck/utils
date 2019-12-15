package ck.rockman;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testBinarySearchPerformance() {
        final int listSize = 10_000_000;
        final List<Integer> list = new ArrayList<>(listSize);
        final Random r = new Random(159);
        for (int i = 0; i < listSize; i += 1) {
            list.add(r.nextInt(50_000));
        }
        list.sort(Integer::compareTo);
        final long t = System.nanoTime();
        final BinarySearchResult<Integer> result = BinarySearch.searchIndexWithRecursion(159, list);
        final double oneSecondInMilliseconds = 1_000;
        final double time = (System.nanoTime() - t) / 1_000_000.0;
        System.out.println("found index = " + result.getIndex() + " found item = " + result.getMatchedItem());
        System.out.println("search time = " + time + "ms");
        assertTrue("Search time more than one second", time < oneSecondInMilliseconds);
    }

    private void checkBinarySearch(Integer searchTerm, List<Integer> list, Integer expectedItem, int expectedIndex) {
        assertEquals(new BinarySearchResult<>(expectedItem, expectedIndex), BinarySearch.searchIndexWithRecursion(searchTerm, list));
    }

    private List<Integer> list(Integer... values) {
        return Arrays.asList(values);
    }
}