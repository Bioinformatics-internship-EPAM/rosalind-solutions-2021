package RosalindTasks;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class DNA {

	public static List<Integer> solveDNATask () throws IOException {
		var dataSet = Utils.readDataFromFile("resources/rosalind_dna.txt").get(0);
		Map <Character, Integer> map = new HashMap<>();
		for (char c: dataSet.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);
		return List.of(map.get('A'), map.get('C'), map.get('G'), map.get('T'));
	}
	public static void main(String[] args) throws IOException {
		System.out.println(solveDNATask()); 
	}
}
