package com.example.demo.decimal;

import jakarta.persistence.*;
import org.slf4j.*;
import org.springframework.stereotype.*;

import java.text.*;
import java.util.*;

@Service
public class StoredProc {


    private String timestamp;

    private static final Logger logger = LoggerFactory.getLogger(StoredProc.class);

    @PersistenceContext
    private EntityManager entityManager;

    public int saveRequest(String request, String aofId, String processName) {

        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        //"login" this is the name of your procedure
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_INS_ONLINE_TXN_HIST");

        //Declare the parameters in the same order
        for (int i = 1; i < 16; i++) {
            query.registerStoredProcedureParameter(i, String.class, ParameterMode.IN);
        }
        query.registerStoredProcedureParameter(16, Integer.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter(17, String.class, ParameterMode.OUT);

        //Pass the parameter values
        query.setParameter(1, aofId);
        query.setParameter(2, aofId);
        query.setParameter(3, aofId);
        query.setParameter(4, "");
        query.setParameter(5, "");
        query.setParameter(6, "");
        query.setParameter(7, "");
        query.setParameter(8, processName);
        query.setParameter(9, processName);
        query.setParameter(10, timestamp);
        query.setParameter(11, "");
        query.setParameter(12, request);
        query.setParameter(13, request);
        query.setParameter(14, "BANDHAN-5K2ZJU5JWE");
        query.setParameter(15, "BANDHAN_WEB-YF4UOFS4T3");

        //Execute query
        query.execute();

        //Get output parameters
        logger.info("request saved (SP_INS_ONLINE_TXN_HIST)");
        return (int) query.getOutputParameterValue(16);
    }

    public void saveResponse(String response, int processId, String statusCode, String statusCodeValue) {

        timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        //"login" this is the name of your procedure
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_UPD_ONLINE_TXN_HIST");

        //Declare the parameters in the same order
        query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
        for (int i = 2; i < 11; i++) {
            query.registerStoredProcedureParameter(i, String.class, ParameterMode.IN);
        }

        //Pass the parameter values
        query.setParameter(1, processId);
        query.setParameter(2, statusCodeValue);
        query.setParameter(3, "");
        query.setParameter(4, statusCode);
        query.setParameter(5, "");
        query.setParameter(6, "");
        query.setParameter(7, response);
        query.setParameter(8, response);
        query.setParameter(9, "");
        query.setParameter(10, timestamp);

        //Execute query
        query.execute();
        logger.info("response saved (SP_UPD_ONLINE_TXN_HIST)");
    }

  /*  public int saveRequest(String request, String aofId, String processName) {
        logger.info("save request");
        return 111;
    }

    public void saveResponse(String response, int processId, String statusCode, String statusCodeValue) {
        logger.info("save response");
    }
*/

    public void saveEODFlag(String eodElag) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_UPD_CHECK_EOD_STATUS");
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.setParameter(1, eodElag);
        query.execute();
    }

    public void saveAccountDetails(String aofId, String customerId, String accountId) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_UPD_CRN_ACCOUNT_DTL");

        for (int i = 1; i < 4; i++) {
            query.registerStoredProcedureParameter(i, String.class, ParameterMode.IN);
        }


        query.setParameter(1, aofId);
        query.setParameter(1, customerId);
        query.setParameter(1, accountId);

        query.execute();
    }

    public void saveJSONDisposition(String aofId, String apiName, String apiNameFE, String STATUS, String customerID, String acctNo, String apiResMsg) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_JSON_PRC_GRP_DISP");


        for (int i = 1; i < 18; i++) {
            query.registerStoredProcedureParameter(i, String.class, ParameterMode.IN);
        }

        //Pass the parameter values
        query.setParameter(1, aofId);
        query.setParameter(2, apiName);
        query.setParameter(3, "");
        query.setParameter(4, aofId);
        query.setParameter(5, aofId);
        query.setParameter(6, aofId);
        query.setParameter(7, "");
        query.setParameter(8, "");
        query.setParameter(9, apiNameFE);
        query.setParameter(10, STATUS);
        query.setParameter(11, "");
        query.setParameter(12, "");
        query.setParameter(13, customerID);
        query.setParameter(14, acctNo);
        query.setParameter(15, "");
        query.setParameter(16, "");
        query.setParameter(17, apiResMsg);

        query.execute();
    }

}

