// Assignment: 8 
// Name: Dean Prach
// StudentID: 1222694057
// Lecture: MWF 10:10 - 11:00
// Description: The Hotel class creates the hotel object which has variables: hotelName, stars, review, priceRange, location, and hotelType

import java.util.ArrayList;
import java.io.Serializable;
public class Hotel implements Serializable
{
    private long serialVersionUID = 205L;
    private String hotelName;
    private int stars;
    private String review;
    private int priceRange;
    private String location;
    private HotelType hotelType;
    public Hotel(String hotelName, int stars, String review, int priceRange, String location, HotelType hotelType)
    {
        this.hotelName = hotelName;
        this.stars = stars;
        this.review = review;
        this.priceRange = priceRange;
        this.location = location;
        this.hotelType = hotelType;
    }

    public String getHotelName()
    {
        return hotelName;
    }
    public int getStars()
    {
        return stars;
    }
    public int getPriceRange()
    {
        return priceRange;
    }
    public String getLocation()
    {
        return location;
    }
    public String getReview()
    {
        return review;
    }
    public HotelType getHotelType()
    {
        return hotelType;
    }
    public String toString()
    {
        String starString = "";
        String priceString = "";
        for(int i = 0; i < stars; i++)
        {
            starString += "*";
        }
        for(int j = 0; j < priceRange; j++)
        {
            priceString += "$";
        }
        return(hotelName + " hotel\n" + starString + "\t\t" + priceString + "\n" + hotelType.toString() + "Location: " + location + "\n" + "Review:\t" + review + "\n\n");

    }
}

