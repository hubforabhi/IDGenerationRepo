package com.maintec.fincore.service;

import com.maintec.fincore.model.CompanyIDGenerationRequestModel;
import com.maintec.fincore.model.CompanyIDGenerationResponseModel;
import com.maintec.fincore.model.PersonalIDGenerationRequestModel;
import com.maintec.fincore.model.PersonalIDGenerationResponseModel;

public interface IDGenerationService {
   CompanyIDGenerationResponseModel save(CompanyIDGenerationRequestModel companyIDGenerationRequestModel);

   PersonalIDGenerationResponseModel save(PersonalIDGenerationRequestModel personalIDGenerationRequestModel);
}
