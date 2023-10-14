package com.example.demo;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * the util class for XML
 */
public class XMLUtil {

    private static final String XSLT_FILENAME = "src/main/resources/sak.xslt";

    /**
     * @param xmlString the xml string
     * @return xml string with xslt applied
     */
    public static StringWriter applyXSLT(String xmlString) {
        StringWriter stringWriter = new StringWriter();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try (InputStream is = new ByteArrayInputStream(xmlString.getBytes())) {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(is);
            transform(doc, stringWriter);
        } catch (IOException | ParserConfigurationException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
        return stringWriter;
    }

    /**
     * @param doc the Document obj
     * @param stringWriter to store xml string after xslt is applied
     * @throws TransformerException if exception occurred
     */
    private static void transform(Document doc, StringWriter stringWriter) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        // add XSLT in Transformer
        Transformer transformer = transformerFactory.newTransformer(new StreamSource(new File(XSLT_FILENAME)));
        transformer.transform(new DOMSource(doc), new StreamResult(stringWriter));

    }

}