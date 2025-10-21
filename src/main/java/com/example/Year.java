package com.example;

import java.util.ArrayList;
import java.util.List;

public class Year {
    private final int year;
    private final List<Month> months = new ArrayList<>();

    public Year(int year) {
        this.year = year;
        generateMonths();
    }

    private void generateMonths() {
        WeekDay firstWeekday = CalendarUtils.firstWeekdayOfYear(year);
        for (MonthData monthData : MonthData.values()) {
            Month month = new Month(monthData, year, firstWeekday);
            months.add(month);
            firstWeekday = month.getLastWeekday().next();
        }
    }

    public List<Month> getMonths() {
        return months;
    }
}
