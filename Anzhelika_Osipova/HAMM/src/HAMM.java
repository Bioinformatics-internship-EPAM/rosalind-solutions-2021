import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HAMM {
	
	public static void main(String[] args)
	{
		Path fin = Path.of("data.txt");
		Path fout = Path.of("out.txt");		
		try 
		{
			List<String> data = Files.readAllLines(fin);
			String str1 = data.get(0);
			String str2 = data.get(1);
			int hamm = 0;
			for(int i = 0; i < str1.length(); i++)
			{
				if(str1.charAt(i) != str2.charAt(i))
				{
					hamm++;
				}
			}
			Files.writeString(fout, Integer.toString(hamm));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
