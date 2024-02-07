package model;

import java.util.Date;
import java.util.List;
/*
    SWAPI API - Star wars API
    This is model class for model.Film
    It will be used to deserialize and obtain film details from API.
 */
public class Film {
    public String title;
    //The attribute does not use camel case in order to allow for gson deserialization from response.
    public int episode_id;
    //The attribute does not use camel case in order to allow for gson deserialization from response.
    String opening_crawl;
    public String director;
    String producer;
    //The attribute does not use camel case in order to allow for gson deserialization from response.
    Date release_date;
    List<String> species;
    List<String> starships;
    List<String> vehicles;
    List<String> characters;
    public List<String> planets;
    String url;
    String created;
    String edited;
}
