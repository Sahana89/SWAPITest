import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import model.APIResponse;
import model.Film;
import model.SearchResults;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
/*
    SWAPI API - Star wars API
    This class contains all the utility methods required to make API call.
 */
public class APICallUtils {
    final Gson gson = new Gson();

    /*
    This method creates a URL for HTTP call to SWAP API. It uses 2 parameters term and search term and BASE url.
    Parameters String term, String searchTerm
    Return: URI object.
    */
    public URI createURL(final String term, final String searchTerm) {
        final String BASE_URL = "https://swapi.dev/api/";
        if (term.isEmpty() || term.isBlank()) {
            return URI.create(BASE_URL);
        }
        if (searchTerm.isBlank() || searchTerm.isEmpty()) {
            final String url = BASE_URL + term;
            return URI.create(url);
        } else {
            final String SEARCH = "search";
            try {
                return new URIBuilder(BASE_URL + term).addParameter(SEARCH, searchTerm)
                        .build();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /*
    This method deserializes API Response body to model.Film Object.
    Parameters model.APIResponse apiResponse
    Return: model.Film object.
    */
    public Film deserializeResponseToFilm(final APIResponse apiResponse) {
        return gson.fromJson(apiResponse.responseBody, Film.class);
    }

    /*
    This method deserializes API Response body to Map of String and JsonElement
    Parameters model.APIResponse apiResponse
    Return: Map<String, JsonElement>
    */
    public Map<String, JsonElement> convertResponseBody(final APIResponse apiResponse) {
        return gson.fromJson(String.valueOf(apiResponse.responseBody), JsonObject.class).asMap();
    }

    /*
    This method deserializes search API Response body to search Results
    Parameters model.APIResponse apiResponse
    Return: model.SearchResults object.
    */
    public SearchResults deserializeSearchResults(final APIResponse apiResponse) {
        return gson.fromJson(apiResponse.responseBody, SearchResults.class);
    }
}
