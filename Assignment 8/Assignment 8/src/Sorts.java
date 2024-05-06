// Assignment: 8 
// Name: Dean Prach
// StudentID: 1222694057
// Lecture: MWF 10:10 - 11:00
// Description: This class sorts the arraylist reviewList depending on if the user chose to sort by rating or hotel type

import java.util.ArrayList;
import java.io.*;
import java.lang.*;
import java.util.*;
public class Sorts 
{
    public static void sort(ArrayList<Hotel>reviewList, Comparator<Hotel>xComparator)
    {
        //IF returned value is positive, do not swap
        //IF returned value is negative, swap
        for(int i = 0; i < reviewList.size() - 1; i++)
        {
            for(int j = i+1; j < reviewList.size(); j++)
            {
                if(xComparator.compare(reviewList.get(i),reviewList.get(j)) < 0)
                {
                    Hotel temp = reviewList.get(i);
                    reviewList.set(i,reviewList.get(j));
                    reviewList.set(j,temp);
                    i = i -1;
                    break;
                }
            }
        }

        

    }
}
