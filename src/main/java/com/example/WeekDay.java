package com.example;

public enum WeekDay {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public WeekDay next() {
        return values()[(ordinal() + 1) % 7];
    }
}
