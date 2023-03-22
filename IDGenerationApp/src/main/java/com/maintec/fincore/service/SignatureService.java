package com.maintec.fincore.service;

import com.maintec.fincore.model.*;

import java.io.InputStream;
import java.util.List;

public interface SignatureService {
   List<ViewSignatureResponseModel> findByParentID(long parentID);

   SaveSignatureResponseModel save(SaveSignatureRequestModel saveSignatureRequestModel);

   GetSignatureResponseModel getImage(GetSignatureImageRequestModel getSignatureImageRequestModel);

   boolean delete(long id);
}
