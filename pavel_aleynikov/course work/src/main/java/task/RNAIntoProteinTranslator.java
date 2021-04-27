package task;

import dto.Protein;
import utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Translating RNA into Protein with Open Reading Frames
 * <p>
 * http://rosalind.info/problems/orf/
 */
public class RNAIntoProteinTranslator {

    /**
     * Translating RNA into Protein with ORF
     *
     * @param rna - RNA string contains chars: {'A', 'C', 'G', 'U'}
     * @return - list of proteins
     */
    public static List<Protein> translate(String rna) {
        List<Integer> startFrameIndexes = findAllStartFrameIndex(rna);
        List<Protein> result = new ArrayList<>();
        for (Integer startIndex : startFrameIndexes) {
            StringBuilder protein = new StringBuilder();
            for (int i = startIndex; i + Constants.CODON_LENGTH <= rna.length(); i += Constants.CODON_LENGTH) {
                String s = Constants.RNA_CODON_TABLE.get(rna.substring(i, i + Constants.CODON_LENGTH));
                if (s.equals(Constants.STOP_CODON)) {
                    result.add(new Protein(startIndex, i + Constants.CODON_LENGTH, protein.toString()));
                    break;
                }
                protein.append(s);
            }
        }
        return result;
    }

    /**
     * Find indexes of start codon
     *
     * @param rna - RNA string contains chars: {'A', 'C', 'G', 'U'}
     * @return - list of start codon index
     */
    private static List<Integer> findAllStartFrameIndex(String rna) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i + Constants.CODON_LENGTH < rna.length(); i++) {
            String s = rna.substring(i, i + Constants.CODON_LENGTH);
            if (s.equals(Constants.START_CODON)) {
                result.add(i);
            }
        }
        return result;
    }

}
