package vitals;

public class BatteryCheckSystem {
	static boolean batteryTest(float temperature, float soc, float chargeRate) {       
        BatteryLimit limit = new BatteryLimit(new BatteryCheck(temperature, soc, chargeRate));
		if(limit.checkBatteryOk()){
			SwitchLanguage.setMessage(BatteryConstants.BATTERY_OK);
			return true;
		}
			return false;
    }
	
    public static void main(String[] args) {
    	
    	assert(SwitchLanguage.setLanguageInSystem("EN")==true);
    	assert(batteryTest(-3, -15, 0.7f)==false);
      	assert(batteryTest(44, 79, 0.7f)==true);
		BatteryLimit limit = new BatteryLimit();
    	assert(limit.setTemperatureUnit("Fahrenheit")==true);
       	assert(batteryTest(140, 60, 0.6f) == false);
       	assert(batteryTest(25, 70, 0.7f) == true);
    	assert(SwitchLanguage.setLanguageInSystem("DE")==true);
    	assert(batteryTest(-3, -15, 0.7f)==false);
      	assert(batteryTest(44, 79, 0.7f)==true);
    	
    }
}
