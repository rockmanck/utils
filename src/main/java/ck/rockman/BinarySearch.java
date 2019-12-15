package ck.rockman;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    private BinarySearch() {
        // hide public constructor
    }

    /**
     * {@code items} should be sorted in ascending order
     */
    public static <T extends Comparable<T>> BinarySearchResult<T> searchIndex(T searchTerm, T[] items) {
        return searchIndex(searchTerm, Arrays.asList(items));
    }

    /**
     * Searching for the {@code searchTerm} and returns its position index.<br>
     * If there is no such element then search result will contain null and target index for search term in items list.<br>
     * {@code items} should be sorted in ascending order.
     */
    public static <T extends Comparable<T>> BinarySearchResult<T> searchIndex(T searchTerm, List<T> items) {
        if (items.isEmpty())
            return new BinarySearchResult<>(null, 0);

        int lo = 0;
        int hi = items.size() - 1;
        int result;
        do {
            int mid = (lo + hi) / 2;
            final int midCompare = searchTerm.compareTo(items.get(mid));
            if (midCompare == 0) {
                return new BinarySearchResult<>(searchTerm, mid);
            } else if (midCompare < 0) {
                hi = mid - 1;
                result = mid;
            } else {
                lo = mid + 1;
                result = lo;
            }
        } while (lo <= hi);

        return new BinarySearchResult<>(null, result);
    }

    public static <T extends Comparable<T>> BinarySearchResult<T> searchIndexWithRecursion(T searchTerm, List<T> items) {
        int lo = 0;
        int hi = items.size() - 1;
        return recBinarySearch(items, searchTerm, lo, hi, 0);
    }

    private static <T extends Comparable<T>> BinarySearchResult<T> recBinarySearch(List<T> items, T searchTerm, int lo, int hi, int targetIndex) {
        if (lo > hi) {
            return new BinarySearchResult<>(null, targetIndex);
        }
        int mid = (lo + hi) / 2;
        final T item = items.get(mid);
        final int compareResult = item.compareTo(searchTerm);
        if (compareResult == 0) {
            return new BinarySearchResult<>(item, mid);
        } else if (compareResult > 0) {
            return recBinarySearch(items, searchTerm, lo, mid - 1, mid);
        } else {
            return recBinarySearch(items, searchTerm, mid + 1, hi, mid + 1);
        }
    }
}
