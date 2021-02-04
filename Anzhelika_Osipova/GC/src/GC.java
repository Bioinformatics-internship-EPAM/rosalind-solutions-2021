import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class GC {
	public static void main(String[] args)
	{
		Path fin = Path.of("data.txt");
		Path fout = Path.of("out.txt");
		try 
		{
			List<String> data = Files.readAllLines(fin);
			String idMaxGC = "", idCurrGC = "";
			double maxGC = 0, currGC = 0;
			double cntGC = 0, allLen = 1;
			for(String str: data)
			{
				if(str.charAt(0) == '>')
				{
					currGC = cntGC / allLen * 100;
					if(maxGC < currGC)
					{
						maxGC = currGC;
						idMaxGC = idCurrGC;
					}
					idCurrGC = str.substring(1);
					currGC = 0;
					cntGC = 0;
					allLen = 0;
				}
				else
				{
					cntGC += str.chars().filter(ch -> (ch =='G' || ch == 'C')).count();
					allLen += str.length();
				}
			}
			currGC = cntGC / allLen * 100;
			if(maxGC < currGC)
			{
				maxGC = currGC;
				idMaxGC = idCurrGC;
			}
			Files.writeString(fout, idMaxGC + "\n" + maxGC);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
