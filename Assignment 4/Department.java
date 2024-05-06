public class Department{

    private String name;
    private Manager manager;
    private String division;
    private String location;

    public Department(){
        name = "?";
        division = "?";
        manager = null;
        location = "?";
    }
    public Department(String name, Manager manager, String division, String location){
        this.name = name;
        this.manager = manager;
        this.division = division;
        this.location = location;
    }
    //accessor method for the variable name
    public String getName(){
        return name;
    }
    //accessor method for the variable manager
    public Manager getManager(){
        return manager;
    }
    //accessor method for the variable division
    public String getDivision(){
        return division;
    }
    //accessor method for the variable location
    public String getLocation(){
        return location;
    }
    //sets the private variable name to a different String value
    public void setName(String someName){
        name = someName;
    }
    //modifys the variables of the object manager 
    public void setManager(String someFirstName, String someLastName, int someYearsExperience, String someManagingSince){
        manager.setFirstName(someFirstName);
        manager.setLastName(someLastName);
        manager.setYearsExperience(someYearsExperience);
        manager.setManagingSince(someManagingSince);
    }
    //sets the private variable division to a different String value
    public void setDivison(String someDivision){
        division = someDivision;
    }
    //sets the private variable of location to a different String value
    public void setLocation(String someLocation){
        location = someLocation;
    }
    //returns the departments information and its corresponding variables
    public String toString(){
        return ("Department Name:\t" + name + "\nDivision:\t" + division + "\nLocation:\t" + location + "\nManager Information:\t" + manager.toString());
    }

}