import avajLauncherPackage.*;
import java.util.StringTokenizer;

class avajLauncher {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java avajLauncher scenario.txt");
			System.exit(1);
		}
		ValidateScenario validateFile = ValidateScenario.getInstance(args[0]);
		Simulation simulation = new Simulation(validateFile.getNumSimulations(), validateFile.getFlyablesData());
	}
};