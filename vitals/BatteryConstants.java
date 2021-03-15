package vitals;

public class BatteryConstants {

	public float value, maxLimit, minimumLimit, lowBreach, highBreach;
    	public String parameter;
    
	static final float MAX_CHARGE_RATE= 0.8f;
	static final float MIN_CHARGE_RATE= 0.0f;
	static final float MAX_TEMPERATURE = 45;
	static final float MIN_TEMPERATURE = 0;
	static final float MAX_SOC= 80;
	static final float MIN_SOC= 20;
	
	static final String LOW_THRESHOLD_ENG= "is below threshold value";
	static final String HIGH_THRESHOLD_ENG="is above threshold value";
	static final String HIGH_BREACH_WARNING_ENG="is about to approach high breach";
	static final String LOW_BREACH_WARNING_ENG="is about to approach low breach";

	static final String	LOW_THRESHOLD_DE="liegt unter dem Schwellenwert";
	static final String HIGH_THRESHOLD_DE="liegt uber dem Schwellenwert";
	static final String	HIGH_BREACH_WARNING_DE="ist kurz davor, sich einer hohen Verletzung zu nahern";
	static final String LOW_BREACH_WARNING_DE="ist im Begriff, sich einer geringen Verletzung zu nahern";
	static final String BATTERY_OK="Battery Status OK";
    
    public BatteryConstants(String battery_parameter, float value, float maxLimit, float minimumLimit)
    {
        this.parameter = battery_parameter;
        this.value = value;
        this.maxLimit = maxLimit;
        this.minimumLimit = minimumLimit;
        this.lowBreach = (minimumLimit * 0.05f);
        this.highBreach = (maxLimit * 0.05f);
    }
	
	

}
