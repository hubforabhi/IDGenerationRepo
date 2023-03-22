package com.maintec.fincore.service;

import com.maintec.fincore.model.GetSignatureImageRequestModel;
import com.maintec.fincore.model.GetSignatureResponseModel;
import com.maintec.fincore.model.SaveSignatureRequestModel;

public interface FileService {
    boolean save(SaveSignatureRequestModel saveSignatureRequestModel);

    byte[] getContent(GetSignatureImageRequestModel getSignatureImageRequestModel);
}
