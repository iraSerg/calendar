package com.example;

public class InputValidator {
    private static final int MIN_YEAR = 1600;

    public static Integer validateYear(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Ввод не должен быть пустым.");
            return -1;
        }

        int year;
        try {
            year = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            System.out.println("Введите корректное целое число.");
            return -1;
        }

        if (year < MIN_YEAR) {
            System.out.println("Год должен быть не меньше 1600.");
            return -1;
        }

        return year;
    }
}
