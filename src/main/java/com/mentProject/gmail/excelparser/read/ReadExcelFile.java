package com.mentProject.gmail.excelparser.read;

import com.epam.excelparser.core.marshall.UnmarshallExcelFile;
import com.epam.excelparser.core.model.excel.ExcelModelProcessor;
import com.epam.excelparser.core.model.excel.ExcelRowPV;
import com.epam.excelparser.core.model.pv.PV;

import java.io.File;
import java.util.List;

/**
 * Created by Anastasiia_Kitlinska on 11/15/2017
 */
public class ReadExcelFile {

    public static List<PV> retrieveAllPVs(String fileName) {
        List<ExcelRowPV> products = UnmarshallExcelFile.fromExcelXSSF(new File(fileName), ExcelRowPV.class);
        return ExcelModelProcessor.processAllPVs(products);
    }

    public static PV retrieveFirstPVs(String fileName) {
        List<ExcelRowPV> products = UnmarshallExcelFile.fromExcelXSSF(new File(fileName), ExcelRowPV.class);
        return ExcelModelProcessor.processFirstPV(products);
    }

}
