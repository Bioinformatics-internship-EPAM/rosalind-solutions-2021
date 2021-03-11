package tasks;

//Link : http://rosalind.info/problems/rna/
public class TranscribingDnaIntoRna {
    public static String translateIntoRna(String dna) {
        return dna.replace("T", "U");
    }
}
