package com.maintec.fincore.service;

import com.maintec.fincore.model.CompanyIDGenerationRequestModel;
import com.maintec.fincore.model.CompanyIDGenerationResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class IDGenerationServiceImpl implements IDGenerationService {
   private static final Logger log = LoggerFactory.getLogger(IDGenerationServiceImpl.class);

   @Override
   public CompanyIDGenerationResponseModel companySave(CompanyIDGenerationRequestModel companyIDGenerationRequestModel) {
      return new CompanyIDGenerationResponseModel();
   }
}
