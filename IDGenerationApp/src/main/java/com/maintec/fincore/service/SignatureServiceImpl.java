package com.maintec.fincore.service;

import com.maintec.fincore.entity.ID;
import com.maintec.fincore.entity.Images;
import com.maintec.fincore.entity.User;
import com.maintec.fincore.model.SaveSignatureRequestModel;
import com.maintec.fincore.model.SaveSignatureResponseModel;
import com.maintec.fincore.model.ViewSignatureResponseModel;
import com.maintec.fincore.repository.IDRepository;
import com.maintec.fincore.repository.SignatureRepository;
import com.maintec.fincore.repository.UserRepository;
import com.maintec.fincore.util.ImageType;
import com.maintec.fincore.util.ResponseStatus;
import com.maintec.fincore.util.Util;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignatureServiceImpl implements SignatureService {
   private static final Logger log = LoggerFactory.getLogger(SignatureServiceImpl.class);

   private static final DateTimeFormatter SIGNATURE_FILE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyyHH-mm-ss-");

   private static final String SIGNATURE_FILE_DEFAULT_EXPIRY_DATE = LocalDate.of(9999, 12, 31).format(DateTimeFormatter.ISO_DATE);

   @Autowired
   private IDRepository idRepository;
   @Autowired
   private SignatureRepository signatureRepository;

   @Autowired
   private FileService fileService;

   @Autowired
   private UserRepository userRepository;

   @Override
   public List<ViewSignatureResponseModel> findByParentID(long parentID) {
      List<ViewSignatureResponseModel> viewSignatureResponseModels = new ArrayList<>();
      Optional<ID> idOptional = this.idRepository.findById(parentID);
      if (idOptional.isPresent()) {
         List<Images> images = this.signatureRepository.findByParentID(idOptional.get());
         if (images != null && !images.isEmpty()) {
            viewSignatureResponseModels = images.stream().map(findMapper).peek(viewSignatureResponseModel -> {
               viewSignatureResponseModel.setSearchIdNo(String.valueOf(parentID));
            }).collect(Collectors.toList());
         }
      } else {
          ViewSignatureResponseModel viewSignatureResponseModel = new ViewSignatureResponseModel();
          viewSignatureResponseModel.setResponseStatus(ResponseStatus.PARENT_ID_NOT_FOUND);
          viewSignatureResponseModels.add(viewSignatureResponseModel);
      }
      return viewSignatureResponseModels;
   }

   @Override
   public SaveSignatureResponseModel save(SaveSignatureRequestModel saveSignatureRequestModel) {
        SaveSignatureResponseModel saveSignatureResponseModel = new SaveSignatureResponseModel();
        Optional<ID> idOptional = this.idRepository.findById(Long.parseLong(saveSignatureRequestModel.getSearchIdNo()));
        if (idOptional.isPresent()) {
            Optional<User> userOptional = userRepository.findById(Long.parseLong(saveSignatureRequestModel.getUserId()));
            if(userOptional.isPresent()) {
                Images images = saveFromMapper.apply(saveSignatureRequestModel, idOptional.get());
                images.setEnteredBy(userOptional.get());
                images = signatureRepository.save(images);
                saveSignatureResponseModel.setId(images.getId());
                saveSignatureResponseModel.setSearchIdNo(saveSignatureRequestModel.getSearchIdNo());
                saveSignatureResponseModel.setTitle(images.getTitle());
                saveSignatureResponseModel.setType(images.getImageType());
                saveSignatureResponseModel.setResponseStatus(ResponseStatus.OK);
            } else {
                saveSignatureResponseModel.setResponseStatus(ResponseStatus.USER_NOT_FOUND);
            }
        } else {
            saveSignatureResponseModel.setResponseStatus(ResponseStatus.PARENT_ID_NOT_FOUND);
        }
        return saveSignatureResponseModel;
   }

   @Override
   public boolean delete(long id) {
      this.signatureRepository.deleteById(id);
      return true;
   }

    private final Function<Images, ViewSignatureResponseModel> findMapper = images -> {
        ViewSignatureResponseModel viewSignatureResponseModel = new ViewSignatureResponseModel();
        viewSignatureResponseModel.setName(images.getTitle());
        viewSignatureResponseModel.setType(images.getImageType());
        viewSignatureResponseModel.setTitle(images.getTitle());
        return viewSignatureResponseModel;
    };
    private final BiFunction<SaveSignatureRequestModel, ID, Images> saveFromMapper = (saveSignatureRequestModel, id)-> {
        Images images = new Images();
        images.setTitle(saveSignatureRequestModel.getTitle());
        images.setImageURL(saveSignatureRequestModel.getImageUrl());
        images.setTitle(saveSignatureRequestModel.getTheFile().getName());
        images.setImageType(ImageType.getValue(saveSignatureRequestModel.getType()));
        images.setEnteredDate(LocalDate.now());
        images.setExpiryDate(SIGNATURE_FILE_DEFAULT_EXPIRY_DATE);
        images.setParentID(id);
        images.setBranch(id.getBranch());
        images.setImageURL(LocalDateTime.now().format(SIGNATURE_FILE_PATTERN) + ".jpg");
        return images;
    };
}
