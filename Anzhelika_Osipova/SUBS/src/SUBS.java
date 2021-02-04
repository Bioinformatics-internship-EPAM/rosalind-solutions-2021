import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class SUBS {
	public static void main(String[] args)
	{
		Path fin = Path.of("data.txt");
		Path fout = Path.of("out.txt");			
		try 
		{
			List<String> data = Files.readAllLines(fin);
			String str = data.get(0), substr = data.get(1);
			Files.writeString(fout, "");
			for(int i = 0; i < str.length() - substr.length(); i++)
			{
				if(str.substring(i).startsWith(substr))
				{
					Files.writeString(fout, i + 1 + " ", StandardOpenOption.APPEND);
				}
			}			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
