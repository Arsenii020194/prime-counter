package com.dataart.primecounter.controller;

import com.dataart.primecounter.service.PrimeCounterService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@Validated
public class PrimeCounterController {

    private final PrimeCounterService primeCounterService;

    @GetMapping("/prime")
    @ApiOperation(
            value = "Get all prime numbers up to limit."
    )
    public ResponseEntity<Object> getPrimeByLimit(@ApiParam(name = "limit", required = true) @NotNull Integer limit) {
        return ResponseEntity.ok(primeCounterService.getPrimeByLimit(limit));
    }
}
