package com.maintec.fincore.controller;

import com.maintec.fincore.model.ReleaseCautionRequestModel;
import com.maintec.fincore.model.ReleaseCautionResponseModel;
import com.maintec.fincore.model.ResponseModel;
import com.maintec.fincore.model.SaveCautionRequestModel;
import com.maintec.fincore.model.SaveCautionResponseModel;
import com.maintec.fincore.model.SearchCautionResponseModel;
import com.maintec.fincore.service.CautionService;
import com.maintec.fincore.util.ResponseStatus;
import com.maintec.fincore.util.TokenUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.maintec.fincore.IDGenerationConstants.FAILURE;
import static com.maintec.fincore.IDGenerationConstants.SUCCESS;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@RestController
@RequestMapping({"/caution"})
@Tag(name = "Caution", description = "Caution API")
public class CautionController {
    private static final Logger log = LoggerFactory.getLogger(CautionController.class);
    @Autowired
    private CautionService cautionService;

    @GetMapping(value = "/ID/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "findByParentID", description = "Find all cautions against an ID", tags = {"Caution"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseModel findByParentID(@RequestHeader("token") String token, @PathVariable("id") String id) {
        ResponseModel responseModel = new ResponseModel();
        List<SearchCautionResponseModel> searchCautionResponseModels = this.cautionService.findByParentId(Long.parseLong(id));
        if (searchCautionResponseModels.size() == 1 && searchCautionResponseModels.get(0).getResponseStatus() != ResponseStatus.OK) {
            responseModel.setData(id);
            responseModel.setMessage(searchCautionResponseModels.get(0).getResponseStatus().getMessage());
            responseModel.setStatus(FAILURE);
            responseModel.setStatusCode(HttpStatus.EXPECTATION_FAILED.value());
        } else {
            responseModel.setData(searchCautionResponseModels);
            responseModel.setMessage("Total number of Caution(s) found is/are "+searchCautionResponseModels.size());
            responseModel.setStatus(SUCCESS);
            responseModel.setStatusCode(HttpStatus.OK.value());
        }
        return responseModel;
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "save", description = "Create a new Caution", tags = {"Caution"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseModel save(@RequestHeader("token") String token, @RequestBody SaveCautionRequestModel saveCautionRequestModel) {
        saveCautionRequestModel.setUserId(TokenUtils.getUserId(token));
        ResponseModel responseModel = new ResponseModel();
        SaveCautionResponseModel saveCautionResponseModel = cautionService.save(saveCautionRequestModel);
        if (saveCautionResponseModel.getResponseStatus() == ResponseStatus.OK) {
            responseModel.setData(saveCautionResponseModel);
            responseModel.setMessage("Caution saved successfully with id "+saveCautionResponseModel.getId());
            responseModel.setStatus(SUCCESS);
            responseModel.setStatusCode(HttpStatus.OK.value());
        } else {
            responseModel.setData(saveCautionRequestModel);
            responseModel.setMessage(saveCautionResponseModel.getResponseStatus().getMessage());
            responseModel.setStatus(FAILURE);
            responseModel.setStatusCode(HttpStatus.EXPECTATION_FAILED.value());
        }
        return responseModel;
    }

    @PostMapping(value = "/release", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "release", description = "Release an existing Caution", tags = {"Caution"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseModel release(@RequestHeader("token") String token, @RequestBody ReleaseCautionRequestModel releaseCautionRequestModel) {
        releaseCautionRequestModel.setUserId(TokenUtils.getUserId(token));
        ResponseModel responseModel = new ResponseModel();
        ReleaseCautionResponseModel releaseCautionResponseModel = cautionService.release(releaseCautionRequestModel);
        if (releaseCautionResponseModel.getResponseStatus() == ResponseStatus.OK) {
            responseModel.setData(releaseCautionResponseModel);
            responseModel.setMessage("Caution released successfully with id "+ releaseCautionResponseModel.getId());
            responseModel.setStatus(SUCCESS);
            responseModel.setStatusCode(HttpStatus.OK.value());
        } else {
            responseModel.setData(releaseCautionRequestModel);
            responseModel.setMessage(releaseCautionResponseModel.getResponseStatus().getMessage());
            responseModel.setStatus(FAILURE);
            responseModel.setStatusCode(HttpStatus.EXPECTATION_FAILED.value());
        }
        return responseModel;
    }
}
