package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String s = bufferedReader.readLine();
		String t = bufferedReader.readLine();

		List<Integer> positions = new ArrayList<Integer>();

		int index = 0;
		while (index != -1) {
			index = s.indexOf(t, index);
			if (index != -1) {
				positions.add(++index);
			}
		}

		for (int i = 0; i < positions.size(); i++) {
			System.out.print(positions.get(i) + " ");
		}
	}
}