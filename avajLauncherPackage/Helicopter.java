package avajLauncherPackage;

public class Helicopter extends Aircraft{

	public Helicopter(long p_id, String p_name, Coordinates p_Coordinates){
		super(p_id, p_name, p_Coordinates);
	}

	@Override
	public String getType(){
		return "Helicopter";
	}

	@Override
	public void updateConditions(){
		String currentWeather = weatherTower.getWeather(coordinates);
		switch (currentWeather){
			case "SUN" :
				if (currentWeather != lastWeather)
					Simulation.printSimulationsInFile("Helicopter#" + name + "(" + id + "): This is hot.");
				coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), (coordinates.getHeight() + 2) > 100 ? 100 : coordinates.getHeight() + 2);
				break;
			case "RAIN" :
				if (currentWeather != lastWeather)
					Simulation.printSimulationsInFile("Helicopter#" + name + "(" + id + "): It's raining. Better watch out for lightings.");
				coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
				break;
			case "FOG" :
				if (currentWeather != lastWeather)
					Simulation.printSimulationsInFile("Helicopter#" + name + "(" + id + "): I can't see anything.");
				coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
				break;
			case "SNOW" :
				if (currentWeather != lastWeather)
					Simulation.printSimulationsInFile("Helicopter#" + name + "(" + id + "): My rotor is going to freeze!");
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
				break;
			default :
		}
		if (coordinates.getHeight() <= 0) {
			Simulation.printSimulationsInFile("Helicopter#" + name + "(" + id + "): landing.");
			weatherTower.unregister(this);
		}
		lastWeather = currentWeather;
	}
}