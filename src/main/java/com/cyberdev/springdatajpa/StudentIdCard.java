package com.cyberdev.springdatajpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "StudentIdCard")
@Table(
        name = "student_id_card",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "student_id_card_number_unique",
                        columnNames = "card_number"
                )
        }
)
public class StudentIdCard
{

  @Id
  @SequenceGenerator(
          name = "student_card_id_sequence",
          sequenceName = "student_card_id_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "student_card_id_sequence"
  )
  @Column(
          name = "id",
          updatable = false
  )
  private Long id;

  @Column(
          name = "card_number",
          nullable = false,
          length = 15
  )
  private String cardNumber;

  public StudentIdCard() {
  }

  public StudentIdCard(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }
}
