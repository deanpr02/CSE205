// Assignment: 10
// Name: Dean Prach 
// StudentID: 1222694057
// Lecture: MWF 10:10 - 11:00
// Description: This class will create a new flight object with variables: flightNumber, destination, numberOfPassengers, and next;

public class Flight {
    String flightNumber;
    String destination;
    int numberOfPassengers;
    Flight next;

    public Flight(String flightNumber, String destination, int numberOfPassengers){
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.numberOfPassengers = numberOfPassengers;
        this.next = null;
    }

    public String toString(){
        return "\nFlight Number " + this.flightNumber + " going to " + this.destination + " has " + this.numberOfPassengers + " passengers" + ".\n";
    }

}
