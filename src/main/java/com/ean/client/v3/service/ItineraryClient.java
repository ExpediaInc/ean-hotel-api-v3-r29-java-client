package com.ean.client.v3.service;

import javax.ws.rs.core.MediaType;

import com.ean.client.v3.domain.HotelItineraryRequest;
import com.ean.client.v3.domain.HotelItineraryResponse;
import com.ean.client.v3.util.EanUtil;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.spi.resource.Singleton;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Http client to call v3 itinerary.
 */
@Singleton
public class ItineraryClient {

    private static final Log LOG = LogFactory.getLog(ItineraryClient.class);
    private static final ItineraryClient INSTANCE = new ItineraryClient();
    private static final String V3_ITINERARY_URL
        = "http://%s:%s/ean-services/rs/hotel/v3/itin?cid=%s&apiKey=%s&sig=%s&itineraryId=%s&email=%s&apiExperience=%s";
    //private static final String V3_ITINERARY_HOSTNAME = "book.api.ean.com";
    private static final String V3_ITINERARY_HOSTNAME = "pheltsvccore001.karmalab.net";
    //private static final String V3_ITINERARY_PORT = "80";
    private static final String V3_ITINERARY_PORT = "7400";
    private static final String CID = "354165";
    private static final String API_KEY = "p9ycn9cxb2zp3k3gfvbf5aym";
    private static final String SECRET_KEY = "QGyYzaSp";
    private static final int V3_API_CONNECTION_TIMEOUT = 5000;
    private static final int V3_API_REQUEST_TIMEOUT = 120000;
    private static final String HEADER_TRANSACTION_ID = "Transaction-Id";
    private static Client client;

    private ItineraryClient() {
        initializeClient();
    }

    private void initializeClient() {
        final ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(
            JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        clientConfig.getClasses().add(ObjectMapperProvider.class);
        client = Client.create(clientConfig);
        client.setConnectTimeout(V3_API_CONNECTION_TIMEOUT);
        client.setReadTimeout(V3_API_REQUEST_TIMEOUT);
    }

    /**
     * Gets the instance of ItineraryClient
     *
     * @return Instance of ItineraryClient
     */
    public static ItineraryClient getInstance() {
        return INSTANCE;
    }

    /**
     * Requests itinerary information.
     *
     */
    public HotelItineraryResponse getItinerary(HotelItineraryRequest hotelItineraryRequest) {
        try {
            String url = createServiceUrl(hotelItineraryRequest);
            System.out.println("url=" + url);
            final WebResource webResource = client.resource(url);
            final ClientResponse clientResponse = sendGetRequest(hotelItineraryRequest, webResource);

            return clientResponse.getEntity(HotelItineraryResponse.class);
        } catch (ClientHandlerException | UniformInterfaceException ex) {
            LOG.error("Unable to communicate with v3 itinerary service", ex);
            throw ex;
        }
    }

    private ClientResponse sendGetRequest(final HotelItineraryRequest request, final WebResource webResource) {
        return webResource.type(MediaType.APPLICATION_JSON_TYPE)
            .header(HEADER_TRANSACTION_ID, request.getTransactionId())
            .header("True-Client-IP", "172.30.143.207")
            .get(ClientResponse.class);
    }

    private String createServiceUrl(final HotelItineraryRequest request) {
        String apiSignature = null; //EanUtil.generateSigParam(API_KEY, SECRET_KEY);
        return String.format(V3_ITINERARY_URL, V3_ITINERARY_HOSTNAME,
            V3_ITINERARY_PORT, CID, API_KEY, apiSignature, request.getItineraryId(), request.getEmail(), request.getApiExperience());
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
