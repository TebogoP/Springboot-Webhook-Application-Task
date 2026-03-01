package com.tebogo.webhook.controller;

import com.tebogo.webhook.dto.SortResponseDTO;
import com.tebogo.webhook.dto.SortRequestDTO;
import com.tebogo.webhook.service.SortService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SortController {

    private final SortService sortService;

    public SortController(SortService sortService) {
        this.sortService = sortService;
    }

    @PostMapping("/sort")
    public SortResponseDTO sort(@RequestBody SortRequestDTO req){
    	 String[] sortedArray = sortService.sortAlphabetically(req.getData());
    	 return new SortResponseDTO(sortedArray);
    }
}
