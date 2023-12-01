package com.example.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InternetYameroTest {
    @Nested
    @DisplayName("アンチに負けず")
    class InterTest {
        @Nested
        @DisplayName("信者に媚びず")
        class NetTest {
            @Nested
            @DisplayName("どんなに努力を重ねても")
            class YameroTest {
                @DisplayName("一寸先は地獄行き")
                @Test
                void internet() {
                    List<String> lyrics = List.of(
                            "かけめぐるエクスタシー",
                            "融けるマイスリー",
                            "画面光だすの",
                            "不安とまらないよ",
                            "誰か◯してくれ",
                            "イヤだ◯にたくない",
                            "朝は見たくないの",
                            "ムリだ！",
                            "◯ぬ",
                            "頭が割れてく！"
                    );
                    assertEquals(3, lyrics.size());
                }
            }
        }
    }
}
