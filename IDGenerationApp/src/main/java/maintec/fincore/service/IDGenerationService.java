package com.maintec.fincore.service;

import com.maintec.fincore.model.CompanyIDGenerationRequestModel;
import com.maintec.fincore.model.CompanyIDGenerationResponseModel;

public interface IDGenerationService {
   CompanyIDGenerationResponseModel companySave(CompanyIDGenerationRequestModel companyIDGenerationRequestModel);
}
