package com.maintec.fincore.service;

import com.maintec.fincore.model.ReleaseCautionRequestModel;
import com.maintec.fincore.model.ReleaseCautionResponseModel;
import com.maintec.fincore.model.SaveCautionRequestModel;
import com.maintec.fincore.model.SaveCautionResponseModel;
import com.maintec.fincore.model.SearchCautionResponseModel;
import java.util.List;

public interface CautionService {
   List<SearchCautionResponseModel> findByParentId(long id);

   SaveCautionResponseModel save(SaveCautionRequestModel saveCautionRequestModel);

   ReleaseCautionResponseModel release(ReleaseCautionRequestModel releaseCautionRequestModel);
}
