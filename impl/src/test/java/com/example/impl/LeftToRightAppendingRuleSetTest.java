package com.example.impl;

import com.example.RuleSet;
import com.example.Value;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeftToRightAppendingRuleSetTest {

    static @NotNull Value value(int original, @NotNull String text) {
        return new ValueImpl(original, text);
    }

    @Test
    void single() {
        RuleSet ruleSet = new LeftToRightAppendingRuleSet(new ModRule(5, "Buzz"));
        List<@NotNull Value> values = ruleSet.apply(1, 2, 3, 4, 5);

        List<Value> expected = List.of(
                Value.of(1),
                Value.of(2),
                Value.of(3),
                Value.of(4),
                value(5, "Buzz")
        );

        assertIterableEquals(expected, values);
    }

    @Test
    void twoRules() {
        RuleSet ruleSet = new LeftToRightAppendingRuleSet(new ModRule(2, "Fizz"), new ModRule(3, "Buzz"));
        List<@NotNull Value> actual = ruleSet.apply(1, 2, 3, 4, 5, 6);

        List<Value> expected = List.of(
                Value.of(1),
                value(2, "Fizz"),
                value(3, "Buzz"),
                value(4, "Fizz"),
                Value.of(5),
                value(6, "FizzBuzz")
        );

        assertIterableEquals(expected, actual);
    }
}