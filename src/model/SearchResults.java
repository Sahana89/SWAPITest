package model;

import com.google.gson.JsonArray;
/*
    SWAPI API - Star wars API
    This is model class for search results
    It will be used to deserialize and obtain search results from API.
 */
public class SearchResults {
    public int count;
    public JsonArray results;
}
