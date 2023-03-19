package com.maintec.fincore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(
   name = "USER_TABLE"
)
@Data
public class User {
   @Id
   @Column(
      name = "FC_USER_ID"
   )
   @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "USER_SEQUENCER"
   )
   @SequenceGenerator(
      name = "USER_SEQUENCER",
      sequenceName = "USER_SEQUENCER"
   )
   private Long id;
   @ManyToOne(
      fetch = FetchType.LAZY,
      optional = false
   )
   @JoinColumn(
      name = "FC_BRANCH"
   )
   private Branch branch;
}
