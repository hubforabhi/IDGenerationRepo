package com.maintec.fincore.controller;

import com.maintec.fincore.model.*;
import com.maintec.fincore.service.IDGenerationService;
import com.maintec.fincore.util.TokenUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.maintec.fincore.IDGenerationConstants.FAILURE;
import static com.maintec.fincore.IDGenerationConstants.SUCCESS;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@RestController
@RequestMapping({"/id"})
@Tag(name = "IDGeneration", description = "ID Generation API")
@Slf4j
public class IDGenerationController {
   @Autowired
   private IDGenerationService idGenerationService;

   @PostMapping(value = "/company/save", produces = MediaType.APPLICATION_JSON_VALUE)
   @Operation(summary = "Company ID Generation", description = "Saves Company Details and Generates ID", tags = {"IDGeneration"})
   @ApiResponses({
           @ApiResponse(responseCode = "200", description = "successful operation",
                   content = @Content(schema = @Schema(implementation = ResponseModel.class))),
           @ApiResponse(responseCode = "400", description = "Invalid input")
   })
   public ResponseModel save(@RequestHeader("token") String token, @RequestBody CompanyIDGenerationRequestModel companyIDGenerationRequestModel) {
      ResponseModel responseModel = new ResponseModel();
      companyIDGenerationRequestModel.setUserId(TokenUtils.getUserId(token));
      CompanyIDGenerationResponseModel companyIDGenerationResponseModel = this.idGenerationService.save(companyIDGenerationRequestModel);
      if (companyIDGenerationResponseModel != null) {
         responseModel.setData(companyIDGenerationResponseModel);
         responseModel.setStatus(SUCCESS);
         responseModel.setMessage("Company information has Successfully Saved, ID : " + companyIDGenerationResponseModel.getId() +
                  " ,Firm Name : "+ companyIDGenerationRequestModel.getFirmName() + " ,Pending for Approval");
         responseModel.setStatusCode(HttpStatus.OK.value());
      } else {
         responseModel.setData(companyIDGenerationRequestModel);
         responseModel.setStatus(FAILURE);
         responseModel.setMessage("Please try after some time");
         responseModel.setStatusCode(HttpStatus.EXPECTATION_FAILED.value());
      }

      return responseModel;
   }

   @PostMapping(value = "/personal/save", produces = MediaType.APPLICATION_JSON_VALUE)
   @Operation(summary = "Personal ID Generation", description = "Saves Personal Details and Generates ID", tags = {"IDGeneration"})
   @ApiResponses({
           @ApiResponse(responseCode = "200", description = "successful operation",
                   content = @Content(schema = @Schema(implementation = ResponseModel.class))),
           @ApiResponse(responseCode = "400", description = "Invalid input")
   })
   public ResponseModel save(@RequestHeader("token") String token, @RequestBody PersonalIDGenerationRequestModel personalIDGenerationRequestModel) {
      ResponseModel responseModel = new ResponseModel();
      personalIDGenerationRequestModel.setUserId(TokenUtils.getUserId(token));
      PersonalIDGenerationResponseModel personalIDGenerationResponseModel = this.idGenerationService.save(personalIDGenerationRequestModel);
      if(personalIDGenerationResponseModel != null) {
         responseModel.setData(personalIDGenerationResponseModel);
         responseModel.setStatus(SUCCESS);
         responseModel.setMessage("Personal information has Successfully Saved, ID : " + personalIDGenerationResponseModel.getId() +
                 " ,Customer : "+ personalIDGenerationRequestModel.getCustomerFName() + " ,Pending for Approval");
         responseModel.setStatusCode(HttpStatus.OK.value());
      } else {
         responseModel.setData(personalIDGenerationRequestModel);
         responseModel.setStatus(FAILURE);
         responseModel.setMessage("Please try after some time");
         responseModel.setStatusCode(HttpStatus.EXPECTATION_FAILED.value());
      }

      return responseModel;
   }
}
