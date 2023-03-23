package com.maintec.fincore.service;

import com.maintec.fincore.model.IDSearchRequestModel;
import com.maintec.fincore.model.IDSearchResponseModel;

public interface IDSearchService {

    IDSearchResponseModel searchById(IDSearchRequestModel idSearchRequestModel);
    IDSearchResponseModel searchByName(IDSearchRequestModel idSearchRequestModel);

    IDSearchResponseModel searchByAadhaar(IDSearchRequestModel idSearchRequestModel);

    IDSearchResponseModel searchByPfNo(IDSearchRequestModel idSearchRequestModel);

    IDSearchResponseModel searchByLicenseNo(IDSearchRequestModel idSearchRequestModel);

    IDSearchResponseModel searchByAccountNo(IDSearchRequestModel idSearchRequestModel);
}
