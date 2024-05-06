// Assignment #: 5
//         Name: Dean Prach
//    StudentID: 1222694057
//      Lecture: MWF 10:10-11:00
//  Description: This class is one of the types of AircraftEntity and it has the instance variable maxSpeed. Objects of this class type will have their attackpower computed depending
//  on the value of the maxSpeed variable
import java.text.DecimalFormat;
public class FighterJet extends AircraftEntity{
private double maxSpeed;
public FighterJet(String entityName, int ammo, double range, double maxSpeed){
super(entityName, ammo, range);
this.maxSpeed = maxSpeed;
}
////implements abstract parent method and calculates the attack power of a fighter jet object using the formula.
public void computeAttackPower(){
    attackPower = (int)((ammo + range) * (maxSpeed / 10));
}
////overrides toString method and uses parent toString method.
public String toString(){
    DecimalFormat df = new DecimalFormat("#.##");
    return("\nFighter Jet:\n" + super.toString() + "Maximum Speed:\t" + df.format(maxSpeed) + "%\n");
    }
}
