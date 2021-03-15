package vitals;

import java.util.Arrays;
import java.util.List;

public class SwitchLanguage {
	
	public static String language;
	static List<String> availableLanguage = Arrays.asList("EN", "DE");
	
	public static boolean setLanguageInSystem(String lan) {
		if(availableLanguage.contains(lan)){
	    	language=lan;
	        return true;
	    }
		else {
			//language is not supported!!!
		return false;
		}
	}
	
	
	public static void setMessage(String messagePrint)
    {
      System.out.println(messagePrint);
    }
    
    public static void maxLimit(String parameter, float MaximumLimit)
    {
    	
    	if (language.equals("DE") ) {
    		String displayMessage =parameter + " " + BatteryConstants.HIGH_THRESHOLD_DE + " " + MaximumLimit;
        	setMessage(displayMessage);
    	}
    	else {
    		String displayMessage =parameter + " " + BatteryConstants.HIGH_THRESHOLD_ENG + " " + MaximumLimit;
        	setMessage(displayMessage);
    	}
    }

    public static void minLimit(String parameter, float MinimumLimit)
    {
    	if (language.equals("DE")) {
    		String displayMessage =parameter + " " + BatteryConstants.LOW_THRESHOLD_DE + " " + MinimumLimit;
        	setMessage(displayMessage);
    	}
    	else {
    		String displayMessage =parameter + " " + BatteryConstants.LOW_THRESHOLD_ENG + " " + MinimumLimit;
        	setMessage(displayMessage);
    	}
    }
    public static void lowBreach(String parameter)
    {
    	if (language.equals("DE")) {
    		String displayMessage =parameter + " " + BatteryConstants.LOW_BREACH_WARNING_DE ;
        	setMessage(displayMessage);
    	}
    	else {
    		String displayMessage =parameter + " " + BatteryConstants.LOW_BREACH_WARNING_ENG ;
        	setMessage(displayMessage);
    	}
    }
    
    public static void highBreach(String parameter)
    {
    	if (language.equals("DE")) {
    		String displayMessage =parameter + " " + BatteryConstants.HIGH_BREACH_WARNING_DE ;
        	setMessage(displayMessage);
    	}
    	else {
    		String displayMessage =parameter + " " + BatteryConstants.HIGH_BREACH_WARNING_ENG ;
        	setMessage(displayMessage);
    	}
    }

    

}
