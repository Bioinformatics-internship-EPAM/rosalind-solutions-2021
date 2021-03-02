package ru.spbstu.coursework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		String c = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			c = br.readLine();
		}

		Map<Character, Character> map = Map.of(
				'A', 'T',
				'T', 'A',
				'C', 'G',
				'G', 'C'
		);

		StringBuilder str = new StringBuilder();
		for (int i = c.length() - 1; i >= 0; i--) {
			str.append(map.get(c.charAt(i)));
		}

		String result = str.toString();
		System.out.println(result);
	}
}
