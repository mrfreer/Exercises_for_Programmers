package com.company;

/**
 * Created by David on 2/3/2017.
 */
//they ended their public API.
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class FandangoApiManager {

    public static FandangoApiResultDelegate delegate = null;

    protected static String sha256Encode(String StringToEncode) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] buffUtf8Msg = digest.digest(StringToEncode.getBytes());
        String result = String.format("%0" + (buffUtf8Msg.length*2) + "X", new BigInteger(1, buffUtf8Msg));

        return result;
    }

    protected static String buildAuthorizationParameters(String apiKey, String sharedSecret) throws NoSuchAlgorithmException {

        long seconds =  System.currentTimeMillis() / 1000;
        String paramsToEncode = apiKey + sharedSecret + seconds;
        String encodedParams = sha256Encode(paramsToEncode);

        String result = String.format("api_key=%s&sig=%s", apiKey, encodedParams);

        return result;
    }

    protected static String getResponse(String parameters) {

        String baseUri = "http://api.fandango.com";
        String apiVersion = "1";

        // Use your account-specific values here
        String apiKey ;
        String sharedSecret;

        String result = null;

        try {

            String authorizationParameters = buildAuthorizationParameters(apiKey, sharedSecret);
            String requestUri = String.format("%s/v%s/?%s&%s", baseUri, apiVersion, parameters, authorizationParameters);
            System.out.println(requestUri + " oh");
            URL url = new URL(requestUri);
            InputStream is = url.openStream();
            InputStreamReader ir = new InputStreamReader(is);
            result = SpaceDirectory.readAll(ir);
        } catch (Exception e) {

            e.printStackTrace();
        }

        return result;
    }

    public void getApiData() {

        FandangoApiManager api = new FandangoApiManager();
        //api.delegate = this; // Be sure to implement "FandangoApiResultDelegate" in your activity declaration

    String zipCode = "33186";
        String parameters = String.format("op=theatersbypostalcodesearch&postalcode=%s", zipCode);

        //api.execute(parameters);
    }

    public static void main(String[] args) {
        FandangoApiManager api = new FandangoApiManager();
        //api.delegate = this;

        String zipCode = "33186";
        String toSearch = String.format("op=theatersbypostalcodesearch&postalcode=%s", zipCode);
        String r = getResponse(toSearch);
        System.out.println(r);
    }


}