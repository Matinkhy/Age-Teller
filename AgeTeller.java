package com.mycompany.ageteller;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.util.HashMap;

public class AgeTeller {

    public static void main(String[] args) {

        int MonthNum = -1, dayOfMonth, yearNum, Years, Months, Days, numOfDaysInMonth = 0;
        boolean boolMonth, boolYear = true, boolDay, boolLeapYear = false;
        String month = "", year, day;

        HashMap<String, Integer> MonthsMap = new HashMap<>();

        putCaseInsensitiveKey(MonthsMap, "January", 1);
        putCaseInsensitiveKey(MonthsMap, "February", 2);
        putCaseInsensitiveKey(MonthsMap, "March", 3);
        putCaseInsensitiveKey(MonthsMap, "April", 4);
        putCaseInsensitiveKey(MonthsMap, "May", 5);
        putCaseInsensitiveKey(MonthsMap, "June", 6);
        putCaseInsensitiveKey(MonthsMap, "July", 7);
        putCaseInsensitiveKey(MonthsMap, "August", 8);
        putCaseInsensitiveKey(MonthsMap, "September", 9);
        putCaseInsensitiveKey(MonthsMap, "October", 10);
        putCaseInsensitiveKey(MonthsMap, "November", 11);
        putCaseInsensitiveKey(MonthsMap, "December", 12);

        LocalDate date = LocalDate.now();

        int CurrentYear = date.getYear();

        do {
            year = JOptionPane.showInputDialog("Hi, which year were you born in?");
            yearNum = Integer.parseInt(year);
            if (yearNum < 1899 || yearNum > CurrentYear) {
                JOptionPane.showMessageDialog(null, "The number you entered is invalid, enter a year"
                        + " between 1900 and " + (CurrentYear - 1));
            } else {
                if (yearNum % 4 == 0) {
                    boolLeapYear = true;
                }
                boolYear = false;
            }
        } while (boolYear);

        do {
            month = JOptionPane.showInputDialog("Which month were you born in");
            if (!MonthsMap.containsKey(month)) {
                boolMonth = false;
                JOptionPane.showMessageDialog(null, "The month you entered is invalid");
            } else {
                MonthNum = MonthsMap.get(month);
                boolMonth = true;
            }
        } while (!boolMonth);

        if (boolLeapYear) {
            numOfDaysInMonth = 29;
        } else {
            switch (MonthNum) {

                case 1, 3, 5, 7, 8, 10, 12 -> {
                    numOfDaysInMonth = 31;
                }
                case 4, 6, 9, 11 -> {
                    numOfDaysInMonth = 30;
                }
                case 2 -> {
                    numOfDaysInMonth = 29;
                }
            }
        }

        do {
            day = JOptionPane.showInputDialog("On what day of " + month + " were you born in?");
            dayOfMonth = Integer.parseInt(day);
            if (dayOfMonth > numOfDaysInMonth || dayOfMonth < 1) {
                boolDay = false;
                JOptionPane.showMessageDialog(null, "The number you entered is invalid, it should be between 1 and " + numOfDaysInMonth);
            } else {
                boolDay = true;
            }
        } while (!boolDay);

        LocalDate bdate = LocalDate.of(yearNum, MonthNum, dayOfMonth);
        Period p = Period.between(bdate, date);

        Years = p.getYears();
        Months = p.getMonths();
        Days = p.getDays();

        JOptionPane.showMessageDialog(null, "You are " + Years + " years and " + Months + " months and " + Days + " days old");
    }

    private static void putCaseInsensitiveKey(HashMap<String, Integer> map, String key, Integer value) {
        map.put(key.toLowerCase(), value);
    }
}