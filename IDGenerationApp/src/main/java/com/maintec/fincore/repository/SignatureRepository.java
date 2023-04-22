package com.maintec.fincore.repository;

import com.maintec.fincore.entity.ID;
import com.maintec.fincore.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SignatureRepository extends JpaRepository<Images, Long> {
   List<Images> findByParentID(ID parentId);

   Optional<Images> findImageUrlById(long id);

   Long deleteById(long id);
}
