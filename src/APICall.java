import model.APIResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
/*
    SWAPI API - Star wars API
    This class contains method to make API call to SWAPI API.
    It returns model.APIResponse object.
 */
public class APICall {
    //The Utility class to convert response from API and also convert strings to URL.
    private static final APICallUtils APICALL_UTILS = new APICallUtils();
    /*
    This method creates http client and makes a call to SWAPI API.
    It returns custom object model.APIResponse
    Parameters String term, String searchTerm
    Return: model.APIResponse Object
    */
    public APIResponse getResponseForUrl(final String term, final String searchTerm) {

        final APIResponse apiResponse = new APIResponse();
        final HttpClient httpClient = HttpClient.newHttpClient();
        final HttpRequest request = HttpRequest.newBuilder(APICALL_UTILS.createURL(term, searchTerm)).GET().build();
        try {
            final HttpResponse<InputStream> response = httpClient.send(request,
                    HttpResponse.BodyHandlers.ofInputStream());

            apiResponse.statusCode = response.statusCode();

            final BufferedReader in = new BufferedReader(new InputStreamReader(response.body()));
            String inputLine;
            final StringBuffer responseBody = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                responseBody.append(inputLine);
            }
            apiResponse.responseBody = String.valueOf(responseBody);
            return apiResponse;
        }
        catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
