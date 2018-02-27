package com.mentProject.gmail.excelparser.core.model.excel;


import com.mentProject.gmail.excelparser.core.annotation.ExcelCell;

public class ExcelRowDeleteWorkflow {

    @ExcelCell(0)
    private String id;

    @ExcelCell(1)
    private String errorMessageProduct;

    @ExcelCell(2)
    private String ctrProductNumber;

    @ExcelCell(3)
    private String ctrProductShortDesc;

    @ExcelCell(4)
    private String ctrProductLongDesc;

    @ExcelCell(5)
    private String imsProductStatus;

    @ExcelCell(6)
    private String finelineName;

    @ExcelCell(7)
    private String finelineNumber;

    @ExcelCell(8)
    private String attributeGroupClassification;

    @ExcelCell(9)
    private String currentPrimeProductVendor;

    @ExcelCell(10)
    private String newPrimeCtrFobNumber;

    @ExcelCell(11)
    private String currentStyleName;

    @ExcelCell(12)
    private String currentFamilyName;

    @ExcelCell(13)
    private String familyNameChange;

    @ExcelCell(14)
    private String newStyleDecision;

    @ExcelCell(15)
    private String newStyleName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getErrorMessageProduct() {
        return errorMessageProduct;
    }

    public void setErrorMessageProduct(String errorMessageProduct) {
        this.errorMessageProduct = errorMessageProduct;
    }

    public String getCtrProductNumber() {
        return ctrProductNumber;
    }

    public void setCtrProductNumber(String ctrProductNumber) {
        this.ctrProductNumber = ctrProductNumber;
    }

    public String getCtrProductShortDesc() {
        return ctrProductShortDesc;
    }

    public void setCtrProductShortDesc(String ctrProductShortDesc) {
        this.ctrProductShortDesc = ctrProductShortDesc;
    }

    public String getCtrProductLongDesc() {
        return ctrProductLongDesc;
    }

    public void setCtrProductLongDesc(String ctrProductLongDesc) {
        this.ctrProductLongDesc = ctrProductLongDesc;
    }

    public String getImsProductStatus() {
        return imsProductStatus;
    }

    public void setImsProductStatus(String imsProductStatus) {
        this.imsProductStatus = imsProductStatus;
    }

    public String getFinelineName() {
        return finelineName;
    }

    public void setFinelineName(String finelineName) {
        this.finelineName = finelineName;
    }

    public String getFinelineNumber() {
        return finelineNumber;
    }

    public void setFinelineNumber(String finelineNumber) {
        this.finelineNumber = finelineNumber;
    }

    public String getAttributeGroupClassification() {
        return attributeGroupClassification;
    }

    public void setAttributeGroupClassification(String attributeGroupClassification) {
        this.attributeGroupClassification = attributeGroupClassification;
    }

    public String getCurrentPrimeProductVendor() {
        return currentPrimeProductVendor;
    }

    public void setCurrentPrimeProductVendor(String currentPrimeProductVendor) {
        this.currentPrimeProductVendor = currentPrimeProductVendor;
    }

    public String getNewPrimeCtrFobNumber() {
        return newPrimeCtrFobNumber;
    }

    public void setNewPrimeCtrFobNumber(String newPrimeCtrFobNumber) {
        this.newPrimeCtrFobNumber = newPrimeCtrFobNumber;
    }

    public String getCurrentStyleName() {
        return currentStyleName;
    }

    public void setCurrentStyleName(String currentStyleName) {
        this.currentStyleName = currentStyleName;
    }

    public String getCurrentFamilyName() {
        return currentFamilyName;
    }

    public void setCurrentFamilyName(String currentFamilyName) {
        this.currentFamilyName = currentFamilyName;
    }

    public String getFamilyNameChange() {
        return familyNameChange;
    }

    public void setFamilyNameChange(String familyNameChange) {
        this.familyNameChange = familyNameChange;
    }

    public String getNewStyleDecision() {
        return newStyleDecision;
    }

    public void setNewStyleDecision(String newStyleDecision) {
        this.newStyleDecision = newStyleDecision;
    }

    public String getNewStyleName() {
        return newStyleName;
    }

    public void setNewStyleName(String newStyleName) {
        this.newStyleName = newStyleName;
    }
}
