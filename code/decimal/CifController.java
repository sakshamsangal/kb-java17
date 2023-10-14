package com.example.demo.decimal;

import com.bandhan.payload.*;
import com.bandhan.service.*;
import org.json.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CifController {

    private final CifPayload cifPayload;
    private final AccountPayload accountPayload;
    private final ConsumePostAPI consumePostAPI;

    public CifController(CifPayload cifPayload, AccountPayload accountPayload, ConsumePostAPI consumePostAPI) {
        this.cifPayload = cifPayload;
        this.accountPayload = accountPayload;
        this.consumePostAPI = consumePostAPI;
    }


    @PostMapping(value = "/cif", produces = MediaType.APPLICATION_JSON_VALUE)
    public String cif(@RequestBody Map<String, Object> map) throws JSONException {
        // hit the end point
        JSONObject aof = new JSONObject(map).getJSONArray("param").getJSONObject(0).getJSONObject("request").getJSONObject("mainObjectJSON").getJSONObject("AOF");

        JSONObject cifResponse= XML.toJSONObject(consumePostAPI.consumeAndSave(cifPayload.create(aof), aof.getJSONObject("key").getString("aofId")));

        JSONObject accountResponse= XML.toJSONObject(consumePostAPI.consumeAndSave(accountPayload.create(aof, cifResponse), aof.getJSONObject("key").getString("aofId")));

        JSONObject response;
        response = accountResponse.getJSONObject("Response").getJSONObject("TransactionStatus");
        response.put("CustomerID", "" + accountResponse.getJSONObject("Response").getLong("CustomerID"));
        response.put("AccountNumber", "" + accountResponse.getJSONObject("Response").getLong("AccountNumber"));
        return response.toString();
    }
}

