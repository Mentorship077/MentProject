package com.mentProject.gmail.excelparser1.core.marshall;

import com.mentProject.gmail.excelparser1.core.marshall.options.MarshallOptions;
import com.mentProject.gmail.excelparser1.core.marshall.options.MarshallOptions.MarshallOptionsBuilder;
import com.mentProject.gmail.excelparser1.core.marshall.unmarshaller.Unmarshaller;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class UnmarshallExcelFile {

    private static Logger LOG = Logger.getLogger(UnmarshallExcelFile.class);

    private UnmarshallExcelFile() {
    }


    public static <T> List<T> fromExcelXSSF(final File file, final Class<T> type) {
        final Unmarshaller unmarshaller = deserializeXSSF(file, MarshallOptionsBuilder.settings().build());
        return unmarshaller.unmarshall(type);
    }


    public static <T> List<T> fromExcelHSSF(final File file, final Class<T> type) {
        final Unmarshaller unmarshaller = deserializeHSSF(file, MarshallOptionsBuilder.settings().build());
        return unmarshaller.unmarshall(type);
    }


    private static Unmarshaller deserializeXSSF(final File file, final MarshallOptions options) {
        XSSFWorkbook workbook = null;
        try {
            FileInputStream inputStream = new FileInputStream(file);
            workbook = new XSSFWorkbook(inputStream);
            inputStream.close();
        } catch (IOException e) {
            LOG.error("File not found: " + e.getMessage());
        }
        return Unmarshaller.instance(workbook, options);
    }


    private static Unmarshaller deserializeHSSF(final File file, final MarshallOptions options) {

        HSSFWorkbook workbook = null;
        try {
            FileInputStream inputStream = new FileInputStream(file);
            workbook = new HSSFWorkbook(inputStream);
            inputStream.close();
        } catch (IOException e) {
            LOG.error("File not found: " + e.getMessage());
        }
        return Unmarshaller.instance(workbook, options);
    }

}
