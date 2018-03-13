package com.mentProject.gmail.excelParser.model;

public class TestCaseModel {
    private String testTestCase;
    private String step;
    private String type;
    private String keyword;
    private String operation;
    private String dataSet;
    private String description;
    private String result;


    @Override
    public String toString() {
        return "TestCaseModel{" +
                "testTestCase='" + testTestCase + '\'' +
                ", step='" + step + '\'' +
                ", type='" + type + '\'' +
                ", keyword='" + keyword + '\'' +
                ", operation='" + operation + '\'' +
                ", dataSet='" + dataSet + '\'' +
                ", description='" + description + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

   public boolean isRowEmpty() {
        return getTestTestCase().isEmpty() && getType().isEmpty() && getStep().isEmpty() &&
                getKeyword().isEmpty() && getOperation().isEmpty() &&
                getDataSet().isEmpty() && getDescription().isEmpty() && getResult().isEmpty();
    }

    public boolean isTestCaseCellEmpty() {
        return getTestTestCase().isEmpty();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTestTestCase() {
        return testTestCase;
    }

    public void setTestTestCase(String tesTestCase) {
        this.testTestCase = tesTestCase;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getDataSet() {
        return dataSet;
    }

    public void setDataSet(String dataSet) {
        this.dataSet = dataSet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
