package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;

class XMLUtilTest {

    @Test
    void test() {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<note>\n" +
                "    <to>sak</to>\n" +
                "    <to>       </to>\n" +
                "    <from>\n" +
                "        <note>\n" +
                "            <to>Tove</to>\n" +
                "            <from/>\n" +
                "            <from    />\n" +
                "            <heading />\n" +
                "            <body>Don't forget me this weekend!</body>\n" +
                "        </note>\n" +
                "    </from>\n" +
                "    <heading/>\n" +
                "    <body>Don't forget me this weekend!</body>\n" +
                "</note>";

        StringWriter stringWriter = XMLUtil.applyXSLT(str);
        Assertions.assertFalse(stringWriter.toString().contains("<from/>"));
    }

}