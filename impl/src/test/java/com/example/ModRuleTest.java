package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModRuleTest {

    final Rule rule = new ModRule(5, "Buzz");

    @Test
    void match() {
        Value value = Value.of(5);
        Value actual = rule.apply(value);

        ValueImpl expected = new ValueImpl(5, "Buzz");

        assertEquals(expected, actual);
    }

    @Test
    void unmatched() {
        Value value = Value.of(3);
        Value actual = rule.apply(value);

        assertEquals(value, actual);
    }
}
