import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class IPRB {
	public static void main(String[] args)
	{
		Path fin = Path.of("data.txt");
		Path fout = Path.of("out.txt");		
		try 
		{
			String[] data = Files.readString(fin).split(" ");
			double prob= 0;			
			double countDom =Double.parseDouble(data[0]), countHet = Double.parseDouble(data[1]), countRec = Double.parseDouble(data[2]);
			double allOrg = countDom + countHet + countRec;
			//dom + dom
			prob += countDom / allOrg * (countDom - 1) / (allOrg - 1);
			//dom + het
			prob += countDom / allOrg * countHet / (allOrg - 1);
			//dom + rec
			prob += countDom / allOrg * countRec / (allOrg - 1);
			//het + dom
			prob += countHet / allOrg * countDom / (allOrg - 1);
			//het + het
			prob += countHet / allOrg * (countHet - 1) / (allOrg - 1) * 3 / 4;
			//het + rec
			prob += countHet / allOrg * countRec / (allOrg - 1) * 1 / 2;
			//rec + dom
			prob += countRec / allOrg * countDom / (allOrg - 1);
			//rec + het
			prob += countRec / allOrg * countHet / (allOrg - 1) * 1 / 2;
			//rec + rec = 0
			Files.writeString(fout, Double.toString(prob));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
