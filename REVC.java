package RosalindTasks;

import java.io.IOException;


public class REVC {
	
	public static String solveREVCTask () throws IOException {
		var dataSet = Utils.readDataFromFile("resources/rosalind_revc.txt").get(0);
		String complimentDNAString = new String();
		String reversedString = new StringBuffer(dataSet).reverse().toString();
		for (int i=0; i < dataSet.length(); i++)
		{
			if (reversedString.charAt(i) == 'A') {
				complimentDNAString += 'T';
			}
			else if (reversedString.charAt(i) == 'G') {
				complimentDNAString += 'C';
			}
			else if (reversedString.charAt(i) == 'T') {
				complimentDNAString += 'A';
			}
			else {
				complimentDNAString += 'G';
			}
		}
		return complimentDNAString;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(solveREVCTask());
	}
}
