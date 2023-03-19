package com.maintec.fincore.service;

import com.maintec.fincore.model.SaveSignatureRequestModel;
import com.maintec.fincore.model.SaveSignatureResponseModel;
import com.maintec.fincore.model.ViewSignatureResponseModel;
import java.util.List;

public interface SignatureService {
   List<ViewSignatureResponseModel> findByParentID(long parentID);

   SaveSignatureResponseModel save(SaveSignatureRequestModel saveSignatureRequestModel);

   boolean delete(long id);
}
