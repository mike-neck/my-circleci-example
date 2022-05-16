package com.example;

import java.time.Instant;
import java.util.Random;
import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ValueTest {

    @TestFactory
    Stream<DynamicTest> originalValueWontBeChanged() {
        Random random = new Random(Instant.now().toEpochMilli());
        return random.ints(100L)
                .mapToObj(original -> {
                    var value = Value.of(original);
                    return DynamicTest.dynamicTest("original:" + original, () -> assertEquals(original, value.original()));
                });
    }

    @TestFactory
    Stream<DynamicTest> valueShouldBeNull() {
        Random random = new Random(Instant.now().toEpochMilli());
        return random.ints(100L)
                .mapToObj(original -> {
                    var value = Value.of(original);
                    return DynamicTest.dynamicTest("original:" + original, () -> assertNull(value.value()));
                });
    }
}
