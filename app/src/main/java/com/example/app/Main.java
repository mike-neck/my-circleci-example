package com.example.app;

import com.example.RuleSet;
import com.example.RuleSetProvider;
import com.example.Value;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;
import org.jetbrains.annotations.NotNull;

public class Main {

    public static void main(String[] args) {
        RuleSet ruleSet = ruleSet();
        List<@NotNull Value> values = ruleSet.apply(range(1, 15));
        values.forEach(v -> System.out.println(v.asString()));
    }

    @SuppressWarnings("SameParameterValue")
    static int[] range(int from, int toInclude) {
        int length = toInclude - from + 1;
        if ((length < 0)) {
            throw new IllegalArgumentException(String.format("invalid range from %d to %d", from, toInclude));
        }
        int[] values = new int[length];
        for (int i = 0; i < length; i++) {
            values[i] = from + i;
        }
        return values;
    }

    static @NotNull RuleSet ruleSet() {
        ServiceLoader<RuleSetProvider> loader = ServiceLoader.load(RuleSetProvider.class);
        Optional<RuleSet> first = loader.findFirst().map(RuleSetProvider::get);
        if (first.isEmpty()) {
            throw new IllegalStateException("RuleSetProvider not found");
        }
        return first.get();
    }
}
