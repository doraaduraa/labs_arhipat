package org.example.lab4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name = "student_groups")
@TableGenerator(
        name = "student_groups_generator",
        table = "hibernate_sequence",
        pkColumnName = "sequence_name",
        valueColumnName = "next_val",
    pkColumnValue = "student_groups_seq",
        allocationSize = 1
)
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "student_groups_generator")
    private Long id;

    @Column(nullable = false, unique = true)
    private String groupName;

    @Column(nullable = false)
    private String specialty;

    @ManyToOne
    @JoinColumn(name = "curator_id", nullable = false)
    private Curator curator;

    public StudentGroup() {
    }

    public StudentGroup(String groupName, String specialty, Curator curator) {
        this.groupName = groupName;
        this.specialty = specialty;
        this.curator = curator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Curator getCurator() {
        return curator;
    }

    public void setCurator(Curator curator) {
        this.curator = curator;
    }
}