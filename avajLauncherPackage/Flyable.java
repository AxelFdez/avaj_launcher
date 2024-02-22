package avajLauncherPackage;

public abstract class Flyable {

	protected WeatherTower weatherTower;

	public abstract void updateConditions();
	public void registerTower(WeatherTower p_tower) {
		this.weatherTower = p_tower;
		weatherTower.register(this);
	}

	public abstract String getType();
	public abstract String getName();
	public abstract String getId();
}
