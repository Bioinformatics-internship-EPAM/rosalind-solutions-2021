import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FIB {
	public static void main(String[] args)
	{
		Path fin = Path.of("data.txt");
		Path fout = Path.of("out.txt");
		try 
		{
			String data = Files.readString(fin);
			String[] params = data.split(" ");
			long oldRabbits = 0;
			long youngRabbits = 1;
			long newRabbits;
			for (int month = 1; month < Integer.parseInt(params[0]) + 1; month++)
			{
				newRabbits = oldRabbits * Integer.parseInt(params[1]);
				oldRabbits += youngRabbits;
				youngRabbits = newRabbits;
			}
			Files.writeString(fout, Long.toString(oldRabbits));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
