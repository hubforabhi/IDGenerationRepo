package com.maintec.fincore.service;

import com.maintec.fincore.entity.*;
import com.maintec.fincore.model.CompanyIDGenerationRequestModel;
import com.maintec.fincore.model.CompanyIDGenerationResponseModel;
import com.maintec.fincore.model.PersonalIDGenerationRequestModel;
import com.maintec.fincore.model.PersonalIDGenerationResponseModel;
import com.maintec.fincore.repository.GeneralMastersRepository;
import com.maintec.fincore.repository.IDRepository;
import com.maintec.fincore.repository.UserRepository;
import com.maintec.fincore.system.constants.ProcessCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import static com.maintec.fincore.IDGenerationConstants.BUSINESS_DATE_FORMATTER;
import static com.maintec.fincore.IDGenerationConstants.BUSINESS_DATE_TIME_FORMATTER;

@Service
@Slf4j
public class IDGenerationServiceImpl implements IDGenerationService {
   @Autowired
   private IDRepository idRepository;

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private GeneralMastersRepository generalMastersRepository;

   @Override
   public CompanyIDGenerationResponseModel save(CompanyIDGenerationRequestModel companyIDGenerationRequestModel) {
      CompanyIDGenerationResponseModel companyIDGenerationResponseModel = companyFrom.apply(companyIDGenerationRequestModel);
      Optional<User> userOptional = userRepository.findById(Long.parseLong(companyIDGenerationRequestModel.getUserId()));
      if(userOptional.isPresent()) {
         Optional<GeneralMasters> generalMastersOptional = generalMastersRepository.findByDescription(companyIDGenerationRequestModel.getConstitutionfirmType());
         if(generalMastersOptional.isPresent()) {
            ID id = saveCompanyIDMapper.apply(companyIDGenerationRequestModel, userOptional.get());
            id.setConstitution(generalMastersOptional.get());
            idRepository.save(id);
            companyIDGenerationResponseModel.setId(String.valueOf(id.getId()));
         }
      }
      return companyIDGenerationResponseModel;
   }

   @Override
   public PersonalIDGenerationResponseModel save(PersonalIDGenerationRequestModel personalIDGenerationRequestModel) {
      PersonalIDGenerationResponseModel personalIDGenerationResponseModel = personalFrom.apply(personalIDGenerationRequestModel);
      Optional<User> userOptional = userRepository.findById(Long.parseLong(personalIDGenerationRequestModel.getUserId()));
      if(userOptional.isPresent()) {
         Optional<GeneralMasters> generalMastersOptional = generalMastersRepository.findByDescription(personalIDGenerationRequestModel.getConstitution());
         if(generalMastersOptional.isPresent()) {
            ID id = savePersonalIDMapper.apply(personalIDGenerationRequestModel, userOptional.get());
            id.setConstitution(generalMastersOptional.get());
            idRepository.save(id);
            personalIDGenerationResponseModel.setId(String.valueOf(id.getId()));
         }
      }
      return personalIDGenerationResponseModel;
   }

   private BiFunction<CompanyIDGenerationRequestModel, User, Company> saveCompanyIDCompanyMapper = (companyIDGenerationRequestModel, user) -> {
      Company company = new Company();
      company.setActivityNature(companyIDGenerationRequestModel.getNatueofAct() );
      company.setESTNo(companyIDGenerationRequestModel.getEstNo() );
      company.setEnteredBy(user);
      //company.setBranch(user.getBranch());
      company.setEnteredDate(LocalDate.now());
      company.setFirmName(companyIDGenerationRequestModel.getFirmName() );
      company.setITWardcircle(companyIDGenerationRequestModel.getItWardCircle() );
      company.setKSTNo(companyIDGenerationRequestModel.getKstNo() );
      company.setRegistrationDate(
              companyIDGenerationRequestModel.getRegistrationDate() != null && companyIDGenerationRequestModel.getRegistrationDate().length() != 0 ?
               LocalDate.parse(companyIDGenerationRequestModel.getRegistrationDate(), BUSINESS_DATE_FORMATTER) : null );
      company.setRegistrationNo(companyIDGenerationRequestModel.getRegistrationNo() );
      company.setRegistrationPlace(companyIDGenerationRequestModel.getRegistrationPlace() );
      //company.setFirmType( form.getConstitutionfirmType() );
      company.setPAN(companyIDGenerationRequestModel.getPan());
      company.setCreationDate(LocalDate.now());
      return company;
   };

   private BiFunction<CompanyIDGenerationRequestModel, User, ID> saveCompanyIDMapper = (companyIDGenerationRequestModel, user) -> {
      ID id = new ID();
      Company company = saveCompanyIDCompanyMapper.apply(companyIDGenerationRequestModel, user);
      id.setCompanyDetails(company);
      id.setCompleted(false);
      id.setQuick(false);
      id.setEnteredBy(user);
      id.setBranch(user.getBranch());
      id.setEnteredDate(LocalDate.now());
      id.setCreationDate(LocalDate.now());
      id.setExpired(false);
      id.setIncome(
              companyIDGenerationRequestModel.getIncome() != null ?
                      new BigDecimal(companyIDGenerationRequestModel.getIncome()) : BigDecimal.ZERO );
      id.setTransactionProcess(createTXNProcess(ProcessCodes.ID_CREATION.getCashTXNCode(),false, null) );
      return id;
   };

   private BiFunction<PersonalIDGenerationRequestModel, User, Passport> savePersonalIDPassportMapper = (personalIDGenerationRequestModel, user) -> {
      Passport passport = null;
      if(personalIDGenerationRequestModel.getPassportDlType()!=null &&  !personalIDGenerationRequestModel.getPassportDlType() .equalsIgnoreCase("") &&  personalIDGenerationRequestModel.getPassportDlType() !=""){
         passport = new Passport(); // Save
         passport.setEnteredBy(user);
         //passport.setBranch(user.getBranch());
         passport.setEnteredDate(LocalDate.now());

         //ObjectPropertyEditor.editFields(form,PersonalDetailsForm.class,FIELDS_TO_UPPER_CASE,"issuedDate","expiryDate","currDate","passportDlNo");
         passport.setIssuedAt(personalIDGenerationRequestModel.getIssuedAt());
         passport.setIssueDate(
                 personalIDGenerationRequestModel.getIssuedDate() != null && personalIDGenerationRequestModel.getIssuedDate().length() != 0 ?
                         LocalDate.parse(personalIDGenerationRequestModel.getIssuedDate(), BUSINESS_DATE_FORMATTER) : null );
         passport.setPassportORDLNo(personalIDGenerationRequestModel.getPassportDlNo() );
         passport.setPassportORDLType(personalIDGenerationRequestModel.getPassportDlType() );
      }
      return passport;
   };

   private BiFunction<PersonalIDGenerationRequestModel, User, Customer> savePersonalIDPersonalMapper = (personalIDGenerationRequestModel, user) -> {
      Customer customer = new Customer();
      customer.setEnteredBy( user );
      customer.setBranch(user.getBranch());
      customer.setEnteredDate(LocalDate.now());

      customer.setBloodGroup(personalIDGenerationRequestModel.getBloodGroup() );
      customer.setCaste(personalIDGenerationRequestModel.getCast());
      NameWithInitials cname =  new NameWithInitials();
      Name fname = new Name();
      Name mname = new Name();
      Name sname = new Name();

      if(personalIDGenerationRequestModel.getCustomerFName()!=null && !personalIDGenerationRequestModel.getCustomerFName().equalsIgnoreCase(""))
         cname.setFirstName(personalIDGenerationRequestModel.getCustomerFName().trim());
      if(personalIDGenerationRequestModel.getCustomerMName()!=null && !personalIDGenerationRequestModel.getCustomerMName().equalsIgnoreCase(""))
         cname.setMiddleName(personalIDGenerationRequestModel.getCustomerMName().trim());
      if(personalIDGenerationRequestModel.getCustomerLName()!=null && !personalIDGenerationRequestModel.getCustomerLName().equalsIgnoreCase(""))
         cname.setLastName(personalIDGenerationRequestModel.getCustomerLName().trim());
      if(personalIDGenerationRequestModel.getInitial()!=null && !personalIDGenerationRequestModel.getInitial().equalsIgnoreCase(""))
         cname.setInitial(personalIDGenerationRequestModel.getInitial());
      customer.setCustomerName(cname);

      if(personalIDGenerationRequestModel.getFathersFName()!=null && !personalIDGenerationRequestModel.getFathersFName().equalsIgnoreCase(""))
         fname.setFirstName(personalIDGenerationRequestModel.getFathersFName().trim());
      if(personalIDGenerationRequestModel.getFathersMName()!=null && !personalIDGenerationRequestModel.getFathersMName().equalsIgnoreCase(""))
         fname.setMiddleName(personalIDGenerationRequestModel.getFathersMName().trim());
      if(personalIDGenerationRequestModel.getFathersLName()!=null && !personalIDGenerationRequestModel.getFathersLName().equalsIgnoreCase(""))
         fname.setLastName(personalIDGenerationRequestModel.getFathersLName().trim());
      customer.setFatherName(fname);

      if(personalIDGenerationRequestModel.getMothersFName()!=null && !personalIDGenerationRequestModel.getMothersFName().equalsIgnoreCase(""))
         mname.setFirstName(personalIDGenerationRequestModel.getMothersFName().trim());
      if(personalIDGenerationRequestModel.getMothersMName()!=null && !personalIDGenerationRequestModel.getMothersMName().equalsIgnoreCase(""))
         mname.setMiddleName(personalIDGenerationRequestModel.getMothersMName().trim());
      if(personalIDGenerationRequestModel.getMothersLName()!=null && !personalIDGenerationRequestModel.getMothersLName().equalsIgnoreCase(""))
         mname.setLastName(personalIDGenerationRequestModel.getMothersLName().trim());
      customer.setMotherName(mname);

      if(personalIDGenerationRequestModel.getSpouseFName()!=null && !personalIDGenerationRequestModel.getSpouseFName().equalsIgnoreCase(""))
         sname.setFirstName(personalIDGenerationRequestModel.getSpouseFName().trim());
      if(personalIDGenerationRequestModel.getSpouseMName()!=null && !personalIDGenerationRequestModel.getSpouseMName().equalsIgnoreCase(""))
         sname.setMiddleName(personalIDGenerationRequestModel.getSpouseMName().trim());
      if(personalIDGenerationRequestModel.getSpouseLName()!=null && !personalIDGenerationRequestModel.getSpouseLName().equalsIgnoreCase(""))
         sname.setLastName(personalIDGenerationRequestModel.getSpouseLName().trim());
      customer.setSpouseName(sname);

      customer.setDateOfBirth(
              personalIDGenerationRequestModel.getDate() != null && personalIDGenerationRequestModel.getDate().length() != 0 ?
                      LocalDate.parse(personalIDGenerationRequestModel.getDate(), BUSINESS_DATE_FORMATTER) : null );
      customer.setGender(personalIDGenerationRequestModel.getGender() );
      customer.setHandicapped(personalIDGenerationRequestModel.getHandicapped() );
      customer.setIdentificationMark(personalIDGenerationRequestModel.getIdentificationmark() );
      //customer.setInitial( form.getInitial() );
      customer.setMarried(personalIDGenerationRequestModel.getMaritalStatus().equals("1") ? false : true );
      customer.setMemberNumber(personalIDGenerationRequestModel.getMembernumber() );
      customer.setMemberType(personalIDGenerationRequestModel.getMemberType() );
      customer.setNationality(personalIDGenerationRequestModel.getNationality() );
      customer.setPAN(personalIDGenerationRequestModel.getPanNo() );
      customer.setAadhaar(personalIDGenerationRequestModel.getAadhaarNo());

      customer.setQualification(personalIDGenerationRequestModel.getQualification());
      customer.setRelegion(personalIDGenerationRequestModel.getReligion());
      customer.setSalutation(personalIDGenerationRequestModel.getSalutation());
      customer.setScst(personalIDGenerationRequestModel.isScSt() );
      customer.setSignatureLanguage( personalIDGenerationRequestModel.getSignLanguage() );
      customer.setStaff(personalIDGenerationRequestModel.isStaff());

      if(personalIDGenerationRequestModel.getGender().equalsIgnoreCase("Female") )
         customer.setGender("FEMALE");
      else
         customer.setGender("MALE");
      return customer;
   };

   private BiFunction<PersonalIDGenerationRequestModel, User, Address> savePersonalIDAddressMapper = (personalIDGenerationRequestModel, user) -> {
      Address address = null;
      if(personalIDGenerationRequestModel.getAddressType()!=null && !personalIDGenerationRequestModel.getAddressType().equalsIgnoreCase("") && personalIDGenerationRequestModel.getAddressType()!="") {
         address = new Address(); // Save
         address.setEnteredBy(user);
         //address.setBranch(user.getBranch());
         //ObjectPropertyEditor.editFields(form,PersonalDetailsForm.class,FIELDS_TO_UPPER_CASE,"email","webSite");
         address.setAddressType(personalIDGenerationRequestModel.getAddressType());
         if (personalIDGenerationRequestModel.getCrossNo() != null && personalIDGenerationRequestModel.getCrossNo().trim() != "")
            address.setNoCrossMain(personalIDGenerationRequestModel.getCrossNo().trim());
         if (personalIDGenerationRequestModel.getAreaLocation() != null && personalIDGenerationRequestModel.getAreaLocation().trim() != "")
            address.setAreaLocation(personalIDGenerationRequestModel.getAreaLocation().trim());
         if (personalIDGenerationRequestModel.getBlockphasestage() != null && personalIDGenerationRequestModel.getBlockphasestage().trim() != "")
            address.setBlockPhaseStage(personalIDGenerationRequestModel.getBlockphasestage().trim());
         if (personalIDGenerationRequestModel.getHobli() != null && personalIDGenerationRequestModel.getHobli().trim() != "" && !personalIDGenerationRequestModel.getHobli().equals("-1"))
            address.setHobli(personalIDGenerationRequestModel.getHobli().trim());
         if (personalIDGenerationRequestModel.getVillage() != null && personalIDGenerationRequestModel.getVillage().trim() != "")
            address.setVillage(personalIDGenerationRequestModel.getVillage().trim());
         if (personalIDGenerationRequestModel.getTown() != null && personalIDGenerationRequestModel.getTown().trim() != "")
            address.setTown(personalIDGenerationRequestModel.getTown().trim());
         if (personalIDGenerationRequestModel.getCity() != null && personalIDGenerationRequestModel.getCity().trim() != "")
            address.setCity(personalIDGenerationRequestModel.getCity().trim());
         if (personalIDGenerationRequestModel.getTaluk() != null && personalIDGenerationRequestModel.getTaluk().trim() != "")
            address.setTaluk(personalIDGenerationRequestModel.getTaluk().trim());
         if (personalIDGenerationRequestModel.getDistrict() != null && personalIDGenerationRequestModel.getDistrict().trim() != "")
            address.setDistrict(personalIDGenerationRequestModel.getDistrict().trim());
         if (personalIDGenerationRequestModel.getCountry() != null && personalIDGenerationRequestModel.getCountry().trim() != "")
            address.setCountry(personalIDGenerationRequestModel.getCountry().trim());
         if (personalIDGenerationRequestModel.getLandMark() != null && personalIDGenerationRequestModel.getLandMark().trim() != "")
            address.setLandMark(personalIDGenerationRequestModel.getLandMark().trim());
         if (personalIDGenerationRequestModel.getPin() != null && personalIDGenerationRequestModel.getPin().trim() != "")
            address.setPin(personalIDGenerationRequestModel.getPin().trim());
         if (personalIDGenerationRequestModel.getState() != null && personalIDGenerationRequestModel.getState().trim() != "")
            address.setState(personalIDGenerationRequestModel.getState().trim());
         address.setCommunication(personalIDGenerationRequestModel.isAddressCommunication());
         address.setFromDate(LocalDate.now());
         address.setEnteredDate(LocalDate.now());
         if(personalIDGenerationRequestModel.getToDate()!=null && !"".equals(personalIDGenerationRequestModel.getToDate()))
            address.setToDate(LocalDate.parse(personalIDGenerationRequestModel.getToDate(), BUSINESS_DATE_FORMATTER));

      }
      return address;
   };

   private BiFunction<PersonalIDGenerationRequestModel, User, TelePhoneDetails> savePersonalIDTelePhoneDetailsMapper = (personalIDGenerationRequestModel, user) -> {
      TelePhoneDetails telePhoneDetails = new TelePhoneDetails();
      if (personalIDGenerationRequestModel.getPhoneType() != null)
         telePhoneDetails.setPhoneType(personalIDGenerationRequestModel.getPhoneType());
      telePhoneDetails.setFromDate(LocalDateTime.now());

      if (personalIDGenerationRequestModel.getPhoneNo() != null)
         telePhoneDetails.setPhoneNo(personalIDGenerationRequestModel.getPhoneNo());

      telePhoneDetails.setTransactionDate(LocalDateTime.now());
      telePhoneDetails.setEnteredBy(user);
      //telePhoneDetails.setBranch(user.getBranch());

      return telePhoneDetails;
   };

   private BiFunction<PersonalIDGenerationRequestModel, User, EmailDetails> savePersonalIDEmailMapper = (personalIDGenerationRequestModel, user) -> {
      EmailDetails email = new EmailDetails();
      email.setFromDate(LocalDateTime.now());
      if(personalIDGenerationRequestModel.getTransactionDate() != null && !"".equalsIgnoreCase(personalIDGenerationRequestModel.getTransactionDate()))
         email.setTransactionDate(LocalDateTime.parse(personalIDGenerationRequestModel.getTransactionDate(), BUSINESS_DATE_TIME_FORMATTER));

      if(personalIDGenerationRequestModel.getEmailID() != null)
         email.setEmailID(personalIDGenerationRequestModel.getEmailID());

      email.setEnteredBy(user);
      //email.setBranch(user.getBranch());
      email.setEnteredDate(LocalDateTime.now());
      return email;
   };

   private BiFunction<PersonalIDGenerationRequestModel, User, Profession> savePersonalIDProfessionMapper = (personalIDGenerationRequestModel, user) -> {
      Profession profession = null;
      if(personalIDGenerationRequestModel.getProffession()!=null && !personalIDGenerationRequestModel.getProffession().equalsIgnoreCase("") && personalIDGenerationRequestModel.getProffession()!="") {
         profession = new Profession(); // Save
         profession.setEnteredBy(user);
         //profession.setBranch(user.getBranch());
         profession.setEnteredDate(LocalDate.now());
         //ObjectPropertyEditor.editFields(pform,PersonalDetailsForm.class,FIELDS_TO_UPPER_CASE,"");
         profession.setDepartment(personalIDGenerationRequestModel.getDepartment() );
         profession.setDesignation(personalIDGenerationRequestModel.getDesignation() );
         profession.setEmployeeID(personalIDGenerationRequestModel.getEmpId() );
         profession.setFirmName(personalIDGenerationRequestModel.getFirmName() );
         profession.setProffession(personalIDGenerationRequestModel.getProffession() );

         profession.setTransactionDate(LocalDate.now());
         profession.setDetailsFromDate(LocalDate.now());
         profession.setRank(personalIDGenerationRequestModel.getRank());
         profession.setDivision(personalIDGenerationRequestModel.getDivision());
         profession.setPlaceOfWorking(personalIDGenerationRequestModel.getPlaceOfWork());
         if(personalIDGenerationRequestModel.getAppointmentDate() != null && !"".equalsIgnoreCase(personalIDGenerationRequestModel.getAppointmentDate()))
            profession.setAppointmentDate(LocalDate.parse(personalIDGenerationRequestModel.getAppointmentDate(), BUSINESS_DATE_FORMATTER));
         if(personalIDGenerationRequestModel.getRetirementDate() != null && !"".equalsIgnoreCase(personalIDGenerationRequestModel.getRetirementDate()))
            profession.setRetirementDate(LocalDate.parse(personalIDGenerationRequestModel.getRetirementDate(), BUSINESS_DATE_FORMATTER));
         //inserting basic pay value.....
         if(personalIDGenerationRequestModel.getBasicPay() !=null && !"".equals(personalIDGenerationRequestModel.getBasicPay() )){
            profession.setBasicPay(new BigDecimal(personalIDGenerationRequestModel.getBasicPay()));
         }
      }
      return profession;
   };

   private BiFunction<PersonalIDGenerationRequestModel, User, Enterprise> savePersonalIDEnterpriseMapper = (personalIDGenerationRequestModel, user) -> {
      Enterprise enterprise = null;
      if(personalIDGenerationRequestModel.getEnterpriseName()!=null && personalIDGenerationRequestModel.getEnterpriseName()!=""){
         enterprise = new Enterprise();
         enterprise.setFirmName(personalIDGenerationRequestModel.getEnterpriseName());
         if(personalIDGenerationRequestModel.getLicenceNo()!=null && personalIDGenerationRequestModel.getLicenceNo()!="")
            enterprise.setLicenceNo(personalIDGenerationRequestModel.getLicenceNo());
         if(personalIDGenerationRequestModel.getClasstype()!=null && personalIDGenerationRequestModel.getClasstype()!="")
            enterprise.setClasstype(personalIDGenerationRequestModel.getClasstype());
         enterprise.setEnteredBy(user);
         enterprise.setEnteredDate(LocalDate.now());
         if(personalIDGenerationRequestModel.getExpiredate()!=null && personalIDGenerationRequestModel.getExpiredate()!="")
            enterprise.setExpireDate(LocalDate.parse(personalIDGenerationRequestModel.getExpiredate(), BUSINESS_DATE_FORMATTER));
      }
      return enterprise;
   };

   private BiFunction<PersonalIDGenerationRequestModel, User, ID> savePersonalIDMapper = (personalIDGenerationRequestModel, user) -> {
      ID id = new ID();

      Customer customer = savePersonalIDPersonalMapper.apply(personalIDGenerationRequestModel, user);

      Passport passport = savePersonalIDPassportMapper.apply(personalIDGenerationRequestModel, user);
      if(passport != null)
         id.addPassport(passport);
      Address address = savePersonalIDAddressMapper.apply(personalIDGenerationRequestModel, user);
      if(address != null)
         id.addAddress(address);
      TelePhoneDetails telePhoneDetails = savePersonalIDTelePhoneDetailsMapper.apply(personalIDGenerationRequestModel, user);
      if(telePhoneDetails != null)
         id.addPhoneDetails(telePhoneDetails);
      id.addEmail(savePersonalIDEmailMapper.apply(personalIDGenerationRequestModel, user));

      Profession profession = savePersonalIDProfessionMapper.apply(personalIDGenerationRequestModel, user);
      if(profession != null) {
         profession.setEmpName(customer.getCustomerName().getFullName());
         id.setIncome(new BigDecimal(personalIDGenerationRequestModel.getBasicPay()));
      }
      Enterprise enterprise = savePersonalIDEnterpriseMapper.apply(personalIDGenerationRequestModel, user);
      if(enterprise != null)
         id.addEnterprise(enterprise);

      id.setPersonal(true);
      id.setPersonalDetails(customer);
      id.setQuick(false);
      id.setCompleted(false);
      id.setEnteredBy(user);
      id.setBranch(user.getBranch());
      id.setEnteredDate(LocalDate.now());
      id.setCreationDate(LocalDate.now());
      id.setExpired(false);
      id.setIncome(
              personalIDGenerationRequestModel.getIncome() != null ?
                      new BigDecimal(personalIDGenerationRequestModel.getIncome()) : BigDecimal.ZERO );
      id.setTransactionProcess(createTXNProcess(ProcessCodes.ID_CREATION.getCashTXNCode(),false, null) );
      return id;
   };

   public TransactionProcess createTXNProcess(String processCode, boolean isExceptional, String entryExceptionalReason) {
      TransactionProcess txnProcess = new TransactionProcess();

      txnProcess.setTxnSource(processCode);

      txnProcess.setFirstApprovedBy(null);
      txnProcess.setSecondApprovedBy(null);
      txnProcess.setDeniedBy(null);

      txnProcess.setFirstApprovedDate(null);
      txnProcess.setSecondApprovedDate(null);
      txnProcess.setDeniedDate(null);

      txnProcess.setFirstApproveExceptionalReason(null);
      txnProcess.setSecondApproveExceptionalReason(null);
      txnProcess.setDeniedReason(null);
      txnProcess.setApprovalReason("Waiting For Ist Approval");
      txnProcess.setExceptional(isExceptional);
      /*    if( isExceptional ) txnProcess.setEntryExceptionalReason(entryExceptionalReason);
       */
      txnProcess.setTxnApproved(false); // Txn. Not Approved.
      txnProcess.setTransactionStatus(0); // Txn. Not Comitted.

      return txnProcess;
   }

    private final Function<CompanyIDGenerationRequestModel, CompanyIDGenerationResponseModel> companyFrom = (companyIDGenerationRequestModel) -> {
        CompanyIDGenerationResponseModel companyIDGenerationResponseModel = new CompanyIDGenerationResponseModel();
        BeanUtils.copyProperties(companyIDGenerationRequestModel, companyIDGenerationResponseModel);
        return companyIDGenerationResponseModel;
    };

   private final Function<PersonalIDGenerationRequestModel, PersonalIDGenerationResponseModel> personalFrom = (personalIDGenerationRequestModel) -> {
       PersonalIDGenerationResponseModel personalIDGenerationResponseModel = new PersonalIDGenerationResponseModel();
       BeanUtils.copyProperties(personalIDGenerationRequestModel, personalIDGenerationResponseModel);
       return personalIDGenerationResponseModel;
   };
}
