package vitals;

public class BatteryCheck {
	public float Temperature, StateOfCharge, ChargeRate;	 
    public BatteryCheck(float temperature, float soc, float chargeRate)
    {
        this.Temperature = temperature;
        this.StateOfCharge = soc;
        this.ChargeRate = chargeRate;
    }
    
    
    public static void CheckLowBreach(BatteryConstants battery)
    {
        if ((battery.value > (battery.minimumLimit + battery.lowBreach)) && (battery.value<(battery.minimumLimit + battery.highBreach))){
        SwitchLanguage.lowBreach(battery.parameter);
        }
    }    
    
    public static void CheckHighBreach(BatteryConstants battery)
    {
         if (((battery.value > battery.maxLimit - battery.highBreach)) && (battery.value<battery.maxLimit)){
         SwitchLanguage.highBreach(battery.parameter);
         }
    }


	public static boolean EvaluateBatteryMeasure(BatteryConstants battery) {
		if(battery.value > battery.maxLimit){
			SwitchLanguage.maxLimit(battery.parameter, battery.maxLimit);
            return false;
		}
        if (battery.value < battery.minimumLimit){
        	SwitchLanguage.minLimit(battery.parameter, battery.minimumLimit);
        	return false;
        }
        return true;
	}
}
