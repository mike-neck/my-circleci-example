package com.example.app;

import com.example.RuleSet;
import com.example.RuleSetProvider;
import com.example.impl.LeftToRightAppendingRuleSet;
import com.example.impl.ModRule;
import org.jetbrains.annotations.NotNull;

public class RuleSets implements RuleSetProvider {

    @Override
    public @NotNull RuleSet get() {
        return new LeftToRightAppendingRuleSet(
                new ModRule(3, "Fizz"),
                new ModRule(5, "Buzz")
        );
    }
}
