package avajLauncherPackage;
import java.util.ArrayList;

public class Tower {
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable p_flyable) {
		observers.add(p_flyable);
		Simulation.printSimulationsInFile("Tower says: " + p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") registered to weather tower.");

	}

	public void unregister(Flyable p_flyable) {
		observers.remove(p_flyable);
		Simulation.printSimulationsInFile("Tower says: " + p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") unregistered from weather tower.");
	}

	protected void conditionsChanged() {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).updateConditions();
		}
	}
}
