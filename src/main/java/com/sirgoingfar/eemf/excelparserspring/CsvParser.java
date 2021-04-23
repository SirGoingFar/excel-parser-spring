package com.sirgoingfar.eemf.excelparserspring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
public class CsvParser {

    /**
     *
     * 1. Error-proof
     *
     * 2. Log errors, don't abort
     *
     * */
    public static void parse(MultipartFile file) {
        log.info("Do something");
    }

}
