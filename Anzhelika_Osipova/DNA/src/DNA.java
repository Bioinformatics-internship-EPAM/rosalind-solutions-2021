import java.io.*;
import java.nio.file.*;

public class DNA 
{

	public static void main(String[] args)
	{
		Path fin = Path.of("data.txt");
		Path fout = Path.of("out.txt");
		int[] countNuc = {0, 0, 0, 0};
		try 
		{
			String data = Files.readString(fin);
			for(int i = 0; i < data.length(); i++)
			{
				switch(data.charAt(i))
				{
					case ('A'):
						countNuc[0]++;
						break;
					case ('C'):
						countNuc[1]++;
						break;
					case ('G'):
						countNuc[2]++;
						break;
					case ('T'):
						countNuc[3]++;
						break;					
				}
			}
			Files.writeString(fout, countNuc[0] + " " + countNuc[1] + " " + countNuc[2] + " " + countNuc[3]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}