package ru.spbstu.coursework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static final int CODON_LENGTH = 3;

	public static void main(String[] args) throws IOException {
		String s = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			s = br.readLine();
		}

		StringBuilder b = new StringBuilder();
		Map<String, String> table = getCodonTable();
		for (int i = 0; i < s.length(); i += CODON_LENGTH) {
			String substring = s.substring(i, i + CODON_LENGTH);
			String value = table.get(substring);
			if (value == "Stop") {
				break;
			}

			b.append(value);
		}

		System.out.println(b.toString());
	}

	private static HashMap<String, String> getCodonTable() {
		HashMap<String, String> table = new HashMap<>();
		table.put("UUU", "F");
		table.put("CUU", "L");
		table.put("AUU", "I");
		table.put("GUU", "V");
		table.put("UUC", "F");
		table.put("CUC", "L");
		table.put("AUC", "I");
		table.put("GUC", "V");
		table.put("UUA", "L");
		table.put("CUA", "L");
		table.put("AUA", "I");
		table.put("GUA", "V");
		table.put("UUG", "L");
		table.put("CUG", "L");
		table.put("AUG", "M");
		table.put("GUG", "V");
		table.put("UCU", "S");
		table.put("CCU", "P");
		table.put("ACU", "T");
		table.put("GCU", "A");
		table.put("UCC", "S");
		table.put("CCC", "P");
		table.put("ACC", "T");
		table.put("GCC", "A");
		table.put("UCA", "S");
		table.put("CCA", "P");
		table.put("ACA", "T");
		table.put("GCA", "A");
		table.put("UCG", "S");
		table.put("CCG", "P");
		table.put("ACG", "T");
		table.put("GCG", "A");
		table.put("UAU", "Y");
		table.put("CAU", "H");
		table.put("AAU", "N");
		table.put("GAU", "D");
		table.put("UAC", "Y");
		table.put("CAC", "H");
		table.put("AAC", "N");
		table.put("GAC", "D");
		table.put("UAA", "Stop");
		table.put("CAA", "Q");
		table.put("AAA", "K");
		table.put("GAA", "E");
		table.put("UAG", "Stop");
		table.put("CAG", "Q");
		table.put("AAG", "K");
		table.put("GAG", "E");
		table.put("UGU", "C");
		table.put("CGU", "R");
		table.put("AGU", "S");
		table.put("GGU", "G");
		table.put("UGC", "C");
		table.put("CGC", "R");
		table.put("AGC", "S");
		table.put("GGC", "G");
		table.put("UGA", "Stop");
		table.put("CGA", "R");
		table.put("AGA", "R");
		table.put("GGA", "G");
		table.put("UGG", "W");
		table.put("CGG", "R");
		table.put("AGG", "R");
		table.put("GGG", "G");

		return table;
	}
}
