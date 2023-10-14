package com.example.demo.decimal;

import lombok.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

@Component
@Getter
@Setter
public class Payload {
    private String apiName;
    private HttpHeaders httpHeaders;
    private boolean mock;
    private String request;
    private String response;
    private String endpoint;
}
