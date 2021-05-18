package com.backend.system.controllers;

import com.backend.system.Services.FileService;
import com.backend.system.entities.OsFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
public class FileController {

    @Autowired
    FileService service;
    @RequestMapping(value = "/files")
    public List<OsFiles> get(@RequestParam String drive,@RequestParam String path) {

        System.out.println(path+" "+drive);
    try{

        return service.listFiles(Path.of(drive+":",path));
    }catch (Exception e){
        e.printStackTrace();
        return null;
    }

    }

}
