package com.example.demo.decimal;

import com.bandhan.pojo.*;
import org.json.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

import java.text.*;

@Service
public class AccountPayload {

    @Value("${account.mock}")
    private boolean mock;

    @Value("${account.request}")
    private String request;

    @Value("${account.response}")
    private String response;

    @Value("${account.endpoint}")
    private String endpoint;

    private final Payload payload;

    public AccountPayload(Payload payload) {
        this.payload = payload;
    }

    public Payload create(JSONObject aof, JSONObject cifResponse) {

        payload.setApiName("Account_creation");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        payload.setHttpHeaders(headers);

        JSONObject data = aof.getJSONObject("Data");
        JSONObject nomineeDetails = data.getJSONObject("nomineeDetails");
        JSONObject personalDetails = data.getJSONObject("personalDetails");


        Object[] arr = new Object[15];

        arr[0] = "" + cifResponse.getJSONObject("Response").getJSONObject("TransactionStatus").getLong("ExternalReferenceNo");
        arr[1] = "" + cifResponse.getJSONObject("Response").getLong("CustomerID");
        arr[2] = personalDetails.getJSONObject("branch").getString("code");
        arr[3] = personalDetails.getJSONObject("debitCard").getString("code");
        arr[4] = personalDetails.getJSONObject("name").getString("fullName");
        arr[5] = nomineeDetails.getString("name");
        arr[6] = nomineeDetails.getString("dob");
        arr[7] = nomineeDetails.getString("relation");
        arr[8] = nomineeDetails.getJSONObject("address").getString("addressLine1");
        arr[9] = nomineeDetails.getJSONObject("address").getString("addressLine2");
        arr[10] = nomineeDetails.getJSONObject("guardianDetails").getString("name");
        arr[11] = nomineeDetails.getJSONObject("guardianDetails").getString("relation");
        arr[12] = nomineeDetails.getJSONObject("guardianDetails").getJSONObject("address").getString("addressLine1");
        arr[13] = nomineeDetails.getJSONObject("guardianDetails").getString("age");
        arr[14] = personalDetails.getJSONObject("leadGeneratorCode").getString("EMP_ID");

        payload.setRequest(MessageFormat.format(request, arr));
        payload.setResponse(this.response);
        payload.setMock(mock);
        payload.setEndpoint(endpoint);
        return payload;
    }

}
