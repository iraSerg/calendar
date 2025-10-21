package com.example;

public class CalendarUtils {
    private static final int JANUARY_AS_13TH_MONTH = 13;
    private static final int DAY_OF_MONTH_FOR_CALC = 1;
    private static final String DAY_PRINT_TEMPLATE = "%2d  ";
    private static final String TEMPLATE_PRINT_DAYS_NAME = "пн  вт  ср  чт  пт  сб  вс";
    private static final int DAYS_IN_WEEK = 7;
    private static final String EMPTY_DAY_SPACE = "    ";

    private static final WeekDay[] ZELLER_TO_WEEKDAY = {
            WeekDay.SATURDAY,
            WeekDay.SUNDAY,
            WeekDay.MONDAY,
            WeekDay.TUESDAY,
            WeekDay.WEDNESDAY,
            WeekDay.THURSDAY,
            WeekDay.FRIDAY
    };

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static WeekDay firstWeekdayOfYear(int year) {
        int yearLastTwoDigits = (year - 1) % 100;
        int yearFirstTwoDigits = (year - 1) / 100;

        int weekdayIndex = (DAY_OF_MONTH_FOR_CALC + 13 * (JANUARY_AS_13TH_MONTH + 1) / 5
                + yearLastTwoDigits + yearLastTwoDigits / 4 + yearFirstTwoDigits / 4 + 5 * yearFirstTwoDigits) % 7;

        return ZELLER_TO_WEEKDAY[weekdayIndex];
    }

    public static void printCalendar(Year year) {
        for (Month month : year.getMonths()) {
            System.out.println(month.getName());
            System.out.println(TEMPLATE_PRINT_DAYS_NAME);
            WeekDay firstWeekday = month.getDays().get(0).getWeekDay();
            int position = firstWeekday.ordinal();
            for (int i = 0; i < position; i++) {
                System.out.print(EMPTY_DAY_SPACE);
            }

            for (Day day : month.getDays()) {
                System.out.printf(DAY_PRINT_TEMPLATE, day.getNumber());
                position++;
                if (position % DAYS_IN_WEEK == 0) {
                    System.out.println();
                }
            }

            if (position % DAYS_IN_WEEK != 0) {
                System.out.println();
            }
            System.out.println();
        }
    }
}
