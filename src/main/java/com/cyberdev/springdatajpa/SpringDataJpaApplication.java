package com.cyberdev.springdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;

import java.time.LocalDateTime;

@SpringBootApplication
public class SpringDataJpaApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(SpringDataJpaApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(
          StudentRepository studentRepository,
          StudentIdCardRepository studentIdCardRepository
          )
  {
    return args -> {
      Faker faker = new Faker();

      String firstName = faker.name().firstName();
      String lastName = faker.name().lastName();
      String email = String.format("%s.%s@cyberdev.com", firstName, lastName);
      int age = faker.number().numberBetween(17, 55);

      Student student = new Student(firstName, lastName, email, age);

      StudentIdCard studentIdCard = new StudentIdCard(
              "123456789",
              student);

      student.addBook(
              new Book("Clean Code", LocalDateTime.now().minusDays(4)));
      student.addBook(
              new Book("Think and Grow Rich", LocalDateTime.now()));
      student.addBook(
              new Book("Spring Data JPA", LocalDateTime.now().minusYears(1)));

      studentIdCardRepository.save(studentIdCard);

    };
  }

  private void generateRandomStudents(StudentRepository studentRepository)
  {
    Faker faker = new Faker();
    for (int i = 0; i < 20; i++)
    {
      String firstName = faker.name().firstName();
      String lastName = faker.name().lastName();
      String email = String.format("%s.%s@cyberdev.com", firstName, lastName);
      int age = faker.number().numberBetween(17, 55);

      Student student = new Student(firstName, lastName, email, age);

      studentRepository.save(student);
    }
  }

}
