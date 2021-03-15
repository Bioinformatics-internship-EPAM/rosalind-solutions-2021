package RosalindTasks;

import java.io.IOException;

public class HAMM {

	public static int solveHAMMTask () throws IOException {
		var firstDataSet = Utils.readDataFromFile("resources/rosalind_hamm.txt").get(0);
		var secondDataSet = Utils.readDataFromFile("resources/rosalind_hamm.txt").get(1);
		int hamDistance = 0;
		for (int i=0; i < firstDataSet.length(); i++) {
			if (firstDataSet.charAt(i) != secondDataSet.charAt(i)) {
				hamDistance += 1;
			}
		}
		return hamDistance;
	}
	public static void main(String[] args) throws IOException {
		System.out.println(solveHAMMTask());
	}
}
