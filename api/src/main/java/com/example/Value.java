package com.example;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Value {

    int original();

    @Nullable String value();

    @Override @NotNull String toString();

    static @NotNull Value of(int original) {
        return new Value() {
            @Override
            public int original() {
                return original;
            }

            @Override
            public @Nullable String value() {
                return null;
            }

            @Override
            public @NotNull String toString() {
                return "Default[" + original + "]";
            }
        };
    }
}
