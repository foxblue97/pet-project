package com.product.viewmodel.errorvm;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record ErrorVm(String code, String title, String details, List<String> fieldErrors) {

    public ErrorVm(String code, String title, String details) {
        this(code,title,details,new ArrayList<>());
    }
    public ErrorVm(String code, String title, String details,String error) {
        this(code,title,details,List.of(error));
    }
}
