package com.tebogo.webhook.controller;

import com.tebogo.webhook.dto.SortReponseDTO;
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
    public SortReponseDTO sort(@RequestBody SortRequestDTO req){
        return sortService.getResponseDTO(req.getData());
    }
}
