package com.IULP.BackEnd.controller;

import com.IULP.BackEnd.Model.Obj;
import com.IULP.BackEnd.Service.ObjService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/obj")
public class ObjController {
    @Autowired
    private ObjService objService;

    @GetMapping
    public ResponseEntity<List<Obj>> getList(){
        return ResponseEntity.ok().body(objService.getObjList());
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteObj(@RequestParam String obj, @RequestParam String author){
        if(objService.deleteObj(obj, author)) return ResponseEntity.ok().body(HttpStatus.OK);
        else return ResponseEntity.ok().body(HttpStatus.BAD_REQUEST);
    }
}
