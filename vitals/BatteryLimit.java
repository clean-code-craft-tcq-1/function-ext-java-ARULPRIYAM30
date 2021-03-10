package vitals;

import java.util.Arrays;
import java.util.List;

public class BatteryLimit {
	
	BatteryCheck bmsCheck;
	static final float MAX_CHARGE_RATE= 0.8f;
	static final float MIN_CHARGE_RATE= 0.0f;
	static final float MAX_TEMPERATURE = 45;
	static final float MIN_TEMPERATURE = 0;
	static final float MAX_SOC= 80;
	static final float MIN_SOC= 20;
	public static String measureUnitTemperature="Celsius";
	static List<String> unitsTemperature = Arrays.asList("Celsius", "Fahrenheit");

	
	public BatteryLimit(BatteryCheck batteryMeasures) {
		this.bmsCheck=batteryMeasures;
	}

	public BatteryLimit() {
		
	}

	public boolean checkBatteryOk() {
		boolean check_of_temp=isTemperatureWithinLimit(bmsCheck.Temperature);
		boolean check_of_soc=isSocWithinLimit(bmsCheck.StateOfCharge);
		boolean check_of_charge=isChargeWithinLimit(bmsCheck.ChargeRate);
		return ((check_of_temp && check_of_soc) && check_of_charge);
	}
	
	public boolean isTemperatureWithinLimit(float temperature) {
		
		if((measureUnitTemperature).equals(unitsTemperature.get(1))){
			temperature=convertFtoC(temperature);
		}
		BatteryLimitMeasures btemp=new BatteryLimitMeasures("Temperature", temperature, MAX_TEMPERATURE, MIN_TEMPERATURE);
		BatteryCheck.CheckLowBreach(btemp);
		BatteryCheck.CheckHighBreach(btemp);
		
		return BatteryCheck.EvaluateBatteryMeasure(btemp);
		
	}
	private float convertFtoC(float temperature) {
		float tempInCelsius=((temperature - 32)*5)/9;		
		System.out.println(tempInCelsius);
		return tempInCelsius;
	}

	
	
	public boolean isChargeWithinLimit(float chargeRate) {
		BatteryLimitMeasures limitCharge=new BatteryLimitMeasures("ChargeRate", chargeRate,MAX_CHARGE_RATE,MIN_CHARGE_RATE);
		BatteryCheck.CheckLowBreach(limitCharge);
		BatteryCheck.CheckHighBreach(limitCharge);	
		return BatteryCheck.EvaluateBatteryMeasure(limitCharge);
	}

	public boolean isSocWithinLimit(float stateofcharge) {
		BatteryLimitMeasures limitSoc=new BatteryLimitMeasures("StateofCharge", stateofcharge, MAX_SOC,MIN_SOC);
		BatteryCheck.CheckLowBreach(limitSoc);
		BatteryCheck.CheckHighBreach(limitSoc);	
		return BatteryCheck.EvaluateBatteryMeasure(limitSoc);
	}
	
	public boolean setTemperatureUnit(String temp_unit) {
		if(unitsTemperature.contains(temp_unit)){
			measureUnitTemperature = temp_unit;
	        return true;
		}
	    else
	        return false;
		
	}

}