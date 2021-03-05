package RosalindTasks;

import java.io.IOException;
import java.util.ArrayList;

public class SUBS {

	public static ArrayList<Integer> solveSUBSTask () throws IOException {
		var firstDataSet = Utils.readDataFromFile("resources/rosalind_subs.txt").get(0);
		var secondDataSet = Utils.readDataFromFile("resources/rosalind_subs.txt").get(1);
		int index = 0;
		ArrayList<Integer> indexes = new ArrayList<>();
		if (firstDataSet.length() < secondDataSet.length()) {
			System.out.println("Second DNA string must be equal or smaller than first DNA string");
		}
		else {
			while (index + secondDataSet.length() != firstDataSet.length()-1) {
				index = firstDataSet.indexOf(secondDataSet, index);
				if (index != -1) {
					index += 1;
					indexes.add(index);
				}
				else {
					break;
				}
			}
		}
		return indexes;
	}
	public static void main(String[] args) throws IOException {
		System.out.println(solveSUBSTask());
	}
}
