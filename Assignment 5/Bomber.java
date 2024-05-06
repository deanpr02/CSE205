// Assignment #: 5
//         Name: Dean Prach
//    StudentID: 1222694057
//      Lecture: MWF 10:10-11:00
//  Description: This class is one of the types of AircraftEntity and it has the instance variables bombCarryingCapacity, maxFlyingAltitude, and isJet. Objects of this class can either
//  have the type jet or propeller and depending on the input this class will use the designated toString method
public class Bomber extends AircraftEntity{
    private int bombCarryingCapacity = 0;
    private double maxFlyingAltitude = 0;
    private boolean isJet;
public Bomber(String entityName, int ammo, double range, boolean isJet){
    super(entityName, ammo, range);
    this.isJet = isJet;
    if(isJet == true){
        bombCarryingCapacity = 100;
        maxFlyingAltitude = 45.5;
    }
    else{
        bombCarryingCapacity = 75;
        maxFlyingAltitude = 34.0;
    }
}
//checks to see if the maxFlyingAltitude is greater than 40 and then depending on if it is or not uses the corresponding formula to
//calculate attackPower
public void computeAttackPower(){
    if(maxFlyingAltitude >= 40.0){
        attackPower = ((int)(maxFlyingAltitude + ammo) * (bombCarryingCapacity / 100));
    }
    else{
        attackPower = ((int)(ammo + range) * (bombCarryingCapacity / 100));
    }
}
//if the isjet is true it will display a bomber that is a jet type and if it is false it will display a propeller type
public String toString(){
    if(isJet == true){
        return("\nBomber:\tJet Type\n" + super.toString() + "Bomb Carrying Capacity:\t" + bombCarryingCapacity + "%\n");
    }
    else{
        return("\nBomber: Propeller Type\n" + super.toString() + "Bomb Carrying Capacity:\t" + bombCarryingCapacity + "%\n");    

    }
    
}

}