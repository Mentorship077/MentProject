package com.mentProject.gmail.excelparser.update;

import com.epam.excelparser.core.model.constants.ProductCreateHeaderConst;
import com.epam.excelparser.core.utils.ExcelFileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * Created by Anastasiia_Kitlinska on 11/28/2017
 */
public class UpdateNewScuUploadExcelFile extends UpdateExcelFile {

    public UpdateNewScuUploadExcelFile(String fileName) {
        super(fileName);
    }

    public void updateProductNumber(String fileName, String newProductNumber) {
        openFile();
        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = ExcelFileUtils.getActualRowCount(sheet, 0);

        for (Row currentRow : sheet) {
            if (currentRow.getRowNum() == 0)
                continue;

            if (currentRow.getRowNum() <= rowCount) {
                updateCellByColumnHeader(ProductCreateHeaderConst.CTR_PRODUCT_NUM, currentRow.getRowNum(), newProductNumber);
            }
        }
        saveChangesToFile();
    }
}
