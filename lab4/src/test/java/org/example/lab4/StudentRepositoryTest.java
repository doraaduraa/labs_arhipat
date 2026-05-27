package org.example.lab4;

import org.example.lab4.entity.Curator;
import org.example.lab4.entity.Student;
import org.example.lab4.entity.StudentCard;
import org.example.lab4.entity.StudentGroup;
import org.example.lab4.repository.CuratorRepository;
import org.example.lab4.repository.StudentGroupRepository;
import org.example.lab4.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("test")
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentGroupRepository studentGroupRepository;

    @Autowired
    private CuratorRepository curatorRepository;

    @Test
    void shouldSaveStudentWithRelations() {
        Curator curator = curatorRepository.save(new Curator("Іван Петренко", "Комп'ютерні науки"));
        StudentGroup studentGroup = studentGroupRepository.save(
                new StudentGroup("КН-31", "Інженерія програмного забезпечення", curator)
        );

        StudentCard studentCard = new StudentCard("SC-1001", LocalDate.of(2024, 9, 1));
        Student student = new Student("Марія Коваль", 3, studentGroup, studentCard);

        Student savedStudent = studentRepository.save(student);

        assertNotNull(savedStudent.getId());
        assertNotNull(savedStudent.getStudentCard().getId());
        assertEquals("КН-31", savedStudent.getStudentGroup().getGroupName());
        assertEquals("Іван Петренко", savedStudent.getStudentGroup().getCurator().getFullName());
    }
}