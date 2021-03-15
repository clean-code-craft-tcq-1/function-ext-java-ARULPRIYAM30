package vitals;

import java.util.Arrays;
import java.util.List;

public class BatteryLimit {

	public static String measureUnitDefault = "Celsius";
	static List<String> unitsTemperature = Arrays.asList("Celsius", "Fahrenheit");

	BatteryCheck bmsCheck;

	public BatteryLimit(BatteryCheck batteryMeasures) {
		this.bmsCheck = batteryMeasures;
	}

	public BatteryLimit() {
		// constructor stub
	}

	public boolean checkBatteryOk() {
		boolean check_of_charge = isChargeWithinLimit(bmsCheck.ChargeRate);
		boolean check_of_temp = isTemperatureWithinLimit(bmsCheck.Temperature);
		boolean check_of_soc = isSocWithinLimit(bmsCheck.StateOfCharge);
		return ((check_of_temp && check_of_soc) && check_of_charge);
	}

	public boolean isTemperatureWithinLimit(float temperature) {

		if ((measureUnitDefault).equals(unitsTemperature.get(1))) {
			temperature = convertFtoC(temperature);
		}
		BatteryConstants btemp = new BatteryConstants("Temperature", temperature, BatteryConstants.MAX_TEMPERATURE,
				BatteryConstants.MIN_TEMPERATURE);
		BatteryCheck.CheckLowBreach(btemp);
		BatteryCheck.CheckHighBreach(btemp);

		return BatteryCheck.EvaluateBatteryMeasure(btemp);

	}

	private float convertFtoC(float temperature) {
		float tempInCelsius = ((temperature - 32) * 5) / 9;
		System.out.println(tempInCelsius);
		return tempInCelsius;
	}

	public boolean isChargeWithinLimit(float chargeRate) {
		BatteryConstants limitCharge = new BatteryConstants("ChargeRate", chargeRate, BatteryConstants.MAX_CHARGE_RATE,
				BatteryConstants.MIN_CHARGE_RATE);
		BatteryCheck.CheckLowBreach(limitCharge);
		BatteryCheck.CheckHighBreach(limitCharge);
		return BatteryCheck.EvaluateBatteryMeasure(limitCharge);
	}

	public boolean isSocWithinLimit(float stateofcharge) {
		BatteryConstants limitSoc = new BatteryConstants("StateofCharge", stateofcharge, BatteryConstants.MAX_SOC,
				BatteryConstants.MIN_SOC);
		BatteryCheck.CheckLowBreach(limitSoc);
		BatteryCheck.CheckHighBreach(limitSoc);
		return BatteryCheck.EvaluateBatteryMeasure(limitSoc);
	}

	public boolean setTemperatureUnit(String temp_unit) {
		if (unitsTemperature.contains(temp_unit)) {
			measureUnitDefault = temp_unit;
			return true;
		} else
			// Temperature Unit Not supported
			return false;

	}

}