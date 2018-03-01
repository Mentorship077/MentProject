package com.mentProject.gmail.excelparser1.core.model.builder;


import com.mentProject.gmail.excelparser1.core.model.excel.ExcelRowPV;
import com.mentProject.gmail.excelparser1.core.model.pv.Product;

public class ProductBuilder {

    private Product product;
    private ExcelRowPV excelRowPV;

    public ProductBuilder(ExcelRowPV excelRowPV) {
        this.product = new Product();
        this.excelRowPV = excelRowPV;
    }


    public Product build() {
        setGeneralInfo()
                .setProductDesc()
                .setProductTypeInfo()
                .setProductVendorInfo()
                .setProductMerchAssortmentInfo()
                .setProductWarrantyInfo()
                .setProductFeatures();
        return product;
    }


    private ProductBuilder setGeneralInfo() {
        product.setProductSbuLink(excelRowPV.getPRODUCT_SBU_LINK());
        product.setParentId(excelRowPV.getParent_ID());
        product.setObjectTypeName(excelRowPV.getObject_Type_Name());

        product.setCtrProductNum(excelRowPV.getCTR_PRODUCT_NUM());

        product.setCtrTempBrandCd(excelRowPV.getCTR_TEMP_BRAND_CD());
        product.setCtrProductGtin12(excelRowPV.getCTR_PRODUCT_GTIN12());

        return this;
    }


    private ProductBuilder setProductDesc() {
        product.setCtrProductShortDesc(excelRowPV.getCTR_PRODUCT_SHORT_DESC());
        product.setCtrProductLongDesc(excelRowPV.getCTR_PRODUCT_LONG_DESC());
        return this;
    }


    private ProductBuilder setProductTypeInfo() {
        product.setGenProductTypeCd(excelRowPV.getGEN_PRODUCT_TYPE_CD());
        product.setCardTypeCd(excelRowPV.getCARD_TYPE_CD());
        product.setPopFixtureTypeLov(excelRowPV.getPOP_FIXTURE_TYPE_LOV());
        product.setPromotionProdTypeLov(excelRowPV.getPROMOTION_PROD_TYPE_LOV());
        product.setServicesTypeLov(excelRowPV.getSERVICES_TYPE_LOV());
        product.setProductTypeImsCd(excelRowPV.getPRODUCT_TYPE_IMS_CD());
        return this;
    }


    private ProductBuilder setProductVendorInfo() {
        product.setPrimeCtrVendorFobNum(excelRowPV.getPRIME_CTR_VENDOR_FOB_NUM());
        product.setAlternateCtrVendFobNumbers(excelRowPV.getALTERNATE_CTR_VEND_FOB_NUMBERS());
        return this;
    }


    private ProductBuilder setProductMerchAssortmentInfo() {
        product.setMerchFinelineBusCd(excelRowPV.getMERCH_FINELINE_BUS_CD());
        product.setMerchAssortmentStyleDecisionCd(excelRowPV.getMERCH_ASSORTMENT_STYLE_DECISION_CD());
        product.setMerchAssortmentStyleDecisionMaintCd(excelRowPV.getMERCH_ASSORTMENT_STYLE_DECISION_MAINT_CD());
        product.setMerchAssortmentStyleName(excelRowPV.getMERCH_ASSORTMENT_STYLE_NAME());

        return this;
    }


    private ProductBuilder setProductWarrantyInfo() {
        product.setWarrantyServiceLetterInd(excelRowPV.getWARRANTY_SERVICE_LETTER_IND());
        product.setReturnPolicyPeriodCd(excelRowPV.getRETURN_POLICY_PERIOD_CD());
        product.setWarrantyRedirectInd(excelRowPV.getWARRANTY_REDIRECT_IND());
        product.setMultiLevelWarrantyInd(excelRowPV.getMULTI_LEVEL_WARRANTY_IND());
        return this;
    }


    private ProductBuilder setProductFeatures() {
        product.setFeaturesBenefitsDlrTxt(excelRowPV.getFEATURES_BENEFITS_DLR_TXT());
        product.setCtrGoodBetterBestCd(excelRowPV.getCTR_GOOD_BETTER_BEST_CD());
        return this;
    }
}
