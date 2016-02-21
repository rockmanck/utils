package ck.rockman.utils;

public class NumberUtils {

    /**
     * Calls round(value, 2)
     */
    public static double round(double value) {
        return round(value, 2);
    }

    /**
     * @param decimalPlaces count of decimal places in rounded value
     * @return i.e. round(4.835734, 2) -> 4.84
     */
    public static double round(double value, int decimalPlaces) {
        final double adj = Math.pow(10, decimalPlaces);
        return Math.round(value * adj) / adj;
    }
}
