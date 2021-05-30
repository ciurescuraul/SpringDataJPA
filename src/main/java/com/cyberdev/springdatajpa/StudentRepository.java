package com.cyberdev.springdatajpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>
{

  Optional<Student> findStudentsByEmail(String email);

  List<Student> findStudentsByFirstNameEqualsAndAgeIsGreaterThanEqual(String firstName,
                                                          Integer age);
}
