import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class CONS {
	public static void main(String[] args)
	{
		Path fin = Path.of("data.txt");
		Path fout = Path.of("out.txt");
		int[][] profile = new int[4][];
		int len = 0;
		try 
		{
			List<String> data = Files.readAllLines(fin);
			for(int i = 1; i < data.size(); i++)
			{
				if(data.get(i).charAt(0) != '>')
				{
					len += data.get(i).length();
				}
				else
				{
					break;
				}
			}
			for(int i = 0; i < 4; i++)
			{
				profile[i] = new int[len];
			}
			int currSymb = 0;
			for(String str: data)
			{
				if(str.charAt(0) == '>')
				{
					currSymb = 0;
				}
				else
				{
					for(int i = 0; i < str.length(); i++)
					{
						switch(str.charAt(i))
						{
							case 'A':
								profile[0][i + currSymb]++;
								break;
							case 'C':
								profile[1][i + currSymb]++;
								break;
							case 'G':
								profile[2][i + currSymb]++;
								break;
							case 'T':
								profile[3][i + currSymb]++;
								break;
						}
					}
					currSymb += str.length();
				}
			}
			Files.writeString(fout, "");
			for(int i = 0; i < len; i++)
			{
				int max = profile[0][i], jmax = 0;
				for(int j = 1; j < 4; j++)
				{
					if(profile[j][i] > max)
					{
						max = profile[j][i];
						jmax = j;
					}
				}
				switch(jmax)
				{
					case 0:
						Files.writeString(fout, "A", StandardOpenOption.APPEND);
						break;
					case 1:
						Files.writeString(fout, "C", StandardOpenOption.APPEND);
						break;
					case 2:
						Files.writeString(fout, "G", StandardOpenOption.APPEND);
						break;
					case 3:
						Files.writeString(fout, "T", StandardOpenOption.APPEND);
						break;
				}
			}
			Files.writeString(fout, "\nA:", StandardOpenOption.APPEND);
			for(int j = 0; j < len; j++)
			{
				Files.writeString(fout, " " + profile[0][j], StandardOpenOption.APPEND);
			}
			Files.writeString(fout, "\nC:", StandardOpenOption.APPEND);
			for(int j = 0; j < len; j++)
			{
				Files.writeString(fout, " " + profile[1][j], StandardOpenOption.APPEND);
			}
			Files.writeString(fout, "\nG:", StandardOpenOption.APPEND);
			for(int j = 0; j < len; j++)
			{
				Files.writeString(fout, " " + profile[2][j], StandardOpenOption.APPEND);
			}
			Files.writeString(fout, "\nT:", StandardOpenOption.APPEND);
			for(int j = 0; j < len; j++)
			{
				Files.writeString(fout, " " + profile[3][j], StandardOpenOption.APPEND);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
