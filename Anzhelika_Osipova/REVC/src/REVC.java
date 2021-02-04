import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class REVC {
	public static void main(String[] args)
	{
		Path fin = Path.of("data.txt");
		Path fout = Path.of("out.txt");
		try 
		{
			String data = Files.readString(fin);
			StringBuilder data3 = new StringBuilder(data);
			for(int i = 0; i < data.length(); i++)
			{
				switch(data.charAt(i))
				{
					case 'A':
						data3.setCharAt(data.length() - 1 - i, 'T');
						break;
					case 'T':
						data3.setCharAt(data.length() - 1 - i, 'A');
						break;
					case 'C':
						data3.setCharAt(data.length() - 1 - i, 'G');
						break;
					case 'G':
						data3.setCharAt(data.length() - 1 - i, 'C');
						break;
				}
			}
			data = data3.toString();
			Files.writeString(fout, data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
