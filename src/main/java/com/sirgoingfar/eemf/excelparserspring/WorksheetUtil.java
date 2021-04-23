package com.sirgoingfar.eemf.excelparserspring;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.math.BigDecimal;

import static org.apache.tomcat.util.bcel.classfile.ElementValue.PRIMITIVE_INT;
import static org.apache.tomcat.util.bcel.classfile.ElementValue.STRING;

public class WorksheetUtil {

    public static String getCellStringValue(XSSFCell cell, FormulaEvaluator formulaEvaluator) {

        switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case PRIMITIVE_INT:
                return BigDecimal.valueOf(cell.getNumericCellValue()).toBigInteger().toString();
            default:
                return cell.getRawValue();
        }

    }

    public static FormulaEvaluator getFormulaEvaluator(Workbook workbook) {
        return workbook.getCreationHelper().createFormulaEvaluator();
    }
}
