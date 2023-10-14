package com.example.demo.xsd_validation;


import org.xml.sax.*;

import java.util.*;

public class XmlErrorHandler implements ErrorHandler {

    private final List<SAXParseException> exceptions;

    public XmlErrorHandler() {
        this.exceptions = new ArrayList<>();
    }

    public List<SAXParseException> getExceptions() {
        return exceptions;
    }

    @Override
    public void warning(SAXParseException exception) {
        exceptions.add(exception);
    }

    @Override
    public void error(SAXParseException exception) {
        exceptions.add(exception);
    }

    @Override
    public void fatalError(SAXParseException exception) {
        exceptions.add(exception);
    }
}
