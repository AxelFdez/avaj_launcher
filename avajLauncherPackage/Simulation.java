package avajLauncherPackage;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.FileWriter;
import java.io.File;

public class Simulation {

	public static void printSimulationsInFile(String string) {
		try {
			FileWriter newFile = new FileWriter("simulation.txt", true);
			newFile.write(string + "\n");
			newFile.close();
		}
		catch (Exception e) {
			System.out.println("Error writing to file: " + e.getMessage());
		}
	}

	public void isSimulationFileExists() {
		try {
			File newFile = new File("simulation.txt");
			if (newFile.exists()) {
				newFile.delete();
			}
		}
		catch (Exception e) {
			System.out.println("Error deleting file: " + e.getMessage());
			System.exit(1);
		}
	}

	public Simulation(int numSimulations, ArrayList<StringTokenizer> flyablesData) {
		isSimulationFileExists();
		WeatherTower newWeatherTower = new WeatherTower();
		int i = 0;
		while (i < flyablesData.size()) {
			AircraftFactory instance = AircraftFactory.getInstance();
			try {
				Flyable newAircraft = instance.newAircraft(flyablesData.get(i).nextToken(), flyablesData.get(i).nextToken(),
								new Coordinates(Integer.parseInt(flyablesData.get(i).nextToken()),
												Integer.parseInt(flyablesData.get(i).nextToken()),
												Integer.parseInt(flyablesData.get(i).nextToken())));
				newAircraft.registerTower(newWeatherTower);
			}
			catch (NumberFormatException e) {
				System.out.println("Invalid Coordinates : " + e.getMessage());
				isSimulationFileExists();
				System.exit(1);
			}
			catch (IllegalArgumentException e) {
				System.out.println("Invalid Flyable type : " + e.getMessage());
				isSimulationFileExists();
				System.exit(1);
			}
			i++;
		}
		i = 0;
		while (i < numSimulations) {
			newWeatherTower.changeWeather();
			i++;
		}
	}
}
