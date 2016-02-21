package ck.rockman;

public final class SortUtils {
	public static <T extends Comparable<T>> boolean less(T a, T b) {
		return a.compareTo(b) < 0;
	}

	public static <T extends Comparable<T>> void exch(T[] items, int i, int j) {
		final T item = items[i];
		items[i] = items[j];
		items[j] = item;
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i += 1) {
			if (less(a[i + 1], a[i])) {
				return false;
			}
		}
		return true;
	}
}
