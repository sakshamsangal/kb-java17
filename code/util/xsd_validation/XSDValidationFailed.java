package com.example.demo.xsd_validation;

import java.util.*;

public class XSDValidationFailed extends IllegalArgumentException {
    private final List<String> msg;

    public XSDValidationFailed(List<String> msg) {
        this.msg = msg;
    }

    public List<String> getMsg() {
        return msg;
    }

}