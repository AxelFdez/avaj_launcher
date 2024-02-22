package avajLauncherPackage;

public class Aircraft extends Flyable{

	protected Aircraft(long p_id, String p_name, Coordinates p_Coordinates) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_Coordinates;
	};


	@Override
	public void updateConditions() {
	}

	@Override
	public String getType() {
		return "Aircraft";
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getId() {
		return Long.toString(this.id);
	}


	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected String lastWeather;
}
