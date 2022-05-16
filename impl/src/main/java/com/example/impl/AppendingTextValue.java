package com.example.impl;

import com.example.Value;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AppendingTextValue implements Value {

    final @NotNull Value value;
    final @NotNull String text;

    AppendingTextValue(@NotNull Value value, @NotNull String text) {
        this.value = value;
        this.text = text;
    }

    @Override
    public int original() {
        return value.original();
    }

    @Override
    public @NotNull String value() {
        String value = this.value.value();
        if (value == null) {
            return text;
        } else {
            return value + text;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Value value)) {
            return false;
        }
        if (this.value.original() != value.original()) {
            return false;
        }
        return value().equals(value.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, text);
    }

    @Override
    public @NotNull String toString() {
        return "Value[" + value + " + '" + text + "']";
    }
}
