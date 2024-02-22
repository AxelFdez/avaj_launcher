package avajLauncherPackage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ValidateScenario{

	private static ValidateScenario instance;

	public static ValidateScenario getInstance(String scenario) {
		if (instance == null) {
			instance = new ValidateScenario(scenario);
		}
		return instance;
	}

	private ValidateScenario(String scenario) {

		if (scenario.length() == 0) {
			throw new IllegalArgumentException("Scenario file is empty");
		}
		try {
			file = testFile(scenario);
			getValues(file);
		} catch (Exception e) {
			System.out.println("Error with file: " + e.getMessage());
			System.exit(1);
		}
		// getValues(file);
	}

	private File file;

	private static File testFile(String scenario) throws IOException {
        File file = new File(scenario);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found");
        } else if (!file.canRead()) {
            throw new IOException("Error reading file");
        }
        return file;
    }

	public int getNumSimulations() {
		return numSimulations;
	}

	public ArrayList<StringTokenizer> getFlyablesData() {
		return flyablesData;
	}

	private static int numSimulations;
	private static ArrayList<StringTokenizer> flyablesData;

	private static void getValues(File file) {
		ArrayList<String> lines = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		numSimulations = Integer.parseInt(lines.get(0));
		if (numSimulations <= 0) {
			throw new IllegalArgumentException("Number of simulations must be a positive integer");
		}
		else if (numSimulations > Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Number of simulations must be less than " + Integer.MAX_VALUE);
		}
		lines.remove(0);
		for (String line : lines) {
			StringTokenizer st = new StringTokenizer(line, " ");
			if (st.countTokens() != 5) {
				throw new IllegalArgumentException("Invalid number of arguments in line: " + line + " need 5 parameters");
			}
			if (flyablesData == null)
				flyablesData = new ArrayList<StringTokenizer>();
			flyablesData.add(st);
		}
	}
}
