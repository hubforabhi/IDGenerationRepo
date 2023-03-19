package com.maintec.fincore.service;

import com.maintec.fincore.entity.ID;
import com.maintec.fincore.entity.Images;
import com.maintec.fincore.model.SaveSignatureRequestModel;
import com.maintec.fincore.model.SaveSignatureResponseModel;
import com.maintec.fincore.model.ViewSignatureResponseModel;
import com.maintec.fincore.repository.IDRepository;
import com.maintec.fincore.repository.SignatureRepository;
import com.maintec.fincore.util.ImageType;
import com.maintec.fincore.util.ResponseStatus;
import com.maintec.fincore.util.Util;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class SignatureServiceImpl implements SignatureService {
   private static final Logger log = LoggerFactory.getLogger(SignatureServiceImpl.class);
   @Autowired
   private IDRepository idRepository;
   @Autowired
   private SignatureRepository signatureRepository;
   @Autowired
   private FileService fileService;
   private Function<Images, ViewSignatureResponseModel> findMapper = images -> {
      ViewSignatureResponseModel viewSignatureResponseModel = new ViewSignatureResponseModel();
      viewSignatureResponseModel.setName(images.getTitle());
      viewSignatureResponseModel.setType(images.getImageType());
      viewSignatureResponseModel.setTitle(images.getTitle());
      return viewSignatureResponseModel;
   };
   private Function<SaveSignatureRequestModel, Images> saveFromMapper = saveSignatureRequestModel -> {
      Images images = new Images();
      images.setTitle(saveSignatureRequestModel.getTitle());
      images.setImageURL(saveSignatureRequestModel.getImageUrl());
      images.setTitle(saveSignatureRequestModel.getTheFile().getName());
      images.setImageType(ImageType.getValue(saveSignatureRequestModel.getType()));
      images.setEnteredDate(LocalDate.now());
      images.setExpiryDate(LocalDate.of(9999, 12, 31).format(DateTimeFormatter.ISO_DATE));
      images.setEnteredBy(Util.getDefaultUser());
      images.setParentID(Util.getDefaultParentID());
      images.setBranch(Util.getDefaultBranch());
      images.setImageURL(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyyHH-mm-ss-")) + ".jpg");
      return images;
   };

   @Override
   public List<ViewSignatureResponseModel> findByParentID(long parentID) {
      List<ViewSignatureResponseModel> viewSignatureResponseModels = Collections.EMPTY_LIST;
      Optional<ID> idOptional = this.idRepository.findById(parentID);
      if (idOptional.isPresent()) {
         List<Images> images = this.signatureRepository.findByParentID((ID)idOptional.get());
         if (images != null && !images.isEmpty()) {
            viewSignatureResponseModels = (List)images.stream().map(this.findMapper).map(viewSignatureResponseModel -> {
               viewSignatureResponseModel.setSearchIdNo(String.valueOf(parentID));
               return viewSignatureResponseModel;
            }).collect(Collectors.toList());
         }
      }

      return viewSignatureResponseModels;
   }

   @Override
   public SaveSignatureResponseModel save(SaveSignatureRequestModel saveSignatureRequestModel) {
      SaveSignatureResponseModel saveSignatureResponseModel = new SaveSignatureResponseModel();
      Images images = (Images)this.signatureRepository.save((Images)this.saveFromMapper.apply(saveSignatureRequestModel));
      saveSignatureResponseModel.setId(images.getId());
      saveSignatureResponseModel.setSearchIdNo(saveSignatureRequestModel.getSearchIdNo());
      saveSignatureResponseModel.setTitle(images.getTitle());
      saveSignatureResponseModel.setType(images.getImageType());
      saveSignatureResponseModel.setResponseStatus(ResponseStatus.OK);
      return saveSignatureResponseModel;
   }

   @Override
   public boolean delete(long id) {
      this.signatureRepository.deleteById(id);
      return true;
   }
}
