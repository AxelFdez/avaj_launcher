package avajLauncherPackage;

public class JetPlane extends Aircraft{

	JetPlane(long p_id, String p_name, Coordinates p_coordinates){
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public String getType(){
		return "Jetplane";
	}

	@Override
	public void updateConditions(){
		String currentWeather = weatherTower.getWeather(coordinates);
		switch (currentWeather){
			case "SUN" :
				if (currentWeather != lastWeather)
					Simulation.printSimulationsInFile("Jetplane#" + name + "(" + id + "): I take my sunglasses.");
				coordinates = new Coordinates(coordinates.getLongitude(), (coordinates.getLatitude() + 10) > 90 ? -90 : coordinates.getLatitude() + 10, (coordinates.getHeight() + 2) > 100 ? 100 : coordinates.getHeight() + 2);
				break;
			case "RAIN" :
				if (currentWeather != lastWeather)
					Simulation.printSimulationsInFile("Jetplane#" + name + "(" + id + "): So much flashes in the sky.");
				coordinates = new Coordinates(coordinates.getLongitude(), (coordinates.getLatitude() + 5) > 90 ? -90 : coordinates.getLatitude() + 5, coordinates.getHeight());
				break;
			case "FOG" :
				if (currentWeather != lastWeather)
					Simulation.printSimulationsInFile("Jetplane#" + name + "(" + id + "): I drive only with my radar.");
				coordinates = new Coordinates(coordinates.getLongitude(), (coordinates.getLatitude() + 1) > 90 ? -90 : coordinates.getLatitude() + 1, coordinates.getHeight());
				break;
			case "SNOW" :
				if (currentWeather != lastWeather)
					Simulation.printSimulationsInFile("Jetplane#" + name + "(" + id + "): Fortunately, I have a heater.");
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
				break;
			default :
		}
		if (coordinates.getHeight() <= 0) {
			Simulation.printSimulationsInFile("Jetplane#" + name + "(" + id + "): landing.");
			weatherTower.unregister(this);
		}
		lastWeather = currentWeather;
	}

}
