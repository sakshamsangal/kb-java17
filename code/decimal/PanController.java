package com.example.demo.decimal;

import com.bandhan.payload.*;
import com.bandhan.service.*;
import com.bandhan.util.*;
import org.json.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PanController {

    private final PanPayload panPayload;
    private final PanDedupePayload panDedupePayload;
    private final ConsumePostAPI consumePostAPI;
    private final Validator validator;

    public PanController(PanPayload panPayload, PanDedupePayload panDedupePayload, ConsumePostAPI consumePostAPI, Validator validator) {
        this.panPayload = panPayload;
        this.panDedupePayload = panDedupePayload;
        this.consumePostAPI = consumePostAPI;
        this.validator = validator;
    }

    @PostMapping(value = "/pan", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object panNSDL(@RequestBody Map<String, String> map) throws JSONException {
        JSONObject response = new JSONObject();

        // pan is valid
        if (validator.isValidPan(map.get("panNumber"))) {

            // hit the end point
            JSONObject panResponse = XML.toJSONObject(consumePostAPI.consumeAndSave(panPayload.create(map.get("panNumber")), map.get("aofId")));

            // extracting data from response
            JSONObject panVerificationResponse = panResponse.getJSONObject("PanVerificationResponse");
            JSONObject panDetail = panVerificationResponse.getJSONObject("PanDetails").getJSONObject("PanDetail");

            // no response
            if (panDetail.getString("PAN-Status").equals("")) {
                response.put("PAN_Response", "No data");
            } else {
                response = panDetail;
            }
        } else {
            response.put("PAN_Response", "Please provide valid pan");
        }
        return response.toString();
    }

    @PostMapping(value = "/dedupePan", produces = MediaType.APPLICATION_JSON_VALUE)
    public String dedupePan(@RequestBody Map<String, String> map) throws JSONException {
        String response;

        // pan is valid
        if (validator.isValidPan(map.get("panNumber"))) {

            // hit the end point
            JSONObject panResponse = XML.toJSONObject(consumePostAPI.consumeAndSave(panDedupePayload.create(map.get("panNumber")), map.get("aofId")));

            if (panResponse.isNull("DeDupeEnquiryResp")) {
                response = "{\"Dedupe_PAN_Response\":\"no data\"}";
            } else {
                response = "{\"Dedupe_PAN_Response\":\"Record not found\"}";
            }
        } else {
            response = "{\"Dedupe_PAN_Response\":\"Please provide valid pan\"}";
        }
        return response;
    }
}
