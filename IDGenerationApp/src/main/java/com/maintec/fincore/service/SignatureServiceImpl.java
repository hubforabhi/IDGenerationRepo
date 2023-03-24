package com.maintec.fincore.service;

import com.maintec.fincore.entity.*;
import com.maintec.fincore.model.*;
import com.maintec.fincore.repository.IDRepository;
import com.maintec.fincore.repository.SignatureRepository;
import com.maintec.fincore.repository.UserRepository;
import com.maintec.fincore.util.ImageType;
import com.maintec.fincore.util.ResponseStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.maintec.fincore.IDGenerationConstants.BUSINESS_DATE_FORMATTER;

@Service
@Slf4j
public class SignatureServiceImpl implements SignatureService {

    private static final DateTimeFormatter SIGNATURE_FILE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyyHH-mm-ss-");

    private static final String SIGNATURE_FILE_DEFAULT_EXPIRY_DATE = LocalDate.of(9999, 12, 31).format(DateTimeFormatter.ISO_DATE);

    @Value("${signature.image.type}")
    private String[] allowedImageTypes;

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
        Optional<ID> idOptional = idRepository.findById(parentID);
        if (idOptional.isPresent()) {
            List<Images> images = signatureRepository.findByParentID(idOptional.get());
            if (images != null && !images.isEmpty()) {
                viewSignatureResponseModels = images.stream().map(findMapper).peek(viewSignatureResponseModel -> {
                    viewSignatureResponseModel.setSearchIdNo(String.valueOf(parentID));
                    viewSignatureResponseModel.setResponseStatus(ResponseStatus.OK);
                }).collect(Collectors.toList());
            } else {
                ViewSignatureResponseModel viewSignatureResponseModel = new ViewSignatureResponseModel();
                viewSignatureResponseModel.setResponseStatus(ResponseStatus.SIGNATURE_NOT_FOUND);
                viewSignatureResponseModels.add(viewSignatureResponseModel);
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
        if(Arrays.asList(allowedImageTypes).stream().anyMatch(
                type -> saveSignatureRequestModel.getTheFile().getContentType().contains(type))) {
            Optional<ID> idOptional = idRepository.findById(Long.parseLong(saveSignatureRequestModel.getParentID()));
            if (idOptional.isPresent()) {
                Optional<User> userOptional = userRepository.findById(Long.parseLong(saveSignatureRequestModel.getUserId()));
                if (userOptional.isPresent()) {
                    Images images = saveFromMapper.apply(saveSignatureRequestModel, idOptional.get());
                    saveSignatureRequestModel.setImageUrl(images.getImageURL());
                    if(fileService.save(saveSignatureRequestModel)) {
                        images.setEnteredBy(userOptional.get());
                        images = signatureRepository.save(images);
                        saveSignatureResponseModel.setId(images.getId());
                        saveSignatureResponseModel.setSearchIdNo(saveSignatureRequestModel.getParentID());
                        saveSignatureResponseModel.setType(images.getImageType());
                        saveSignatureResponseModel.setEnteredDate(BUSINESS_DATE_FORMATTER.format(images.getEnteredDate()));
                        saveSignatureResponseModel.setResponseStatus(ResponseStatus.OK);
                    } else {
                        saveSignatureResponseModel.setResponseStatus(ResponseStatus.NOT_ABLE_TO_SAVE_FILE_ON_LOCAL);
                    }
                } else {
                    saveSignatureResponseModel.setResponseStatus(ResponseStatus.USER_NOT_FOUND);
                }
            } else {
                saveSignatureResponseModel.setResponseStatus(ResponseStatus.PARENT_ID_NOT_FOUND);
            }
        } else {
            saveSignatureResponseModel.setResponseStatus(ResponseStatus.SIGNATURE_IMAGE_TYPE_NOT_SUPPORTED);
        }

        return saveSignatureResponseModel;
    }

    @Override
    public GetSignatureResponseModel getImage(GetSignatureImageRequestModel getSignatureImageRequestModel) {
        GetSignatureResponseModel getSignatureResponseModel = new GetSignatureResponseModel();
        getSignatureResponseModel.setId(getSignatureImageRequestModel.getId());
        Optional<Images> imagesOptional = signatureRepository.findImageUrlById(Long.parseLong(getSignatureImageRequestModel.getId()));
        if(imagesOptional.isPresent()) {
            getSignatureImageRequestModel.setImageURL(imagesOptional.get().getImageURL());
            getSignatureResponseModel.setType(imagesOptional.get().getImageType());
            getSignatureResponseModel.setExtension(
                    imagesOptional.get().getImageURL() != null ?
                            imagesOptional.get().getImageURL().substring(imagesOptional.get().getImageURL().lastIndexOf("-") + 1) : null);
            byte[] content = fileService.getContent(getSignatureImageRequestModel);
            if (content != null) {
                getSignatureResponseModel.setContent(content);
                getSignatureResponseModel.setResponseStatus(ResponseStatus.OK);
            } else {
                getSignatureResponseModel.setResponseStatus(ResponseStatus.SIGNATURE_NOT_FOUND);
            }
        } else {
            getSignatureResponseModel.setResponseStatus(ResponseStatus.SIGNATURE_NOT_FOUND);
        }
        return getSignatureResponseModel;
    }

    @Override
    public boolean delete(long id) {
        return signatureRepository.deleteById(id)> 0 ? true: false;
    }

    private final Function<Images, ViewSignatureResponseModel> findMapper = images -> {
        ViewSignatureResponseModel viewSignatureResponseModel = new ViewSignatureResponseModel();
        viewSignatureResponseModel.setType(images.getImageType());
        viewSignatureResponseModel.setId(String.valueOf(images.getId()));
        viewSignatureResponseModel.setEnteredDate(BUSINESS_DATE_FORMATTER.format(images.getEnteredDate()));
        return viewSignatureResponseModel;
    };
    private final BiFunction<SaveSignatureRequestModel, ID, Images> saveFromMapper = (saveSignatureRequestModel, id) -> {
        Images images = new Images();
        images.setTitle(saveSignatureRequestModel.getTitle());
        images.setImageURL(saveSignatureRequestModel.getImageUrl());
        //images.setTitle(saveSignatureRequestModel.getTheFile().getName());
        images.setImageType(ImageType.getValue(saveSignatureRequestModel.getType()));
        images.setEnteredDate(LocalDate.now());
        images.setExpiryDate(SIGNATURE_FILE_DEFAULT_EXPIRY_DATE);
        images.setParentID(id);
        images.setBranch(id.getBranch());
        String url = null;
        if(id.isPersonal()){
            Customer customer = id.getPersonalDetails();
            url = id.getId().toString()+"-"+customer.getCustomerName().getFirstName()+"-"+
                    LocalDateTime.now().format(SIGNATURE_FILE_PATTERN)+ saveSignatureRequestModel.getTheFile().getOriginalFilename().substring(
                    saveSignatureRequestModel.getTheFile().getOriginalFilename().lastIndexOf( "." ) ) ;
        } else{
            Company company = id.getCompanyDetails();
            url =id.getId().toString()+"-"+company.getFirmName()+"-"+
                    LocalDateTime.now().format(SIGNATURE_FILE_PATTERN)+"-"+ saveSignatureRequestModel.getTheFile().getOriginalFilename().substring(
                    saveSignatureRequestModel.getTheFile().getOriginalFilename().lastIndexOf( "." ) ) ;
        }
        url = url.replaceAll(" ","");
        images.setImageURL(url);
        return images;
    };
}
