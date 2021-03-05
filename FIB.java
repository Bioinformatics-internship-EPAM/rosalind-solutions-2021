package RosalindTasks;

import java.io.IOException;

public class FIB {

	public static long solveFIBTask () throws IOException {
		var dataSet = Utils.readDataFromFile("resources/rosalind_fib.txt").get(0);
		int months = Integer.parseInt(dataSet.split(" ")[0]);
		int rabbitsProductivity = Integer.parseInt(dataSet.split(" ")[1]);
		long parents = 1;
		long pairsNumber = 1;
		long children = 0;
		if (months == 1 || months == 2)
			pairsNumber = 1;
		else {
			for (int i=2; i < months; i++) {
				children = (parents * rabbitsProductivity) + pairsNumber;
				parents = pairsNumber;
				pairsNumber = children;
			}
		}
		return pairsNumber;
	}
	public static void main(String[] args) throws IOException {
		System.out.println(solveFIBTask());
	}
}
