package com.app.flow;

import java.util.List;

public class Sample7_58_29 {

    public static void main(String[] args) {
        ap();
    }

    public static void ap() {
        // onboarded legal entity
        List<Object> rec = Db.getListOfObject();

        for (Object o : rec) {

            // for which ap flow is applicable
            if (true) {

                // SAP / ORACLE
                String erp = Util.getERP();

                // all document api
                List<Object> docs = ThirdParty.consumeGetJson();

                for (Object doc : docs) {
                    Db.addEntry(); // doc

                    try {
                        // target xml api
                        ThirdParty.consumeGetXML();
                    } catch (Exception e) {
                        Db.update(); // ERR, TARGET_XML_FETCH_FAILED
                        Db.addEntry(); // history table
                        throw new RuntimeException(e);
                    }

                    Util.xmlToJson();
                    Db.update();
                    S3.save();
                }

            }
        }
    }


    public void submitApi() {
        Db.addEntry();
        
    }
}
