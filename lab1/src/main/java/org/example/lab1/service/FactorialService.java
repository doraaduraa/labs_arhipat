package org.example.lab1.service;

import org.springframework.stereotype.Service;

@Service
public class FactorialService {

    public long calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("число не може бути від'ємним");
        }

        if (number > 20) {
            throw new IllegalArgumentException("число має бути не більше 20");
        }

        long result = 1;

        for (int i = 1; i <= number; i++) {
            result *= i;
        }

        return result;
    }
}