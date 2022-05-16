package com.example.impl;

import com.example.Value;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

record ValueImpl(int original, @NotNull String text) implements Value {

    @Override
    public @NotNull
    String toString() {
        return "[" + original + " / " + text + "]";
    }

    @Override
    public @NotNull
    String value() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Value value)) {
            return false;
        }
        if (original != value.original()) {
            return false;
        }
        return text.equals(value.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(original, text);
    }
}
