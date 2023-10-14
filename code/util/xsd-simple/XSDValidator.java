package com.example;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class XSDValidator {
    public static void main(String[] args) {
        String xmlFilePath = "src/main/resources/books.xml";
        String xsdFilePath = "src/main/resources/books.xsd";
        boolean isValid = validateXMLSchema(xmlFilePath, xsdFilePath);
        if (isValid) {
            System.out.println("XML is valid against XSD.");
        } else {
            System.out.println("XML is not valid against XSD.");
        }
    }

    public static boolean validateXMLSchema(String xmlFilePath, String xsdFilePath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdFilePath));
            Validator validator = schema.newValidator();
            validator.setErrorHandler(new XsdValidationErrorHandler()); // Set custom error handler
            validator.validate(new StreamSource(new File(xmlFilePath)));
            return true; // XML is valid
        } catch (IOException | SAXException e) {
            e.printStackTrace();
            return false; // XML is not valid
        }
    }

    static class XsdValidationErrorHandler implements org.xml.sax.ErrorHandler {
        public void warning(org.xml.sax.SAXParseException exception) throws SAXException {
            System.out.println("Warning: " + exception.getMessage());
        }

        public void error(org.xml.sax.SAXParseException exception) throws SAXException {
            System.out.println("Error: " + exception.getMessage());
        }

        public void fatalError(org.xml.sax.SAXParseException exception) throws SAXException {
            System.out.println("Fatal Error: " + exception.getMessage());
        }
    }
}
