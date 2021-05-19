package covid;

import covid.rosalind.DNAIntoRNA;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static covid.rosalind.CalculatingProteinMass.calcMass;
import static covid.rosalind.ComplDNA.complementingDNA;
import static covid.rosalind.RNAIntoProtein.createProtein;


public class Main {

    private static String openFrame(String str) {
        int start = str.indexOf("ATG");
        int i = start + 3;
        while (i < str.length() - 3 && start != -1) {
            String endStr = str.substring(i, i + 3);
            if (endStr.equals("TAG") || endStr.equals("TGA") || endStr.equals("TAA")) {
                return str.substring(start, i + 3);
            }
            i += 3;
        }
        return "";
    }

    public static List<String> searchProtein(String str){
        int i=0;
        List<String> res=new ArrayList<>();
        while(i<str.length()-6) {
            String dna1 = openFrame(str.substring(i));
            if(dna1.equals("")){
                break;
            }
            i+= str.substring(i).indexOf("ATG")+3;
            String rna1 = DNAIntoRNA.createRNA(dna1);
            String s=createProtein(rna1);
            if(!res.contains(s)) {
                res.add(s);
                double mass=calcMass(s);
                res.add(String.valueOf(mass));
            }
        }
        str=complementingDNA(str);
        i=0;
        while(i<str.length()-6) {
            String dna1 = openFrame(str.substring(i));
            if(dna1.equals("")){
                break;
            }
            i+= str.substring(i).indexOf("ATG")+3;
            String rna1 = DNAIntoRNA.createRNA(dna1);
            String s=createProtein(rna1);
            if(!res.contains(s)) {
                res.add(s);
                double mass=calcMass(s);
                res.add(String.valueOf(mass));
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        String pathIn = "src/covid/genome.fasta";
        String pathOut = "src/covid/genomeRes.txt";
        FileReader fileReader = new FileReader(pathIn);
        FileWriter fileWriter = new FileWriter(pathOut);
        Scanner scanner = new Scanner(fileReader);
        String name = "";
        String str = "";
        List<String> res = new ArrayList<>();
        name = scanner.nextLine();
        while (scanner.hasNext()) {
            str += scanner.nextLine();
        }
        res = searchProtein(str);
        for (String s : res) {
            fileWriter.write(s + "\n");
        }
        fileReader.close();
        fileWriter.close();
    }
}
