import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RNA {
	
	public static void main(String[] args)
	{
		Path fin = Path.of("data.txt");
		Path fout = Path.of("out.txt");
		int[] countNuc = {0, 0, 0, 0};
		try 
		{
			String data = Files.readString(fin);
			data = data.replace('T', 'U');
			Files.writeString(fout, data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
