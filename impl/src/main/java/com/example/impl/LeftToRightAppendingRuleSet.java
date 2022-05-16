package com.example.impl;

import com.example.Rule;
import com.example.RuleSet;
import com.example.Value;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class LeftToRightAppendingRuleSet implements RuleSet {

    private final @NotNull List<@NotNull Rule> rules;

    @Override
    public int size() {
        return rules.size();
    }

    public LeftToRightAppendingRuleSet(@NotNull Rule rule, @NotNull Rule @NotNull ... rules) {
        var list = new ArrayList<@NotNull Rule>(1 + rules.length);
        list.add(rule);
        Collections.addAll(list, rules);
        this.rules = list;
    }

    @Override
    public @NotNull Value apply(@NotNull Value value) {
        Value current = value;
        for (Rule rule : rules) {
            current = rule.apply(current);
        }
        return current;
    }
}
