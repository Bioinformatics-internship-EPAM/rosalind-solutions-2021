package task;

import dto.Protein;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RNAIntoProteinTranslatorTest {

    @Test
    void testOnNormalDataset() {
        String rna = "AGCCAUGUAGCUAACUCAGGUUACAUGGGGAUGACCCCGCGACUUGGAUUAGAGUCUCUUUUGGAAUAAGCCUGAAUGAUCCGAGUAGCAUCUCAG";
        List<Protein> proteins = RNAIntoProteinTranslator.translate(rna);
        String complementingRna = "CUGAGAUGCUACUCGGAUCAUUCAGGCUUAUUCCAAAAGAGACUCUAAUCCAAGUCGCGGGGUCAUCCCCAUGUAACCUGAGUUAGCUACAUGGCU";
        proteins.addAll(RNAIntoProteinTranslator.translate(complementingRna));
        List<String> actual = proteins.stream()
                .map(Protein::getSequence)
                .collect(Collectors.toSet())
                .stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        List<String> expected = List.of("MLLGSFRLIPKETLIQVAGSSPCNLS",
                "M",
                "MGMTPRLGLESLLE",
                "MTPRLGLESLLE").stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        Assertions.assertEquals(expected, actual);
    }

}
