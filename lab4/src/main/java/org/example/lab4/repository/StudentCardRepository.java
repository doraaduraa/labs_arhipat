package org.example.lab4.repository;

import org.example.lab4.entity.StudentCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCardRepository extends JpaRepository<StudentCard, Long> {
}