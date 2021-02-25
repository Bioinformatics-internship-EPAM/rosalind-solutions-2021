package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String c = bufferedReader.readLine();
		HashMap<Character, Character> map = new HashMap<Character, Character>(Map.of(
				'A', 'T',
				'T', 'A',
				'C', 'G',
				'G', 'C'
		));

		StringBuilder str = new StringBuilder();
		for (int i = c.length() - 1; i >= 0; i--) {
			str.append(map.get(c.charAt(i)));
		}

		String result = str.toString();
		System.out.println(result);
	}
}