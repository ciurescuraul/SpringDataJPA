package com.cyberdev.springdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(SpringDataJpaApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(StudentRepository studentRepository)
  {
    return args -> {
      Student ioana = new Student("Ioana",
                                  "Ionescu",
                                  "ioana.ionescu@cyberit.ro",
                                  27);

      Student raul = new Student("Raul",
              "Ciurescu",
              "raul.ciurescu@cyberit.ro",
              37);

      System.out.println("Adding ioana and raul");
      studentRepository.saveAll(List.of(ioana, raul));

      System.out.print("Number of students");
      System.out.println(studentRepository.count());


      studentRepository
              .findById(2L)
              .ifPresentOrElse(
                      System.out::println, () ->
        System.out.println("Student with ID 2 not found"));

      studentRepository
              .findById(3L)
              .ifPresentOrElse(
                      System.out::println, () ->
                              System.out.println("Student with ID 3 not found"));

      System.out.println("Select all students");
      List<Student> students = studentRepository.findAll();
      students.forEach(System.out::println);

      System.out.println("Delete ioana");
      studentRepository.deleteById(1L);

      System.out.print("Number of students");
      System.out.println(studentRepository.count());
    };
  }

}
