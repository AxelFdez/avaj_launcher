package avajLauncherPackage;

public class AircraftFactory {

	private static AircraftFactory instance;
	private static int counter;

	public static AircraftFactory getInstance() {
		if (instance == null) {
			counter = 0;
			instance = new AircraftFactory();
		}
		return instance;
	}

	private AircraftFactory() {}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		if (p_type.equals("Baloon")) {
			return new Baloon(++counter, p_name, p_coordinates);
		} else if (p_type.equals("JetPlane")) {
			return new JetPlane(++counter, p_name, p_coordinates);
		}
		else if (p_type.equals("Helicopter")) {
			return new Helicopter(++counter, p_name, p_coordinates);
		} else {
			throw new IllegalArgumentException("Invalid Aircraft Type");
		}
	}
}
