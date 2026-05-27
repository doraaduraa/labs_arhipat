package org.example.lab4.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name = "students")
@TableGenerator(
        name = "students_generator",
        table = "hibernate_sequence",
        pkColumnName = "sequence_name",
        valueColumnName = "next_val",
    pkColumnValue = "students_seq",
        allocationSize = 1
)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "students_generator")
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private int course;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private StudentGroup studentGroup;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_card_id", nullable = false, unique = true)
    private StudentCard studentCard;

    public Student() {
    }

    public Student(String fullName, int course, StudentGroup studentGroup, StudentCard studentCard) {
        this.fullName = fullName;
        this.course = course;
        this.studentGroup = studentGroup;
        this.studentCard = studentCard;
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

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public StudentCard getStudentCard() {
        return studentCard;
    }

    public void setStudentCard(StudentCard studentCard) {
        this.studentCard = studentCard;
    }
}