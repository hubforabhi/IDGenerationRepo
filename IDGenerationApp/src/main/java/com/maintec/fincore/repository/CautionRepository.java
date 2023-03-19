package com.maintec.fincore.repository;

import com.maintec.fincore.entity.Caution;
import com.maintec.fincore.entity.ID;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CautionRepository extends JpaRepository<Caution, Long> {
   @Query("from Caution as caution where caution.parentID =:parentID and caution.releaseDate is null and caution.transactionProcess.txnApproved = true")
   List<Caution> findAllByParenId(@Param("parentID") ID parentId);
}
