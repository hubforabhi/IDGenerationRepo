package com.maintec.fincore.controller;

import com.maintec.fincore.model.*;
import com.maintec.fincore.service.SignatureService;
import com.maintec.fincore.util.ResponseStatus;
import com.maintec.fincore.util.TokenUtils;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.maintec.fincore.IDGenerationConstants.FAILURE;
import static com.maintec.fincore.IDGenerationConstants.SUCCESS;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@RestController
@RequestMapping({"/signature"})
@Tag(name = "Signature", description = "Signature API")
public class SignatureController {

    private static final Logger log = LoggerFactory.getLogger(SignatureController.class);

    @Autowired
    private SignatureService signatureService;

    @GetMapping(value = "/ID/{searchIdNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "findBySearchIdNo", description = "Show", tags = {"Signature"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseModel findBySearchIdNo(@RequestHeader("token") String token, @PathVariable("searchIdNo") String searchIdNo) {
        ResponseModel responseModel = new ResponseModel();
        List<ViewSignatureResponseModel> viewSignatureResponseModels = signatureService.findByParentID(Long.parseLong(searchIdNo));
        if (!viewSignatureResponseModels.isEmpty()) {
            responseModel.setData(viewSignatureResponseModels);
            responseModel.setMessage(viewSignatureResponseModels.size() + " Found Successfully");
            responseModel.setStatus(SUCCESS);
            responseModel.setStatusCode(HttpStatus.OK.value());
        } else {
            responseModel.setData(searchIdNo);
            responseModel.setStatus(FAILURE);
            responseModel.setMessage("No Image Found");
            responseModel.setStatusCode(HttpStatus.OK.value());
        }

        return responseModel;
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "save", description = "Create New Signature", tags = {"Signature"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseModel save(@RequestHeader("token") String token, @RequestParam("searchIdNo") String searchIdNo,
                              @RequestParam("name") String name, @RequestParam("type") String type, @RequestParam("file") MultipartFile file) {
        ResponseModel responseModel = new ResponseModel();
        SaveSignatureRequestModel saveSignatureRequestModel = new SaveSignatureRequestModel();
        saveSignatureRequestModel.setUserId(TokenUtils.getUserId(token));
        saveSignatureRequestModel.setSearchIdNo(searchIdNo);
        saveSignatureRequestModel.setType(type);
        saveSignatureRequestModel.setName(name);
        saveSignatureRequestModel.setTheFile(file);
        SaveSignatureResponseModel saveSignatureResponseModel = signatureService.save(saveSignatureRequestModel);
        if (saveSignatureResponseModel.getResponseStatus() == ResponseStatus.OK) {
            responseModel.setData(saveSignatureResponseModel);
            responseModel.setStatus(SUCCESS);
            responseModel.setMessage(file.getName() + " Saved Successfully");
            responseModel.setStatusCode(HttpStatus.OK.value());
        } else {
            responseModel.setStatus(FAILURE);
            responseModel.setMessage("Image can't be saved, Please try after some time.");
            responseModel.setStatusCode(HttpStatus.OK.value());
        }
        return responseModel;
    }

    @GetMapping(value = "/content/{id}")
    @Operation(summary = "Get Signature Image", description = "Get Image Details", tags = {"Signature"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseModel getSignatureImage(@RequestHeader("token") String token, @RequestParam("id") String id) {
        ResponseModel responseModel = new ResponseModel();
        GetSignatureImageRequestModel getSignatureImageRequestModel = new GetSignatureImageRequestModel();
        getSignatureImageRequestModel.setUserId(TokenUtils.getUserId(token));
        getSignatureImageRequestModel.setId(id);

        GetSignatureResponseModel getSignatureResponseModel = signatureService.getImage(getSignatureImageRequestModel);
        if (getSignatureResponseModel.getResponseStatus() == ResponseStatus.OK) {
            responseModel.setData(getSignatureResponseModel);
            responseModel.setStatus(SUCCESS);
            responseModel.setMessage(id +" Found Successfully");
            responseModel.setStatusCode(HttpStatus.OK.value());
        } else {
            responseModel.setStatus(FAILURE);
            responseModel.setMessage(id + " Not Found");
            responseModel.setStatusCode(HttpStatus.OK.value());
        }
        return responseModel;
    }

    @PostMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "delete", description = "Expire an existing signature", tags = {"Signature"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseModel delete(@RequestHeader("token") String token, @RequestParam("id") long id) {
        ResponseModel responseModel = new ResponseModel();
        if (signatureService.delete(id)) {
            responseModel.setData(id);
            responseModel.setStatus(SUCCESS);
            responseModel.setMessage(id + " Deleted Successfully");
            responseModel.setStatusCode(HttpStatus.OK.value());
        } else {
            responseModel.setData(id);
            responseModel.setStatus(FAILURE);
            responseModel.setMessage("Image can't be deleted, Please try after some time.");
            responseModel.setStatusCode(HttpStatus.OK.value());
        }

        return responseModel;
    }
}
