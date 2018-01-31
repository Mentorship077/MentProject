package com.mentProject.gmail.fileReader;

public interface KeywordAbstractParser {
    // excel properties
    String KEYWORDS_XLSX_PATH = "keywords.xlsx";
    String USER_SHEET = "keywords";

    String getBrowserName();

    String getEnterURL();
}
