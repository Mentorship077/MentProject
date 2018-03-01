package com.mentProject.gmail.excelParser.core;

import com.mentProject.gmail.bo.GmailComposeMessageBO;
import com.mentProject.gmail.bo.GmailDeleteMessageBO;
import com.mentProject.gmail.bo.GmailLoginBO;
import com.mentProject.gmail.core.driver.WebDriverManager;
import com.mentProject.gmail.excelParser.model.TestCaseModel;
import com.mentProject.gmail.fileReader.model.Message;
import com.mentProject.gmail.fileReader.model.User;
import com.mentProject.gmail.kdtParser.NotFoundKeywordException;
import com.mentProject.gmail.util.EnvProperties;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.mentProject.gmail.excelParser.core.constants.Keywords.*;
import static com.mentProject.gmail.kdtParser.NumberConstant.*;

public class ExcelUnmarshaller {
    // excel properties
    private static final String KEYWORDS_XLSX_PATH = "keywords.xlsx";
    private static final String EXCEL_SHEET = "GmailKeywords";
    private final static EnvProperties prop = EnvProperties.getInstance();

    private GmailComposeMessageBO gmailComposeMessageBO = new GmailComposeMessageBO();
    private GmailLoginBO gmailLoginBO = new GmailLoginBO();
    private GmailDeleteMessageBO gmailDeleteMessageBO = new GmailDeleteMessageBO();


    private Logger LOG = Logger.getLogger(ExcelUnmarshaller.class);

    public static void main(String[] args) {
        new ExcelUnmarshaller().runKeywords();
    }

    public void runKeywords() {
        ExcelUnmarshaller excelUnmarshaller = new ExcelUnmarshaller();
        List<TestCaseModel> list = new ArrayList<>();
        excelUnmarshaller.getListTestCaseModels(excelUnmarshaller, list);
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


    private List<TestCaseModel> getListTestCaseModels(ExcelUnmarshaller excelUnmarshaller, List<TestCaseModel> list) {
        int i = 1;
        int testCaseCashCellNumber = 0;
        do {
            TestCaseModel testCaseModel = new TestCaseModel();
            testCaseModel.setTestTestCase(excelUnmarshaller.getField(i, ZERO.getNumber()));
            testCaseModel.setStep(excelUnmarshaller.getField(i, ONE.getNumber()));
            testCaseModel.setType(excelUnmarshaller.getField(i, TWO.getNumber()));
            testCaseModel.setKeyword(excelUnmarshaller.getField(i, THREE.getNumber()));
            testCaseModel.setOperation(excelUnmarshaller.getField(i, FOUR.getNumber()));
            testCaseModel.setDataSet(excelUnmarshaller.getField(i, FIVE.getNumber()));
            testCaseModel.setDescription(excelUnmarshaller.getField(i, SIX.getNumber()));
            testCaseModel.setResult(excelUnmarshaller.getField(i, SEVEN.getNumber()));
            if (testCaseModel.isRowEmpty()) {
                break;
            }
            if (!testCaseModel.isTestCaseCellEmpty()) {
                testCaseCashCellNumber = i;
            } else {
                testCaseModel.setTestTestCase(excelUnmarshaller.getField(testCaseCashCellNumber, ZERO.getNumber()));
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
