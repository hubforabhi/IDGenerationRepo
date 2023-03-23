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

import java.util.function.BiConsumer;

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

    @GetMapping(value = "/search/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "ID Search by id", description = "Search existing ID(s) by an id", tags = {"IDSearch"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseModel searchById(@RequestHeader("token") String token, @RequestParam("id") String id) {
        ResponseModel responseModel = new ResponseModel();
        IDSearchRequestModel idSearchRequestModel = new IDSearchRequestModel();
        idSearchRequestModel.setUserId(TokenUtils.getUserId(token));
        idSearchRequestModel.setId(id);
        idSearchRequestModel.setUserId(TokenUtils.getUserId(token));
        responseModel.setData(id);
        responseModelMapper.accept(responseModel, idSearchService.searchById(idSearchRequestModel));
        return responseModel;
    }

    @GetMapping(value = "/search/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "ID Search by name", description = "Search existing ID(s) by a name", tags = {"IDSearch"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseModel searchByName(@RequestHeader("token") String token, @RequestParam("name") String name) {
        ResponseModel responseModel = new ResponseModel();
        IDSearchRequestModel idSearchRequestModel = new IDSearchRequestModel();
        idSearchRequestModel.setUserId(TokenUtils.getUserId(token));
        idSearchRequestModel.setName(name);
        responseModel.setData(name);
        responseModelMapper.accept(responseModel, idSearchService.searchByName(idSearchRequestModel));
        return responseModel;
    }

    @GetMapping(value = "/search/aadhaar/{aadhaar}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "ID Search by aadhaar", description = "Search existing ID(s) by an aadhaar", tags = {"IDSearch"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseModel searchByAadhaar(@RequestHeader("token") String token, @RequestParam("aadhaar") String aadhaar) {
        ResponseModel responseModel = new ResponseModel();
        IDSearchRequestModel idSearchRequestModel = new IDSearchRequestModel();
        idSearchRequestModel.setUserId(TokenUtils.getUserId(token));
        idSearchRequestModel.setName(aadhaar);
        responseModel.setData(aadhaar);
        responseModelMapper.accept(responseModel, idSearchService.searchByAadhaar(idSearchRequestModel));
        return responseModel;
    }

    @GetMapping(value = "/search/accountno/{accountNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "ID Search by Account Number", description = "Search existing ID(s) by Account Number", tags = {"IDSearch"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseModel searchByAccountNo(@RequestHeader("token") String token, @RequestParam("accountNo") String accountNo) {
        ResponseModel responseModel = new ResponseModel();
        IDSearchRequestModel idSearchRequestModel = new IDSearchRequestModel();
        idSearchRequestModel.setUserId(TokenUtils.getUserId(token));
        idSearchRequestModel.setAccountNo(accountNo);
        responseModel.setData(accountNo);
        responseModelMapper.accept(responseModel, idSearchService.searchByAccountNo(idSearchRequestModel));
        return responseModel;
    }

    @GetMapping(value = "/search/pfno/{pfNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "ID Search by PF No", description = "Search existing ID(s) by a PF no", tags = {"IDSearch"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseModel searchByPFNo(@RequestHeader("token") String token, @RequestParam("pfNo") String pfNo) {
        ResponseModel responseModel = new ResponseModel();
        IDSearchRequestModel idSearchRequestModel = new IDSearchRequestModel();
        idSearchRequestModel.setUserId(TokenUtils.getUserId(token));
        idSearchRequestModel.setPfNo(pfNo);
        responseModel.setData(pfNo);
        responseModelMapper.accept(responseModel, idSearchService.searchByPfNo(idSearchRequestModel));
        return responseModel;
    }

    @GetMapping(value = "/search/licenseno/{licenseNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "ID Search by PF No", description = "Search existing ID(s) by a PF no", tags = {"IDSearch"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseModel searchByLicenseNo(@RequestHeader("token") String token, @RequestParam("licenseNo") String licenseNo) {
        ResponseModel responseModel = new ResponseModel();
        IDSearchRequestModel idSearchRequestModel = new IDSearchRequestModel();
        idSearchRequestModel.setUserId(TokenUtils.getUserId(token));
        idSearchRequestModel.setLicenseNo(licenseNo);
        responseModel.setData(licenseNo);
        responseModelMapper.accept(responseModel, idSearchService.searchByLicenseNo(idSearchRequestModel));
        return responseModel;
    }

    private BiConsumer<ResponseModel, IDSearchResponseModel> responseModelMapper = (responseModel, idSearchResponseModel) -> {
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
            responseModel.setStatus(FAILURE);
            responseModel.setMessage(idSearchResponseModel.getResponseStatus().getMessage());
            responseModel.setStatusCode(HttpStatus.EXPECTATION_FAILED.value());
        }
    };
}
