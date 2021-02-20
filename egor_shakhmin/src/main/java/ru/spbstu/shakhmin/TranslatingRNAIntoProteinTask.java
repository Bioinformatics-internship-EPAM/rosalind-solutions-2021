package ru.spbstu.shakhmin;

import com.google.common.base.Splitter;
import ru.spbstu.shakhmin.utils.RosalindUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class TranslatingRNAIntoProteinTask implements RosalindTask {

    private static final String DATASET_FILE_NAME = "translating_rna_into_protein.txt";
    private static final String RNA_CODON_TABLE_FILE_NAME = "rna_codon_table.txt";
    private static final String STOP = "Stop";
    private static final int RNA_CODON_LENGTH = 3;

    private final Map<String, String> rnaCodonToAminoAcid;

    public TranslatingRNAIntoProteinTask() throws Exception {
        rnaCodonToAminoAcid = RosalindUtils.loadDataset(RNA_CODON_TABLE_FILE_NAME).stream()
                .flatMap(line -> Arrays.stream(line.split("\\s\\s+")))
                .map(translation -> translation.split("\\s`+"))
                .collect(Collectors.toMap(tr -> tr[0], tr -> tr[1]));
    }

    @Override
    public String resolve(final List<String> dataset) {
        final var protein = new StringBuilder();
        final var rnaCodons = Splitter.fixedLength(RNA_CODON_LENGTH)
                .split(dataset.get(0));
        for (final var rnaCodon : rnaCodons) {
            final var aminoAcid = rnaCodonToAminoAcid.get(rnaCodon);
            if (STOP.equals(aminoAcid)) {
                break;
            }
            protein.append(aminoAcid);
        }
        return protein.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new TranslatingRNAIntoProteinTask().resolve(
                RosalindUtils.loadDataset(DATASET_FILE_NAME)));
    }
}
