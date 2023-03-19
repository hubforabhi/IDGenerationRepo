package com.maintec.fincore.service;

import com.maintec.fincore.model.ApprovalRequestModel;
import com.maintec.fincore.model.ApprovalResponseModel;
import com.maintec.fincore.model.FindPendingListResponseModel;
import java.util.List;

public interface ApprovalService {
   List<FindPendingListResponseModel> findPendingItems(String userId);

   ApprovalResponseModel firstApprove(ApprovalRequestModel approvalRequestModel);

   ApprovalResponseModel secondApprove(ApprovalRequestModel approvalRequestModel);
}
