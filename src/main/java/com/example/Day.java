package com.example;

public class Day {
    private int number;
    private WeekDay weekDay;

    public Day(int number, WeekDay weekDay) {
        this.number = number;
        this.weekDay = weekDay;
    }

    public int getNumber() {
        return number;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }
}
