package ck.rockman;

public final class UncheckedUtils {
    @SuppressWarnings("unchecked")
    public static <T> T[] array(int size) {
        return (T[]) new Object[size];
    }
}
