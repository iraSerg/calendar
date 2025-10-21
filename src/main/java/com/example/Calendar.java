package com.example;

import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите год: ");
        String input = scanner.nextLine();
        int validationResult = InputValidator.validateYear(input);
        if (validationResult != -1) {
            CalendarUtils.printCalendar(new Year(validationResult));
        }
    }
}
