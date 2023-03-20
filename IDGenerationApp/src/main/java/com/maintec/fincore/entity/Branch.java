package com.maintec.fincore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "BRANCH")
@Data
public class Branch {

   @Id
   @Column(name = "FC_BR_MASTER_ID")
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRANCH_SEQUENCER")
   @SequenceGenerator(name = "BRANCH_SEQUENCER", sequenceName = "BRANCH_SEQUENCER")
   private Long id;


}
