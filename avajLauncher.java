import avajLauncherPackage.*;

class avajLauncher {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java avajLauncher scenario.txt");
			System.exit(1);
		}
		try {
			ValidateScenario validateFile = ValidateScenario.getInstance(args[0]);
			new Simulation(validateFile.getNumSimulations(), validateFile.getFlyablesData());
		}
		catch (Exception e) {
			System.out.println("Error in runtime: " + e.getMessage());
			System.exit(1);
		}
	}
};