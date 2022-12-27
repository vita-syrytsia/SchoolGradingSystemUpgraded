package com.schoolgrading.secondversion.common.businessentity;

import java.util.HashMap;
import java.util.Map;

public enum Grade {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5),
    SIXTH(6),
    SEVENTH(7),
    EIGHTH(8),
    NINTH(9),
    TENTH(10),
    ELEVENTH(11),
    TWELFTH(12);

    private static final Map<Integer, Grade> numberToGrade = new HashMap<>();

    static {
        for (Grade grade : values()) {
            numberToGrade.put(grade.getNumber(), grade);
        }
    }

    private final int number;

    Grade(int number) {
        this.number = number;
    }

    public static boolean doesGradeExistByNumber(int number) {
        return numberToGrade.containsKey(number);
    }

    public int getNumber() {
        return number;
    }
}
