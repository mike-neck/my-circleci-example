package com.example.impl;

import com.example.Value;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppendingTextValueTest {

    @Test
    void valueAndOriginalFromDefault() {
        Value value = Value.of(5);
        AppendingTextValue fizz = new AppendingTextValue(value, "Fizz");
        assertAll(
                () -> assertEquals(5, fizz.original()),
                () -> assertEquals("Fizz", fizz.value())
        );
    }

    @Test
    void valueAndOriginalFromAppending() {
        Value value = Value.of(5);
        AppendingTextValue fizz = new AppendingTextValue(value, "Fizz");
        AppendingTextValue buzz = new AppendingTextValue(fizz, "Buzz");

        assertAll(
                () -> assertEquals(5, buzz.original()),
                () -> assertEquals("FizzBuzz", buzz.value())
        );
    }

    @Test
    void equality() {
        Value value = Value.of(5);
        Value fizz = new AppendingTextValue(value, "Fizz");
        Value v = new ValueImpl(5, "Fizz");

        assertAll(
                () -> assertEquals(v, fizz),
                () -> assertEquals(fizz, v)
        );
    }
}
