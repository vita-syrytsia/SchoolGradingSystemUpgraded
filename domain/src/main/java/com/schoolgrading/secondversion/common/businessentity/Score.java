package com.schoolgrading.secondversion.common.businessentity;

import java.util.HashMap;
import java.util.Map;

public enum Score {
    A,
    B,
    C,
    D,
    E;

    private static final Map<String, Score> symbolToScore = new HashMap<>();
    static {
        for (Score score : values()) {
            symbolToScore.put(score.name(), score);
        }
    }

    public static Score getBySymbol(String symbol) {
        return symbolToScore.get(symbol);
    }


}
