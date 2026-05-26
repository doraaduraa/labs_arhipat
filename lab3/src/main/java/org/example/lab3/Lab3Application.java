package org.example.lab3;

import java.util.List;

public class Lab3Application {

    public static void main(String[] args) {
        StudentScoreService studentScoreService = new StudentScoreService();
        List<Integer> scores = List.of(95, 88, 91, 84, 97);

        double averageScore = studentScoreService.calculateAverage(scores);
        int highestScore = studentScoreService.findHighestScore(scores);
        boolean scholarship = studentScoreService.hasScholarship(scores);

        System.out.println("Результати лабораторної роботи 3");
        System.out.println("Оцінки студента: " + scores);
        System.out.println("Середній бал: " + averageScore);
        System.out.println("Найвищий бал: " + highestScore);
        System.out.println("Стипендія: " + (scholarship ? "так" : "ні"));
    }
}