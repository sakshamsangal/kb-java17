package com.example.demo.decimal;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

import java.text.*;

@Service
public class PanPayload {

    @Value("${pan.nsdl.mock}")
    private boolean mock;

    @Value("${pan.nsdl.request}")
    private String request;

    @Value("${pan.nsdl.response}")
    private String response;

    @Value("${pan.nsdl.endpoint}")
    private String endpoint;

    private final Payload payload;

    public PanPayload(Payload payload) {
        this.payload = payload;
    }

    public Payload create(String panNumber) {
        // Object[] arr = {panNumber};
        payload.setApiName("PAN_NSDL");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        payload.setHttpHeaders(headers);

        payload.setRequest(MessageFormat.format(request, panNumber));
        payload.setResponse(response);
        payload.setMock(mock);
        payload.setEndpoint(endpoint);
        return payload;
    }

}
