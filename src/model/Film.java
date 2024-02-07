package model;

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
    public String director;
    public List<String> planets;
}
