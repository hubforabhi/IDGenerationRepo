package com.maintec.fincore.controller;

import com.maintec.fincore.model.ReleaseCautionRequestModel;
import com.maintec.fincore.model.ReleaseCautionResponseModel;
import com.maintec.fincore.model.ResponseModel;
import com.maintec.fincore.model.SaveCautionRequestModel;
import com.maintec.fincore.model.SaveCautionResponseModel;
import com.maintec.fincore.model.SearchCautionResponseModel;
import com.maintec.fincore.service.CautionService;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(
   origins = {"http://localhost:4200", "http://localhost"}
)
@RestController
@RequestMapping({"/caution"})
@Tag(
   name = "Caution",
   description = "Caution API"
)
public class CautionController {
   private static final Logger log = LoggerFactory.getLogger(CautionController.class);
   @Autowired
   private CautionService cautionService;

   @GetMapping(
      value = {"/findById/{id}"},
      produces = {"application/json"}
   )
   @Operation(
      summary = "findById",
      description = "find Details by ID no ",
      tags = {"Caution"}
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
   public ResponseModel findById(@RequestHeader("token") String token, @PathVariable("id") String id) {
      ResponseModel responseModel = new ResponseModel();
      List<SearchCautionResponseModel> searchCautionResponseModels = this.cautionService.findByParentId(Long.parseLong(id));
      if (searchCautionResponseModels != null && !searchCautionResponseModels.isEmpty()) {
         responseModel.setData(searchCautionResponseModels);
         responseModel.setMessage(id + " found successfully");
         responseModel.setStatus("SUCCESS");
      } else {
         responseModel.setData(id);
         responseModel.setMessage(id + " not found");
         responseModel.setStatus("FAILURE");
      }

      responseModel.setStatusCode(HttpStatus.OK.value());
      return responseModel;
   }

   @PostMapping(
      value = {"/save"},
      produces = {"application/json"}
   )
   @Operation(
      summary = "save",
      description = "Save Caution Details",
      tags = {"Caution"}
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
   public ResponseModel save(@RequestHeader("token") String token, @RequestBody SaveCautionRequestModel saveCautionRequestModel) {
      saveCautionRequestModel.setUserId(TokenUtils.getUserId(token));
      ResponseModel responseModel = new ResponseModel();
      SaveCautionResponseModel saveCautionResponseModel = this.cautionService.save(saveCautionRequestModel);
      if (saveCautionResponseModel != null) {
         responseModel.setData(saveCautionResponseModel);
         responseModel.setMessage("Saved successfully");
         responseModel.setStatus("SUCCESS");
      } else {
         responseModel.setMessage("Not Found");
         responseModel.setStatus("FAILURE");
      }

      responseModel.setStatusCode(HttpStatus.OK.value());
      return responseModel;
   }

   @PostMapping(
      value = {"/release"},
      produces = {"application/json"}
   )
   @Operation(
      summary = "release",
      description = "Release Caution",
      tags = {"Caution"}
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
   public ResponseModel release(@RequestHeader("token") String token, @RequestBody ReleaseCautionRequestModel releaseCautionRequestModel) {
      releaseCautionRequestModel.setUserId(TokenUtils.getUserId(token));
      ResponseModel responseModel = new ResponseModel();
      responseModel.setData(releaseCautionRequestModel);
      ReleaseCautionResponseModel releaseCautionResponseModel = this.cautionService.release(releaseCautionRequestModel);
      if (releaseCautionResponseModel != null) {
         responseModel.setData(releaseCautionResponseModel);
         responseModel.setMessage("Released successfully");
         responseModel.setStatus("SUCCESS");
      } else {
         responseModel.setMessage("Not Found");
         responseModel.setStatus("FAILURE");
      }

      responseModel.setStatusCode(HttpStatus.OK.value());
      return responseModel;
   }
}
