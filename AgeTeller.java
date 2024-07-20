package com.mycompany.ageteller;

import java.time.*;
import javax.swing.*;

public class AgeTeller {

    public static void main(String[] args) {

        int MonthNum = -1, dayOfMonth, yearNum, Years, Months, Days, numOfDaysInMonth = 0;
        boolean boolMonth = true, boolYear = true, boolDay, boolLeapYear = false;
        String month = "", year, day;
        String[] MonthsArray = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};

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
            for (int i = 0; i < 11; ++i) {
                if (MonthsArray[i].equalsIgnoreCase(month)) {
                    MonthNum = i + 1;
                    boolMonth = true;
                    break;
                }
            }
            if (MonthNum == -1) {
                boolMonth = false;
                JOptionPane.showMessageDialog(null, "The month you entered is invalid");

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

}

