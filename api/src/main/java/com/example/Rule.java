package com.example;

import org.jetbrains.annotations.NotNull;

public interface Rule {

    @NotNull Value apply(@NotNull Value value);

    @Override @NotNull String toString();
}
