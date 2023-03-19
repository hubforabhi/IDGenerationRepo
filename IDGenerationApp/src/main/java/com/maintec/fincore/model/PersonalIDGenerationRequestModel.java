package com.maintec.fincore.model;

import lombok.Data;

@Data
public class PersonalIDGenerationRequestModel {
    private String idNo;
    private String salutation;
    private String reason;
    private String decision;

    private String approveUser;
    private String initial;
    private String customerFName;
    private String customerMName;
    private String customerLName;
    private String fathersFName;
    private String fathersMName;
    private String fathersLName;
    private String mothersFName;
    private String mothersMName;
    private String mothersLName;
    private String spouseFName;
    private String spouseMName;
    private String spouseLName;
    private String gender;
    private String maritalStatus;
    private String date;
    private String age;
    private String majorityStatus;
    private String nationality;
    private String bloodGroup;
    private String religion;
    private String cast;
    private boolean scSt;
    private String handicapped;
    private String qualification;
    private String panNo;
    private String memberType;
    private String membernumber;
    private String constitution;
    private String signLanguage;
    private String income = "0.00";
    private Long   aadhaarNo;
    private String mobileNo;
    private String searchIdNo;
    private String identificationmark;
    private String marking;
    private String caution;
    private boolean staff;
    private String entereduser;
    private String entereddate;
    private String memNo;
    private String finitial;
    private String minitial;
    private String sinitial;
    private String ssalutation;
    private String msalutation;
    private String fsalutation;
    private String houseNo;
    private String crossNo;
    private String mainNo;
    private String areaLocation;

    private String blockphasestage;
    private String landMark;
    private String city;
    private String pin;
    private String state;
    private String district;
    private String town;
    private String village;
    private String taluk;
    private String hobli;

    private String country;
    private String landLine;
    private String fax;
    private String email;
    private String webSite;
    private boolean addressCommunication;
    private String addressType;
    private String fromDate;
    private String toDate;

    //passport
    private String passportDlNo;

    private String issuedDate;
    private String expiryDate;
    private String cancelDate;
    private String passportDlType;
    private String issuedAt;
    //telephone

    private Long customerNameID;
    private String phoneType;
    private String frmDate;
    private String tdate;
    private String accNo;
    private Long phoneNo;
    private String cancellingReason;
    //private String searchIdNo;
    // private String searchIdNo;
    private String currDate;
    //email

    private String customerID;
    private String transactionDate;
    private String emailfromDate;
    private String emailtoDate;
    private String emailaccNo;
    private String emailID;
    private String emailcancellingReason;
    private boolean wantHistory;
    //professional
    private String firmName;
    private String department;
    private String proffession;
    private String designation;
    private String empId;
    private String proffromDate;
    private String proftoDate;
    private String rank;
    private String division;
    private String placeOfWork;
    private String appointmentDate;
    private String retirementDate;
    private String basicPay;

    //    private FormFile theFile;
    //   private String customerID;
    private String name;
    private String type;
    private String title;
    private String imageUrl;
    private String signexpiryDate;
    private String theFile;

    // Enterprise
    private String enterpriseName;
    private String licenceNo;
    private String classtype;
    private String expiredate;

    private String userId;
}
