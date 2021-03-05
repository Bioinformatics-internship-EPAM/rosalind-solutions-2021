package RosalindTasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PROT {

	private static final String STOP_CODON = "Stop";

	public static ArrayList <String> solvePROTTask () throws IOException {
		var dataSet = Utils.readDataFromFile("resources/rosalind_prot.txt").get(0);
		int codonLength = 3;
		ArrayList<String> protein = new ArrayList<>();
		for (int i=0; i < dataSet.length() - codonLength; i+= codonLength) {
			var aminoAcid = table.get(dataSet.substring(i, i + codonLength));
			if (aminoAcid.equals(STOP_CODON)) {
				break;
			}
			else {
				protein.add(aminoAcid);
			}
		}
		return protein;
	}
	
	private static HashMap<String, String> table = new HashMap<>();
	static {
        table.put("UUU", "F");
        table.put("UUC", "F");
        table.put("UUA", "L");
        table.put("UUG", "L");
        table.put("CUU", "L");
        table.put("CUC", "L");
        table.put("CUA", "L");
        table.put("CUG", "L");
        table.put("UCU", "S");
        table.put("UCC", "S");
        table.put("UCA", "S");
        table.put("UCG", "S");
        table.put("UAU", "Y");
        table.put("UAC", "Y");
        table.put("AUU", "I");
        table.put("AUC", "I");
        table.put("AUA", "I");
        table.put("GUU", "V");
        table.put("GUC", "V");
        table.put("GUA", "V");
        table.put("GUG", "V");
        table.put("AUG", "M");
        table.put("CCU", "P");
        table.put("CCC", "P");
        table.put("CCA", "P");
        table.put("CCG", "P");
        table.put("ACU", "T");
        table.put("ACC", "T");
        table.put("ACA", "T");
        table.put("ACG", "T");
        table.put("GCU", "A");
        table.put("GCC", "A");
        table.put("GCA", "A");
        table.put("GCG", "A");
        table.put("CAU", "H");
        table.put("CAC", "H");
        table.put("AAU", "N");
        table.put("AAC", "N");
        table.put("GAU", "D");
        table.put("GAC", "D");
        table.put("CAA", "Q");
        table.put("CAG", "Q");
        table.put("AAA", "K");
        table.put("AAG", "K");
        table.put("GAA", "E");
        table.put("GAG", "E");
        table.put("UGU", "C");
        table.put("UGC", "C");
        table.put("CGU", "R");
        table.put("CGC", "R");
        table.put("CGA", "R");
        table.put("AGA", "R");
        table.put("CGG", "R");
        table.put("AGG", "R");
        table.put("AGU", "S");
        table.put("AGC", "S");
        table.put("GGU", "G");
        table.put("GGC", "G");
        table.put("GGA", "G");
        table.put("GGG", "G");
        table.put("UGG", "W");
        table.put("UAA", STOP_CODON);
        table.put("UAG", STOP_CODON);
        table.put("UGA", STOP_CODON);
	}

	public static void main(String[] args) throws IOException {
		for (int i=0; i < solvePROTTask().size(); i++)
			System.out.print(solvePROTTask().get(i));
	}
}
