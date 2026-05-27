package org.example.lab4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

import java.time.LocalDate;

@Entity
@Table(name = "student_cards")
@TableGenerator(
        name = "student_cards_generator",
        table = "hibernate_sequence",
        pkColumnName = "sequence_name",
        valueColumnName = "next_val",
    pkColumnValue = "student_cards_seq",
        allocationSize = 1
)
public class StudentCard {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "student_cards_generator")
    private Long id;

    @Column(nullable = false, unique = true)
    private String cardNumber;

    @Column(nullable = false)
    private LocalDate issueDate;

    public StudentCard() {
    }

    public StudentCard(String cardNumber, LocalDate issueDate) {
        this.cardNumber = cardNumber;
        this.issueDate = issueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }
}