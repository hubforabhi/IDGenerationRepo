package com.maintec.fincore.controller;

import com.maintec.fincore.model.ResponseModel;
import com.maintec.fincore.model.SaveSignatureRequestModel;
import com.maintec.fincore.model.SaveSignatureResponseModel;
import com.maintec.fincore.model.ViewSignatureResponseModel;
import com.maintec.fincore.service.SignatureService;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@RestController
@RequestMapping({"/signature"})
@Tag(name = "Signature", description = "Signature API")
public class SignatureController {

   private static final Logger log = LoggerFactory.getLogger(SignatureController.class);

   @Autowired
   private SignatureService signatureService;

   @GetMapping(
      value = {"/findBySearchIdNo/{searchIdNo}"},
      produces = {"application/json"}
   )
   @Operation(
      summary = "findBySearchIdNo",
      description = "Show ",
      tags = {"Signature"}
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
   public ResponseModel findBySearchIdNo(@RequestHeader("token") String token, @PathVariable("searchIdNo") String searchIdNo) {
      ResponseModel responseModel = new ResponseModel();
      List<ViewSignatureResponseModel> viewSignatureResponseModels = this.signatureService.findByParentID(Long.parseLong(searchIdNo));
      if (!viewSignatureResponseModels.isEmpty()) {
         responseModel.setData(viewSignatureResponseModels);
         responseModel.setMessage(viewSignatureResponseModels.size() + " Found Successfully");
         responseModel.setStatus("SUCCESS");
         responseModel.setStatusCode(HttpStatus.OK.value());
      } else {
         responseModel.setData(searchIdNo);
         responseModel.setStatus("FAILURE");
         responseModel.setMessage("No Image Found");
         responseModel.setStatusCode(HttpStatus.OK.value());
      }

      return responseModel;
   }

   @PostMapping(
      value = {"/save"},
      produces = {"application/json"},
      consumes = {"multipart/form-data"}
   )
   @Operation(
      summary = "save",
      description = "Create/Update New Signature",
      tags = {"Signature"}
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
   public ResponseModel save(@RequestHeader("token") String token, @RequestParam("searchIdNo") String searchIdNo,
                             @RequestParam("name") String name, @RequestParam("type") String type, @RequestParam("file") MultipartFile file) {
      ResponseModel responseModel = new ResponseModel();
      SaveSignatureRequestModel saveSignatureRequestModel = new SaveSignatureRequestModel();
       saveSignatureRequestModel.setUserId(TokenUtils.getUserId(token));
      saveSignatureRequestModel.setSearchIdNo(searchIdNo);
      saveSignatureRequestModel.setType(type);
      saveSignatureRequestModel.setName(name);
      saveSignatureRequestModel.setTheFile(file);
      SaveSignatureResponseModel saveSignatureResponseModel = this.signatureService.save(saveSignatureRequestModel);
      if (saveSignatureResponseModel.getResponseStatus() == ResponseStatus.OK) {
         responseModel.setData(saveSignatureResponseModel);
         responseModel.setStatus("SUCCESS");
         responseModel.setMessage(file.getName() + " Saved Successfully");
         responseModel.setStatusCode(HttpStatus.OK.value());
      } else {
         responseModel.setStatus("FAILURE");
         responseModel.setMessage("Image can't be saved, Please try after some time.");
         responseModel.setStatusCode(HttpStatus.OK.value());
      }

      return responseModel;
   }

   @PostMapping(
      value = {"/delete/{id}"},
      produces = {"application/json"}
   )
   @Operation(
      summary = "delete",
      description = "Delete an Existing Signature",
      tags = {"Signature"}
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
   public ResponseModel delete(@RequestHeader("token") String token, @RequestParam("id") long id) {
      ResponseModel responseModel = new ResponseModel();
      if (this.signatureService.delete(id)) {
         responseModel.setData(id);
         responseModel.setStatus("SUCCESS");
         responseModel.setMessage(id + " Deleted Successfully");
         responseModel.setStatusCode(HttpStatus.OK.value());
      } else {
         responseModel.setData(id);
         responseModel.setStatus("FAILURE");
         responseModel.setMessage("Image can't be deleted, Please try after some time.");
         responseModel.setStatusCode(HttpStatus.OK.value());
      }

      return responseModel;
   }
}
