package ck.rockman;

import java.util.Objects;

/**
 * If matched item is null then {@code index} points to position in an array for search term
 */
public class BinarySearchResult<T> {
    private final T matchedItem;
    private final int index;

    public BinarySearchResult(T matchedItem, int index) {
        this.matchedItem = matchedItem;
        this.index = index;
    }

    public T getMatchedItem() {
        return matchedItem;
    }

    public int getIndex() {
        return index;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinarySearchResult<?> that = (BinarySearchResult<?>) o;
        return index == that.index &&
            Objects.equals(matchedItem, that.matchedItem);
    }

    @Override public int hashCode() {

        return Objects.hash(matchedItem, index);
    }

    @Override public String toString() {
        return "BinarySearchResult{" +
            "matchedItem=" + matchedItem +
            ", index=" + index +
            '}';
    }
}
