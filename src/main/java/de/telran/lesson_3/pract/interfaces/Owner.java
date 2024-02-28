package de.telran.lesson_3.pract.interfaces;

import java.time.LocalDate;

public interface Owner {
    void addBalance(double sum);
    double withdrawBalance(double sum);
    double getBalance();
    void closeAccount(String closeDate);
}

