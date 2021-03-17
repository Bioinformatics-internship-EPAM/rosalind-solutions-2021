package RosalindTasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class PROT {

	private static final String STOP_CODON = "Stop";

	public static ArrayList <String> solvePROTTask () throws IOException {
		var dataSet = Utils.readDataFromFile("resources/rosalind_prot.txt").get(0);
		var proteintFile = Utils.readDataFromFile("resources/Constants.properties").get(0);
		Properties properties = new Properties();
		properties.load(proteinFile);
		int codonLength = 3;
		String codon = dataSet.substring();
		ArrayList <String> protein = new ArrayList<>();
		for (int i = 0; i < dataSet.length() - codonLength; i += codonLength) {
			var aminoAcid = properties.getProperty(codon(i, i + codonLength));
			if (aminoAcid.equals(STOP_CODON)) {
				break;
			}
			else {
				protein.add(aminoAcid);
			}
		}
		return protein;
	}

	public static void main(String[] args) throws IOException {
		for (int i=0; i < solvePROTTask().size(); i++)
			System.out.print(solvePROTTask().get(i));
	}
}
