// Assignment: 10
// Name: Dean Prach 
// StudentID: 1222694057
// Lecture: MWF 10:10 - 11:00
// Description: This class will create linked list containing Flight objects. This class will contain several methods used by the menu such as
// getNumberOfPassengers, removeFirstFlight, getPosition, removeFlight, and listAllFlights

public class LinkedList 
{
    Flight first;
    int size;

    public LinkedList()
    {
        this.first = null;
        this.size = 0;
    }

    // This method will add a flight into the linked list
    public void addFlight(String flightNumber, String destination, int numberOfPassengers)
    {
        Flight newFlight = new Flight(flightNumber, destination, numberOfPassengers);
        if(this.first == null)
        {
            this.first = newFlight;
        }
        else
        {
            Flight pointer = first;
            while(pointer.next != null)
                pointer = pointer.next;

            pointer.next = newFlight;
            
        }
        this.size++;
    }
    //This method will return the total number of passengers heading towards a specific destination
    public int getNumberOfPassengers(String destination)
    {
        int count = 0;
        if(this.first == null)
        {
            return(0);
        }
        else
        {
            Flight pointer = first;
        while(pointer != null)
        {
            if(pointer.destination.equals(destination))
            {
        count += pointer.numberOfPassengers;
        pointer = pointer.next;
            }
        else
        {
        pointer = pointer.next;
        }
        }
        }
        return count;
    }
    //This method will remove the first flight in the linked list
    public Flight removeFirstFlight()
    {
        Flight temp = null;
        if(this.first == null)
        {
            EmptyFlight empty = new EmptyFlight();
            return(empty);
        }
        else
        {
            temp = first;
            this.first = first.next;
            return(temp);
        }
    }
    //This method will list all the flights in the linked list
    public String listFlights()
    {
        if(first == null)
        {
            return("No flights scheduled for departure at this time.\n");
        }
        else
        {
            String str = first.toString();
            Flight pointer = first;
            int count = 1;
            while(pointer.next != null)
            {
            count++;
            pointer = pointer.next;
            str = str + pointer.toString();
            }
            return(str + "\nTotal flights: " + count + ".\n");
        }
    }
    //This method will return what position in the queue the flight is depending on the flightNumber passed in
    public int getPosition(String flightNumber)
    {
        int queue = -1;
        int count = 0;
        if(first == null)
        {
            return(queue);
        }
        else
        {
            Flight pointer = first;
            while(pointer != null)
            {
                if(pointer.flightNumber.equals(flightNumber))
                {
                    queue = count;
                    return(queue);
                }
                pointer = pointer.next;
                count++;
            }
            return(queue);
        }

    }
    //This method will remove a flight from the queue depending on its flightNumber
    public Flight removeFlight(String flightNumber)
    {
    EmptyFlight empty = new EmptyFlight();
    Flight temp = null;
        if(first == null)
        {
            return empty;
        }
        Flight pointer = first; 
        if(pointer.flightNumber.equals(flightNumber))
        {
            first = first.next;
            return(pointer);
        }
        while(pointer.next != null)
        {
            if(pointer.next.flightNumber.equals(flightNumber))
            {
                if(pointer.next.next == null)
                {
                    temp = pointer.next;
                    pointer.next = null;

                    return(temp);
                }
                temp = pointer.next;
                pointer.next = pointer.next.next;
                return(temp);
            }
            pointer = pointer.next;
        }
        return(empty);
        }
    }
    

