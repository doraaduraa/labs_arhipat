package org.example.lab4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "curators")
@TableGenerator(
        name = "curators_generator",
        table = "hibernate_sequence",
        pkColumnName = "sequence_name",
        valueColumnName = "next_val",
    pkColumnValue = "curators_seq",
        allocationSize = 1
)
public class Curator {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "curators_generator")
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String department;

    public Curator() {
    }

    public Curator(String fullName, String department) {
        this.fullName = fullName;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}