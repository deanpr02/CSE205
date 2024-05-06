// Assignment: 8 
// Name: Dean Prach
// StudentID: 1222694057
// Lecture: MWF 10:10 - 11:00
// Description: This class creates the HotelType object which contains the variables type and topFeature

import java.io.Serializable;

public class HotelType implements Serializable 
{
    // The serialVersionUID is used to verify compatibility of senders and
    // receivers. See the document for more details:
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 205L; 
    private String type;
    private String topFeature;

    public HotelType(String type, String topFeature) 
    {
        this.type = type;
        this.topFeature = topFeature;
    }

    public String getType() 
    {
        return type;
    }

    @Override
    public String toString() 
    {
        return type + " Hotel\n" +
                "Top Feature:\t" + topFeature + '\n';
    }
}
