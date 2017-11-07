/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2powerd.BE;

/**
 *
 * @author ddose
 */
public class Company
{

    private int id;
    private String name;
    private String country;
    private String address;
    private String website;
    private double lat;
    private double lng;
    private int isSME;

    public Company(int id, String name, String country, String address, String website, double lat, double lng, int isSME) //Constructer
    {
        this.id = id;  //refrence to id above
        this.name = name;
        this.country = country;
        this.address = address;
        this.website = website;
        this.lat = lat;
        this.lng = lng;
        this.isSME = isSME;
    }

    /**
     * Get the value of isSME
     *
     * @return the value of isSME
     */
    public int getIsSME()
    {
        return isSME;
    }

    /**
     * Set the value of isSME
     *
     * @param isSME new value of isSME
     */
    public void setIsSME(int isSME)
    {
        this.isSME = isSME;
    }

    /**
     * Get the value of lng
     *
     * @return the value of lng
     */
    public double getLng()
    {
        return lng;
    }

    /**
     * Set the value of lng
     *
     * @param lng new value of lng
     */
    public void setLng(double lng)
    {
        this.lng = lng;
    }

    /**
     * Get the value of lat
     *
     * @return the value of lat
     */
    public double getLat()
    {
        return lat;
    }

    /**
     * Set the value of lat
     *
     * @param lat new value of lat
     */
    public void setLat(double lat)
    {
        this.lat = lat;
    }

    /**
     * Get the value of website
     *
     * @return the value of website
     */
    public String getWebsite()
    {
        return website;
    }

    /**
     * Set the value of website
     *
     * @param website new value of website
     */
    public void setWebsite(String website)
    {
        this.website = website;
    }

    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * Get the value of country
     *
     * @return the value of country
     */
    public String getCountry()
    {
        return country;
    }

    /**
     * Set the value of country
     *
     * @param country new value of country
     */
    public void setCountry(String country)
    {
        this.country = country;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id)
    {
        this.id = id;
    }

}
