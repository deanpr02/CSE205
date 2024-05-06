// Assignment: 8
// Name: Dean Prach
// StudentID: 1222694057
// Lecture: MWF 10:10 - 11:00
// Description: This class will call all the methods called by Assignment8 and it will contain the reviewList

import java.io.Serializable;
import java.util.ArrayList;
import java.io.*;
import java.lang.*;
import java.util.*;

public class ReviewManager implements Serializable 
{
    // The serialVersionUID is used to verify compatibility of senders and
    // receivers. See the document for more details:
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 205L;

    ArrayList<Hotel> reviewList;

    public ReviewManager() 
    {
        reviewList = new ArrayList<>();
    }

    /**
     * Add a Hotel object to the reviewList and return true if such an object
     * is added successfully. Otherwise, return false. Two hotels are
     * considered duplicated if they have exactly the same hotel name and
     * hotel type.
     * 
     * @param  hotelName     the name of the hotel
     * @param  stars         the number of stars for the hotel
     * @param  review        the hotel review
     * @param  priceRange    the integer price range
     * @param  type          the hotel's type
     * @param  location      the hotel location (street address)
     * @param  topFeature    most famous feature of the hotel
     * @return               true if the operation is successful; false otherwise
     */
    public boolean addReview(String hotelName, int stars, String review, String priceRange, String type, String location, String topFeature) 
    {
        if (hotelExists(hotelName, location) == -1) 
        {
            int price = priceRange.length();
            HotelType newType = new HotelType(type, topFeature);
            Hotel newHotel = new Hotel(hotelName, stars, review, price, location, newType);
            reviewList.add(newHotel);
            return true;
        }
        return false;
    }
    // This method will check if an item in reviewList has the same name or location as the parameters passed in
    public int hotelExists(String hotelName, String location)
    {
        int returnValue = -1;
        for(int i = 0; i < reviewList.size(); i++)
        {
        if(reviewList.get(i).getHotelName().equals(hotelName) && reviewList.get(i).getLocation().equals(location))
        {
            returnValue = i;
            break;
        }
        }
        return (returnValue);
        
        
    }
    // This method will check to see how many hotels have the same hotelType
    public ArrayList<Integer> hotelTypeExists(String hotelType)
    {
        ArrayList<Integer> total = new ArrayList<>();
        for(int i = 0; i < reviewList.size(); i++)
        {
            if(reviewList.get(i).getHotelType().getType().equals(hotelType))
            {
                total.add(i);
            }
        }
        return (total);
    }
    // Hotel getter method
    public Hotel getHotel(int index)
    {
        return (reviewList.get(index));
    }
    // This method will remove a hotel from the list if it has the parameters passed in
    public boolean removeReview(String hotelName, String location)
    {
        for(int i = 0;i < reviewList.size(); i++)
        {
            if(reviewList.get(i).getHotelName().equals(hotelName) && reviewList.get(i).getLocation().equals(location))
            {
                reviewList.remove(i);
                return true;
            }
        }
        return false;
    }
    // This method will call the sort method using the ReviewRatingComparator class
    public void sortByRating()
    {
        Sorts.sort(reviewList,new ReviewRatingComparator());
    }
    // This method will call the sort method using the ReviewHoteTypeComparator class
    public void sortByHotelType()
    {
        Sorts.sort(reviewList,new ReviewHotelTypeComparator());
    }
    // This method will list all the reviews currently stored in the reviewList
    public String listReviews()
    {
        String str = "";
        for(int i = 0; i < reviewList.size(); i++)
        {
            str = str + reviewList.get(i).toString();
        }
        return str;
    }
    // This method clears the Review Manager
    public void closeReviewManager()
    {
        reviewList.clear();
    }


}
