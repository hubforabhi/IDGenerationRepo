package com.maintec.fincore.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ID_TABLE", schema = "public")
@Data
@EqualsAndHashCode(exclude = {"address", "passports", "professions", "emaildetails", "phoneDetails", "enterprise", "images"})
public class ID {

   @Id
   @Column(name = "FC_ID")
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCER")
   @SequenceGenerator(name = "ID_SEQUENCER", sequenceName = "ID_SEQUENCER")
   private Long id;

   private Long oldId;

   @Column(name = "FC_MEM_NO", length = 25)
   private String memberNumber;

   //private String newid;
   //private String idNo;

   @Column(name = "FC_PERSONAL")
   private boolean personal;
   @Column(name = "FC_QUICK")
   private boolean quick;

   @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
   @JoinColumn(name = "FC_CUSTOMER")
   private Customer personalDetails;

   @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
   @JoinColumn(name = "FC_COMPANY")
   private Company companyDetails;

   @Column(name = "FC_COMMUNICATION_ADDRESS", length = 50)
   private BigDecimal income;

   @ManyToOne(optional = false)
   @JoinColumn(name = "FC_CONSTITUTION")
   private GeneralMasters constitution;

   @OneToMany(mappedBy = "customerId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   private Set<Address> address = new HashSet<>();

   @OneToMany(mappedBy = "customerId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   private Set<Passport> passports = new HashSet<>();

   @OneToMany(mappedBy = "customerId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   private Set<Profession> professions = new HashSet<>();

   @OneToMany(mappedBy = "customerId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   private Set<EmailDetails> emaildetails = new HashSet<>();

   @OneToMany(mappedBy = "customerId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   private Set<TelePhoneDetails> phoneDetails = new HashSet<>();

   @OneToMany(mappedBy = "customerId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   private Set<Enterprise> enterprise = new HashSet<>();

   @OneToMany(mappedBy = "parentID", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   private Set<Images> images = new HashSet<>();

   @Embedded
   private TransactionProcess transactionProcess;

   @Column(name = "FC_EXPIRED")
   private boolean expired;
   @Column(name = "FC_COMPLETED")
   private boolean completed;

   @Column(name = "FC_ENTERED_DATE", nullable = false)
   private LocalDate enteredDate;

   @Column(name = "FC_CREATION_DATE", nullable = false)
   private LocalDate creationDate;

   @OneToOne
   private Caution currentCaution;

   @ManyToOne(fetch = FetchType.LAZY, optional = false)
   @JoinColumn(name = "FC_ENTERED_BY")
   private User enteredBy;

   @ManyToOne(fetch = FetchType.LAZY, optional = false)
   @JoinColumn(name = "FC_BRANCH")
   private Branch branch;

   @Version
   @Column(name = "FC_VERSION_ID", nullable = false)
   private Integer versionID;

   //private Integer previousVersionID;

   public void addAddress(Address address) {

      if( address == null ) throw new IllegalArgumentException("Address is Null");

      address.setCustomerId(this);
      this.address.add(address);
   }

   public void addProfession(Profession profession){
      if( profession == null ) throw new IllegalArgumentException("Profession is Null");

      profession.setCustomerId(this);
      this.professions.add(profession);
   }
   public void addPassport(Passport passport){
      if( passport == null ) throw new IllegalArgumentException("Passport is Null");

      passport.setCustomerId(this);
      this.passports.add(passport);
   }
   public void addEmail(EmailDetails email){
      if( email == null ) throw new IllegalArgumentException("EmailDetails is Null");

      email.setCustomerId(this);
      this.emaildetails.add(email);
   }

   public void addPhoneDetails(TelePhoneDetails phone) {

      if( phone == null ) throw new IllegalArgumentException("TelePhoneDetails is Null");

      phone.setCustomerId(this);
      this.phoneDetails.add(phone);
   }
   public void addEnterprise(Enterprise enterprise){
      if( enterprise == null ) throw new IllegalArgumentException("Enterprise is Null");

      enterprise.setCustomerId(this);
      this.enterprise.add(enterprise);
   }
}
