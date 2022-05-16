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

            @Override
            public int hashCode() {
                return original;
            }

            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof Value value)) {
                    return false;
                }
                if (value.value() != null) {
                    return false;
                }
                return value.original() == original;
            }
        };
    }
}
