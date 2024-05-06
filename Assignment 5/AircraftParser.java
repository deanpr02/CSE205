// Assignment #: 5
//         Name: Dean Prach
//    StudentID: 1222694057
//      Lecture: MWF 10:10-11:00
//  Description: This class takes the input and splits the data and puts it in an array. This class will determine from the input whether to create a new fighter jet, combat helicopter or,
//  a bomber object and it returns the object
import java.io.*;
public class AircraftParser{
    //This class parses the first word of the input and makes it lowercase, then it checks if the type is jet, bomber, or helicopter
    //then it creates an object based on the first word and then returns the object
    public static AircraftEntity parseNewAircraft(String lineToParse){
    
    String[] word = lineToParse.split(",");
    word[0] = word[0].toLowerCase();
    if(word[0].equals("fighterjet")){
        FighterJet jet = new FighterJet(word[1],Integer.parseInt(word[2]),Double.parseDouble(word[3]),Double.parseDouble(word[4]));
        return jet;
    }
    else if(word[0].equals("bomber")){
        word[4] = word[4].toLowerCase();
        if(word[4].equals("jet")){
            Bomber bomb = new Bomber(word[1],Integer.parseInt(word[2]),Double.parseDouble(word[3]),true);
            return bomb;
        }
        else{
        Bomber bomb = new Bomber(word[1],Integer.parseInt(word[2]),Double.parseDouble(word[3]),false);
        return bomb;
        }
}
else if(word[0].equals("combathelicopter")){
    CombatHelicopter helicopter = new CombatHelicopter(word[1],Integer.parseInt(word[2]),Double.parseDouble(word[3]),Double.parseDouble(word[4]));
    return helicopter;
}
else{
return null;
    }
}
}