package com.maintec.fincore.model;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
public class PersonalIDGenerationRequestModel {
    protected String idNo;
    protected String salutation;
    protected String reason;
    protected String decision;

    protected String approveUser;
    protected String initial;
    protected String customerFName;
    protected String customerMName;
    protected String customerLName;
    protected String fathersFName;
    protected String fathersMName;
    protected String fathersLName;
    protected String mothersFName;
    protected String mothersMName;
    protected String mothersLName;
    protected String spouseFName;
    protected String spouseMName;
    protected String spouseLName;
    protected String gender;
    protected String maritalStatus;
    protected String date;
    protected String age;
    protected String majorityStatus;
    protected String nationality;
    protected String bloodGroup;
    protected String religion;
    protected String cast;
    protected boolean scSt;
    protected String handicapped;
    protected String qualification;
    protected String panNo;
    protected String memberType;
    protected String membernumber;
    protected String constitution;
    protected String signLanguage;
    protected String income = "0.00";
    protected Long   aadhaarNo;
    protected String mobileNo;
    protected String searchIdNo;
    protected String identificationmark;
    protected String marking;
    protected String caution;
    protected boolean staff;
    protected String entereduser;
    protected String entereddate;
    protected String memNo;
    protected String finitial;
    protected String minitial;
    protected String sinitial;
    protected String ssalutation;
    protected String msalutation;
    protected String fsalutation;
    protected String houseNo;
    protected String crossNo;
    protected String mainNo;
    protected String areaLocation;

    protected String blockphasestage;
    protected String landMark;
    protected String city;
    protected String pin;
    protected String state;
    protected String district;
    protected String town;
    protected String village;
    protected String taluk;
    protected String hobli;

    protected String country;
    protected String landLine;
    protected String fax;
    protected String email;
    protected String webSite;
    protected boolean addressCommunication;
    protected String addressType;
    protected String fromDate;
    protected String toDate;

    //passport
    protected String passportDlNo;

    protected String issuedDate;
    protected String expiryDate;
    protected String cancelDate;
    protected String passportDlType;
    protected String issuedAt;
    //telephone

    protected Long customerNameID;
    protected String phoneType;
    protected String frmDate;
    protected String tdate;
    protected String accNo;
    protected Long phoneNo;
    protected String cancellingReason;
    //protected String searchIdNo;
    // protected String searchIdNo;
    protected String currDate;
    //email

    protected String customerID;
    protected String transactionDate;
    protected String emailfromDate;
    protected String emailtoDate;
    protected String emailaccNo;
    protected String emailID;
    protected String emailcancellingReason;
    protected boolean wantHistory;
    //professional
    protected String firmName;
    protected String department;
    protected String proffession;
    protected String designation;
    protected String empId;
    protected String proffromDate;
    protected String proftoDate;
    protected String rank;
    protected String division;
    protected String placeOfWork;
    protected String appointmentDate;
    protected String retirementDate;
    protected String basicPay;

    //    protected FormFile theFile;
    //   protected String customerID;
    protected String name;
    protected String type;
    protected String title;
    protected String imageUrl;
    protected String signexpiryDate;
    protected String theFile;

    // Enterprise
    protected String enterpriseName;
    protected String licenceNo;
    protected String classtype;
    protected String expiredate;

    @JsonIgnore
    private String userId;
}
