package vitals;

public class BMSDriver {
	static boolean batteryTest(float temperature, float soc, float chargeRate) {       
        BatteryLimit estimateLimit = new BatteryLimit(new BatteryCheck(temperature, soc, chargeRate));
		if(estimateLimit.checkBatteryOk()){
			SwitchLanguage.setMessage("Battery Status Perfect");
			return true;
		}
			return false;
    }
	
    public static void main(String[] args) {
    	
    	BatteryLimit estimateLimit=new BatteryLimit();
    	assert(SwitchLanguage.setLanguageInSystem("EN")==true);
    	assert(estimateLimit.setTemperatureUnit("Fahrenheit")==true);
    	assert(batteryTest(140, 60, 0.6f) == false);
    	assert(batteryTest(25, 70, 0.7f) == true);
        assert(batteryTest(-1, -20, 0.7f)==false);
    	assert(batteryTest(44, 79, 0.7f)==true);
    	
    }
}