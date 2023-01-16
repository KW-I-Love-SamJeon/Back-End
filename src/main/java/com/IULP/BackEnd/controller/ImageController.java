package com.IULP.BackEnd.controller;

import com.IULP.BackEnd.Model.Obj;
import com.IULP.BackEnd.Service.ObjService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/obj")
public class ImageController {
    @Autowired
    private ObjService objService;

    @GetMapping
    public ResponseEntity<List<Obj>> getList(){
        return ResponseEntity.ok().body(objService.getObjList());
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteObj(@RequestParam String obj){
        if(objService.deleteObj(obj)) return ResponseEntity.ok().body(HttpStatus.OK);
        else return ResponseEntity.ok().body(HttpStatus.BAD_REQUEST);
    }

//    @GetMapping
//    public ResponseEntity<HttpStatus> changeObj(@RequestParam String obj){
//        File file = new File("");
//        File newFile = new File("");
//        Path filePath = Paths.get("");
//        Path newFilePath = Paths.get("");
//        return ResponseEntity.ok().body(HttpStatus.OK);
//    }
}
