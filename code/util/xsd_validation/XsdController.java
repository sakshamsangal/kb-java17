package com.example.demo.xsd_validation;

import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.*;

import java.io.*;
import java.util.*;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class XsdController {

    private static final String BAELDUNG_XML_PATH = "xml/validation/baeldung.xml";
    private static final String PERSON_XSD_PATH = "xml/validation/person.xsd";
    private static final String XSD_PATH = "xml/validation/full-person.xsd";

    // @PostMapping("/users")
    // public ResponseEntity<PenResponse> postUser(@RequestBody Pen pen) {
    //     return ResponseEntity.ok()
    //             .header("Custom-Header", "foo")
    //             .body(null);
    // }

    @GetMapping("/xsd")
    ResponseEntity<String> age() throws IOException, SAXException {
        List<String> errorMsg = new XmlValidator(XSD_PATH, BAELDUNG_XML_PATH).listParsingExceptions();
        if (errorMsg.size() != 0) {
            throw new XSDValidationFailed(errorMsg);
        }
        return ResponseEntity.ok()
                .body("Custom header set");
    }


}