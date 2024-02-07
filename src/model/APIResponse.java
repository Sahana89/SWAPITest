package model;

/*
    SWAPI API - Star wars API
    This is model class for API Response for SWAPI calls.
    It will be used to deserialize and obtain API response.
    It is custom defined Object with status code and response body attributes.
 */
public class APIResponse {
    public int statusCode;
    public String responseBody;
}
