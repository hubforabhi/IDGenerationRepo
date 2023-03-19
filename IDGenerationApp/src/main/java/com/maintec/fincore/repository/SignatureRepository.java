package com.maintec.fincore.repository;

import com.maintec.fincore.entity.ID;
import com.maintec.fincore.entity.Images;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignatureRepository extends JpaRepository<Images, Long> {
   List<Images> findByParentID(ID parentId);
}
