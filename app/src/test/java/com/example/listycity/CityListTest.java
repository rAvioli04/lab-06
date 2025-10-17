package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }



    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testHasCityTrue(){
        CityList cityList = mockCityList();
        City city2 = new City("Edmonton", "Alberta");
        cityList.add(city2);
        assertEquals(true, cityList.hasCity(city2));
    }

    @Test
    void testHasCityFalse(){
        CityList cityList = mockCityList();
        City city2 = new City("Edmontonon", "Alberta");
        cityList.add(city2);
        assertEquals(false, cityList.hasCity(city2));
    }

    @Test
    void testSize(){
        CityList cityList = mockCityList();
        City city1 = new City("Edmonton", "Alberta");
        City city2 = new City("Edmontonon", "Alberta");
        City city3 = new City("Edmontononon", "Alberta");
        City city4 = new City("Edmontonononon", "Alberta");
        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);
        cityList.add(city4);
        assertEquals(5,cityList.cityCount());
        //expected is 5 because we need to account for the inital add of mock city
    }

    @Test
    void testDeleteValid(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city1 = new City("Calgary", "Alberta");
        cityList.add(city1);
        assertEquals(2, cityList.getCities().size());
        cityList.deleteCity(city1);
        assertEquals(false, cityList.hasCity(city1));
    }

    @Test
    void testDeleteInvalid(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city1 = new City("Calgary", "Alberta");
        cityList.add(city1);
        assertEquals(2, cityList.getCities().size());
        cityList.deleteCity(city1);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(city1);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
}
