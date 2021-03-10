package vitals;

import java.util.Arrays;
import java.util.List;

public class SwitchLanguage {
	
	public static String language;
	static List<String> langAllowed = Arrays.asList("EN", "DE");
	
	
    public static void HighLimitMessage(String Measure)
    {
    	String Message = (language == "DE") ? "Die " + Measure + " lauft in Richtung ihrer oberen Bruchgrenze" : Measure + " is near high Limit limit";
    	setMessage(Message);
    }

    public static void MaximumLimitMessage(String Measure, float MaximumLimit)
    {
    	String Message = (language == "DE") ? "Die " + Measure + " hat seine Hochstgrenze von " + MaximumLimit + " uberschritten" : Measure + " is more than its Maximum Limit of " + MaximumLimit;
    	setMessage(Message);
    }

    public static void MinimumLimitMessage(String Measure, float MinimumLimit)
    {
    	String Message = (language == "DE") ? "Die " + Measure + " ist unter seine Mindestgrenze von " + MinimumLimit + " gefallen" : Measure + " is less than its Minimum Limit of " + MinimumLimit;
    	setMessage(Message);
    }
    public static void LowLimitMessage(String Measure)
    {
		String Message = (language == "DE") ? "Die "+ Measure +" lauft in Richtung ihrer unteren Bruchgrenze" : Measure + " is near low Limit limit";
		setMessage(Message);
    }

    public static void setMessage(String Message)
    {
      System.out.println(Message);
    }
    
	public static boolean setLanguageInSystem(String lan) {
		if(langAllowed.contains(lan)){
	    	language=lan;
	        return true;
	    }
		return false;
	}
}
