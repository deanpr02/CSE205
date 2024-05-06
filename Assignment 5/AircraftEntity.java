// Assignment #: 5
//         Name: Dean Prach
//    StudentID: 1222694057
//      Lecture: MWF 10:10-11:00
//  Description: This class creates the parent class AircraftEntity and it creates the parent toString method and has an abstract method that all child classes will inherit
public abstract class AircraftEntity{
    protected String entityName;
    protected int ammo;
    protected double range;
    protected int attackPower = 0;

public AircraftEntity(String entityName, int ammo, double range){
    this.entityName = entityName;
    this.ammo = ammo;
    this.range = range;
}
//returns the attackPower variable
public int getAttackPower(){
    return attackPower; 
}
//returns the display of the aircraft name, current ammo, range, and the current attack power
public String toString(){
    return("Aircraft name:\t" + entityName + "\nCurrent Ammo:\t" + ammo + "\nRange:\t" + range + "\nCurrent Attack Power:\t" + attackPower + "\n");
}
//abstract parent method for computeAttackPower which all the child classes will now have to implement
public abstract void computeAttackPower();
}