package RosalindTasks;

import java.io.IOException;
import java.util.HashMap;

public class PRTM {

	public static double solvePRMTTask () throws IOException {
		var dataSet = Utils.readDataFromFile("resources/rosalind_prtm.txt").get(0);
		double mass = 0;
		for (char c : dataSet.toCharArray())
		{
			mass += table.get(c);
		}
		return mass;
	}
	
	private static HashMap<Character, Double> table = new HashMap<>();
	static {
        table.put('A', 71.03711);
        table.put('C', 103.00919);
        table.put('D', 115.02694);
        table.put('E', 129.04259);
        table.put('F', 147.06841);
        table.put('G', 57.02146);
        table.put('H', 137.05891);
        table.put('I', 113.08406);
        table.put('K', 128.09496);
        table.put('L', 113.08406);
        table.put('M', 131.04049);
        table.put('N', 114.04293);
        table.put('P', 97.05276);
        table.put('Q', 128.05858);
        table.put('R', 156.10111);
        table.put('S', 87.03203);
        table.put('T', 101.04768);
        table.put('V', 99.06841);
        table.put('W', 186.07931);
        table.put('Y', 163.06333);
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(solvePRMTTask());
	}
}
