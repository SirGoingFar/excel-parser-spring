package com.sirgoingfar.eemf.excelparserspring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("upload")
public class UploaderController {

    @PostMapping(value = "/file/csv", consumes = {"multipart/form-data"})
    public void uploadFile(
            @RequestParam("file") MultipartFile assocFieldsFile
    ) {
        CompletableFuture.runAsync(() -> {
            try {
                CsvParser.parse(assocFieldsFile);
            } catch(IOException e) {
                log.error("Yeah we know");
            }
        }).exceptionally(exception -> {
            log.error("Exception: ", exception);
            return null;
        });
    }

}