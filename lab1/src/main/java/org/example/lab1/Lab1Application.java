package org.example.lab1;

import java.util.Scanner;
import org.example.lab1.service.FactorialService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab1Application implements CommandLineRunner {

    private final FactorialService factorialService;

    public Lab1Application(FactorialService factorialService) {
        this.factorialService = factorialService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab1Application.class, args);
    }

    @Override
    public void run(String... args) {
        if (args.length > 0) {
            handleArgumentInput(args[0]);
            return;
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Обчислення факторіалу числа за допомогою Spring Boot");
            System.out.print("Введіть ціле число від 0 до 20: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Помилка: потрібно ввести саме ціле число.");
                return;
            }

            int number = scanner.nextInt();

            try {
                long result = factorialService.calculateFactorial(number);
                System.out.println("Факторіал числа " + number + " = " + result);
            } catch (IllegalArgumentException exception) {
                System.out.println("Помилка: " + exception.getMessage());
            }
        }
    }

    private void handleArgumentInput(String value) {
        System.out.println("Обчислення факторіалу числа за допомогою Spring Boot");

        try {
            int number = Integer.parseInt(value);
            long result = factorialService.calculateFactorial(number);
            System.out.println("Факторіал числа " + number + " = " + result);
        } catch (NumberFormatException exception) {
            System.out.println("Помилка: потрібно передати ціле число.");
        } catch (IllegalArgumentException exception) {
            System.out.println("Помилка: " + exception.getMessage());
        }
    }
}