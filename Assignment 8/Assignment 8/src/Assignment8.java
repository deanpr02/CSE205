// Assignment: 8 
// Name: Dean Prach
// StudentID: 1222694057
// Lecture: MWF 10:10 - 11:00
// Description: This class creates the menu for which the user gets to select which option they would like to select: the user can add, remove, sort, or find similar
// hotels with the menu

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Assignment8 
{
    public static void main(String[] args)  
    {
        // Menu options
        char inputOpt = ' ';
        String inputLine;
        // Hotel and Hotel Type information
        String hotelName, hotelType;
        String review = null, location, topFeature, priceRange;

        int rating;
        // Output information
        String outFilename, inFilename;
        String outMsg, inMsg;
        // Hotel manager
        ReviewManager reviewManager = new ReviewManager();
        // Operation result
        boolean opResult;     
        
        try 
        {
            printMenu();
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do 
            {
                System.out.print("\nWhat action would you like to perform?\n");
                inputLine = stdin.readLine().trim();
                if (inputLine.isEmpty()) 
                {
                    continue;
                }
                inputOpt = inputLine.charAt(0);
                inputOpt = Character.toUpperCase(inputOpt);

                switch (inputOpt) 
                {

                    case 'A': // Add a new Hotel Review
                        System.out.print("Please enter the hotel information:\n");
                        System.out.print("Enter the hotel name:\n");
                        hotelName = stdin.readLine().trim();
                        System.out.print("Enter the review:\n");
                        review = stdin.readLine().trim();
                        System.out.print("Enter the price range:\n");
                        priceRange = stdin.readLine().trim();
                        System.out.print("Enter the rating:\n");
                        rating = Integer.parseInt(stdin.readLine().trim());
                        System.out.print("Enter the hotel type:\n");
                        hotelType = stdin.readLine().trim();
                        System.out.print("Enter the location:\n");
                        location = stdin.readLine().trim();
                        System.out.print("Enter the hotel's top feature\n");
                        topFeature = stdin.readLine().trim();
                        if(reviewManager.addReview(hotelName, rating, review, priceRange, hotelType, location, topFeature))
                        {
                            System.out.print("Hotel added\n");
                        }
                        else
                        {
                            System.out.print("Hotel NOT added\n");
                        }
                        break;
                        


                    case 'D': // Search a Hotel
                        System.out.print("Please enter the Hotel name to search:\n");
                        hotelName = stdin.readLine().trim();
                        System.out.print("Please enter the hotel's location':\n");
                        location = stdin.readLine().trim();
                        
                        int index = reviewManager.hotelExists(hotelName,location);
                        if(index != -1)
                        {
                            System.out.print("Hotel found. Here's the review:\n" + reviewManager.getHotel(index).getReview() + "\n");
                        }
                        else
                        {
                            System.out.print("Hotel not found. Please try again\n");
                        }
                        break;


                    case 'E': // Search for a Hotel Type
                        System.out.print("Please enter the hotel type to search:\n");
                        hotelType = stdin.readLine().trim();
                        ArrayList<Integer> total = new ArrayList<>();
                        total = reviewManager.hotelTypeExists(hotelType);
                        if(total.size() > 0)
                        {
                            System.out.print(total.size() + " Hotels matching " + hotelType + " type were found:\n");
                            for(int i = 0; i < total.size(); i++)
                            {
                                System.out.print(reviewManager.getHotel(total.get(i)).toString() + "\n");
                            }
                        }
                        else
                        {
                            System.out.print("Hotel Type: " + hotelType + " was NOT found\n");
                        }
                        break; 
                        
                    case 'L': // List hotel's reviews
                        if(reviewManager.listReviews().equals(""))
                        {
                            System.out.print("\n\nNo Reviews available\n");
                        }
                        System.out.print("\n" + reviewManager.listReviews() + "\n");
                        break;
                        

                    case 'N':// Sorts hotel reviews by rating
                        reviewManager.sortByRating();
                        System.out.print("sorted by rating\n");
                        break;
                    
                    case 'P': // Sorts hotel reviews by type
                        reviewManager.sortByHotelType();
                        System.out.print("sorted by hotel type\n");
                        break;                       
                        
                    case 'Q': // Quit
                        break;

                    case 'R': // Remove a review
                        System.out.print("Please enter the hotel name of the review to remove:\n");
                        hotelName = stdin.readLine().trim();
                        System.out.print("Please enter the location to remove:\n");
                        location = stdin.readLine().trim();
                        if(reviewManager.removeReview(hotelName,location))
                        {
                            System.out.print(hotelName + ", " + location + " was removed\n");

                        }
                        else
                        {
                            System.out.print(hotelName + ", " + location + " was NOT removed\n");
                        }
                        break;
                        
                        
                    case 'T': // Close reviewList
                        reviewManager.closeReviewManager();
                        System.out.print("Hotel management system was reset\n");
                        break;

                    case 'U': // Write hotel names and reviews to a text file
                        System.out.print("Please enter a file name that we will write to:\n");
                        outFilename = stdin.readLine().trim();
                        System.out.print("Please enter the name of the hotel:\n");
                        hotelName = stdin.readLine().trim();
                        System.out.println("Please enter a review to save locally:\n");
                        review = stdin.readLine().trim();
                        outMsg = hotelName + "\n" + review + "\n";
                        try
                        {

                            FileWriter fw = new FileWriter(outFilename);
                            BufferedWriter bw = new BufferedWriter(fw);
                            PrintWriter outFile = new PrintWriter(bw);
                            outFile.println(outMsg);
                            outFile.close();
                            System.out.print(outFilename + " is written\n");
                        }

                        catch(IOException e)
                        {
                            System.out.print("Write string in file error\n");

                        }
                        break;

                    case 'V': // Read strings from a text file
                        System.out.print("Please enter a file name which we will read from:\n");
                        inFilename = stdin.readLine().trim();
                        try{
                            FileReader fr = new FileReader(inFilename);
                            BufferedReader in = new BufferedReader(fr);
                            String line = "";
                            String hold = in.readLine();
                            while(hold != null){
                                line += "\n" + hold;
                                hold = in.readLine();
                        
                            }
                            System.out.print(inFilename + " was read\n");
                            System.out.print("The contents of the file are:\n" + line + "\n");
                        }
                        catch(FileNotFoundException e)
                        {
                            System.out.print(inFilename + " was not found\n");
                        }
                        catch(IOException e)
                        {
                            System.out.print("Read string from file error\n");
                        }
                        break;
                        
                    case 'W': // Serialize ReviewManager to a data file
                        System.out.print("Please enter a file name to write:\n");
                        outFilename = stdin.readLine().trim();
                        try{
                            FileOutputStream toFile = new FileOutputStream(outFilename);
                            ObjectOutputStream objectToFile = new ObjectOutputStream(toFile);
                            objectToFile.writeObject(reviewManager);
                            objectToFile.close();
                        }
                        catch(NotSerializableException e)
                        {
                            System.out.print("Not serializable exception\n");
                        }
                        catch(FileNotFoundException e)
                        {
                            System.out.print("Data file written exception\n");
                        }
                        break;                 
                        

                    case 'X': // Deserialize ReviewManager from a data file
                        System.out.print("Please enter a file name which we will read from:\n");
                        inFilename = stdin.readLine().trim();
                        try{
                            FileInputStream fileToStream = new FileInputStream(inFilename);
                            ObjectInputStream objectFromFile = new ObjectInputStream(fileToStream);
                            Object any = null;
                            any = objectFromFile.readObject();
                            reviewManager = (ReviewManager)any;
                            objectFromFile.close();
                            System.out.print(inFilename + " was read\n");
                        }
                        catch(ClassNotFoundException e)
                        {
                            System.out.print("Class not found exception\n");
                        }
                        catch(NotSerializableException e)
                        {
                            System.out.print("Not serializable exception\n");
                        }
                        catch(FileNotFoundException e)
                        {
                            System.out.print("Data file read exception\n");
                        }
                        break;
                        

                    case '?': // Display help
                        printMenu();
                        break;

                    default:
                        System.out.print("Unknown action\n");
                        break;
                }

            } while (inputOpt != 'Q' || inputLine.length() != 1);
        }
        catch (IOException exception) {
            System.out.print("IO Exception\n");
        }
    }

    public static void printMenu() 
    {
        System.out.println("Welcome to HotelAdvisor! ");
        System.out.println("Find or post reviews for your favorite (and not so favorite) hotels.");

        System.out.print("Choice\t\tAction\n" + "------\t\t------\n" + "A\t\tAdd a review\n"
                + "D\t\tSearch for a hotel\n" + "E\t\tSearch for a hotel type\n"
                + "L\t\tList all reviews\n" + "N\t\tSort by stars\n" + "P\t\tSort by hotel type\n"
                + "Q\t\tQuit\n" + "R\t\tRemove a review\n"
                + "U\t\tAdd personal review to a local file\n" + "V\t\tRetrieve personal review from a local file\n"
                + "W\t\tSave reviews to a file\n"
                + "X\t\tUpload reviews from a file\n"
                + "T\t\t(admin) reset database\n"
                + "?\t\tDisplay Help\n");
    }
}
