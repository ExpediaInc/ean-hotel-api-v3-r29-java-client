package com.ean.client.v3.service;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ean.client.v3.domain.HotelItineraryRequest;
import com.ean.client.v3.domain.HotelItineraryResponse;
import com.ean.client.v3.util.EanUtil;

import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 * Http client to call v3 itinerary.
 */
@Singleton
public class ItineraryClient {

    private static final Log LOG = LogFactory.getLog(ItineraryClient.class);
    private static final ItineraryClient INSTANCE = new ItineraryClient();
    private static final String V3_ITINERARY_URL
        = "http://%s:%s/ean-services/rs/hotel/v3/itin?cid=%s&minorRev=%s&apiKey=%s&sig=%s&itineraryId=%s&email=%s&apiExperience=%s";
    private static final String V3_MINOR_REV = "30";
    //private static final String V3_ITINERARY_HOSTNAME = "book.api.ean.com";
    //private static final String V3_ITINERARY_PORT = "80";
    private static final String V3_ITINERARY_HOSTNAME = "pheltsvccore001.karmalab.net";
    private static final String V3_ITINERARY_PORT = "7400";
    private static final String CID = "55505";
    private static final String API_KEY = "cbrzfta369qwyrm9t5b8y8kf";
    private static final String SECRET_KEY = "cj9p2mujjlsrs";
    private static final int V3_API_CONNECTION_TIMEOUT = 5000;
    private static final int V3_API_REQUEST_TIMEOUT = 120000;
    private static final String HEADER_TRANSACTION_ID = "Transaction-Id";
    private static Client client;

    private ItineraryClient() {
        initializeClient();
    }

    private void initializeClient() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.property(ClientProperties.CONNECT_TIMEOUT, V3_API_CONNECTION_TIMEOUT);
        clientConfig.property(ClientProperties.READ_TIMEOUT, V3_API_REQUEST_TIMEOUT);
        client = ClientBuilder.newBuilder()
            .withConfig(clientConfig)
            .register(ObjectMapperProvider.class)
            .register(JacksonFeature.class)
            .build();
    }

    /**
     * Gets the instance of ItineraryClient.
     *
     * @return Instance of ItineraryClient.
     */
    public static ItineraryClient getInstance() {
        return INSTANCE;
    }

    /**
     * Requests itinerary information.
     *
     */
    public HotelItineraryResponse getItinerary(HotelItineraryRequest hotelItineraryRequest) {
        HotelItineraryResponse hotelItineraryResponse = null;
        try {
            String url = createServiceUrl(hotelItineraryRequest);
            System.out.println("url=" + url);
            final WebTarget webTarget = client.target(url);

            final Response response = sendGetRequest(hotelItineraryRequest, webTarget);
            LOG.info(response.getStatus());
            //System.out.println(response.readEntity(String.class));

            hotelItineraryResponse = response.readEntity(HotelItineraryResponse.class);
        } catch (Exception ex) {
            LOG.error("Exception calling v3 itinerary service", ex);
            throw ex;
        } finally {
            LOG.info("finished getItinerary; hotelItineraryResponse=" + hotelItineraryResponse);
        }
        return hotelItineraryResponse;
    }

    private Response sendGetRequest(final HotelItineraryRequest request, final WebTarget webTarget) {
        Invocation.Builder invocationBuilder =
            webTarget.request(MediaType.APPLICATION_JSON_TYPE);
        invocationBuilder.header(HEADER_TRANSACTION_ID, request.getTransactionId());
        invocationBuilder.header("True-Client-IP", "172.30.143.207");

        return invocationBuilder.get(); 
    }

    private String createServiceUrl(final HotelItineraryRequest request) {
        String apiSignature = EanUtil.generateSigParam(API_KEY, SECRET_KEY);
        request.setSig(apiSignature);
        return String.format(V3_ITINERARY_URL, V3_ITINERARY_HOSTNAME,
            V3_ITINERARY_PORT, CID, V3_MINOR_REV, API_KEY, apiSignature, request.getItineraryId(),
            request.getEmail(), request.getApiExperience());
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        if (args != null && args.length > 1) {
            String itineraryId = args[0];
            String email = args[1];
            ItineraryClient client = ItineraryClient.getInstance();
            HotelItineraryRequest hotelItineraryRequest = new HotelItineraryRequest();
            hotelItineraryRequest.setApiExperience("PARTNER_MOBILE_APP");
            hotelItineraryRequest.setItineraryId(Long.parseLong(itineraryId));
            hotelItineraryRequest.setEmail(email);
            System.out.println("sending request");
            HotelItineraryResponse response = client.getItinerary(hotelItineraryRequest);
            System.out.println("received response; response=" + response);
        }

    }

}
