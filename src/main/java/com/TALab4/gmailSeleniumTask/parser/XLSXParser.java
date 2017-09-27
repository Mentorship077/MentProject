package com.TALab4.gmailSeleniumTask.parser;

import com.TALab4.gmailSeleniumTask.parser.model.Message;
import com.TALab4.gmailSeleniumTask.parser.model.User;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XLSXParser implements AbstractParser {
    @Override
    public List<User> parseUsers() throws IOException {
        List<User> users = new ArrayList<>();
        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(USERS_XLSX_PATH));
        XSSFSheet myExcelSheet = myExcelBook.getSheet(USER_SHEET);
        for (int i = 0; i < ROW_NUMBER; i++) {
            XSSFRow row = myExcelSheet.getRow(i);
            String name = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();
            users.add(new User(name, password));
        }
        myExcelBook.close();
        return users;
    }

    @Override
    public List<Message> parseMessages() throws IOException {
        List<Message> messages = new ArrayList<>();
        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(MESSAGES_XLSX_PATH));
        XSSFSheet myExcelSheet = myExcelBook.getSheet(MESSAGE_SHEET);
        for (int i = 0; i < 5; i++) {
            XSSFRow row = myExcelSheet.getRow(i);
            String to = row.getCell(0).getStringCellValue();
            String subject = row.getCell(1).getStringCellValue();
            String textMessage = row.getCell(2).getStringCellValue();
            messages.add(new Message(to, subject, textMessage));
        }
        myExcelBook.close();
        return messages;
    }
}
