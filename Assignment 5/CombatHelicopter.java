// Assignment #: 5
//         Name: Dean Prach
//    StudentID: 1222694057
//      Lecture: MWF 10:10-11:00
//  Description: This class is one of the types of AircraftEntity and it has the instance variables minFlyingAltitude and stealthIndex. Objects of this class will have their attack power
//  computed depending on the minFlyingAltitude variable
public class CombatHelicopter extends AircraftEntity{
    private double minFlyingAltitude = 0.0;
    private int stealthIndex = 0;
    public CombatHelicopter(String entityName, int ammo, double range, double minFlyingAltitude){
        super(entityName, ammo, range);
        this.minFlyingAltitude = minFlyingAltitude;
        if(minFlyingAltitude < 5){
            stealthIndex = 10;
        }
        else{
            stealthIndex = 7;
        }
    }
    //implements abstract parent method and calculates the attack power of a combat helicopter object using the formula.
    public void computeAttackPower(){
        attackPower = (int)((minFlyingAltitude + ammo + range) * (double)(stealthIndex));
    }
    //overrides toString method and uses parent toString method.
    public String toString(){
        return("\nCombat Helicopter\n" + super.toString() + "Stealth Index:\t" + stealthIndex + "\n");
    }
}