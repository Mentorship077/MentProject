package com.mentProject.gmail.excelparser.core.model.builder;


import com.mentProject.gmail.excelparser.core.model.excel.ExcelRowPV;
import com.mentProject.gmail.excelparser.core.model.pv.Vendor;

public class VendorBuilder {

    private Vendor vendor;
    private ExcelRowPV excelRowPV;

    public VendorBuilder(ExcelRowPV excelRowPV) {
        this.vendor = new Vendor();
        this.excelRowPV = excelRowPV;
    }


    public Vendor build() {
        setGeneralInfo()
                .setVendorPackagingType()
                .setVendorPackagingInfo()
                .setVendorOrderingInfo()
                .setVendorGtinInfo()
                .setVendorWarrantyInfo()
                .setVendorProductDesc()
                .setVendorExclusiveFeatures();
        return vendor;
    }

    private VendorBuilder setGeneralInfo() {
        vendor.setParentId(excelRowPV.getParent_ID());
        vendor.setObjectTypeName(excelRowPV.getObject_Type_Name());
        vendor.setCtrVendorFobNum(excelRowPV.getCTR_VENDOR_FOB_NUM());
        vendor.setCtrProductNum(excelRowPV.getCTR_PRODUCT_NUM());
        vendor.setVendorPartNum(excelRowPV.getVENDOR_PART_NUM());
        vendor.setCountryOfOriginIso3CharCd(excelRowPV.getCOUNTRY_OF_ORIGIN_ISO_3CHAR_CD());
        vendor.setIaBrandKeyNm(excelRowPV.getIA_BRAND_KEY_NM());
        return this;
    }


    private VendorBuilder setVendorPackagingType() {
        vendor.setTireTreadDepth32NdInchAmt(excelRowPV.getTIRE_TREAD_DEPTH_32ND_INCH_AMT());
        vendor.setConsumerPackageTypeCd(excelRowPV.getCONSUMER_PACKAGE_TYPE_CD());
        vendor.setOuterPackgageTypeCd(excelRowPV.getOUTER_PACKGAGE_TYPE_CD());
        vendor.setInnerPackageTypeCd(excelRowPV.getINNER_PACKAGE_TYPE_CD());
        return this;
    }


    private VendorBuilder setVendorPackagingInfo() {
        vendor.setVeStorageCd(excelRowPV.getVE_STORAGE_CD());
        vendor.setInnerPackageConsumerUnitQty(toDouble(excelRowPV.getINNER_PACKAGE_CONSUMER_UNIT_QTY()));
        vendor.setOuterPackageDepthCmQty(toDouble(excelRowPV.getOUTER_PACKAGE_DEPTH_CM_QTY()));
        vendor.setOuterPackageWidthCmQty(toDouble(excelRowPV.getOUTER_PACKAGE_WIDTH_CM_QTY()));
        vendor.setOuterPackageHeightCmQty(toDouble(excelRowPV.getOUTER_PACKAGE_HEIGHT_CM_QTY()));
        return this;
    }


    private VendorBuilder setVendorOrderingInfo() {
        vendor.setVendorMinimumOrderQty(toDouble(excelRowPV.getVENDOR_MINIMUM_ORDER_QTY()));
        vendor.setVendorMultipleOrderQty(toDouble(excelRowPV.getVENDOR_MULTIPLE_ORDER_QTY()));
        return this;
    }


    private VendorBuilder setVendorWarrantyInfo() {
        vendor.setProductMfrWarrantyCtrLink(excelRowPV.getPRODUCT_MFR_WARRANTY_CTR_LINK());
        vendor.setWarrantyReplacementPeriodCd(excelRowPV.getWARRANTY_REPLACEMENT_PERIOD_CD());
        vendor.setWarrantyRepairPeriodCd(excelRowPV.getWARRANTY_REPAIR_PERIOD_CD());
        vendor.setColdSensitiveInd(excelRowPV.getCOLD_SENSITIVE_IND());
        vendor.setHeatSensitiveInd(excelRowPV.getHEAT_SENSITIVE_IND());
        vendor.setWarrantyDispositionCd(excelRowPV.getWARRANTY_DISPOSITION_CD());
        return this;
    }


    private VendorBuilder setVendorGtinInfo() {
        vendor.setProdvendGtin8(excelRowPV.getPRODVEND_GTIN8());
        vendor.setProdvendGtin12(excelRowPV.getPRODVEND_GTIN12());
        vendor.setProdvendGtin13(excelRowPV.getPRODVEND_GTIN13());
        return this;
    }


    private VendorBuilder setVendorProductDesc() {
        vendor.setCtrVeProductDesc(excelRowPV.getCTR_VE_PRODUCT_DESC());
        return this;
    }


    private VendorBuilder setVendorExclusiveFeatures() {
        vendor.setExclusiveContentFeaturesInd(excelRowPV.getEXCLUSIVE_CONTENT_FEATURES_IND());
        vendor.setExclusiveContentFeaturesCd(excelRowPV.getEXCLUSIVE_CONTENT_FEATURES_CD());
        vendor.setVeFeaturesBenefitsTxt(excelRowPV.getVE_FEATURES_BENEFITS_TXT());
        return this;
    }

    private Double toDouble(String stringValue) {
        Double doubleValue = 0.0;
        if (!stringValue.isEmpty()) {
            doubleValue = Double.valueOf(stringValue);
        }
        return doubleValue;


    }
}
