package ck.rockman;

import java.util.function.Function;

public class NotNullChain<T, R> {
    private final T bean;
    private final Function<T, R> func;

    public NotNullChain(T bean, Function<T, R> func) {
        this.bean = bean;
        this.func = func;
    }

    public R get() {
        return bean != null ? func.apply(bean) : null;
    }

    public R getElse(R defaultValue) {
        return bean != null ? func.apply(bean) : defaultValue;
    }

    public <T2> NotNullChain<R, T2> notNull(Function<R, T2> func) {
        return bean != null ? new NotNullChain<>(this.func.apply(bean), func) : new EmptyValueChain<>(null, func);
    }
}
