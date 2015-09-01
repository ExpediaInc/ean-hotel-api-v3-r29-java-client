package com.ean.client.v3.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.ean.client.v3.domain.BaseRequest;

public class EanUtil {
    public final static int MINOR_REV = 30;
	
    public static String generateSigParam(String apiKey, String secretKey) {
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

    public static void setStandardRequestParams(BaseRequest baseRequest, int cid, boolean useSigAuthentication,
            String apiKey, String secretKey) {
        baseRequest.setApiKey(apiKey);
        baseRequest.setSig(EanUtil.generateSigParam(apiKey, secretKey));
        baseRequest.setMinorRev(MINOR_REV);
        baseRequest.setTest(false);
        baseRequest.setDebug(false);
        baseRequest.setCid(cid);
    }

}
