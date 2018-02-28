package com.mentProject.gmail.kdtParser;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.mentProject.gmail.kdtParser.NumberConstant.*;

public class ExcelParser {
    // excel properties
    String KEYWORDS_XLSX_PATH = "keywords.xlsx";
    String EXCEL_SHEET = "GmailKeywords";
    Integer maxRowSize;

    public static void main(String[] args) {
        ExcelParser excelParser = new ExcelParser();
        List<TestCaseModel> list = new ArrayList<>();

        System.out.println(excelParser.getField(1, FOUR.getNumber()));

        int i = 0;
        do {
            TestCaseModel testCaseModel = new TestCaseModel();
            testCaseModel.setTesTestCase(excelParser.getField(i, ZERO.getNumber()));
            testCaseModel.setStep(excelParser.getField(i, ONE.getNumber()));
            testCaseModel.setKeyword(excelParser.getField(i, TWO.getNumber()));
            testCaseModel.setOperation(excelParser.getField(i, THREE.getNumber()));
            testCaseModel.setDataSet(excelParser.getField(i, FOUR.getNumber()));
            testCaseModel.setDescription(excelParser.getField(i, FIVE.getNumber()));
            testCaseModel.setResult(excelParser.getField(i, SIX.getNumber()));
            if (testCaseModel.emptyAllFields()) {
                break;
            }

            list.add(testCaseModel);
            i++;
        } while (true);

        list.forEach(System.out::println);
    }

    public String getField(int rowNumber, Integer cellNumber) {
        XSSFWorkbook myExcelBook = null;
        try {
            myExcelBook = new XSSFWorkbook(new FileInputStream(KEYWORDS_XLSX_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet myExcelSheet = myExcelBook.getSheet(EXCEL_SHEET);
        XSSFRow row = myExcelSheet.getRow(rowNumber);
        try {
            return row.getCell(cellNumber).toString();
        } catch (NullPointerException ex) {
            return "";
        }
    }

}
