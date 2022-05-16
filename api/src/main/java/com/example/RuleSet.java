package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

public interface RuleSet {

    @NotNull Value apply(@NotNull Value value);

    default @NotNull @Unmodifiable List<@NotNull Value> apply(int... values) {
        var list = new ArrayList<Value>(values.length);
        for (int original : values) {
            Value value = Value.of(original);
            Value v = apply(value);
            list.add(v);
        }
        return Collections.unmodifiableList(list);
    }
}
