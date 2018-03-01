package com.mentProject.gmail.excelparser1.core.model.excel;

import com.mentProject.gmail.excelparser1.core.annotation.ExcelCell;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Class for each Excel row Model representation
 * <p>
 * Used for further Java processing for proper Java Model representation of functionality
 */
public class ExcelRowPV {

    @ExcelCell(0)
    private String ID;

    @ExcelCell(1)
    private String PRODUCT_SBU_LINK;

    @ExcelCell(2)
    private String Parent_ID;

    @ExcelCell(3)
    private String Object_Type_Name;

    @ExcelCell(4)
    private String GEN_PRODUCT_TYPE_CD;

    @ExcelCell(5)
    private String CARD_TYPE_CD;

    @ExcelCell(6)
    private String POP_FIXTURE_TYPE_LOV;

    @ExcelCell(7)
    private String PROMOTION_PROD_TYPE_LOV;

    @ExcelCell(8)
    private String SERVICES_TYPE_LOV;

    @ExcelCell(9)
    private String CTR_VENDOR_FOB_NUM;

    @ExcelCell(10)
    private String CTR_PRODUCT_NUM;

    @ExcelCell(11)
    private String CTR_PRODUCT_SHORT_DESC;

    @ExcelCell(12)
    private String TIRE_TREAD_DEPTH_32ND_INCH_AMT;

    @ExcelCell(13)
    private String CTR_TEMP_BRAND_CD;

    @ExcelCell(14)
    private String CONSUMER_PACKAGE_TYPE_CD;

    @ExcelCell(15)
    private String OUTER_PACKGAGE_TYPE_CD;

    @ExcelCell(16)
    private String OUTER_PACKAGE_CONSUMER_UNIT_QTY;

    @ExcelCell(17)
    private String WARRANTY_SERVICE_LETTER_IND;

    @ExcelCell(18)
    private String RETURN_POLICY_PERIOD_CD;

    @ExcelCell(19)
    private String WARRANTY_REDIRECT_IND;

    @ExcelCell(20)
    private String MULTI_LEVEL_WARRANTY_IND;

    @ExcelCell(21)
    private String VENDOR_PART_NUM;

    @ExcelCell(22)
    private String VENDOR_MINIMUM_ORDER_QTY;

    @ExcelCell(23)
    private String VENDOR_MULTIPLE_ORDER_QTY;

    @ExcelCell(24)
    private String PRODUCT_MFR_WARRANTY_CTR_LINK;

    @ExcelCell(25)
    private String WARRANTY_REPLACEMENT_PERIOD_CD;

    @ExcelCell(26)
    private String WARRANTY_REPAIR_PERIOD_CD;

    @ExcelCell(27)
    private String COLD_SENSITIVE_IND;

    @ExcelCell(28)
    private String HEAT_SENSITIVE_IND;

    @ExcelCell(29)
    private String WARRANTY_DISPOSITION_CD;

    @ExcelCell(30)
    private String MERCH_FINELINE_BUS_CD;

    @ExcelCell(31)
    private String PRODUCT_TYPE_IMS_CD;

    @ExcelCell(32)
    private String COUNTRY_OF_ORIGIN_ISO_3CHAR_CD;

    @ExcelCell(33)
    private String PRIME_CTR_VENDOR_FOB_NUM;

    @ExcelCell(34)
    private String PRODVEND_GTIN8;

    @ExcelCell(35)
    private String PRODVEND_GTIN12;

    @ExcelCell(36)
    private String PRODVEND_GTIN13;

    @ExcelCell(37)
    private String CTR_PRODUCT_GTIN12;

    @ExcelCell(38)
    private String ALTERNATE_CTR_VEND_FOB_NUMBERS;

    @ExcelCell(39)
    private String CTR_PRODUCT_LONG_DESC;

    @ExcelCell(40)
    private String CTR_VE_PRODUCT_DESC;

    @ExcelCell(41)
    private String VE_STORAGE_CD;

    @ExcelCell(42)
    private String INNER_PACKAGE_TYPE_CD;

    @ExcelCell(43)
    private String INNER_PACKAGE_CONSUMER_UNIT_QTY;

    @ExcelCell(44)
    private String OUTER_PACKAGE_DEPTH_CM_QTY;

    @ExcelCell(45)
    private String OUTER_PACKAGE_WIDTH_CM_QTY;

    @ExcelCell(46)
    private String OUTER_PACKAGE_HEIGHT_CM_QTY;

    @ExcelCell(47)
    private String IA_BRAND_KEY_NM;

    @ExcelCell(48)
    private String EXCLUSIVE_CONTENT_FEATURES_IND;

    @ExcelCell(49)
    private String EXCLUSIVE_CONTENT_FEATURES_CD;

    @ExcelCell(50)
    private String VE_FEATURES_BENEFITS_TXT;

    @ExcelCell(51)
    private String FEATURES_BENEFITS_DLR_TXT;

    @ExcelCell(52)
    private String CTR_GOOD_BETTER_BEST_CD;

    @ExcelCell(53)
    private String MERCH_ASSORTMENT_STYLE_DECISION_CD;

    @ExcelCell(54)
    private String MERCH_ASSORTMENT_STYLE_DECISION_MAINT_CD;

    @ExcelCell(55)
    private String MERCH_ASSORTMENT_STYLE_NAME;

    @ExcelCell(56)
    private String IA_PRODUCT_FAMILY_NM;


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPRODUCT_SBU_LINK() {
        return PRODUCT_SBU_LINK;
    }

    public void setPRODUCT_SBU_LINK(String PRODUCT_SBU_LINK) {
        this.PRODUCT_SBU_LINK = PRODUCT_SBU_LINK;
    }

    public String getParent_ID() {
        return Parent_ID;
    }

    public void setParent_ID(String parent_ID) {
        Parent_ID = parent_ID;
    }

    public String getObject_Type_Name() {
        return Object_Type_Name;
    }

    public void setObject_Type_Name(String object_Type_Name) {
        Object_Type_Name = object_Type_Name;
    }

    public String getGEN_PRODUCT_TYPE_CD() {
        return GEN_PRODUCT_TYPE_CD;
    }

    public void setGEN_PRODUCT_TYPE_CD(String GEN_PRODUCT_TYPE_CD) {
        this.GEN_PRODUCT_TYPE_CD = GEN_PRODUCT_TYPE_CD;
    }

    public String getCARD_TYPE_CD() {
        return CARD_TYPE_CD;
    }

    public void setCARD_TYPE_CD(String CARD_TYPE_CD) {
        this.CARD_TYPE_CD = CARD_TYPE_CD;
    }

    public String getPOP_FIXTURE_TYPE_LOV() {
        return POP_FIXTURE_TYPE_LOV;
    }

    public void setPOP_FIXTURE_TYPE_LOV(String POP_FIXTURE_TYPE_LOV) {
        this.POP_FIXTURE_TYPE_LOV = POP_FIXTURE_TYPE_LOV;
    }

    public String getPROMOTION_PROD_TYPE_LOV() {
        return PROMOTION_PROD_TYPE_LOV;
    }

    public void setPROMOTION_PROD_TYPE_LOV(String PROMOTION_PROD_TYPE_LOV) {
        this.PROMOTION_PROD_TYPE_LOV = PROMOTION_PROD_TYPE_LOV;
    }

    public String getSERVICES_TYPE_LOV() {
        return SERVICES_TYPE_LOV;
    }

    public void setSERVICES_TYPE_LOV(String SERVICES_TYPE_LOV) {
        this.SERVICES_TYPE_LOV = SERVICES_TYPE_LOV;
    }

    public String getCTR_VENDOR_FOB_NUM() {
        return CTR_VENDOR_FOB_NUM;
    }

    public void setCTR_VENDOR_FOB_NUM(String CTR_VENDOR_FOB_NUM) {
        this.CTR_VENDOR_FOB_NUM = CTR_VENDOR_FOB_NUM;
    }

    public String getCTR_PRODUCT_NUM() {
        return CTR_PRODUCT_NUM;
    }

    public void setCTR_PRODUCT_NUM(String CTR_PRODUCT_NUM) {
        this.CTR_PRODUCT_NUM = CTR_PRODUCT_NUM;
    }

    public String getCTR_PRODUCT_SHORT_DESC() {
        return CTR_PRODUCT_SHORT_DESC;
    }

    public void setCTR_PRODUCT_SHORT_DESC(String CTR_PRODUCT_SHORT_DESC) {
        this.CTR_PRODUCT_SHORT_DESC = CTR_PRODUCT_SHORT_DESC;
    }

    public String getTIRE_TREAD_DEPTH_32ND_INCH_AMT() {
        return TIRE_TREAD_DEPTH_32ND_INCH_AMT;
    }

    public void setTIRE_TREAD_DEPTH_32ND_INCH_AMT(String TIRE_TREAD_DEPTH_32ND_INCH_AMT) {
        this.TIRE_TREAD_DEPTH_32ND_INCH_AMT = TIRE_TREAD_DEPTH_32ND_INCH_AMT;
    }

    public String getCTR_TEMP_BRAND_CD() {
        return CTR_TEMP_BRAND_CD;
    }

    public void setCTR_TEMP_BRAND_CD(String CTR_TEMP_BRAND_CD) {
        this.CTR_TEMP_BRAND_CD = CTR_TEMP_BRAND_CD;
    }

    public String getCONSUMER_PACKAGE_TYPE_CD() {
        return CONSUMER_PACKAGE_TYPE_CD;
    }

    public void setCONSUMER_PACKAGE_TYPE_CD(String CONSUMER_PACKAGE_TYPE_CD) {
        this.CONSUMER_PACKAGE_TYPE_CD = CONSUMER_PACKAGE_TYPE_CD;
    }

    public String getOUTER_PACKGAGE_TYPE_CD() {
        return OUTER_PACKGAGE_TYPE_CD;
    }

    public void setOUTER_PACKGAGE_TYPE_CD(String OUTER_PACKGAGE_TYPE_CD) {
        this.OUTER_PACKGAGE_TYPE_CD = OUTER_PACKGAGE_TYPE_CD;
    }

    public String getOUTER_PACKAGE_CONSUMER_UNIT_QTY() {
        return OUTER_PACKAGE_CONSUMER_UNIT_QTY;
    }

    public void setOUTER_PACKAGE_CONSUMER_UNIT_QTY(String OUTER_PACKAGE_CONSUMER_UNIT_QTY) {
        this.OUTER_PACKAGE_CONSUMER_UNIT_QTY = OUTER_PACKAGE_CONSUMER_UNIT_QTY;
    }

    public String getWARRANTY_SERVICE_LETTER_IND() {
        return WARRANTY_SERVICE_LETTER_IND;
    }

    public void setWARRANTY_SERVICE_LETTER_IND(String WARRANTY_SERVICE_LETTER_IND) {
        this.WARRANTY_SERVICE_LETTER_IND = WARRANTY_SERVICE_LETTER_IND;
    }

    public String getRETURN_POLICY_PERIOD_CD() {
        return RETURN_POLICY_PERIOD_CD;
    }

    public void setRETURN_POLICY_PERIOD_CD(String RETURN_POLICY_PERIOD_CD) {
        this.RETURN_POLICY_PERIOD_CD = RETURN_POLICY_PERIOD_CD;
    }

    public String getWARRANTY_REDIRECT_IND() {
        return WARRANTY_REDIRECT_IND;
    }

    public void setWARRANTY_REDIRECT_IND(String WARRANTY_REDIRECT_IND) {
        this.WARRANTY_REDIRECT_IND = WARRANTY_REDIRECT_IND;
    }

    public String getMULTI_LEVEL_WARRANTY_IND() {
        return MULTI_LEVEL_WARRANTY_IND;
    }

    public void setMULTI_LEVEL_WARRANTY_IND(String MULTI_LEVEL_WARRANTY_IND) {
        this.MULTI_LEVEL_WARRANTY_IND = MULTI_LEVEL_WARRANTY_IND;
    }

    public String getVENDOR_PART_NUM() {
        return VENDOR_PART_NUM;
    }

    public void setVENDOR_PART_NUM(String VENDOR_PART_NUM) {
        this.VENDOR_PART_NUM = VENDOR_PART_NUM;
    }

    public String getVENDOR_MINIMUM_ORDER_QTY() {
        return VENDOR_MINIMUM_ORDER_QTY;
    }

    public void setVENDOR_MINIMUM_ORDER_QTY(String VENDOR_MINIMUM_ORDER_QTY) {
        this.VENDOR_MINIMUM_ORDER_QTY = VENDOR_MINIMUM_ORDER_QTY;
    }

    public String getVENDOR_MULTIPLE_ORDER_QTY() {
        return VENDOR_MULTIPLE_ORDER_QTY;
    }

    public void setVENDOR_MULTIPLE_ORDER_QTY(String VENDOR_MULTIPLE_ORDER_QTY) {
        this.VENDOR_MULTIPLE_ORDER_QTY = VENDOR_MULTIPLE_ORDER_QTY;
    }

    public String getPRODUCT_MFR_WARRANTY_CTR_LINK() {
        return PRODUCT_MFR_WARRANTY_CTR_LINK;
    }

    public void setPRODUCT_MFR_WARRANTY_CTR_LINK(String PRODUCT_MFR_WARRANTY_CTR_LINK) {
        this.PRODUCT_MFR_WARRANTY_CTR_LINK = PRODUCT_MFR_WARRANTY_CTR_LINK;
    }

    public String getWARRANTY_REPLACEMENT_PERIOD_CD() {
        return WARRANTY_REPLACEMENT_PERIOD_CD;
    }

    public void setWARRANTY_REPLACEMENT_PERIOD_CD(String WARRANTY_REPLACEMENT_PERIOD_CD) {
        this.WARRANTY_REPLACEMENT_PERIOD_CD = WARRANTY_REPLACEMENT_PERIOD_CD;
    }

    public String getWARRANTY_REPAIR_PERIOD_CD() {
        return WARRANTY_REPAIR_PERIOD_CD;
    }

    public void setWARRANTY_REPAIR_PERIOD_CD(String WARRANTY_REPAIR_PERIOD_CD) {
        this.WARRANTY_REPAIR_PERIOD_CD = WARRANTY_REPAIR_PERIOD_CD;
    }

    public String getCOLD_SENSITIVE_IND() {
        return COLD_SENSITIVE_IND;
    }

    public void setCOLD_SENSITIVE_IND(String COLD_SENSITIVE_IND) {
        this.COLD_SENSITIVE_IND = COLD_SENSITIVE_IND;
    }

    public String getHEAT_SENSITIVE_IND() {
        return HEAT_SENSITIVE_IND;
    }

    public void setHEAT_SENSITIVE_IND(String HEAT_SENSITIVE_IND) {
        this.HEAT_SENSITIVE_IND = HEAT_SENSITIVE_IND;
    }

    public String getWARRANTY_DISPOSITION_CD() {
        return WARRANTY_DISPOSITION_CD;
    }

    public void setWARRANTY_DISPOSITION_CD(String WARRANTY_DISPOSITION_CD) {
        this.WARRANTY_DISPOSITION_CD = WARRANTY_DISPOSITION_CD;
    }

    public String getMERCH_FINELINE_BUS_CD() {
        return MERCH_FINELINE_BUS_CD;
    }

    public void setMERCH_FINELINE_BUS_CD(String MERCH_FINELINE_BUS_CD) {
        this.MERCH_FINELINE_BUS_CD = MERCH_FINELINE_BUS_CD;
    }

    public String getPRODUCT_TYPE_IMS_CD() {
        return PRODUCT_TYPE_IMS_CD;
    }

    public void setPRODUCT_TYPE_IMS_CD(String PRODUCT_TYPE_IMS_CD) {
        this.PRODUCT_TYPE_IMS_CD = PRODUCT_TYPE_IMS_CD;
    }

    public String getCOUNTRY_OF_ORIGIN_ISO_3CHAR_CD() {
        return COUNTRY_OF_ORIGIN_ISO_3CHAR_CD;
    }

    public void setCOUNTRY_OF_ORIGIN_ISO_3CHAR_CD(String COUNTRY_OF_ORIGIN_ISO_3CHAR_CD) {
        this.COUNTRY_OF_ORIGIN_ISO_3CHAR_CD = COUNTRY_OF_ORIGIN_ISO_3CHAR_CD;
    }

    public String getPRIME_CTR_VENDOR_FOB_NUM() {
        return PRIME_CTR_VENDOR_FOB_NUM;
    }

    public void setPRIME_CTR_VENDOR_FOB_NUM(String PRIME_CTR_VENDOR_FOB_NUM) {
        this.PRIME_CTR_VENDOR_FOB_NUM = PRIME_CTR_VENDOR_FOB_NUM;
    }

    public String getPRODVEND_GTIN8() {
        return PRODVEND_GTIN8;
    }

    public void setPRODVEND_GTIN8(String PRODVEND_GTIN8) {
        this.PRODVEND_GTIN8 = PRODVEND_GTIN8;
    }

    public String getPRODVEND_GTIN12() {
        return PRODVEND_GTIN12;
    }

    public void setPRODVEND_GTIN12(String PRODVEND_GTIN12) {
        this.PRODVEND_GTIN12 = PRODVEND_GTIN12;
    }

    public String getPRODVEND_GTIN13() {
        return PRODVEND_GTIN13;
    }

    public void setPRODVEND_GTIN13(String PRODVEND_GTIN13) {
        this.PRODVEND_GTIN13 = PRODVEND_GTIN13;
    }

    public String getCTR_PRODUCT_GTIN12() {
        return CTR_PRODUCT_GTIN12;
    }

    public void setCTR_PRODUCT_GTIN12(String CTR_PRODUCT_GTIN12) {
        this.CTR_PRODUCT_GTIN12 = CTR_PRODUCT_GTIN12;
    }

    public String getALTERNATE_CTR_VEND_FOB_NUMBERS() {
        return ALTERNATE_CTR_VEND_FOB_NUMBERS;
    }

    public void setALTERNATE_CTR_VEND_FOB_NUMBERS(String ALTERNATE_CTR_VEND_FOB_NUMBERS) {
        this.ALTERNATE_CTR_VEND_FOB_NUMBERS = ALTERNATE_CTR_VEND_FOB_NUMBERS;
    }

    public String getCTR_PRODUCT_LONG_DESC() {
        return CTR_PRODUCT_LONG_DESC;
    }

    public void setCTR_PRODUCT_LONG_DESC(String CTR_PRODUCT_LONG_DESC) {
        this.CTR_PRODUCT_LONG_DESC = CTR_PRODUCT_LONG_DESC;
    }

    public String getCTR_VE_PRODUCT_DESC() {
        return CTR_VE_PRODUCT_DESC;
    }

    public void setCTR_VE_PRODUCT_DESC(String CTR_VE_PRODUCT_DESC) {
        this.CTR_VE_PRODUCT_DESC = CTR_VE_PRODUCT_DESC;
    }

    public String getVE_STORAGE_CD() {
        return VE_STORAGE_CD;
    }

    public void setVE_STORAGE_CD(String VE_STORAGE_CD) {
        this.VE_STORAGE_CD = VE_STORAGE_CD;
    }

    public String getINNER_PACKAGE_TYPE_CD() {
        return INNER_PACKAGE_TYPE_CD;
    }

    public void setINNER_PACKAGE_TYPE_CD(String INNER_PACKAGE_TYPE_CD) {
        this.INNER_PACKAGE_TYPE_CD = INNER_PACKAGE_TYPE_CD;
    }

    public String getINNER_PACKAGE_CONSUMER_UNIT_QTY() {
        return INNER_PACKAGE_CONSUMER_UNIT_QTY;
    }

    public void setINNER_PACKAGE_CONSUMER_UNIT_QTY(String INNER_PACKAGE_CONSUMER_UNIT_QTY) {
        this.INNER_PACKAGE_CONSUMER_UNIT_QTY = INNER_PACKAGE_CONSUMER_UNIT_QTY;
    }

    public String getOUTER_PACKAGE_DEPTH_CM_QTY() {
        return OUTER_PACKAGE_DEPTH_CM_QTY;
    }

    public void setOUTER_PACKAGE_DEPTH_CM_QTY(String OUTER_PACKAGE_DEPTH_CM_QTY) {
        this.OUTER_PACKAGE_DEPTH_CM_QTY = OUTER_PACKAGE_DEPTH_CM_QTY;
    }

    public String getOUTER_PACKAGE_WIDTH_CM_QTY() {
        return OUTER_PACKAGE_WIDTH_CM_QTY;
    }

    public void setOUTER_PACKAGE_WIDTH_CM_QTY(String OUTER_PACKAGE_WIDTH_CM_QTY) {
        this.OUTER_PACKAGE_WIDTH_CM_QTY = OUTER_PACKAGE_WIDTH_CM_QTY;
    }

    public String getOUTER_PACKAGE_HEIGHT_CM_QTY() {
        return OUTER_PACKAGE_HEIGHT_CM_QTY;
    }

    public void setOUTER_PACKAGE_HEIGHT_CM_QTY(String OUTER_PACKAGE_HEIGHT_CM_QTY) {
        this.OUTER_PACKAGE_HEIGHT_CM_QTY = OUTER_PACKAGE_HEIGHT_CM_QTY;
    }

    public String getIA_BRAND_KEY_NM() {
        return IA_BRAND_KEY_NM;
    }

    public void setIA_BRAND_KEY_NM(String IA_BRAND_KEY_NM) {
        this.IA_BRAND_KEY_NM = IA_BRAND_KEY_NM;
    }

    public String getEXCLUSIVE_CONTENT_FEATURES_IND() {
        return EXCLUSIVE_CONTENT_FEATURES_IND;
    }

    public void setEXCLUSIVE_CONTENT_FEATURES_IND(String EXCLUSIVE_CONTENT_FEATURES_IND) {
        this.EXCLUSIVE_CONTENT_FEATURES_IND = EXCLUSIVE_CONTENT_FEATURES_IND;
    }

    public String getEXCLUSIVE_CONTENT_FEATURES_CD() {
        return EXCLUSIVE_CONTENT_FEATURES_CD;
    }

    public void setEXCLUSIVE_CONTENT_FEATURES_CD(String EXCLUSIVE_CONTENT_FEATURES_CD) {
        this.EXCLUSIVE_CONTENT_FEATURES_CD = EXCLUSIVE_CONTENT_FEATURES_CD;
    }

    public String getVE_FEATURES_BENEFITS_TXT() {
        return VE_FEATURES_BENEFITS_TXT;
    }

    public void setVE_FEATURES_BENEFITS_TXT(String VE_FEATURES_BENEFITS_TXT) {
        this.VE_FEATURES_BENEFITS_TXT = VE_FEATURES_BENEFITS_TXT;
    }

    public String getFEATURES_BENEFITS_DLR_TXT() {
        return FEATURES_BENEFITS_DLR_TXT;
    }

    public void setFEATURES_BENEFITS_DLR_TXT(String FEATURES_BENEFITS_DLR_TXT) {
        this.FEATURES_BENEFITS_DLR_TXT = FEATURES_BENEFITS_DLR_TXT;
    }

    public String getCTR_GOOD_BETTER_BEST_CD() {
        return CTR_GOOD_BETTER_BEST_CD;
    }

    public void setCTR_GOOD_BETTER_BEST_CD(String CTR_GOOD_BETTER_BEST_CD) {
        this.CTR_GOOD_BETTER_BEST_CD = CTR_GOOD_BETTER_BEST_CD;
    }

    public String getMERCH_ASSORTMENT_STYLE_DECISION_CD() {
        return MERCH_ASSORTMENT_STYLE_DECISION_CD;
    }

    public void setMERCH_ASSORTMENT_STYLE_DECISION_CD(String MERCH_ASSORTMENT_STYLE_DECISION_CD) {
        this.MERCH_ASSORTMENT_STYLE_DECISION_CD = MERCH_ASSORTMENT_STYLE_DECISION_CD;
    }

    public String getMERCH_ASSORTMENT_STYLE_DECISION_MAINT_CD() {
        return MERCH_ASSORTMENT_STYLE_DECISION_MAINT_CD;
    }

    public void setMERCH_ASSORTMENT_STYLE_DECISION_MAINT_CD(String MERCH_ASSORTMENT_STYLE_DECISION_MAINT_CD) {
        this.MERCH_ASSORTMENT_STYLE_DECISION_MAINT_CD = MERCH_ASSORTMENT_STYLE_DECISION_MAINT_CD;
    }

    public String getMERCH_ASSORTMENT_STYLE_NAME() {
        return MERCH_ASSORTMENT_STYLE_NAME;
    }

    public void setMERCH_ASSORTMENT_STYLE_NAME(String MERCH_ASSORTMENT_STYLE_NAME) {
        this.MERCH_ASSORTMENT_STYLE_NAME = MERCH_ASSORTMENT_STYLE_NAME;
    }

    public String getIA_PRODUCT_FAMILY_NM() {
        return IA_PRODUCT_FAMILY_NM;
    }

    public void setIA_PRODUCT_FAMILY_NM(String IA_PRODUCT_FAMILY_NM) {
        this.IA_PRODUCT_FAMILY_NM = IA_PRODUCT_FAMILY_NM;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("\n PRODUCT_SBU_LINK", PRODUCT_SBU_LINK)
                .append("\n Parent_ID", Parent_ID)
                .append("\n Object_Type_Name", Object_Type_Name)
                .append("\n GEN_PRODUCT_TYPE_CD", GEN_PRODUCT_TYPE_CD)
                .append("\n CTR_VENDOR_FOB_NUM", CTR_VENDOR_FOB_NUM)
                .append("\n CTR_PRODUCT_NUM", CTR_PRODUCT_NUM)
                .append("\n CTR_PRODUCT_SHORT_DESC", CTR_PRODUCT_SHORT_DESC)
                .append("\n CTR_TEMP_BRAND_CD", CTR_TEMP_BRAND_CD)
                .append("\n CONSUMER_PACKAGE_TYPE_CD", CONSUMER_PACKAGE_TYPE_CD)
                .append("\n OUTER_PACKGAGE_TYPE_CD", OUTER_PACKGAGE_TYPE_CD)
                .append("\n VENDOR_PART_NUM", VENDOR_PART_NUM)
                .append("\n VENDOR_MINIMUM_ORDER_QTY", VENDOR_MINIMUM_ORDER_QTY)
                .append("\n VENDOR_MULTIPLE_ORDER_QTY", VENDOR_MULTIPLE_ORDER_QTY)
                .append("\n PRODUCT_MFR_WARRANTY_CTR_LINK", PRODUCT_MFR_WARRANTY_CTR_LINK)
                .append("\n MERCH_FINELINE_BUS_CD", MERCH_FINELINE_BUS_CD)
                .append("\n PRIME_CTR_VENDOR_FOB_NUM", PRIME_CTR_VENDOR_FOB_NUM)
                .append("\n ALTERNATE_CTR_VEND_FOB_NUMBERS", ALTERNATE_CTR_VEND_FOB_NUMBERS)
                .toString();
    }
}
