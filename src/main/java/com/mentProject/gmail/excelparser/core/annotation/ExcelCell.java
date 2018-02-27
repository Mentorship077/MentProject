package com.mentProject.gmail.excelparser.core.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface ExcelCell {

    //    column index
    int value();
}
