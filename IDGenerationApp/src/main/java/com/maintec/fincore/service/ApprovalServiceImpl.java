package com.maintec.fincore.service;

import com.maintec.fincore.entity.Branch;
import com.maintec.fincore.entity.TransactionPendingTray;
import com.maintec.fincore.entity.User;
import com.maintec.fincore.model.ApprovalRequestModel;
import com.maintec.fincore.model.ApprovalResponseModel;
import com.maintec.fincore.model.FindPendingListResponseModel;
import com.maintec.fincore.repository.TransactionPendingTrayRepository;
import com.maintec.fincore.repository.UserRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovalServiceImpl implements ApprovalService {
   private static final Logger log = LoggerFactory.getLogger(ApprovalServiceImpl.class);
   private static final String DECISION_APPROVED = "1";
   @Autowired
   private TransactionPendingTrayRepository transactionPendingTrayRepository;
   @Autowired
   private UserRepository userRepository;
   private Function<TransactionPendingTray, FindPendingListResponseModel> findPendingItemsMapper = tray -> {
      FindPendingListResponseModel findPendingListResponseModel = new FindPendingListResponseModel();
      findPendingListResponseModel.setDescription(tray.getProcessDescription());
      return findPendingListResponseModel;
   };

   @Override
   public List<FindPendingListResponseModel> findPendingItems(String userId) {
      List<FindPendingListResponseModel> findPendingListResponseModels = Collections.EMPTY_LIST;
      Optional<User> userOptional = this.userRepository.findById(Long.parseLong(userId));
      if (userOptional.isPresent()) {
         Branch branch = ((User)userOptional.get()).getBranch();
         List<TransactionPendingTray> transactionPendingTrays = this.transactionPendingTrayRepository.findByBranchId(branch.getId());
         if (transactionPendingTrays != null && !transactionPendingTrays.isEmpty()) {
            transactionPendingTrays.stream().map(this.findPendingItemsMapper).collect(Collectors.toList());
         }
      }

      return findPendingListResponseModels;
   }

   @Override
   public ApprovalResponseModel firstApprove(ApprovalRequestModel approvalRequestModel) {
      ApprovalResponseModel approvalResponseModel = new ApprovalResponseModel();
      if ("1".equals(approvalRequestModel.getDecision())) {
      }

      return approvalResponseModel;
   }

   @Override
   public ApprovalResponseModel secondApprove(ApprovalRequestModel approvalRequestModel) {
      return new ApprovalResponseModel();
   }
}
