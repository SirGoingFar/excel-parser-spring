package com.sirgoingfar.eemf.excelparserspring;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
public class CsvParser {

    /**
     * 1. Error-proof
     * <p>
     * 2. Log errors, don't abort
     */
    public static void parse(MultipartFile file) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);
        FormulaEvaluator formulator =
                WorksheetUtil.getFormulaEvaluator(workbook);

//        log.info("Num of Row: {}", worksheet.getPhysicalNumberOfRows());
        for (int i = 0; i < worksheet.getPhysicalNumberOfRows(); i++) {

            //Each row
            final XSSFRow eachRow = worksheet.getRow(i);
            if (eachRow == null)
                continue;

//            log.info("Row: {}, Num of Cell: {}", i, eachRow.getPhysicalNumberOfCells());

            //Each Column
            for (int j = 0; j < eachRow.getPhysicalNumberOfCells(); j++) {
//                log.info("Row: {}, Num of Cell: {}", i, eachRow.getPhysicalNumberOfCells());
                XSSFCell cell = eachRow.getCell(j);
                if (cell == null) {
                    log.info("Cell [{},{}] is null", i, j);
                    continue;
                }

                String cellVal = cell.getStringCellValue().trim();

                if (!cellVal.isEmpty())
                    log.info(cellVal);
            }

            log.info("................................");

            // row -> cell(0, 0), cell(0, 1), -->
            // row -> 1


        }

        log.info("Stop");
        //Data: worksheet -> rows (row items) -> key/value* -> cells (column 1 to n)

    }

}
