package com.maintec.fincore.controller;

import com.maintec.fincore.model.ResponseModel;
import com.maintec.fincore.service.GeneralMastersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.maintec.fincore.IDGenerationConstants.SUCCESS;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@RestController
@RequestMapping({"/master"})
@Tag(name = "GeneralMasters", description = "General Masters API")
public class GeneralMastersController {

    @Autowired
    private GeneralMastersService generalMastersService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All General Masters", description = "Show", tags = {"GeneralMasters"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = ResponseModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseModel findAll(@RequestHeader("token") String token) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setData(generalMastersService.findAll());
        responseModel.setStatusCode(HttpStatus.OK.value());
        responseModel.setStatus(SUCCESS);
        return responseModel;
    }
}
