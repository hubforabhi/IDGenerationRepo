package com.maintec.fincore.controller;

import com.maintec.fincore.model.IDSearchRequestModel;
import com.maintec.fincore.model.IDSearchResponseModel;
import com.maintec.fincore.model.ResponseModel;
import com.maintec.fincore.service.IDSearchService;
import com.maintec.fincore.util.ResponseStatus;
import com.maintec.fincore.util.TokenUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.maintec.fincore.IDGenerationConstants.FAILURE;
import static com.maintec.fincore.IDGenerationConstants.SUCCESS;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@RestController
@RequestMapping({"/id"})
@Tag(name = "IDSearch", description = "ID Search API")
@Slf4j
public class IDSearchController {

    @Autowired
    private IDSearchService idSearchService;

    @PostMapping(value = "/search/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "ID Search", description = "Search IDs", tags = {"IDSearch"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseModel search(@RequestHeader("token") String token, @RequestParam("id") String id) {
        ResponseModel responseModel = new ResponseModel();
        IDSearchRequestModel idSearchRequestModel = new IDSearchRequestModel();
        idSearchRequestModel.setId(id);
        idSearchRequestModel.setUserId(TokenUtils.getUserId(token));
        IDSearchResponseModel idSearchResponseModel = idSearchService.searchById(idSearchRequestModel);
        if(idSearchResponseModel.getResponseStatus() == ResponseStatus.OK) {
            responseModel.setData(idSearchResponseModel);
            responseModel.setMessage(
                    (idSearchResponseModel.getCompanies() != null ?
                        "Total companies found " + idSearchResponseModel.getCompanies().size() + " " : "") +
                    (idSearchResponseModel.getCustomers() != null ?
                        "Total customers found " + idSearchResponseModel.getCustomers().size() : ""));
            responseModel.setStatus(SUCCESS);
            responseModel.setStatusCode(HttpStatus.OK.value());
        } else {
            responseModel.setData(id);
            responseModel.setStatus(FAILURE);
            responseModel.setMessage(idSearchResponseModel.getResponseStatus().getMessage());
            responseModel.setStatusCode(HttpStatus.EXPECTATION_FAILED.value());
        }
        return responseModel;
    }
}
