package avajLauncherPackage;

public class WeatherTower extends Tower{

	public String getWeather(Coordinates p_coordinates)
	{
		WeatherProvider instance = WeatherProvider.getInstance();
		return instance.getCurrentWeather(p_coordinates);
	}

	public void changeWeather()
	{
		this.conditionsChanged();
	}

}
