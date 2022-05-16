package com.example.impl;

import com.example.Rule;
import com.example.Value;
import org.jetbrains.annotations.NotNull;

public class ModRule implements Rule {

    final int base;
    final @NotNull String text;

    public ModRule(int base, @NotNull String text) {
        this.base = base;
        this.text = text;
    }

    @Override
    public @NotNull Value apply(@NotNull Value value) {
        int original = value.original();
        if (original % base == 0) {
            return new AppendingTextValue(value, text);
        } else {
            return value;
        }
    }

    @Override
    public @NotNull String toString() {
        return "Rule[ mod : " + base + " -> " + text + "]";
    }
}
