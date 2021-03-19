package RosalindTasks;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class PRTM {

	public static double solvePRMTTask () throws IOException {
		var dataSet = Utils.readDataFromFile("resources/rosalind_prtm.txt").get(0);
		var proteintMassFile = Utils.readDataFromFile("resources/Constants.properties").get(0);
		Properties properties = new Properties();
		properties.load(proteinMassFile);
		double mass = 0;
		for (char c : dataSet.toCharArray()) {
			mass += properties.getProperty(c);
		}
		return mass;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(solvePRMTTask());
	}
}
