package com.IULP.BackEnd.Controller;

import com.IULP.BackEnd.Service.BagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BagController {
    private BagService bagService;

    @GetMapping
    public ResponseEntity<HttpStatus> recordBag(){
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
