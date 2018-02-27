package com.mentProject.gmail.excelparser.core.marshall.unmarshaller;

import com.mentProject.gmail.excelparser.core.marshall.options.MarshallOptions;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public abstract class Unmarshaller {

    public abstract <T> List<T> unmarshall(Class<T> type);


    public static Unmarshaller instance(XSSFWorkbook workbook, MarshallOptions options) {
        return new XSSFUnmarshaller(workbook, options);
    }

    public static Unmarshaller instance(HSSFWorkbook workbook, MarshallOptions options) {
        return new HSSFUnmarshaller(workbook, options);
    }
}
