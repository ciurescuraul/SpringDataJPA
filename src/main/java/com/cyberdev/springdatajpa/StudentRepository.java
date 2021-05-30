package com.cyberdev.springdatajpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long>
{

  @Query("SELECT s FROM Student s WHERE s.email= :email")
  Optional<Student> findStudentsByEmail(@Param("email") String email);

  @Query("SELECT s FROM Student s WHERE s.firstName= ?1 AND s.age >= ?2")
  List<Student> findStudentsByFirstNameEqualsAndAgeIsGreaterThanEqual(String firstName,
                                                                      Integer age);

  @Query(value = "SELECT * FROM student WHERE first_name= ?1 AND age >= ?2", nativeQuery = true)
  List<Student> findStudentsByFirstNameEqualsAndAgeIsGreaterThanEqualNative(String firstName,
                                                                            Integer age);
}
