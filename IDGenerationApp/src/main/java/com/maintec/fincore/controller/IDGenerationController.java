package com.maintec.fincore.controller;

import com.maintec.fincore.model.CompanyIDGenerationRequestModel;
import com.maintec.fincore.model.CompanyIDGenerationResponseModel;
import com.maintec.fincore.model.ResponseModel;
import com.maintec.fincore.service.IDGenerationService;
import com.maintec.fincore.util.TokenUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(
   origins = {"http://localhost:8080", "http://localhost"}
)
@RestController
@RequestMapping({"/id"})
@Tag(
   name = "Approval",
   description = "Approval API"
)
public class IDGenerationController {
   private static final Logger log = LoggerFactory.getLogger(IDGenerationController.class);
   @Autowired
   private IDGenerationService idGenerationService;

   @PostMapping(
      value = {"/company/save"},
      produces = {"application/json"}
   )
   @Operation(
      summary = "firstApprove",
      description = "Show ",
      tags = {"Approval"}
   )
   @ApiResponses({@ApiResponse(
   responseCode = "200",
   description = "Successful Operation",
   content = {@Content(
   schema = @Schema(
   implementation = ResponseModel.class
)
)}
), @ApiResponse(
   responseCode = "204",
   description = "No Data Found",
   content = {@Content(
   schema = @Schema(
   implementation = Void.class
)
)}
)})
   public ResponseModel companySave(@RequestHeader("token") String token, @RequestBody CompanyIDGenerationRequestModel companyIDGenerationRequestModel) {
      String userId = TokenUtils.getUserId(token);
      ResponseModel responseModel = new ResponseModel();
      CompanyIDGenerationResponseModel companyIDGenerationResponseModel = this.idGenerationService.companySave(companyIDGenerationRequestModel);
      if (companyIDGenerationResponseModel != null) {
         responseModel.setData(companyIDGenerationResponseModel);
         responseModel.setStatus("SUCCESS");
         responseModel.setStatusCode(HttpStatus.OK.value());
      } else {
         responseModel.setStatus("FAILURE");
         responseModel.setMessage("No Pending Item Found");
         responseModel.setStatusCode(HttpStatus.OK.value());
      }

      return responseModel;
   }
}
