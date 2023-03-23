package com.maintec.fincore.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BANK")
@Data
@EqualsAndHashCode(exclude = {"branches"})
public class Bank {

    @Id
    @Column(name = "FC_BANK_MASTER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BANK_SEQUENCER")
    @SequenceGenerator(name = "BANK_SEQUENCER", sequenceName = "BANK_SEQUENCER")
    private Long id;

    @Column(name = "FC_BANK_ID", nullable = false, unique = true)
    private String bankId;

    @Column(name = "FC_BANK_MICR_CODE", nullable = true, unique = true)
    private String bankMicrCode;

    @Column(name = "centralised")
    private boolean centralised;

    @OneToMany(mappedBy = "bankId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Branch> branches = new HashSet<Branch>();

    public void addBranch(Branch branch) {
        if( branch == null ) throw new IllegalArgumentException("Branch is null");
        branches.add(branch);
        branch.setBankId(this);
    }
}
