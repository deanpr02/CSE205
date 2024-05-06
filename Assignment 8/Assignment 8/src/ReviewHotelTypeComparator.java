// Assignment: 8 
// Name: Dean Prach
// StudentID: 1222694057
// Lecture: MWF 10:10 - 11:00
// Description: This class creates the sorts the arraylist reviewList by hotel type. The arraylist will be sorted with the hotelTypes being alphabetized
// then the cheaper hotel will be sorted before the more expensive hotel of the same type

import java.util.ArrayList;
import java.io.*;
import java.lang.*;
import java.util.*;
public class ReviewHotelTypeComparator implements Comparator<Hotel>
{
    public int compare(Hotel first, Hotel second)
    {
        //if "first" and "second" hotelTypes are not equal, then compare to see which comes first alphabetically
        //if "first"comes before "second" then a -1 will be returned, if it comes after "second" a 1 will be returned
        if(!first.getHotelType().getType().equals(second.getHotelType().getType()))
        {
                return(second.getHotelType().getType().compareTo(first.getHotelType().getType()));
        }
        else
        {
        //else "first" and "second" hotelTypes are equal; if "first" priceRange is less than return 1, if it is greater return -1
            if(first.getPriceRange() < second.getPriceRange())
            {
            return(1);
            }
            else
            {
                return(-1);
            }
        }
    }
}

/*
 * if(first.getHotelType().getType().equals(second.getHotelType().getType())){
            {
                if(first.getPriceRange() < second.getPriceRange()){
                    //returns 1 if second is more expensive
                    return(1);
                }
                else{
                    //returns -1 if first is more expensive
                    return(-1);
                }
            }
        }
        if(first.getHotelType().getType().compareTo(second.getHotelType().getType()) == -1)
        {
            return(1);
        }
        if(first.getHotelType().getType().compareTo(second.getHotelType().getType()) == 1){
            return(-1);
        }
        return(1);
 */