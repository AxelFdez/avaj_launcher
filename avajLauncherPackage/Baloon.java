package avajLauncherPackage;

public class Baloon extends Aircraft{

	public Baloon(long p_id, String p_name, Coordinates p_Coordinates){
		super(p_id, p_name, p_Coordinates);
	}

	@Override
	public String getType(){
		return "Baloon";
	}

	@Override
	public void updateConditions(){
		String currentWeather = weatherTower.getWeather(coordinates);
		switch (currentWeather){
			case "SUN" :
				if (currentWeather != lastWeather)
					Simulation.printSimulationsInFile("Baloon#" + name + "(" + id + "): What a sunny day.");
				coordinates = new Coordinates((coordinates.getLongitude() + 2) > 180 ? -180 : (coordinates.getLongitude() + 2), coordinates.getLatitude(), (coordinates.getHeight() + 4) > 100 ? 100 : coordinates.getHeight() + 4);
				break;
			case "RAIN" :
				if (currentWeather != lastWeather)
					Simulation.printSimulationsInFile("Baloon#" + name + "(" + id + "): Watch out for the rain.");
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
				break;
			case "FOG" :
				if (currentWeather != lastWeather)
					Simulation.printSimulationsInFile("Baloon#" + name + "(" + id + "): Where am I?");
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
				break;
			case "SNOW" :
				if (currentWeather != lastWeather)
					Simulation.printSimulationsInFile("Baloon#" + name + "(" + id + "): It's snowing. We're going down!");
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
				break;
			default :
		}
		if (coordinates.getHeight() <= 0) {
			Simulation.printSimulationsInFile("Baloon#" + name + "(" + id + "): landing.");
			weatherTower.unregister(this);
		}
		lastWeather = currentWeather;
	}

}
