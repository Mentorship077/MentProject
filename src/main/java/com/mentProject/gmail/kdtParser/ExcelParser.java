package com.mentProject.gmail.kdtParser;

import com.mentProject.gmail.bo.GmailComposeMessageBO;
import com.mentProject.gmail.bo.GmailDeleteMessageBO;
import com.mentProject.gmail.bo.GmailLoginBO;
import com.mentProject.gmail.core.driver.WebDriverManager;
import com.mentProject.gmail.fileReader.model.Message;
import com.mentProject.gmail.fileReader.model.User;
import com.mentProject.gmail.util.EnvProperties;
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
    private static final String KEYWORDS_XLSX_PATH = "keywords.xlsx";
    private static final String EXCEL_SHEET = "GmailKeywords";
    private static final String RUN_APP = "Run app";
    private static final String LOGIN = "Login";
    private static final String DELETE = "Delete";
    private static final String COMPOSE = "Compose";
    private final static EnvProperties prop = EnvProperties.getInstance();

    private GmailComposeMessageBO gmailComposeMessageBO = new GmailComposeMessageBO();
    private GmailLoginBO gmailLoginBO = new GmailLoginBO();
    private GmailDeleteMessageBO gmailDeleteMessageBO = new GmailDeleteMessageBO();


    private Logger LOG = Logger.getLogger(ExcelParser.class);

    public static void main(String[] args) {
        new ExcelParser().runKeywords();
    }

    public void runKeywords() {
        ExcelParser excelParser = new ExcelParser();
        List<TestCaseModel> list = new ArrayList<>();
        excelParser.getListTestCaseModels(excelParser, list);
        for (TestCaseModel aList : list) {
            System.out.println(aList.getKeyword());
            if (aList.getKeyword().equalsIgnoreCase(RUN_APP)) {
                WebDriverManager.gotoURL(prop.getBaseUrl());
            } else if (aList.getKeyword().equalsIgnoreCase(LOGIN)) {
                gmailLoginBO.login(new User("papai9919@gmail.com", "123456Pp"));
            } else if (aList.getKeyword().equalsIgnoreCase(COMPOSE)) {
                gmailComposeMessageBO.compose(new Message("superPapai1488@gmail.com", "subject", "textMessage"));
            } else if (aList.getKeyword().equalsIgnoreCase(DELETE)) {
                gmailDeleteMessageBO.delete();
            } else {
                try {
                    throw new NotFoundKeywordException("Keyword  '" + aList.getKeyword() + "' not found");
                } catch (NotFoundKeywordException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private List<TestCaseModel> getListTestCaseModels(ExcelParser excelParser, List<TestCaseModel> list) {
        int i = 1;
        int testCaseCashCellNumber = 0;
        do {
            TestCaseModel testCaseModel = new TestCaseModel();
            testCaseModel.setTestTestCase(excelParser.getField(i, ZERO.getNumber()));
            testCaseModel.setStep(excelParser.getField(i, ONE.getNumber()));
            testCaseModel.setType(excelParser.getField(i, TWO.getNumber()));
            testCaseModel.setKeyword(excelParser.getField(i, THREE.getNumber()));
            testCaseModel.setOperation(excelParser.getField(i, FOUR.getNumber()));
            testCaseModel.setDataSet(excelParser.getField(i, FIVE.getNumber()));
            testCaseModel.setDescription(excelParser.getField(i, SIX.getNumber()));
            testCaseModel.setResult(excelParser.getField(i, SEVEN.getNumber()));
            if (testCaseModel.isRowEmpty()) {
                break;
            }
            if (!testCaseModel.isTestCaseCellEmpty()) {
                testCaseCashCellNumber = i;
            } else {
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
