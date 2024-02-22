package avajLauncherPackage;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude, int height) {
		if (longitude <= 0 || latitude <= 0)
			throw new IllegalArgumentException("Coordinates must be positive");
		else if (height > 100)
			throw new IllegalArgumentException("Height must be less than 100");
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
