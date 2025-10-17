package com.example.listycity;

public class City implements Comparable<City>{
    private String city;
    private String province;
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * This method sets the province
     *
     * @return nothing
     */

    public String getCity() {
        return city;
    }

    /**
     * This method sets the province
     * @param city, the var modified
     * @return nothing
     */

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * This method sets the province
     *
     * @return nothing
     */

    public String getProvince() {
        return province;
    }

    /**
     * This method sets the province
     * @param province, the var modified
     * @return nothing
     */

    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * This methods compares a given city to another
     * @param o the object to be compared.
     * @return 0, <1 or >1 if two values are equal
     */

    @Override
    public int compareTo(City o) {
        //City city = (City) o;
        return this.city.compareTo(o.getCity());
    }
}
