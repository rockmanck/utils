package ck.rockman.utils.array;

public class ArrayUtils {

    private ArrayUtils() {
        // hide public constructor
    }

    public static int encodePosition(int row, int col, int[][] arr) {
        return col + 1 + row * arr[row].length;
    }

    public static Position decode(int encodedId, int[][] array) {
        final int row = (encodedId - 1) / array[0].length;
        return new Position(row, encodedId - row * array[0].length - 1);
    }
}
