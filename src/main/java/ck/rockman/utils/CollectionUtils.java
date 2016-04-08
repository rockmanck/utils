package ck.rockman.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class CollectionUtils {
    public static <T, B> Map<T, B> arrayToMap(B[] array, Function<B, T> keyMapper) {
        final Map<T, B> result = new HashMap<>();
        for (B item : array) {
            result.put(keyMapper.apply(item), item);
        }
        return result;
    }
}
