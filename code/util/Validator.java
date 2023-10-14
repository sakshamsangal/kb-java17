package com.example.demo;

import org.springframework.stereotype.*;

import java.util.regex.*;


// remove empty lines
// ^$\n
@Component
public class Validator {
    public boolean isValidPan(String panCardNo) {
        String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
        Pattern p = Pattern.compile(regex);
        if (panCardNo == null) return false;
        Matcher m = p.matcher(panCardNo);
        return m.matches();
    }

    public boolean isValidAadhaar(String str) {
        String regex = "^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$";
        if (str == null) return false;
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
