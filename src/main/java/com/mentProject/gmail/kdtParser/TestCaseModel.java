package com.mentProject.gmail.kdtParser;

public class TestCaseModel {
    private String tesTestCase;
    private String step;
    private String keyword;
    private String operation;
    private String dataSet;
    private String description;
    private String result;


    boolean emptyAllFields() {
        return getTesTestCase().isEmpty() && getStep().isEmpty() &&
                getKeyword().isEmpty() && getOperation().isEmpty() &&
                getDataSet().isEmpty() && getDescription().isEmpty() && getResult().isEmpty();
    }

    @Override
    public String toString() {
        return "TestCaseModel{" +
                "tesTestCase='" + tesTestCase + '\'' +
                ", step='" + step + '\'' +
                ", keyword='" + keyword + '\'' +
                ", operation='" + operation + '\'' +
                ", dataSet='" + dataSet + '\'' +
                ", description='" + description + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public String getTesTestCase() {
        return tesTestCase;
    }

    public void setTesTestCase(String tesTestCase) {
        this.tesTestCase = tesTestCase;
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
