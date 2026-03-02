package com.tebogo.webhook.controller;

import com.tebogo.webhook.dto.SortResponseDTO;
import com.tebogo.webhook.dto.SortRequestDTO;
import com.tebogo.webhook.service.SortService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Sorting SpringBoot Webhook", description = "Operations related to sorting characters alphabetically")
@RequestMapping("/api")
public class SortController {

    private final SortService sortService;

    public SortController(SortService sortService) {
        this.sortService = sortService;
    }

    @Operation(
            summary = "Sort characters alphabetically from a valid input",
            description = "Accepts a string and returns its characters sorted in ascending alphabetical order in an array.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully sorted characters",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = SortResponseDTO.class),
                                    examples = @ExampleObject(
                                            value = """
                                                    {
                                                      "word": ["a","b","c","d"]
                                                    }
                                                    """
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid input",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = SortResponseDTO.class),
                                    examples = @ExampleObject(
                                            value = """
                                                    {
                                                       "timestamp": "2026-03-02T16:29:16.18645",
                                                       "error": "Bad Request",
                                                       "message": "Input string cannot be null or empty",
                                                       "status": 400
                                                     }
                                                    """
                                    )
                            )
                    )//,
//                    @ApiResponse(
//                            responseCode = "415",
//                            description = "Unsupported Media Type - Only application/json is supported"
//                    ),
//                    @ApiResponse(
//                            responseCode = "500",
//                            description = "Internal Server Error"
//                    )
            }
    )
    @PostMapping(value = "/sort",
            consumes = "application/json",
            produces = "application/json")
    public SortResponseDTO sort(@RequestBody SortRequestDTO req){
    	 String[] sortedArray = sortService.sortAlphabetically(req.getData());
    	 return new SortResponseDTO(sortedArray);
    }
}
