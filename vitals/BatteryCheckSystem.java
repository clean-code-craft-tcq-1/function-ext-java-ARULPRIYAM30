package vitals;

import java.util.Locale;

public class BatteryCheckSystem {

	static boolean batteryTest(float temperature, float soc, float chargeRate) {
		BatteryLimit limit = new BatteryLimit(new BatteryCheck(temperature, soc, chargeRate));
		if(limit.checkBatteryOk()) {
			SwitchLanguage.batterysuccess();
		}
		return limit.checkBatteryOk();
		
	}

	public static void main(String[] args) {
		SwitchLanguage.setLanguageInSystem(Locale.GERMAN);

		assert (SwitchLanguage.setLanguageInSystem(Locale.GERMAN) == true);
		BatteryLimit limit = new BatteryLimit();
		assert (limit.setTemperatureUnit("Celsius") == true);		
		assert (batteryTest(-3, -15, 0.7f) == false);
		assert (batteryTest(44, 79, 0.7f) == true);
		assert (limit.setTemperatureUnit("Fahrenheit") == true);
		assert (batteryTest(140, 60, 0.6f) == false);
		assert (SwitchLanguage.setLanguageInSystem(Locale.ENGLISH) == true);
		assert (batteryTest(-3, -15, 0.7f) == false);
		assert (batteryTest(44, 79, 0.7f) == true);
		SwitchLanguage.setLanguageInSystem(Locale.ENGLISH);
		batteryTest(-3, -15, 0.7f);
		/*batteryTest(44, 79, 0.7f);
		batteryTest(24, 55, 0.4f);*/
	}
}

