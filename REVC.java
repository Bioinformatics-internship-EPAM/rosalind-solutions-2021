package RosalindTasks;

import java.io.IOException;
import java.util.Properties;


public class REVC {

	public static String solveREVCTask () throws IOException {
		var dataSet = Utils.readDataFromFile("resources/rosalind_revc.txt").get(0);
		StringBuilder complimentDNAString = new StringBuilder();
		String reversedString = new StringBuilder(dataSet).reverse().toString();
		var complements = Map.of(
			    'A', 'T',
			    'T', 'A',
			    'G', 'C',
			    'C', 'G'
		);
		for (int i=0; i < dataSet.length(); i++) {
			complimentDNAString.append(complements::get(charAt(i)))
		}
		return complimentDNAString;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(solveREVCTask());
	}
}
