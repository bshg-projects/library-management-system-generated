package org.bshg.librarysystem.utils.builder;

import java.util.function.BiConsumer;

public abstract class IBuilder<T, B extends IBuilder<T, B>> {
    protected T item;
    protected B builder;

    protected IBuilder(T item) {
        this.item = item;
    }

    public T build() {
        return item;
    }

    protected <V> B setter(BiConsumer<T, V> setter, V value) {
        setter.accept(item, value);
        return builder;
    }
}
