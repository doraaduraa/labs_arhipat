package org.example.lab4.repository;

import org.example.lab4.entity.Curator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuratorRepository extends JpaRepository<Curator, Long> {
}