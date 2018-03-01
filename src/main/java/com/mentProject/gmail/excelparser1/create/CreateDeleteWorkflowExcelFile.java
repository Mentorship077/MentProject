package com.mentProject.gmail.excelparser1.create;
import com.mentProject.gmail.excelparser1.core.marshall.UnmarshallExcelFile;
import com.mentProject.gmail.excelparser1.core.model.excel.ExcelRowDeleteWorkflow;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateDeleteWorkflowExcelFile {

    private static Logger LOG = Logger.getLogger(CreateDeleteWorkflowExcelFile.class);

    public static void fromOtherFile(String inputFileName, String outputFileName) {
        List<ExcelRowDeleteWorkflow> products = UnmarshallExcelFile.fromExcelHSSF(new File(inputFileName), ExcelRowDeleteWorkflow.class);
        List<String> prodID = new ArrayList<>();

        for (ExcelRowDeleteWorkflow product : products) {
            prodID.add(product.getId());
        }

        fromList(prodID, outputFileName);

    }

    public static void fromList(List<String> productList, String outputFileName) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();

        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("ID");
        int rowCount = 0;
        for (String id : productList) {
            sheet.createRow(++rowCount).createCell(0).setCellValue(id);
        }

        try (FileOutputStream outputStream = new FileOutputStream(outputFileName)) {
            workbook.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            LOG.error("Couldn't create file: " + outputFileName);
        }
    }
}
