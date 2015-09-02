package com.ean.client.v3.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.ean.client.v3.domain.BaseRequest;

public class EanUtil {

    public static String generateSigParam(String apiKey, String secretKey) {
        if (secretKey == null) {
            return null;
        }
        String sig = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            long timeInSeconds = (System.currentTimeMillis() / 1000);
            System.out.println("timeInSec=" + timeInSeconds);
            String input = apiKey + secretKey + timeInSeconds;
            md.update(input.getBytes());
            sig = String.format("%032x", new BigInteger(1, md.digest()));
        } catch (NoSuchAlgorithmException nse) {
            nse.printStackTrace();
        }
        return sig;
    }

    public static void setStandardRequestParams(BaseRequest baseRequest, int cid, int minorRev,
            String apiKey, String secretKey) {
        baseRequest.setCid(cid);
        baseRequest.setApiKey(apiKey);
        baseRequest.setSig(EanUtil.generateSigParam(apiKey, secretKey));
        baseRequest.setMinorRev(minorRev);
        baseRequest.setTest(false);
        baseRequest.setDebug(false);
    }

}
