package ck.rockman;

import java.util.function.Function;

public class EmptyValueChain<T, R> extends NotNullChain<T, R> {
    public EmptyValueChain(T bean, Function<T, R> func) {
        super(bean, func);
    }

    @Override public R get() {
        return null;
    }

    @Override public <T2> NotNullChain<R, T2> notNull(Function<R, T2> func) {
        return new EmptyValueChain<>(null, func);
    }
}
