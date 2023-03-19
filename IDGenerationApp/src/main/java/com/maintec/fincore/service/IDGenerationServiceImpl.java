package com.maintec.fincore.service;

import com.maintec.fincore.entity.GeneralMasters;
import com.maintec.fincore.entity.User;
import com.maintec.fincore.model.CompanyIDGenerationRequestModel;
import com.maintec.fincore.model.CompanyIDGenerationResponseModel;
import com.maintec.fincore.model.PersonalIDGenerationRequestModel;
import com.maintec.fincore.model.PersonalIDGenerationResponseModel;
import com.maintec.fincore.repository.GeneralMastersRepository;
import com.maintec.fincore.repository.IDRepository;
import com.maintec.fincore.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class IDGenerationServiceImpl implements IDGenerationService {

   @Autowired
   IDRepository idRepository;

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private GeneralMastersRepository generalMastersRepository;

   @Override
   public CompanyIDGenerationResponseModel save(CompanyIDGenerationRequestModel companyIDGenerationRequestModel) {
      CompanyIDGenerationResponseModel companyIDGenerationResponseModel = new CompanyIDGenerationResponseModel();
      Optional<User> userOptional = userRepository.findById(Long.parseLong(companyIDGenerationRequestModel.getUserId()));
      if(userOptional.isPresent()) {
         Optional<GeneralMasters> generalMastersOptional = generalMastersRepository.findByDescription(companyIDGenerationRequestModel.getConstitutionType());
         if(generalMastersOptional.isPresent()) {

         }
      }
      return companyIDGenerationResponseModel;
   }

   @Override
   public PersonalIDGenerationResponseModel save(PersonalIDGenerationRequestModel personalIDGenerationRequestModel) {
      PersonalIDGenerationResponseModel personalIDGenerationResponseModel = new PersonalIDGenerationResponseModel();
      Optional<User> userOptional = userRepository.findById(Long.parseLong(personalIDGenerationRequestModel.getUserId()));
      if(userOptional.isPresent()) {
         Optional<GeneralMasters> generalMastersOptional = generalMastersRepository.findByDescription(personalIDGenerationRequestModel.getConstitution());
         if(generalMastersOptional.isPresent()) {

         }
      }
      return personalIDGenerationResponseModel;
   }
}
