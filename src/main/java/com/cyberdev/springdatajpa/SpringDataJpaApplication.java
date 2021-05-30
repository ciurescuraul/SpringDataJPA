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

      Student raul2 = new Student("Raul",
                                  "Ciurescu",
                                  "raul2.ciurescu@cyberit.ro",
                                  25);

      Student raul3 = new Student("Raul",
                                  "Ciurescu",
                                  "raul3.ciurescu@cyberit.ro",
                                  17);

      studentRepository.saveAll(List.of(ioana, raul, raul2, raul3));

      studentRepository.findStudentsByEmail("ioana.ionescu@cyberit.ro")
          .ifPresentOrElse(System.out::println,
                           () -> System.out
                               .println("Student with ioana.ionescu@cyberit.ro not found."));

      studentRepository.findStudentsByFirstNameEqualsAndAgeIsGreaterThanEqual("Raul", 25)
              .forEach(System.out::println);

      studentRepository.findStudentsByFirstNameEqualsAndAgeIsGreaterThanEqualNative("Raul", 25)
          .forEach(System.out::println);

    };
  }

}
