package org.myspringtemplate.controller;


import org.myspringtemplate.service.FileMergerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Arrays;

@RestController
@RequestMapping("/mendix")
public class FileMergerController {

    @Autowired
    public FileMergerService fileMergerService;

    @PostMapping("/mergeSortedFiles")
    public ResponseEntity<String> mergeSortedFiles(@RequestParam("inputPath") String inputPath, @RequestParam("outputPath") String outputPath) {

        File dirPath = new File(inputPath);

        // Assuming all the input files end with .dat extension, In case of text files use .txt
        File[] files = dirPath.listFiles((dir, name) -> name.endsWith(".dat"));

        if (files == null || files.length == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No files found to merge.");
        } else {
            fileMergerService.mergeSortedFiles(Arrays.asList(files), new File(outputPath));
            return ResponseEntity.ok("Files merged successfully.");
        }
    }

}
