package com.mentProject.gmail.kdtParser;

import org.apache.log4j.Logger;
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
    private Logger LOG = Logger.getLogger(ExcelParser.class);

    public static void main(String[] args) {
        ExcelParser excelParser = new ExcelParser();
        List<TestCaseModel> list = new ArrayList<>();
        excelParser.getListTestCaseModelsl(excelParser, list).forEach(System.out::println);
    }

    private List<TestCaseModel> getListTestCaseModelsl(ExcelParser excelParser, List<TestCaseModel> list) {
        int i = 1;
        int testCaseCashCellNumber = 0;
        do {
            TestCaseModel testCaseModel = new TestCaseModel();
            testCaseModel.setTestTestCase(excelParser.getField(i, ZERO.getNumber()));
            testCaseModel.setStep(excelParser.getField(i, ONE.getNumber()));
            testCaseModel.setKeyword(excelParser.getField(i, TWO.getNumber()));
            testCaseModel.setOperation(excelParser.getField(i, THREE.getNumber()));
            testCaseModel.setDataSet(excelParser.getField(i, FOUR.getNumber()));
            testCaseModel.setDescription(excelParser.getField(i, FIVE.getNumber()));
            testCaseModel.setResult(excelParser.getField(i, SIX.getNumber()));
            if (testCaseModel.isRowEmpty()) {
                break;
            }
            if(!testCaseModel.isTestCaseCellEmpty()){
                testCaseCashCellNumber = i;
            }else {
                testCaseModel.setTestTestCase(excelParser.getField(testCaseCashCellNumber, ZERO.getNumber()));
            }
            list.add(testCaseModel);
            i++;
        } while (true);
        return list;
    }

    public String getField(int rowNumber, Integer cellNumber) {
        XSSFWorkbook myExcelBook = null;
        try {
            FileInputStream inputStream = new FileInputStream(KEYWORDS_XLSX_PATH);
            myExcelBook = new XSSFWorkbook(inputStream);
            inputStream.close();
        } catch (IOException e) {
            LOG.error("File not found: " + e.getMessage());
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
