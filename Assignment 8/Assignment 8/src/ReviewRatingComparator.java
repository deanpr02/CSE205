// Assignment: 8 
// Name: Dean Prach
// StudentID: 1222694057
// Lecture: MWF 10:10 - 11:00
// Description: This class sorts the array based on review rating. The list will be sortest by star rating and then same star hotels will be sorted alphabetically

import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.lang.*;
public class ReviewRatingComparator implements Comparator<Hotel>
{
    public int compare(Hotel first, Hotel second)
    {
        int difference;
        //IF the stars are equal for Hotel "first" and Hotel "second" return a 1 if first comes before second alphabetically 
        if(first.getStars() == second.getStars())
        {
            return(second.getHotelName().compareTo(first.getHotelName()));
        }
        else
        {
            //IF Hotel "second" has more stars it will return a positive value, if "first" has more stars it will return a negative value
            difference = second.getStars() - first.getStars();
            return (difference);
        }
    }   

}
