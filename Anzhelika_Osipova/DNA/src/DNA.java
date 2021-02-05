import java.io.*;
import java.nio.file.*;

public class DNA 
{
	//function reads a DNA string from a file
	public static String readInputFile(String fileName)
	{
		Path fin = Path.of(fileName);
		String data = null;
		try 
		{
			data = Files.readString(fin);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return data;
	}
	
	//function counts nucleotides in a DNA string
	public static int[] countNucleotides(String data)
	{
		int[] countNuc = {0, 0, 0, 0};
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
		return countNuc;
	}
	
	//function writes number of nucleotides in a string into a file
	public static void writeInFile(String fileName, int[] countNuc)
	{
		Path fout = Path.of(fileName);
		try 
		{
			Files.writeString(fout, countNuc[0] + " " + countNuc[1] + " " + countNuc[2] + " " + countNuc[3]);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		//reading of input data
		String data = readInputFile("data.txt");
		
		//count nucleotides in a given string
		int[] countNuc = countNucleotides(data);
		
		//write results in a file
		writeInFile("out.txt", countNuc);
	}

}