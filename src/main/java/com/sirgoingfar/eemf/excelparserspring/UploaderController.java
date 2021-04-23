package com.sirgoingfar.eemf.excelparserspring;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("upload")
public class UploaderController {

    @PostMapping(value = "/file/csv", consumes = {"multipart/form-data"})
    public void uploadFile(
            @RequestParam("file") MultipartFile assocFieldsFile
    ) {
        CompletableFuture.runAsync(() -> CsvParser.parse(assocFieldsFile));
    }

}