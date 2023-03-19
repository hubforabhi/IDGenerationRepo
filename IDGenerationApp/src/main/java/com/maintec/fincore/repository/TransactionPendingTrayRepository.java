package com.maintec.fincore.repository;

import com.maintec.fincore.entity.TransactionPendingTray;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionPendingTrayRepository extends JpaRepository<TransactionPendingTray, Long> {
   List<TransactionPendingTray> findByBranchId(Long branchId);
}
