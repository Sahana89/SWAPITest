import com.google.gson.JsonElement;
import model.Film;
import model.SearchResults;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

/*
    SWAPI API - Star wars API
    This class contains all the tests for API call.
    It uses Junit to make assertions.
    The expected output has been defined locally within each test method.
    Term here refers to different object information such as people, vehicle, film, planet etc from star wars universe.
    Source of truth for expected output is from the website here: https://swapi.dev/
 */
public class APICallTest {
    //The API class which makes the call to the SWAPI API.
    APICall apiCall = new APICall();
    //The Utility class to convert response from API and also convert strings to URL.
    private static final APICallUtils APICALL_UTILS = new APICallUtils();

    /*
    This test method makes the API call with BASE URL for SWAPI API.
    Expected output: 6 count of different API terms
    Parameters Term: empty
    Parameters Search Term: empty
    */
    @Test
    public void countAllAPITest(){
        Map<String, JsonElement> returnedResponse = APICALL_UTILS.convertResponseBody(apiCall
                .getResponseForUrl("", ""));
        int expected = 6;
        assertEquals(expected,returnedResponse.size());
    }

    /*
    This test method makes the API call with incorrect term.
    Expected output: Throws RuntimeException.
    Parameters Term: 123
    Parameters Search Term: empty
    */
    @Test
    public void invalidUrlTest(){
        String urlTerm = "123";
        assertThrows(RuntimeException.class, () -> APICALL_UTILS.convertResponseBody(apiCall
                .getResponseForUrl(urlTerm, "")));
    }

    /*
    This test method makes the API call to search for people with incorrect search term.
    Expected output: Returns empty search results.
    Parameters Term: people
    Parameters Search Term: A new hope
    */
    @Test
    public void searchReturnsEmptyResultsForIncorrectSearchTerm(){
        String urlTerm = "people";
        String searchTerm = "A new hope";
        SearchResults searchResults = APICALL_UTILS.deserializeSearchResults(apiCall
                .getResponseForUrl(urlTerm, searchTerm));
        assertEquals(searchResults.count,0);
        assertTrue(searchResults.results.isEmpty());
    }

    /*
    This test method makes the API call to search for people which returns more than 1 search results.
    Expected output: Returns 3 search results.
    Parameters Term: people
    Parameters Search Term: skywalker
    */
    @Test
    public void searchReturnsMoreThanOneResults(){
        String urlTerm = "people";
        String searchTerm = "skywalker";
        SearchResults searchResults = APICALL_UTILS.deserializeSearchResults(apiCall
                .getResponseForUrl(urlTerm, searchTerm));
        assertEquals(searchResults.count,3);
        assertFalse(searchResults.results.isEmpty());
    }

    /*
    This test method makes the API call to search for people with empty search term
    Expected output: Returns all search results for people.
    Parameters Term: people
    Parameters Search Term: empty
    */
    @Test
    public void searchReturnsAllResultsforEmptySearchTerm() {
        String urlTerm = "people";
        String searchTerm = "";
        SearchResults searchResults = APICALL_UTILS.deserializeSearchResults(apiCall
                .getResponseForUrl(urlTerm, searchTerm));
        assertEquals(searchResults.count,82);
        assertFalse(searchResults.results.isEmpty());
    }

    /*
    This test method makes the API call to film with id =1
    Expected output: Returns a non-empty model.Film object.
    Parameters Term: films/1
    Parameters Search Term: empty
    */
    @Test
    public void getFilmById() {
        String urlTerm = "films/1";
        Film returnedResponse = APICALL_UTILS.deserializeResponseToFilm(apiCall
                .getResponseForUrl(urlTerm, ""));
        assertEquals(returnedResponse.title,"A New Hope");
        assertEquals(returnedResponse.episode_id,4);
        assertEquals(returnedResponse.director,"George Lucas");
        final List<String> planets = new ArrayList<>(Arrays.asList("https://swapi.dev/api/planets/1/",
                "https://swapi.dev/api/planets/2/",
                "https://swapi.dev/api/planets/3/"));
        assertEquals(returnedResponse.planets,planets);
    }

    /*
    This test method makes the API call to film with id = 72 (Only 60 planets)
    Expected output: Returns Object which contains "Not found"
    Parameters Term: planets/72
    Parameters Search Term: empty
    */
    @Test
    public void getPlanetByUsingIdWhichDoesNotExist() {
        String urlTerm = "planets/72";
        Map<String, JsonElement> returnedResponse = APICALL_UTILS.convertResponseBody(apiCall
                .getResponseForUrl(urlTerm, ""));
        assertTrue(returnedResponse.toString().contains("Not found"));
    }

}