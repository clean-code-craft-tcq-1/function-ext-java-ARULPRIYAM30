package vitals;

public class BatteryCheck {
	public float Temperature, StateOfCharge, ChargeRate;
	 
    public BatteryCheck(float temperature, float soc, float chargeRate)
    {
        this.Temperature = temperature;
        this.StateOfCharge = soc;
        this.ChargeRate = chargeRate;
    }
    
    
    public static void CheckLowBreach(BatteryLimitMeasures battery)
    {
        if ((battery.MeasureValue > (battery.MinimumLimit + battery.LowBreach)) && (battery.MeasureValue<(battery.MinimumLimit + battery.HighBreach))){
        SwitchLanguage.LowLimitMessage(battery.MeasureName);
        }
    }    
    
    public static void CheckHighBreach(BatteryLimitMeasures battery)
    {
         if (((battery.MeasureValue > battery.MaximumLimit - battery.HighBreach)) && (battery.MeasureValue<battery.MaximumLimit)){
         SwitchLanguage.LowLimitMessage(battery.MeasureName);
         }
    }


	public static boolean EvaluateBatteryMeasure(BatteryLimitMeasures battery) {
		if(battery.MeasureValue > battery.MaximumLimit){
			SwitchLanguage.MaximumLimitMessage(battery.MeasureName, battery.MaximumLimit);
            return false;
		}
        if (battery.MeasureValue < battery.MinimumLimit){
        	SwitchLanguage.MinimumLimitMessage(battery.MeasureName, battery.MinimumLimit);
        	return false;
        }
        return true;
	}
}
