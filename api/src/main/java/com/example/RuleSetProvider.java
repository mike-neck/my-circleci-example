package com.example;

import org.jetbrains.annotations.NotNull;

public interface RuleSetProvider {

    @NotNull RuleSet get();
}
