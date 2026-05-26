package org.example.lab3;

import java.util.List;

public class StudentScoreService {

    public double calculateAverage(List<Integer> scores) {
        validateScores(scores);

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }

        return (double) sum / scores.size();
    }

    public int findHighestScore(List<Integer> scores) {
        validateScores(scores);

        int highestScore = scores.get(0);
        for (int score : scores) {
            if (score > highestScore) {
                highestScore = score;
            }
        }

        return highestScore;
    }

    public boolean hasScholarship(List<Integer> scores) {
        return calculateAverage(scores) >= 90;
    }

    private void validateScores(List<Integer> scores) {
        if (scores == null || scores.isEmpty()) {
            throw new IllegalArgumentException("Список оцінок не може бути порожнім");
        }
    }
}