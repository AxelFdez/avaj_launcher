package avajLauncherPackage;

public class WeatherProvider {

	private static WeatherProvider instance;

	public static WeatherProvider getInstance() {
		if (instance == null) {
			instance = new WeatherProvider();
		}
		return instance;
	}
	private WeatherProvider() {}


	private String[] weather = {"SUN", "FOG", "RAIN", "SNOW"};

	public String getCurrentWeather(Coordinates p_coordinates)
	{
		int longitude = p_coordinates.getLongitude();
		int latitude = p_coordinates.getLatitude();
		int height = p_coordinates.getHeight();

		Coordinates NiceTowerPosition = new Coordinates(43, 7, 0);

		double distance = Math.sqrt((longitude - NiceTowerPosition.getLongitude()) * (longitude - NiceTowerPosition.getLongitude())
						+ (latitude - NiceTowerPosition.getLatitude()) * (latitude - NiceTowerPosition.getLatitude())
						+ (height - NiceTowerPosition.getHeight()) * (height - NiceTowerPosition.getHeight()));
		if (((int)distance) % 4 == 0) {
			return weather[0];
		} else if (((int)distance) % 4 == 1) {
			return weather[1];
		} else if (((int)distance) % 4 == 2) {
			return weather[2];
		} else {
			return weather[3];
		}
	}



}

