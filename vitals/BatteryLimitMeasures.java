package vitals;

public class BatteryLimitMeasures {
	
	public float MeasureValue, MaximumLimit, MinimumLimit, LowBreach, HighBreach;
    public String MeasureName, MessageLanguage;
     public BatteryLimitMeasures(String Name, float Value, float MaximumValue, float MinimumValue)
     {
         this.MeasureName = Name;
         this.MeasureValue = Value;
         this.MaximumLimit = MaximumValue;
         this.MinimumLimit = MinimumValue;
         this.LowBreach = (MinimumValue * 0.05f);
         this.HighBreach = (MaximumValue * 0.05f);
     }
	
 }

