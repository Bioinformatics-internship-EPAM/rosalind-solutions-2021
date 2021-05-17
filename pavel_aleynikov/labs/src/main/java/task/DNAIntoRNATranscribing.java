package task;

/**
 * Transcribing DNA into RNA
 * <p>
 * http://rosalind.info/problems/rna/
 */
public class DNAIntoRNATranscribing {

    /**
     * Transcribe DNA into RNA
     *
     * @param dna - DNA string contains chars: {'A', 'C', 'G', 'T'}
     * @return - RNA string contains chars: {'A', 'C', 'G', 'U'}
     */
    public static String transcribe(String dna) {
        return dna.replace('T', 'U');
    }

}
