package com.mentProject.gmail.excelparser.core.model.excel;

import com.mentProject.gmail.excelparser.core.model.builder.ProductBuilder;
import com.mentProject.gmail.excelparser.core.model.builder.VendorBuilder;
import com.mentProject.gmail.excelparser.core.model.pv.PV;
import com.mentProject.gmail.excelparser.core.model.pv.Product;
import com.mentProject.gmail.excelparser.core.model.pv.Vendor;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ExcelModelProcessor {

    public static List<PV> processAllPVs(List<ExcelRowPV> products) {
        List<String> uniqueIDs = getUniqueProductID(products);
        List<PV> pvModelsList = new ArrayList<>();

        uniqueIDs.forEach(id -> {
            List<ExcelRowPV> pvList = getAllExcelRowPvForProductID(products, id);
            PV pvModel = transformToPvModel(pvList);
            pvModelsList.add(pvModel);
        });

        return pvModelsList;
    }


    public static PV processFirstPV(List<ExcelRowPV> products) {
        List<PV> pvModelsList = processAllPVs(products);
        return pvModelsList.get(0);
    }


    private static List<String> getUniqueProductID(List<ExcelRowPV> products) {
        List<String> allProductIds = new ArrayList<>();
        products.forEach(product -> allProductIds.add(product.getCTR_PRODUCT_NUM()));

        return allProductIds.stream().distinct().collect(toList());
    }


    private static List<ExcelRowPV> getAllExcelRowPvForProductID(List<ExcelRowPV> products, String id) {
        return products
                .stream()
                .filter(x -> x.getCTR_PRODUCT_NUM().equalsIgnoreCase(id))
                .collect(toList());
    }


    private static PV transformToPvModel(List<ExcelRowPV> excelRowPVs) {
        PV pv = new PV();

        excelRowPVs.forEach(excelRowPV -> {
            pv.setProductNumber(excelRowPV.getCTR_PRODUCT_NUM());
            if (excelRowPV.getObject_Type_Name().contains("VEND")) {
                setVendor(excelRowPV, pv);
            } else {
                setProduct(excelRowPV, pv);
            }
        });
        return pv;
    }


    private static Vendor setVendor(ExcelRowPV excelRowPV, PV pvModel) {
        VendorBuilder builder = new VendorBuilder(excelRowPV);
        Vendor vendor = builder.build();
        pvModel.getVendors().add(vendor);

        return vendor;
    }


    private static Product setProduct(ExcelRowPV excelRowPV, PV pvModel) {
        ProductBuilder builder = new ProductBuilder(excelRowPV);
        Product product = builder.build();
        pvModel.setProduct(product);
        return product;
    }


}
