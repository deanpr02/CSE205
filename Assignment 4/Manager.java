public class Manager{
        private String firstName;
        private String lastName;
        private int yearsExperience;
        private String managingSince;
    
    public Manager(){
        firstName = "?";
        lastName = "?";
        yearsExperience = 0;
        managingSince = "?";
    }
    public Manager(String firstName, String lastName, int yearsExperience, String managingSince){
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearsExperience = yearsExperience;
        this.managingSince = managingSince;
    }
    //accesses the variable firstName
    public String getFirstName(){
        return firstName;
    }
    //accesses the variable lastName
    public String getLastName(){
        return lastName;
    }
    //accesses the variable yearsExperience
    public int getYearsExperience(){
        return yearsExperience;
    }
    //accesses the variable managingSince
    public String getManagingSince(){
        return managingSince;
    }
    //modifys the variable firstName
    public void setFirstName(String someFirstName){
        firstName = someFirstName;
    }
    //modifys the variable lastName
    public void setLastName(String someLastName){
        lastName = someLastName;
    }
    //modifys the variable yearsExperience
    public void setYearsExperience(int someYears){
        yearsExperience = someYears;
    }
    //modifys the variable managingSince
    public void setManagingSince(String someDate){
        managingSince = someDate;
    }
    //returns the information of the manager
    public String toString(){
        return ("\nLast Name:\t" + lastName + "\nFirst Name:\t" + firstName + "\nYears of Experience:\t" + yearsExperience + "\nManaging Since:\t" + managingSince + "\n");
    }

}