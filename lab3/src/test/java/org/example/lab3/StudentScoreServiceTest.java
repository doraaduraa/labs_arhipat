package org.example.lab3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentScoreServiceTest {

    private final StudentScoreService studentScoreService = new StudentScoreService();

    @Test
    void shouldCalculateAverageScore() {
        double average = studentScoreService.calculateAverage(List.of(90, 80, 100));

        assertEquals(90.0, average);
    }

    @Test
    void shouldFindHighestScore() {
        int highestScore = studentScoreService.findHighestScore(List.of(76, 89, 95, 88));

        assertEquals(95, highestScore);
    }

    @Test
    void shouldReturnTrueWhenAverageIsEnoughForScholarship() {
        boolean scholarship = studentScoreService.hasScholarship(List.of(95, 92, 90));

        assertTrue(scholarship);
    }

    @Test
    void shouldReturnFalseWhenAverageIsTooLowForScholarship() {
        boolean scholarship = studentScoreService.hasScholarship(List.of(80, 82, 85));

        assertFalse(scholarship);
    }

    @Test
    void shouldThrowExceptionForEmptyScores() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> studentScoreService.calculateAverage(List.of())
        );

        assertEquals("Список оцінок не може бути порожнім", exception.getMessage());
    }
}