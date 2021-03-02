package ru.spbstu.coursework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		String s = "";
		String t = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			s = br.readLine();
			t = br.readLine();
		}

		List<Integer> positions = new ArrayList<Integer>();

		int index = 0;
		while (index != -1) {
			index = s.indexOf(t, index);
			if (index != -1) {
				index++;
				positions.add(index);
			}
		}

		for (int i = 0; i < positions.size(); i++) {
			System.out.print(positions.get(i) + " ");
		}
	}
}
