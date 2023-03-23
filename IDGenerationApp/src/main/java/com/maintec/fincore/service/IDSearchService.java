package com.maintec.fincore.service;

import com.maintec.fincore.model.IDSearchRequestModel;
import com.maintec.fincore.model.IDSearchResponseModel;

public interface IDSearchService {

    IDSearchResponseModel searchById(IDSearchRequestModel idSearchRequestModel);
}
