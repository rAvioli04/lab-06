package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* This is a class that keeps track of a list of city objects
*/
public class CityList {
    private List<City> cities = new ArrayList<>();
    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This finds if the list of cities has a certain city
     * @param city the city to compare against the list
     * @return boolean
     */

    public boolean hasCity(City city){
        for(int i = 0; i < cities.size(); i++){
            if(cities.get(i).compareTo(city) == 0){
                return true;
            }else return false;
        }
        return false;
    }

    /**
     * This finds whether the list has a city and if it can delete it
     * @param city the city to delete from the list
     * @return nothin
     */

    public void deleteCity(City city){
        if(hasCity(city)){
            cities.remove(city);
        }else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * A function to get the size of cities
     * @return cities.size() the size of cities
     */

    public int cityCount(){
        return cities.size();
    }
}
