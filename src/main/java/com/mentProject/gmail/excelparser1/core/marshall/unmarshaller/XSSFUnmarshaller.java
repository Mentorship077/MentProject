package com.mentProject.gmail.excelparser1.core.marshall.unmarshaller;

import com.mentProject.gmail.excelparser1.core.annotation.ExcelCell;
import com.mentProject.gmail.excelparser1.core.exception.ModelInstantiationException;
import com.mentProject.gmail.excelparser1.core.marshall.options.MarshallOptions;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static com.mentProject.gmail.excelparser1.core.utils.ExcelFileUtils.getActualRowCount;
import static com.mentProject.gmail.excelparser1.core.utils.ExcelFileUtils.skip;


public class XSSFUnmarshaller extends Unmarshaller {


    private final MarshallOptions options;
    private final XSSFWorkbook workbook;
    private Logger LOG = Logger.getLogger(XSSFUnmarshaller.class);


    XSSFUnmarshaller(XSSFWorkbook workbook, MarshallOptions options) {
        this.workbook = workbook;
        this.options = options;
    }


    @Override
    public <T> List<T> unmarshall(Class<T> type) {
        Sheet sheet = workbook.getSheetAt(options.getSheetIndex());

        int skip = options.getSkip();
        int rowCount = getActualRowCount(sheet, skip);
        List<T> list = new ArrayList<>(rowCount);

        for (Row currentRow : sheet) {

            if (skip(currentRow, skip))
                continue;

            if (currentRow.getRowNum() <= rowCount) {
                T t = mapRowToModel(currentRow, type);
                list.add(t);
            }
        }
        return list;
    }


    private <T> T mapRowToModel(Row currentRow, Class<T> type) {
        T instance;
        try {
            instance = type.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            throw new ModelInstantiationException("Cannot create a new instance of " + type.getName());
        }

        return setFieldValue(currentRow, type, instance);
    }


    private <T> T setFieldValue(Row currentRow, Class<? super T> subclass, T instance) {
        return subclass == null
                ? instance
                : tailSetFieldValue(currentRow, subclass, setFieldValue(currentRow, subclass.getSuperclass(), instance));
    }


    private <T> T tailSetFieldValue(Row currentRow, Class<? super T> type, T instance) {
        for (Field field : type.getDeclaredFields()) {

            ExcelCell index = field.getAnnotation(ExcelCell.class);
            if (index != null) {
                Cell cell = currentRow.getCell(index.value());

                try {
                    field.setAccessible(true);

                    if (cell == null) {
                        field.set(instance, "");
                    } else if (cell.getCellTypeEnum() == CellType.BLANK) {
                        field.set(instance, "");
                    } else if (cell.getCellTypeEnum() == CellType.STRING) {
                        field.set(instance, cell.getStringCellValue());
                    } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                        Double doubleValue = cell.getNumericCellValue();
                        String stringValue = String.valueOf(Integer.valueOf(doubleValue.intValue())).replace("\'", "");
                        field.set(instance, stringValue);
                    }
                } catch (IllegalAccessException e) {
                    LOG.error(field.getName() + e);
                }
            }
        }
        return instance;
    }

}
