package com.mentProject.gmail.excelparser1.read;


import com.mentProject.gmail.excelparser1.core.marshall.UnmarshallExcelFile;
import com.mentProject.gmail.excelparser1.core.model.excel.ExcelModelProcessor;
import com.mentProject.gmail.excelparser1.core.model.excel.ExcelRowPV;
import com.mentProject.gmail.excelparser1.core.model.pv.PV;

import java.io.File;
import java.util.List;

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
