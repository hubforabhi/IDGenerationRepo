package com.maintec.fincore.service;

import com.maintec.fincore.entity.Caution;
import com.maintec.fincore.entity.ID;
import com.maintec.fincore.entity.TransactionPendingTray;
import com.maintec.fincore.entity.TransactionProcess;
import com.maintec.fincore.entity.User;
import com.maintec.fincore.model.ReleaseCautionRequestModel;
import com.maintec.fincore.model.ReleaseCautionResponseModel;
import com.maintec.fincore.model.SaveCautionRequestModel;
import com.maintec.fincore.model.SaveCautionResponseModel;
import com.maintec.fincore.model.SearchCautionResponseModel;
import com.maintec.fincore.repository.CautionRepository;
import com.maintec.fincore.repository.IDRepository;
import com.maintec.fincore.repository.UserRepository;
import com.maintec.fincore.system.constants.ProcessCodes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.maintec.fincore.util.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CautionServiceImpl implements CautionService {

    private static final String SAVE_CAUTION_ACTION = "caution";

    private static final String RELEASE_CAUTION_ACTION = "caution";

    @Autowired
    private IDRepository idRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CautionRepository cautionRepository;

    @Override
    public List<SearchCautionResponseModel> findByParentId(long id) {
        List<SearchCautionResponseModel> searchCautionResponseModels = new ArrayList<>();
        Optional<ID> idOptional = idRepository.findById(id);
        if (idOptional.isPresent()) {
            List<Caution> cautions = cautionRepository.findAllByParenId((ID) idOptional.get());
            if (cautions != null && !cautions.isEmpty()) {
                searchCautionResponseModels = (List) cautions.stream().map(findMapper).collect(Collectors.toList());
                searchCautionResponseModels.get(0).setResponseStatus(ResponseStatus.OK);
            } else {
                SearchCautionResponseModel searchCautionResponseModel = new SearchCautionResponseModel();
                searchCautionResponseModel.setResponseStatus(ResponseStatus.CAUTION_NOT_FOUND);
                searchCautionResponseModels.add(searchCautionResponseModel);
            }
        } else {
            SearchCautionResponseModel searchCautionResponseModel = new SearchCautionResponseModel();
            searchCautionResponseModel.setResponseStatus(ResponseStatus.PARENT_ID_NOT_FOUND);
            searchCautionResponseModels.add(searchCautionResponseModel);
        }

        return searchCautionResponseModels;
    }

    @Override
    public SaveCautionResponseModel save(SaveCautionRequestModel saveCautionRequestModel) {
        SaveCautionResponseModel saveCautionResponseModel = new SaveCautionResponseModel();
        saveCautionResponseModel.setParentId(saveCautionRequestModel.getParentId());
        saveCautionResponseModel.setDescription(saveCautionRequestModel.getDescription());

        Optional<ID> parentIDOptional = idRepository.findById(Long.parseLong(saveCautionRequestModel.getParentId()));
        if(parentIDOptional.isPresent()) {
            Optional<User> userOptional = userRepository.findById(Long.parseLong(saveCautionRequestModel.getUserId()));
            if(userOptional.isPresent()) {
                Caution caution = from(saveCautionRequestModel, (ID) parentIDOptional.get(), (User) userOptional.get());
                if (isApprovalRequired("caution", caution.getTransactionProcess().isExceptional())) {
                    caution.setPendingTray(
                            createPendingTray(
                                    (User) userOptional.get(), caution.getPendingTray(), null, caution.getClass().getName(),
                                    false, null, false, false, "Caution Entry",
                                    caution.getId().toString()));
                } else {
                    caution.getTransactionProcess().setTxnApproved(true);
                }
                commitTXN((User) userOptional.get(), caution.getEnteredBy(), caution.getPendingTray(), caution.getTransactionProcess());
                cautionRepository.save(caution);
                saveCautionResponseModel.setId(String.valueOf(caution.getId()));
                saveCautionResponseModel.setResponseStatus(ResponseStatus.OK);
            } else {
                saveCautionResponseModel.setResponseStatus(ResponseStatus.USER_NOT_FOUND);
            }
        } else {
            saveCautionResponseModel.setResponseStatus(ResponseStatus.PARENT_ID_NOT_FOUND);
        }
        return saveCautionResponseModel;
    }

    @Override
    public ReleaseCautionResponseModel release(ReleaseCautionRequestModel releaseCautionRequestModel) {
        ReleaseCautionResponseModel releaseCautionResponseModel = new ReleaseCautionResponseModel();
        releaseCautionResponseModel.setId(releaseCautionRequestModel.getId());
        releaseCautionResponseModel.setReleaseReason(releaseCautionRequestModel.getReleaseReason());

        Optional<Caution> cautionOptional = cautionRepository.findById(Long.parseLong(releaseCautionRequestModel.getId()));
        if (cautionOptional.isPresent()) {
            Optional<User> userOptional = userRepository.findById(Long.parseLong(releaseCautionRequestModel.getUserId()));
            if(userOptional.isPresent()) {
                Caution caution = (Caution) cautionOptional.get();
                if (caution.getTransactionProcess().isTxnApproved()
                        || !caution.getTransactionProcess().isTxnApproved() && caution.getTransactionProcess().getDeniedDate() != null) {
                    caution.setReleaseDate(LocalDate.now());
                    caution.setReleaseReson("Release Reason-" + releaseCautionRequestModel.getReleaseReason());
                    caution.setTransactionProcess(this.createTXNProcess(new TransactionProcess(), ProcessCodes.ID_CAUTION.getCashTXNCode(), false, null));
                    if (this.isApprovalRequired("caution", caution.getTransactionProcess().isExceptional())) {
                        caution.setPendingTray(
                                this.createPendingTray(
                                        (User) userOptional.get(), caution.getPendingTray(), null, caution.getClass().getName(), false,
                                        null, false, false, "Caution Entry", caution.getId().toString()));
                    } else {
                        caution.getTransactionProcess().setTxnApproved(true);
                    }
                    cautionRepository.saveAndFlush(caution);
                    releaseCautionResponseModel.setResponseStatus(ResponseStatus.OK);
                } else {
                    releaseCautionResponseModel.setResponseStatus(ResponseStatus.USER_NOT_FOUND);
                }
            }
        } else {
            releaseCautionResponseModel.setResponseStatus(ResponseStatus.CAUTION_NOT_FOUND);
        }
        return releaseCautionResponseModel;
    }

    private Function<Caution, SearchCautionResponseModel> findMapper = caution -> {
        SearchCautionResponseModel searchCautionResponseModel = new SearchCautionResponseModel();
        searchCautionResponseModel.setId(caution.getId());
        searchCautionResponseModel.setDescription(caution.getCautionDesc());
        searchCautionResponseModel.setReleaseReason(caution.getReleaseReson());
        return searchCautionResponseModel;
    };

    private Caution from(SaveCautionRequestModel saveCautionRequestModel, ID id, User user) {
        Caution caution = new Caution();
        caution.setCautionDesc(saveCautionRequestModel.getDescription());
        caution.setParentID(id);
        caution.setEnteredBy(user);
        caution.setEnteredDate(LocalDate.now());
        caution.setTransactionProcess(this.createTXNProcess(id.getTransactionProcess(), ProcessCodes.ID_CAUTION.getCashTXNCode(), false, null));
        return caution;
    }

    private TransactionProcess createTXNProcess(TransactionProcess txnProcess, String processCode, boolean isExceptional, String entryExceptionalReason) {
        if (txnProcess == null) {
            txnProcess = new TransactionProcess();
        }

        txnProcess.setTxnSource(processCode);
        txnProcess.setFirstApprovedBy(null);
        txnProcess.setSecondApprovedBy(null);
        txnProcess.setDeniedBy(null);
        txnProcess.setFirstApprovedDate(null);
        txnProcess.setSecondApprovedDate(null);
        txnProcess.setDeniedDate(null);
        txnProcess.setFirstApproveExceptionalReason(null);
        txnProcess.setSecondApproveExceptionalReason(null);
        txnProcess.setDeniedReason(null);
        txnProcess.setApprovalReason("Waiting For Ist Approval");
        txnProcess.setExceptional(isExceptional);
        txnProcess.setTxnApproved(false);
        txnProcess.setTransactionStatus(0);
        return txnProcess;
    }

    private TransactionPendingTray createPendingTray(User user, TransactionPendingTray txnPendingTray, String url, String tableClassName,
            boolean isExceptional, String reason, boolean isCommitted, boolean isMasterTx, String processDescription, String refNo) {
        if (txnPendingTray == null || txnPendingTray.getStatus() == 0 && txnPendingTray.isCommitted()) {
            txnPendingTray = new TransactionPendingTray();
            txnPendingTray.setLinkURL(url);
            txnPendingTray.setProcessDescription(processDescription);
            txnPendingTray.setExpired(false);
            txnPendingTray.setExceptional(isExceptional);
            if (isExceptional) {
                txnPendingTray.setReason(reason);
            }

            txnPendingTray.setEnteredBy(user);
            txnPendingTray.setEnteredDate(LocalDate.now());
            txnPendingTray.setTableClassName(tableClassName);
            txnPendingTray.setBranch(user.getBranch());
            txnPendingTray.setMaster(isMasterTx);
            txnPendingTray.setRefNumber(refNo);
            txnPendingTray.setReason("Waiting For Approval");
            txnPendingTray.setStatus(0);
            txnPendingTray.setCommitted(isCommitted);
        }

        return txnPendingTray;
    }

    private void commitTXN(User user, User enteredBy, TransactionPendingTray ptray, TransactionProcess process) {
        if (!user.equals(enteredBy)) {
            throw new RuntimeException("messages.no_right_to_commit");
        } else {
            if (ptray != null && !ptray.isCommitted()) {
                ptray.setCommitted(true);
                ptray.setStatus(1);
                process.setTransactionStatus(1);
            } else if (ptray == null) {
                process.setTransactionStatus(0);
                process.setTxnApproved(true);
            }
        }
    }

    private boolean isApprovalRequired(String action, boolean isExceptional) {
        boolean approval = false;
        if (isExceptional) {
            approval = true;
        }
        return approval;
    }
}
