package com.example;

import java.util.ArrayList;
import java.util.List;

public class Month {
    private final MonthData data;
    private final int year;
    private final List<Day> days = new ArrayList<>();

    public Month(MonthData data, int year, WeekDay firstWeekday) {
        this.data = data;
        this.year = year;
        generateDays(firstWeekday);
    }

    private void generateDays(WeekDay start) {
        WeekDay wd = start;
        for (int i = 1; i <= data.getDays(year); i++) {
            days.add(new Day(i, wd));
            wd = wd.next();
        }
    }

    public List<Day> getDays() {
        return days;
    }

    public WeekDay getLastWeekday() {
        return days.get(days.size() - 1).getWeekDay();
    }

    public String getName() {
        return data.getName();
    }
}
