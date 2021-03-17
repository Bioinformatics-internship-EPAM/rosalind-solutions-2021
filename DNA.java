package RosalindTasks;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class DNA {

	public static List<Integer> solveDNATask () throws IOException {
		var dataSet = Utils.readDataFromFile("resources/rosalind_dna.txt").get(0);
		Map <Character, Integer> map = new HashMap<>();
		for (int i=0; i < dataSet.length(); i++) {
			map.merge(charAt(i), 1, Integer::sum);
		}
		return List.of(map.get('A'), map.get('C'), map.get('G'), map.get('T'));
	}
	public static void main(String[] args) throws IOException {
		System.out.println(solveDNATask()); 
	}
}
