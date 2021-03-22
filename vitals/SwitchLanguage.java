package vitals;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Locale;
import vitals.ILogger;

public class SwitchLanguage {

	private static ILogger log = new Logger();
	public static String lang;
	static List<String> availableLanguage = Arrays.asList("de", "en");
	public static ResourceBundle bundle;

	public static boolean setLanguageInSystem(Locale language) {

		lang = language.toString();
		if (availableLanguage.contains(lang)) {
			Locale.setDefault(language);
			bundle = ResourceBundle.getBundle("vitals/language/messages", language);
			return true;

		} else {
			// language is not supported but default English!!!
			bundle = ResourceBundle.getBundle("vitals/language/messages", Locale.ENGLISH);
			return false;
		}
	}

	public static void maxLimit(String parameter, float MaximumLimit) {

		String displayMessage = parameter + " " + bundle.getObject("HIGH_THRESHOLD") + " " + MaximumLimit;
		log.setMessage(displayMessage);

	}

	public static void minLimit(String parameter, float MinimumLimit) {
		String displayMessage = parameter + " " + bundle.getObject("LOW_THRESHOLD") + " " + MinimumLimit;
		log.setMessage(displayMessage);
	}

	public static void lowBreach(String parameter) {
		String displayMessage = parameter + " " + bundle.getObject("LOW_BREACH_WARNING");
		log.setMessage(displayMessage);
	}

	public static void highBreach(String parameter) {

		String displayMessage = parameter + " " + bundle.getObject("HIGH_BREACH_WARNING");
		log.setMessage(displayMessage);
	}
	public static void batterysuccess() {

		String displayMessage = (String) bundle.getObject("BATTERY_OK");
		log.setMessage(displayMessage);
	}

}
