package com.mentProject.gmail.fileReader;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class KeywordsXLSXParser implements KeywordAbstractParser {

    private static final int ROW1 = 1;
    private static final int ROW2 = 2;
    private static final int CELL1 = 1;

    @Override
    public String getBrowserName(){
        return getField(ROW1, CELL1);
    }

    private String getField(int rowNumber, int cellNumber)  {
        XSSFWorkbook myExcelBook = null;
        try {
            myExcelBook = new XSSFWorkbook(new FileInputStream(KEYWORDS_XLSX_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet myExcelSheet = myExcelBook.getSheet(USER_SHEET);
        XSSFRow row = myExcelSheet.getRow(rowNumber);
        return row.getCell(cellNumber).getStringCellValue();
    }

    @Override
    public String getEnterURL() {
        return getField(ROW2, CELL1);
    }
}
