import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class PROT {
	public static void main(String[] args)
	{
		Path fin = Path.of("data.txt");
		Path fout = Path.of("out.txt");	
		Path dicttxt = Path.of("dict.txt");
		StringBuilder res = new StringBuilder();
		try 
		{
			String[] data = Files.readString(dicttxt).split("\n");
			Map<String,String> dict = new HashMap<String,String>();
			for(int i = 0; i < data.length; i++)
			{
				String[] data2 = data[i].split(" ");
				dict.put(data2[0], data2[1].substring(0,1)); //\n?
			}
			
			String data2 = Files.readString(fin);
			for(int i = 0; i < data2.length() / 3 - 1; i++)
			{
				res.append(dict.get(data2.substring(i * 3, i * 3 + 3)));
			}
			Files.writeString(fout, res.toString());
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
