package com.example.demo.xsd_validation;


import org.slf4j.*;
import org.springframework.core.io.*;
import org.xml.sax.*;

import javax.xml.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.validation.*;
import java.io.*;
import java.util.*;

public class XmlValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlValidator.class);

    private final String xsdPath;
    private final ByteArrayResource byteArrayResource;

    public XmlValidator(String xsdPath, String xmlString) {
        this.xsdPath = xsdPath;
        this.byteArrayResource = new ByteArrayResource(xmlString.getBytes()) {
            @Override
            public String getFilename() {
                return "temp.xml";
            }
        };
    }

    public boolean isValid() throws IOException, SAXException {
        Validator validator = initValidator(xsdPath);
        try {
            validator.validate(new StreamSource(byteArrayResource.getInputStream()));
            return true;
        } catch (SAXException e) {
            return false;
        }
    }

    public List<String> listParsingExceptions() throws IOException, SAXException {
        XmlErrorHandler xsdErrorHandler = new XmlErrorHandler();
        Validator validator = initValidator(xsdPath);
        validator.setErrorHandler(xsdErrorHandler);
        try {
            validator.validate(new StreamSource(byteArrayResource.getInputStream()));
        } catch (SAXParseException e) {}
        ArrayList<String> msg = new ArrayList<>();
        xsdErrorHandler.getExceptions().forEach(e -> {
            msg.add(e.getMessage());
            LOGGER.info(e.getMessage());
        });
        return msg;
    }

    private Validator initValidator(String xsdPath) throws SAXException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(getFile(xsdPath));
        Schema schema = factory.newSchema(schemaFile);
        return schema.newValidator();
    }

    private File getFile(String location) {
        return new File(getClass().getClassLoader().getResource(location).getFile());
    }

}