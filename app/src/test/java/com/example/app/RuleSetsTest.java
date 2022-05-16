package com.example.app;

import com.example.RuleSetProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RuleSetsTest {

    @TestFactory
    List<DynamicTest> instance() {
        ServiceLoader<RuleSetProvider> loader = ServiceLoader.load(RuleSetProvider.class);
        Optional<RuleSetProvider> first = loader.findFirst();

        List<DynamicTest> tests = new ArrayList<>();

        tests.add(DynamicTest.dynamicTest("RuleSetProvider has at least 1 instance.", () -> assertTrue(first.isPresent())));
        if (first.isEmpty()) {
            return tests;
        }
        RuleSetProvider provider = first.get();
        tests.add(DynamicTest.dynamicTest("Instance of RuleSets", () -> assertInstanceOf(RuleSets.class, provider)));
        tests.add(DynamicTest.dynamicTest("Has 2 Rules", () -> assertEquals(2, provider.get().size())));
        return tests;
    }
}
