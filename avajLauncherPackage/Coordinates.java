package avajLauncherPackage;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude, int height) {
		// System.out.println("Coordinates: " + longitude + " " + latitude + " " + height);
		// if (longitude < -180 || longitude > 180)
		// 	throw new AircraftException("Longitude must be between -180 and 180 : " + longitude);
		// else if (latitude < -90 || latitude > 90)
		// 	throw new AircraftException("Latitude must be between -90 and 90 : " + latitude);
		// if (height > 100)
		// 	throw new AircraftException("Height must be less than 100 : " + height);
		// else if (height < 0)
		// 	throw new AircraftException("Height must be positive : " + height);
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public int getLongitude() {
		return this.longitude;
	}

	public int getLatitude() {
		return this.latitude;
	}

	public int getHeight() {
		return this.height;
	}
}
