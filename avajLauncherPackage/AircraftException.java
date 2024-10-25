package avajLauncherPackage;

public class AircraftException extends IllegalArgumentException {
	public AircraftException(String message) {
		super(message);
	}

	public AircraftException(String message, Throwable cause) {
		super(message, cause);
	}

	public AircraftException(Throwable cause) {
		super(cause);
	}

	public AircraftException() {
		super();
	}
}